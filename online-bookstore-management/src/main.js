import Vue from 'vue'
import App from './App.vue'

//引入store
import store from './store'
//引入VueRouter
import VueRouter from 'vue-router'
//引入路由器
import router from './router'
// 完整引入
// 引入ElementUI组件库
import ElementUI from 'element-ui';
// 引入ElementUI全部样式
import 'element-ui/lib/theme-chalk/index.css';


//关闭Vue的生产提示
Vue.config.productionTip = false

Vue.use(VueRouter)
Vue.use(ElementUI);


new Vue({
	el:'#app',
	render: h => h(App),
	store,
	router,
	beforeCreate() {
		Vue.prototype.$bus = this
	}
})
