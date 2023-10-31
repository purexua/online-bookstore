// 该文件专门用于创建整个应用的路由器
import VueRouter from 'vue-router'

import Login from '../views/login/index.vue'
import Home from '../views/home/index.vue'

const router = new VueRouter({
   mode: 'hash',
   routes: [
      {
         name: 'login',
         path: '/login',
         component: Login,
         meta: { 'title': '登录' }
      },
      {
         name: 'home',
         path: '/home',
         component: Home,
         meta: { 'title': '网上书店管理系统' }
      }
   ]
}
)

//全局前置路由守卫————初始化的时候被调用、每次路由切换之前被调用
router.beforeEach((to, from, next) => {
   next()
})

//全局后置路由守卫————初始化的时候被调用、每次路由切换之后被调用
router.afterEach((to, from) => {
   document.title = to.meta.title || '网上书店管理系统'
})

export default router