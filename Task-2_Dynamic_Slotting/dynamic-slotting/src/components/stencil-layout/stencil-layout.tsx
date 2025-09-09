import { Component, h, Prop } from '@stencil/core';

@Component({
  tag: 'stencil-layout',
  styleUrl: 'stencil-layout.css',
  shadow: true,
})
export class StencilLayout {
  
  @Prop() variant: 'standard' | 'inverted' = 'inverted';

  render() {
    return (
      <div class={`container ${this.variant}`}>
        <header class="header">
          <slot name="header">
            <h1>Default Header</h1>
          </slot>
        </header>

        <main class="main">
          <slot name="main">
            <p>Default Main Content</p>
          </slot>
        </main>

        <footer class="footer">
          <slot name="footer">
            <p>Default Footer</p>
          </slot>
        </footer>
      </div>
    );
  }
}
