import { Component, Prop, Event, EventEmitter, State, h } from '@stencil/core';

@Component({
  tag: 'task-card',
  styleUrl: 'task-card.css',
  shadow: true,
})
export class TaskCard {
  @Prop() taskId: string;
  @Prop() taskTitle: string;
  @Prop() description: string;
  @Prop() priority: string;

  @Event() deleteTask: EventEmitter<{ taskId: string }>;
  @Event() editTask: EventEmitter<{ taskId: string }>;

  handleDelete = () => {
    this.deleteTask.emit({ taskId: this.taskId });
  };

  handleEdit() {
    this.editTask.emit({ taskId: this.taskId });
  }

  render() {
    return (
      <div class="background">
        <div id="card" class={`card ${this.priority.toLowerCase()}`}>
          <h1>Task</h1>
          <h2>{this.taskTitle}</h2>
          <p>{this.description}</p>
          <p class={`priority ${this.priority.toLowerCase()}`}>
            <b>Priority:</b> {this.priority}
          </p>
          <div class="button">
            <button class="edit" onClick={() => this.handleEdit()}>
              Edit
            </button>
            <button class="delete" onClick={this.handleDelete}>
              Delete
            </button>
          </div>
        </div>
      </div>
    );
  }
}
