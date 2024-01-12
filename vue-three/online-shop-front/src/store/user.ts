import axios from 'axios'
import { defineStore } from 'pinia'
import { reactive } from 'vue'

export const useUserStore = defineStore('user', () => {
    //state
    let user = reactive({
        id: -1,
        avatar: '',
        username: '',
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
    })
    //actions
    function getUserInfo(id: number) {
        axios(
            {
                method: 'get',
                url: `http://localhost:3919/serve8080/user/${id}`,
            }
        ).then((res) => {
            user.id = res.data.userId
            user.avatar = res.data.avatar
            user.username = res.data.userName
            user.password = res.data.password
            user.realName = res.data.realName
            user.email = res.data.email
            user.address = res.data.address
            user.phone = res.data.phoneNumber
            user.description = res.data.description
            user.status = res.data.status
            user.wallet = res.data.wallet
            user.createTime = res.data.registerTime
            user.updateTime = res.data.updateTime
        })
    }

    //reset state
    function $reset() {
        user = reactive({
            id: -1,
            avatar: '',
            username: '',
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
        })
    }

    return { user, getUserInfo, $reset }
})