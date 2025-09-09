import { newSpecPage } from '@stencil/core/testing';
import { StencilLayout } from '../stencil-layout';

describe('stencil-layout', () => {
  it('renders', async () => {
    const page = await newSpecPage({
      components: [StencilLayout],
      html: `<stencil-layout></stencil-layout>`,
    });
    expect(page.root).toEqualHtml(`
      <stencil-layout>
        <mock:shadow-root>
          <slot></slot>
        </mock:shadow-root>
      </stencil-layout>
    `);
  });
});
