<template>
    <div class="login_container">
        <el-row>
            <el-col :span="12" :xs="0"></el-col>
            <el-col :span="12" :xs="24">
                <!-- 登录的表单 -->
                <el-form class="login_form" :model="loginForm">
                    <h1>Hello</h1>
                    <h2>网上书店管理系统</h2>
                    <el-form-item>
                        <el-input prefix-icon="el-icon-user" v-model="loginForm.username"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-input type="password" prefix-icon="el-icon-lock" v-model="loginForm.password"
                            show-password></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button :loading="loading" class="login_btn" type="primary" size="default"
                            @click="login">登录</el-button>
                    </el-form-item>
                </el-form>
            </el-col>
        </el-row>
    </div>
</template>

<script>

import axios from 'axios'

export default {
    name: 'Login',
    data() {
        return {
            loginForm: {
                username: 'user1',
                password: 'password1'
            },
            loading: false,
        }
    },
    methods: {
        login() {
            axios({
                method: 'get',
                url: `http://localhost:3919/serve8080/login?username=${this.loginForm.username}`,
            }).then(res => {
                this.loading = true
                if(res.data===''){
                    alert('用户名不存在')
                }else{
                    if(res.data.password===this.loginForm.password){
                        this.$store.commit('user/SAVEUSER',res.data)
                        this.$router.push('/home')
                    }else{
                        alert('密码错误')
                    }
                }
            }).catch(err => {
                console.log(err)
            }).finally(() => {
                this.loading = false
            })
        },
    }
}
</script>

<style lang="scss">
.login_container {
    width: 100%;
    height: 100vh;
    background: url('../../assets/images/background.jpg') no-repeat;
    background-size: cover;

    .login_form {
        position: relative;
        width: 80%;
        top: 30vh;
        left: 100%;
        background: url("../../assets/images/login_form.png") no-repeat;
        background-size: cover;
        padding: 40px;

        h1 {
            color: white;
            font-size: 40px;
        }

        h2 {
            font-size: 20px;
            color: white;
            margin: 20px 0px;
        }

        .login_btn {
            width: 100%;
        }
    }
}
</style>
