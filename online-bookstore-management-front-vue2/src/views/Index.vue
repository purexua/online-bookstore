<template>
    <el-container>
        <el-aside width="250px">
            <el-menu default-active="1" class="el-menu-vertical-demo">

                <el-menu-item index="1">
                    <i class="el-icon-s-home"></i>
                    <span slot="title"><router-link to="/home">首页</router-link></span>
                </el-menu-item>

                <el-submenu index="2">
                    <template slot="title">
                        <i class="el-icon-location"></i>
                        <span>图书购买</span>
                    </template>
                    <el-menu-item-group>
                        <template slot="title">图书分类</template>
                        <el-menu-item index="2-1">
                            <router-link :to="{
                                name: 'computer',
                                params: { bookType: '计算机' }
                            }">计算机类</router-link>
                        </el-menu-item>
                        <el-menu-item index="2-2">
                            <router-link :to="{
                                name: 'history',
                                params: { bookType: '历史' }
                            }">历史类</router-link>
                        </el-menu-item>
                        <el-menu-item index="2-3">
                            <router-link :to="{
                                name: 'popularscience',
                                params: { bookType: '科普' }
                            }">科普类</router-link></el-menu-item>

                        <el-menu-item index="2-4">
                            <router-link :to="{
                                name: 'sciencefiction',
                                params: { bookType: '科幻' }
                            }">科幻类</router-link></el-menu-item>

                        <el-menu-item index="2-5">
                            <router-link :to="{
                                name: 'children',
                                params: { bookType: '儿童读物' }
                            }">儿童读物</router-link></el-menu-item>
                    </el-menu-item-group>
                </el-submenu>

                <el-menu-item index="3" v-if="user.userId === 1">
                    <i class="el-icon-document"></i>
                    <span slot="title">
                        <router-link :to="{
                            name: 'addBook',
                        }">添加图书</router-link>
                    </span>
                </el-menu-item>

                <el-menu-item index="3" v-if="user.userId !== 1">
                    <i class="el-icon-document"></i>
                    <span slot="title">
                        <router-link :to="{
                            name: 'order',
                        }">我的订单</router-link>
                    </span>
                </el-menu-item>

                <el-menu-item index="5" v-if="user.userId !== 1">
                    <i class="el-icon-document"></i>
                    <span slot="title">
                        <router-link :to="{
                            name: 'shopCart',
                        }">我的购物车</router-link>
                    </span>
                </el-menu-item>

                <el-submenu index="4">
                    <template slot="title">
                        <i class="el-icon-location"></i>
                        <span>我的</span>
                    </template>
                    <el-menu-item-group>
                        <template slot="title">设置</template>
                        <el-menu-item index="4-1">
                            <router-link :to="{
                                name: 'changePass',
                            }">修改密码</router-link>
                        </el-menu-item>
                    </el-menu-item-group>
                    <el-submenu index="4-2">
                        <template slot="title">信息</template>
                        <el-menu-item index="4-2-1" v-if="user.userId !== 1">
                            <router-link :to="{
                                name: 'recharge',
                            }">充值系统</router-link>
                        </el-menu-item>
                        <el-menu-item index="4-2-2">
                            <router-link :to="{
                                name: 'changeInfo',
                            }">修改信息</router-link>
                        </el-menu-item>
                    </el-submenu>
                </el-submenu>
            </el-menu>
        </el-aside>
        <el-container>
            <el-header height="80px">
                <Header></Header>
            </el-header>
            <el-main><router-view></router-view></el-main>
        </el-container>
    </el-container>
</template>

<script>
import Header from '../components/Header.vue'

export default {
    name: 'Index',
    computed: {
        user() {
            return this.$store.state.userInfo.user
        }
    },
    components: {
        Header,
    },
    mounted() {
    }
}
</script>

<style lang="scss">
.el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
}

.el-aside {
    color: #333;
}

a {
    text-decoration: none;
}
</style>

