import { newE2EPage } from '@stencil/core/testing';

describe('stencil-layout', () => {
  it('renders', async () => {
    const page = await newE2EPage();
    await page.setContent('<stencil-layout></stencil-layout>');

    const element = await page.find('stencil-layout');
    expect(element).toHaveClass('hydrated');
  });
});
