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
                {
                    path: 'category/computer',
                    name: 'ComputerCategory',
                    component: () => import('../pages/index/BookCategory.vue'),
                    meta: {
                        title: 'Computer 分区',
                        category: 'Computer'
                    },
                },
                {
                    path: 'category/history',
                    name: 'HistoryCategory',
                    component: () => import('../pages/index/BookCategory.vue'),
                    meta: {
                        title: 'History 分区',
                        category: 'History'
                    },
                },
                {
                    path: 'category/novel',
                    name: 'NovelCategory',
                    component: () => import('../pages/index/BookCategory.vue'),
                    meta: {
                        title: 'Novel 分区',
                        category: 'Novel'
                    },
                },
                {
                    path: 'category/science',
                    name: 'ScienceCategory',
                    component: () => import('../pages/index/BookCategory.vue'),
                    meta: {
                        title: 'Science 分区',
                        category: 'Science'
                    },
                },
                {
                    path: 'category/other',
                    name: 'OtherCategory',
                    component: () => import('../pages/index/BookCategory.vue'),
                    meta: {
                        title: 'Other 分区',
                        category: 'Other'
                    },
                }
            ]
        }
    ]
})
export default router