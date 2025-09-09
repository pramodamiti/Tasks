import { newE2EPage } from '@stencil/core/testing';

describe('task-container', () => {
  it('renders', async () => {
    const page = await newE2EPage();
    await page.setContent('<task-container></task-container>');

    const element = await page.find('task-container');
    expect(element).toHaveClass('hydrated');
  });
});
