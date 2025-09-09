import { Component, Host, h } from '@stencil/core';

@Component({
  tag: 'task-container',
  styleUrl: 'task-container.css',
  shadow: true,
})
export class TaskContainer {
  render() {
    return (
      <Host>
        <slot></slot>
      </Host>
    );
  }
}
