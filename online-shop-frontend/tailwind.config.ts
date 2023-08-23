import type { Config } from 'tailwindcss';

export default {
  content: ['./src/**/*.{html,ts}'],
  theme: {
    extend: {},
  },
  corePlugins: {
    preflight: false,
  },
  plugins: [],
} satisfies Config;
