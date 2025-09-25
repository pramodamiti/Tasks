import { Component, h, State } from '@stencil/core';
import { Task } from '../../interfaces/task';
import { fetchTasks, addTask, updateTask, deleteTask } from '../../interfaces/task-service';

@Component({
  tag: 'app-root',
  styleUrl: 'app-root.css',
  shadow: true,
})
export class AppRoot {
  @State() tasks: Task[] = [];

  async componentWillLoad() {
    this.tasks = await fetchTasks();
  }

  handleDeleteTask = async (taskId: string) => {
    await deleteTask(taskId);
    this.tasks = this.tasks.filter(task => task.id !== taskId);
    this.componentWillLoad();
  };

  async handleEditTask(taskId: string) {
    const task = this.tasks.find(task => task.id === taskId);
    if (task) {
      const newTitle = prompt('Edit Title', task.title);
      const newDescription = prompt('Edit Description', task.description);
      const newPriority = prompt('Edit Priority (Low, Medium, High)', task.priority);

      const updated: Task = {
        ...task,
        title: newTitle || task.title,
        description: newDescription || task.description,
        priority: (['Low', 'Medium', 'High'].includes(newPriority || '') ? newPriority : task.priority) as 'Low' | 'Medium' | 'High',
      };

      const saved = await updateTask(taskId, updated);
      this.tasks = this.tasks.map(t => (t.id === taskId ? saved : t));
      this.componentWillLoad();
    }
  }

  handleAddTask = async (event: CustomEvent<{ title: string; description: string; priority: string }>) => {
    const newTask: Omit<Task, 'id'> = {
      title: event.detail.title,
      description: event.detail.description,
      priority: event.detail.priority as 'Low' | 'Medium' | 'High',
    };
    const saved = await addTask(newTask);
    this.tasks = [...this.tasks, saved];
    this.componentWillLoad();
  };

  handleSortTasks = (event: CustomEvent<'Low' | 'Medium' | 'High'>) => {
    const priority = event.detail;
    this.tasks = [...this.tasks].sort((a, b) => {
      if (a.priority === priority && b.priority !== priority) return -1;
      if (a.priority !== priority && b.priority === priority) return 1;
      return 0;
    });
  };

  render() {
    return (
      <div class="task-card">
        <nav-bar onAddTask={this.handleAddTask} onSortTasks={this.handleSortTasks}></nav-bar>
        <div class="task-list">
          {this.tasks.map(task => (
            <task-card
              taskId={task.id}
              task-title={task.title}
              description={task.description}
              priority={task.priority}
              onDeleteTask={(event: CustomEvent<{ taskId: string }>) => this.handleDeleteTask(event.detail.taskId)}
              onEditTask={(event: CustomEvent<{ taskId: string }>) => this.handleEditTask(event.detail.taskId)}
            ></task-card>
          ))}
        </div>
      </div>
    );
  }
}
