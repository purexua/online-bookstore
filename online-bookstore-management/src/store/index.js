//该文件用于创建Vuex中最为核心的store
import Vue from 'vue'

//引入Vuex
import Vuex from 'vuex'
import userInfo from './user.js'
import bookInfo from './book.js'
import orderInfo from './order.js'
import shopCart from './shopcart.js'


//应用Vuex插件
Vue.use(Vuex)

//创建并暴露store
export default new Vuex.Store(
    {
        modules: {
            userInfo: userInfo,
            bookInfo: bookInfo,
            orderInfo: orderInfo,
            shopCart:shopCart,
        }
    })