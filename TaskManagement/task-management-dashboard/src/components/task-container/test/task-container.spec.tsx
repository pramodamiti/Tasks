import { newSpecPage } from '@stencil/core/testing';
import { TaskContainer } from '../task-container';

describe('task-container', () => {
  it('renders', async () => {
    const page = await newSpecPage({
      components: [TaskContainer],
      html: `<task-container></task-container>`,
    });
    expect(page.root).toEqualHtml(`
      <task-container>
        <mock:shadow-root>
          <slot></slot>
        </mock:shadow-root>
      </task-container>
    `);
  });
});
