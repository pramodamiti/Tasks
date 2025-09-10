import { Component, h, State } from '@stencil/core';
import { Task } from '../../interfaces/task';

@Component({
  tag: 'app-root',
  styleUrl: 'app-root.css',
  shadow: true,
})
export class AppRoot {
  @State() tasks: Task[] = [];

  handleDeleteTask = (taskId: string) => {
    this.tasks = this.tasks.filter(task => task.id !== taskId);

    console.log(this.tasks);
  };

  handleEditTask(taskId: string) {
    const task = this.tasks.find(task => task.id === taskId);
    if (task) {
      const newTitle = prompt('Edit Title', task.title);
      if (newTitle !== null && newTitle.trim() !== '') {
        task.title = newTitle;
        this.tasks = [...this.tasks];
      }
      const newDescription = prompt('Edit Description', task.description);
      if (newDescription !== null) {
        task.description = newDescription;
        this.tasks = [...this.tasks];
      }
      const newPriority = prompt('Edit Priority (Low, Medium, High)', task.priority.toLowerCase());
      if (newPriority !== null && ['Low', 'Medium', 'High'].includes(newPriority)) {
        task.priority = newPriority as 'Low' | 'Medium' | 'High';
        this.tasks = [...this.tasks];
      }
    }
  }

  handleAddTask = (event: CustomEvent<{ title: string; description: string; priority: string }>) => {
    const newTask: Task = {
      id: `task-${Date.now()}`,
      title: event.detail.title,
      description: event.detail.description,
      priority: event.detail.priority as 'Low' | 'Medium' | 'High',
    };
    this.tasks = [...this.tasks, newTask];
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
