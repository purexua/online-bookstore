import { createRouter, createWebHashHistory } from 'vue-router'
import Login from '@/pages/Login.vue'
import Index from '@/pages/Index.vue'
import Register from '@/pages/Register.vue'

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            name: 'login',
            path: '/login',
            component: Login,
            meta: { 'title': '登录', isAuth: false }
        },
        {
            name: 'register',
            path: '/register',
            component: Register,
            meta: { 'title': '注册', isAuth: false }
        },
        {
            path: '/',
            redirect: '/login'
        },
        {
            name: 'index',
            path: '/index',
            component: Index,
            meta: { 'title': '网上书店管理系统', isAuth: true },
            children: [
            ]
        }
    ]
})
export default router