import { Component, Prop, State, h } from '@stencil/core';

@Component({
  tag: 'task-card',
  styleUrl: 'task-card.css',
  shadow: true,
})
export class TaskCard {
  @Prop() taskTitle: string;
  @Prop() description: string;
  @Prop() priority: string;
  @State() count: number = 1;
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
            <button id="edit" class="edit">
              Edit
            </button>
            <button class="delete">Delete</button>
          </div>
        </div>
      </div>
    );
  }
}
