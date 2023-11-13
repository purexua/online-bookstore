// 该文件专门用于创建整个应用的路由器
import VueRouter from 'vue-router'

import Login from '../views/Login.vue'
import Index from '../views/Index.vue'
import Home from '../views/index/Home.vue'
import Book from '../views/index/Book.vue'
import BookForm from '../views/index/BookForm.vue'
import ChangePass from '../views/index/ChangePass.vue'
import ChangeInfo from '../views/index/ChangeInfo.vue'
import Recharge from '../views/index/Recharge.vue'
import Order from '../views/index/Order.vue'
import ShopCart from '../views/index/ShopCart.vue'

const router = new VueRouter({
   mode: 'hash',
   routes: [
      {
         name: 'login',
         path: '/login',
         component: Login,
         meta: { 'title': '登录'}
      },
      {
         name: 'index',
         path: '/',
         component: Index,
         meta: { 'title': '网上书店管理系统' },
         children: [
            {
               name: 'home',
               path: 'home',
               component: Home,
               meta: { 'title': '首页' }
            },
            {
               name: 'computer',
               path: 'computer',
               component: Book,
               meta: { 'title': '计算机分区 购买' }
            },
            {
               name: 'history',
               path: 'history',
               component: Book,
               meta: { 'title': '历史分区 购买' }
            },
            {
               name: 'popularscience',
               path: 'popularscience',
               component: Book,
               meta: { 'title': '科普分区 购买' }
            },
            {
               name: 'sciencefiction',
               path: 'sciencefiction',
               component: Book,
               meta: { 'title': '科幻分区 购买' }
            },
            {
               name: 'children',
               path: 'children',
               component: Book,
               meta: { 'title': '儿童读物分区 购买' }
            },
            {
               name: 'addBook',
               path: 'addBook',
               component: BookForm,
               meta: { 'title': '添加图书' }
            },
            {
               name: 'changePass',
               path: 'changePass',
               component: ChangePass,
               meta: { 'title': '修改密码' }
            },
            {
               name: 'changeInfo',
               path: 'changeInfo',
               component: ChangeInfo,
               meta: { 'title': '修改个人信息' }
            },
            {
               name: 'recharge',
               path: 'recharge',
               component: Recharge,
               meta: { 'title': '充值系统' }
            },
            {
               name: 'order',
               path: 'order',
               component: Order,
               meta: { 'title': '订单管理' }
            },
            {
               name:'shopCart',
               path:'shopCart',
               component:ShopCart,
               meta:{'title':'购物车'}
            }
            
         ]
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