import { newE2EPage } from '@stencil/core/testing';

describe('task-card', () => {
  it('renders', async () => {
    const page = await newE2EPage();
    await page.setContent('<task-card></task-card>');

    const element = await page.find('task-card');
    expect(element).toHaveClass('hydrated');
  });
});
