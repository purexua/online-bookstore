import { defineStore } from 'pinia'
import { reactive } from 'vue'
import axios from 'axios'

export const useBookStore = defineStore('book', () => {


    const state = reactive({
        bookList: [] as Book[],
        pageInfo: {} as IPage
    });


    async function getBookByType(category: string, pageNum: number) {
        try {
            const res = await axios({
                method: 'get',
                url: `http://localhost:3919/serve8080/book/${category}/${pageNum}`,
            });
            state.bookList = reactive<Book[]>(res.data.data);
        } catch (err) {
            console.log(err);
        }
    }

    async function getPageInfo(category: string, pageNum: number) {
        try {
            const res = await axios({
                method: 'get',
                url: `http://localhost:3919/serve8080/book/page/${category}/${pageNum}`,
            });
            state.pageInfo = reactive<IPage>(res.data.data);
        } catch (err) {
            console.log(err);
        }
    }

    return { state, getBookByType, getPageInfo }
})

interface Book {
    id: number,
    bookName: string,
    imageURL: string,
    author: string,
    publisher: string,
    isbn: string,
    price: number,
    category: string,
    stock: number,
    description: string,
    status: string
}

interface IPage {
    total: number,
    current: number,
    size: number,
}