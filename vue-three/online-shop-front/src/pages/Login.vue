<template>
    <div class="flex min-h-full flex-1 flex-col justify-center px-6 py-12 lg:px-8">
        <div class="sm:mx-auto sm:w-full sm:max-w-sm">
            <img class="mx-auto h-12 w-auto" src="../assets/logo.jpg" alt="Your Company" />
            <h2 class="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">Sign in to your account
            </h2>
        </div>

        <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
            <form class="space-y-6">
                <div>
                    <label for="email" class="block text-sm font-medium leading-6 text-gray-900">Email address</label>
                    <div class="mt-2">
                        <input id="email" name="email" type="email" autocomplete="email" required v-model="loginForm.email"
                            class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" />
                    </div>
                </div>

                <div>
                    <div class="flex items-center justify-between">
                        <label for="password" class="block text-sm font-medium leading-6 text-gray-900">Password</label>
                        <div class="text-sm">
                            <a href="#" class="font-semibold text-indigo-600 hover:text-indigo-500">Forgot password?</a>
                        </div>
                    </div>
                    <div class="mt-2">
                        <input id="password" name="password" type="password" autocomplete="current-password" required
                            v-model="loginForm.password"
                            class="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6" />
                    </div>
                </div>

                <div>
                    <el-button :loading="loading" size="large" type="primary" @click="login"
                        class="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Sign
                        in</el-button>
                </div>
            </form>

            <p class="mt-10 text-center text-sm text-gray-500">
                Not a member?
                {{ ' ' }}
                <a @click.stop="register" class="font-semibold leading-6 text-indigo-600 hover:text-indigo-500">Sign up</a>
            </p>
        </div>
    </div>
</template>
  
<script setup lang="ts">
import { reactive, ref } from 'vue'
import axios from 'axios'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
import { useUserStore } from '../store/user'

const router = useRouter()
const userStore = useUserStore()

let loginForm = reactive({
    email: 'purexua@qq.com',
    password: '123456',
});

let loading = ref<boolean>(false);

function login() {
    axios({
        method: 'get',
        url: 'http://localhost:3919/serve8080/login',
        params: {
            email: loginForm.email,
            password: loginForm.password,
        }
    }).then(res => {
        loading.value = true
        if (res.data.code === 200) {
            ElMessage({
                message: '登录成功',
                grouping: true,
                type: 'success',
                center: true,
            })

            userStore.state.user.id = res.data.data

            // Save the user info to the store
            userStore.getUserInfo(res.data.data)

            setTimeout(() => {
                router.replace({
                    name: 'Home'
                })
            }, 1000)
        } else {
            ElMessage({
                message: res.data.data,
                grouping: true,
                type: 'error',
                center: true,
            })
        }
    }).catch(err => {
        ElMessage({
            message: err,
            grouping: true,
            type: 'error',
            center: true,
        })
    }).finally(() => {
        loading.value = false
    })
}

function register() {
    // Redirect to the register page
    router.replace({
        name: 'Register'
    })
}
</script>
  
<style lang="scss" scoped></style>