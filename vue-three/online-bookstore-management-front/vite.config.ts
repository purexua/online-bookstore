import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import VueSetupExtend from 'vite-plugin-vue-setup-extend'
import vue from '@vitejs/plugin-vue'

export default defineConfig({
  plugins: [
    vue(),
    VueSetupExtend()
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server: {
    port: 3919,
    strictPort: true,//若端口已被占用则会直接退出，而不是尝试下一个可用端口。
    proxy: {
      '/serve8080': {
        target: 'http://localhost:8080/',
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/serve8080/, ""),
      },
    }
  }
})
