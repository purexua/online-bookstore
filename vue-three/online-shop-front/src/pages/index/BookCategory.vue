<template>
    <div class="flex flex-col w-full mt-12">
        <div class="px-4 sm:px-6 lg:px-8">
            <div class="sm:flex sm:items-center">
                <div class="sm:flex-auto">
                    <h1 class="text-base font-semibold leading-6 text-gray-900">Books</h1>
                    <p class="mt-2 text-sm text-gray-700">A list of all the book </p>
                </div>
                <div class="mt-4 sm:ml-16 sm:mt-0 sm:flex-none">
                    <button type="button"
                        class="block rounded-md bg-indigo-600 px-3 py-2 text-center text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Add
                        user</button>
                </div>
            </div>
            <div class="mt-8 flow-root">
                <div class="-mx-4 -my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                    <div class="inline-block min-w-full py-2 align-middle sm:px-6 lg:px-8">
                        <table class="min-w-full divide-y divide-gray-300">
                            <thead>
                                <tr>
                                    <th scope="col"
                                        class="py-3.5 pl-4 pr-3 text-left text-sm font-semibold text-gray-900 sm:pl-0">
                                        BookName
                                    </th>
                                    <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">
                                        Author&Publisher
                                    </th>
                                    <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">ISBN
                                    </th>
                                    <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Price
                                    </th>
                                    <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Stock
                                    </th>
                                    <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">
                                        Description
                                    </th>
                                    <th scope="col" class="relative py-3.5 pl-3 pr-4 sm:pr-0">
                                        <span class="sr-only">Edit</span>
                                    </th>
                                </tr>
                            </thead>
                            <tbody class="divide-y divide-gray-200 bg-white">
                                <tr v-for="book in bookStore.state.bookList" :key="book.id">
                                    <td class="whitespace-nowrap py-5 pl-4 pr-3 text-sm sm:pl-0">
                                        <div class="flex items-center">
                                            <div class="h-11 w-11 flex-shrink-0">
                                                <!-- <img class="h-11 w-11 rounded-full" :src="book.imageURL" alt="" /> -->
                                                <img class="h-11 w-11 rounded-full" src="../../assets/unlogin.jpg" alt="" />
                                            </div>
                                            <div class="ml-4">
                                                <div class="font-medium text-gray-900">{{ book.bookName }}</div>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="whitespace-nowrap px-3 py-5 text-sm text-gray-500">
                                        <div class="text-gray-900">{{ book.author }}</div>
                                        <div class="mt-1 text-gray-500">{{ book.publisher }}</div>
                                    </td>
                                    <td class="whitespace-nowrap px-3 py-5 text-sm text-gray-500">{{ book.isbn }}</td>
                                    <td class="whitespace-nowrap px-3 py-5 text-sm text-gray-500">
                                        <span
                                            class="overflow-auto  inline-flex items-center rounded-md bg-green-50 px-2 py-1 text-xs font-medium text-green-700 ring-1 ring-inset ring-green-600/20">{{
                                                book.price }}</span>
                                    </td>
                                    <td class=" whitespace-nowrap px-3 py-5 text-sm text-gray-500">
                                        <span
                                            class="overflow-auto  inline-flex items-center rounded-md bg-green-50 px-2 py-1 text-xs font-medium text-green-700 ring-1 ring-inset ring-green-600/20">{{
                                                book.stock }}</span>
                                    </td>
                                    <td class="whitespace-nowrap px-3 py-5 text-sm text-gray-500">{{ book.description }}
                                    </td>
                                    <td
                                        class="relative whitespace-nowrap py-5 pl-3 pr-4 text-right text-sm font-medium sm:pr-0">
                                        <a href="#" class="text-indigo-600 hover:text-indigo-900">Buy</a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <nav class="flex items-center justify-between border-t border-gray-200 bg-white px-4 py-3 sm:px-6 mt-auto"
            aria-label="Pagination">
            <div class="hidden sm:block">
                <p class="text-sm text-gray-700">
                    Showing Page
                    {{ ' ' }}
                    <span class="font-medium">{{ bookStore.state.pageInfo.current }}</span>
                    {{ ' ' }}
                    of
                    {{ ' ' }}
                    <span class="font-medium">{{ Math.ceil(bookStore.state.pageInfo.total /
                        bookStore.state.pageInfo.size) }}</span>
                </p>
            </div>
            <div class="flex flex-1 justify-between sm:justify-end mb-6">
                <div class="flex items-center">
                    <button @click="previous"
                        class="relative inline-flex items-center rounded-md bg-white px-3 py-2 text-sm font-semibold text-gray-900 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus-visible:outline-offset-0">Previous</button>
                </div>
                <div class="flex items-center ml-3">
                    <button @click="next"
                        class="relative inline-flex items-center rounded-md bg-white px-3 py-2 text-sm font-semibold text-gray-900 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus-visible:outline-offset-0">Next</button>
                </div>
            </div>
        </nav>
    </div>
</template>
  
<script setup lang="ts">
import { useBookStore } from '../../store/book'
import { onMounted, watch } from 'vue'
import { useRoute } from 'vue-router'

const bookStore = useBookStore()
const route = useRoute()

async function fetchBooks(pageNum: number) {
    await bookStore.getBookByType(route.meta.category as string, pageNum)
    await bookStore.getPageInfo(route.meta.category as string, pageNum)
}

function previous() {
    if (bookStore.state.pageInfo.current > 1) {
        bookStore.state.pageInfo.current--
        fetchBooks(bookStore.state.pageInfo.current)
    }
}

function next() {
    if (bookStore.state.pageInfo.current < Math.ceil(bookStore.state.pageInfo.total / bookStore.state.pageInfo.size)) {
        bookStore.state.pageInfo.current++
        fetchBooks(bookStore.state.pageInfo.current)
    }
}

onMounted(() => fetchBooks(1))

watch(() => route.meta.category, () => fetchBooks(1))
</script>