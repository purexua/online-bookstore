import { createRouter, createWebHashHistory } from 'vue-router'

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: '/',
            name: 'HomePage',
            component: () => import('../pages/HomePage.vue')
        },
        {
            path: '/login',
            name: 'Login',
            component: () => import('../pages/Login.vue')
        },
        {
            path: '/register',
            name: 'Register',
            component: () => import('../pages/Register.vue')
        },
        {
            path: '/error',
            name: 'Error',
            component: () => import('../pages/Error.vue')
        },
        {
            path: '/index',
            name: 'Index',
            component: () => import('../pages/Index.vue'),
            children: [
                {
                    path: 'home',
                    name: 'Home',
                    component: () => import('../pages/index/Home.vue')
                },
            ]
        }
    ]
})
export default router