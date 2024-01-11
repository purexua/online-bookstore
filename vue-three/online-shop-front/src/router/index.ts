import { createRouter, createWebHashHistory } from 'vue-router'

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: '/',
            name: 'Index',
            component: () => import('../pages/Index.vue')
        }
    ]
})
export default router