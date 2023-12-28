import { defineStore } from 'pinia'
import axios from 'axios'
import { nanoid } from 'nanoid'
import { reactive } from 'vue'

export const useTalkStore = defineStore('talk', () => {
    // talkList就是state
    const talkList = reactive(
        JSON.parse(localStorage.getItem('talkList') as string) || []
    )

    // 函数相当于action
    async function getATalk() {
        let { data: { content: title } } = await axios.get('https://api.uomg.com/api/rand.qinghua?format=json')
        let obj = { id: nanoid(), title }
        talkList.unshift(obj)
    }
    return { talkList, getATalk }
})