<template>
    <el-container class="container">
        <el-aside width="250px" class="aside">
            <el-scrollbar>
                <el-menu>
                    <el-menu-item index="1">
                        <el-icon>
                            <HomeFilled />
                        </el-icon>
                        <span>首页</span>
                    </el-menu-item>

                    <el-sub-menu index="2">
                        <template #title>
                            <el-icon>
                                <Reading />
                            </el-icon>
                            图书购买
                        </template>
                        <el-menu-item-group>
                            <template #title>图书分类</template>
                            <el-menu-item index="2-1">Option 1</el-menu-item>
                            <el-menu-item index="2-2">Option 2</el-menu-item>
                        </el-menu-item-group>
                    </el-sub-menu>

                    <el-menu-item index="3">
                        <el-icon>
                            <Document />
                        </el-icon>
                        <span>我的订单</span>
                    </el-menu-item>

                    <el-menu-item index="4">
                        <el-icon>
                            <ShoppingCartFull />
                        </el-icon>
                        <span>我的购物车</span>
                    </el-menu-item>

                    <el-sub-menu index="5">
                        <template #title>
                            <el-icon>
                                <Setting />
                            </el-icon>
                            <span>设置</span>
                        </template>
                        <el-menu-item-group title="修改">
                            <el-menu-item index="5-1">修改密码</el-menu-item>
                            <el-menu-item index="5-2">修改信息</el-menu-item>
                        </el-menu-item-group>
                        <el-menu-item-group title="其他">
                            <el-menu-item index="5-3">充值系统</el-menu-item>
                        </el-menu-item-group>
                    </el-sub-menu>
                </el-menu>
            </el-scrollbar>
        </el-aside>

        <el-container>
            <el-header class="header">
                <el-row>
                    <el-col :span="20" class="header-title">
                        <p>Welcom to Online Shop !</p>
                    </el-col>
                    <el-col :span="4">
                        <div class="header-toolbar">
                            <el-dropdown>
                                <el-icon size="28px" style="margin-right: 8px; margin-top: 1px">
                                    <Setting />
                                </el-icon>
                                <template #dropdown>
                                    <el-dropdown-menu>
                                        <el-dropdown-item>View</el-dropdown-item>
                                        <el-dropdown-item>Add</el-dropdown-item>
                                        <el-dropdown-item>Delete</el-dropdown-item>
                                    </el-dropdown-menu>
                                </template>
                            </el-dropdown>
                            <span>{{ userStore.user.userName }}</span>
                        </div>
                    </el-col>
                </el-row>
            </el-header>

            <el-main>
                <RouterView />
            </el-main>
        </el-container>
    </el-container>
</template>
  
<script lang="ts" setup>
import { ref } from 'vue'
import { RouterLink, RouterView } from 'vue-router';

import { useUserStore } from '@/store/user'

const userStore = useUserStore()

</script>
  

<style scoped>
.container {
    height: 100vh;
}

.aside {
    background-color: #f0f0f0;
}

.header {
    background-color: #f0f0f0;
    color: #333;
    text-align: center;
    padding: 10px;
}

.header-title p {
    font-size: 28px;
    margin: 0;
    font-weight: bold;
    color: #333;
}

.header-toolbar {
    display: flex;
    align-items: center;
    justify-content: flex-end;
    margin-right: 20px;
}

.header-toolbar span {
    font-size: 22px;
    margin-left: 10px;
}
</style>
  