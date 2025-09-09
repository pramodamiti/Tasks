import { Component, Event, EventEmitter, h, State } from '@stencil/core';

@Component({
  tag: 'nav-bar',
  styleUrl: 'nav-bar.css',
  shadow: true,
})
export class NavBar {
  @State() title: string = '';
  @State() description: string = '';
  @State() priority: string = '';

  @Event() addTask: EventEmitter<{ title: string; description: string; priority: string }>;
  @Event() sortTasks: EventEmitter<'Low' | 'Medium' | 'High'>;

  handleAddTask() {
    if (this.title.trim() === '') {
      alert('Title is required!');
      return;
    }
    this.addTask.emit({
      title: this.title,
      description: this.description,
      priority: this.priority,
    });

    this.title = '';
    this.description = '';
    this.priority = 'Low';
  }

  handleSort(event: Event) {
    const select = event.target as HTMLSelectElement;
    this.sortTasks.emit(select.value as 'Low' | 'Medium' | 'High');
  }

  render() {
    return (
      <div>
        <div class="header">
          <h1>Task Management</h1>
        </div>

        <div class="nav-container">
          <div class="add-task">
            <input type="text" placeholder="Task Title" value={this.title} onInput={e => (this.title = (e.target as HTMLInputElement).value)} />
            <input type="text" placeholder="Description" value={this.description} onInput={e => (this.description = (e.target as HTMLInputElement).value)} />
            <select onChange={e => (this.priority = (e.target as HTMLSelectElement).value as 'Low' | 'Medium' | 'High')}>
              <option value="Low">Low</option>
              <option value="Medium">Medium</option>
              <option value="High">High</option>
            </select>

            <button onClick={() => this.handleAddTask()}>Add Task</button>
          </div>

          <div class="sort-task">
            <label>Sort by Priority: </label>
            <select onChange={e => this.handleSort(e)}>
              <option value="High">High</option>
              <option value="Medium">Medium</option>
              <option value="Low">Low</option>
            </select>
          </div>
        </div>
        <div class="task-card">
          <task-card task-title="Complete Project" description="Finish the StencilJS project by end of the week." priority="low"></task-card>
          <task-card task-title="Complete Project" description="Finish the StencilJS project by end of the week." priority="medium"></task-card>
          <task-card task-title="Complete Project" description="Finish the StencilJS project by end of the week." priority="high"></task-card>
          <task-card task-title="Complete Project" description="Finish the StencilJS project by end of the week." priority="low"></task-card>
          <task-card task-title="Complete Project" description="Finish the StencilJS project by end of the week." priority="high"></task-card>
          <task-card task-title="Complete Project" description="Finish the StencilJS project by end of the week." priority="high"></task-card>
          <task-card task-title="Complete Project" description="Finish the StencilJS project by end of the week." priority="low"></task-card>
          <task-card task-title="Complete Project" description="Finish the StencilJS project by end of the week." priority="high"></task-card>
        </div>
      </div>
    );
  }
}
