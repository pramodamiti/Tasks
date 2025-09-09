import { newSpecPage } from '@stencil/core/testing';
import { TaskCard } from '../task-card';

describe('task-card', () => {
  it('renders', async () => {
    const page = await newSpecPage({
      components: [TaskCard],
      html: `<task-card></task-card>`,
    });
    expect(page.root).toEqualHtml(`
      <task-card>
        <mock:shadow-root>
          <slot></slot>
        </mock:shadow-root>
      </task-card>
    `);
  });
});
