import axios from 'axios'
import { defineStore } from 'pinia'
import { reactive } from 'vue'

export const useUserStore = defineStore('user', () => {
    //state
    let user = reactive({
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
    })
    //actions
    function getUserInfo(id: number) {
        axios(
            {
                method: 'get',
                url: `http://localhost:3919/serve8080/user/${id}`,
            }
        ).then((res) => {
            user.id = res.data.data.id
            user.avatar = res.data.data.avatar
            user.userName = res.data.data.userName
            user.password = res.data.data.password
            user.realName = res.data.data.realName
            user.email = res.data.data.email
            user.address = res.data.data.address
            user.phone = res.data.data.phoneNumber
            user.description = res.data.data.description
            user.status = res.data.data.status
            user.wallet = res.data.data.wallet
            user.createTime = res.data.data.registerTime
            user.updateTime = res.data.data.updateTime
        }).catch((err) => {
            console.log(err)
        })
    }
    return { user, getUserInfo }
})