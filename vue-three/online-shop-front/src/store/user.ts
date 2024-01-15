import axios from 'axios'
import { defineStore } from 'pinia'
import { reactive } from 'vue'

export const useUserStore = defineStore('user', () => {
    //state

    const state = reactive({
        user: {
            id: -1,
            avatar: '',
            userName: '',
            password: '',
            realName: '',
            email: '',
            address: '',
            phone: '',
            description: '',
            status: '',
            wallet: '',
            createTime: '',
            updateTime: '',
        } as User
    })

    //actions
    function getUserInfo(id: number) {
        axios(
            {
                method: 'get',
                url: `http://localhost:3919/serve8080/user/${id}`,
            }
        ).then((res) => {
            state.user.id = res.data.data.id
            state.user.avatar = res.data.data.avatar
            state.user.userName = res.data.data.userName
            state.user.password = res.data.data.password
            state.user.realName = res.data.data.realName
            state.user.email = res.data.data.email
            state.user.address = res.data.data.address
            state.user.phone = res.data.data.phoneNumber
            state.user.description = res.data.data.description
            state.user.status = res.data.data.status
            state.user.wallet = res.data.data.wallet
            state.user.createTime = res.data.data.registerTime
            state.user.updateTime = res.data.data.updateTime
        }).catch((err) => {
            console.log(err)
        })
    }

    function logOut() {
        state.user = {
            id: -1,
            avatar: '',
            userName: '',
            password: '',
            realName: '',
            email: '',
            address: '',
            phone: '',
            description: '',
            status: '',
            wallet: '',
            createTime: '',
            updateTime: '',
        }
    }
    return { state, getUserInfo, logOut }
})

interface User {
    id: number,
    avatar: string,
    userName: string,
    password: string,
    realName: string,
    email: string,
    address: string,
    phone: string,
    description: string,
    status: string,
    wallet: string,
    createTime: string,
    updateTime: string,
}