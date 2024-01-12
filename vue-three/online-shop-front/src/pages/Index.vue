<template>
    <div class="flex flex-row ">
        <div class="w-1/5">
            <div class="flex grow flex-col gap-y-5 overflow-y-auto border-r border-gray-200 bg-white px-6">
                <div class="flex h-16 shrink-0 items-center">
                    <img class="h-8 w-auto" src="../assets/logo.jpg" alt="Your Company" />
                </div>
                <nav class="flex flex-1 flex-col">
                    <ul role="list" class="flex flex-1 flex-col gap-y-7">
                        <li>
                            <ul role="list" class="-mx-2 space-y-1">
                                <li v-for="item in navigation" :key="item.name">
                                    <RouterLink v-if="!item.children" :to="item.to"
                                        :class="[item.current ? 'bg-gray-50' : 'hover:bg-gray-50', 'group flex gap-x-3 rounded-md p-2 text-sm leading-6 font-semibold text-gray-700']">
                                        <component :is="item.icon" class="h-6 w-6 shrink-0 text-gray-400"
                                            aria-hidden="true" />
                                        {{ item.name }}
                                    </RouterLink>
                                    <Disclosure as="div" v-else v-slot="{ open }">
                                        <DisclosureButton
                                            :class="[item.current ? 'bg-gray-50' : 'hover:bg-gray-50', 'flex items-center w-full text-left rounded-md p-2 gap-x-3 text-sm leading-6 font-semibold text-gray-700']">
                                            <component :is="item.icon" class="h-6 w-6 shrink-0 text-gray-400"
                                                aria-hidden="true" />
                                            {{ item.name }}
                                            <ChevronRightIcon
                                                :class="[open ? 'rotate-90 text-gray-500' : 'text-gray-400', 'ml-auto h-5 w-5 shrink-0']"
                                                aria-hidden="true" />
                                        </DisclosureButton>
                                        <DisclosurePanel as="ul" class="mt-1 px-2">
                                <li v-for="subItem in item.children" :key="subItem.name">
                                    <RouterLink :to="subItem.to"
                                        :class="[subItem.current ? 'bg-gray-50' : 'hover:bg-gray-50', 'block rounded-md py-2 pr-2 pl-9 text-sm leading-6 text-gray-700']">
                                        {{ subItem.name }}
                                    </RouterLink>
                                </li>
                                </DisclosurePanel>
                                </Disclosure>
                        </li>
                    </ul>
                    </li>
                    <li class="-mx-6 mt-auto" v-if="userStore.user.id === -1">
                        <RouterLink :to="{ name: 'Login' }"
                            class="flex items-center gap-x-4 px-6 py-3 text-sm font-semibold leading-6 text-gray-900 hover:bg-gray-50">
                            <img class="h-8 w-8 rounded-full bg-gray-50" src="../assets/unlogin.jpg" alt="" />
                            <span class="sr-only">Your profile</span>
                            <span aria-hidden="true">log in</span>
                        </RouterLink>
                    </li>
                    <li v-else>
                        <RouterLink :to="{ name: 'Login' }"
                            class="flex items-center gap-x-4 px-6 py-3 text-sm font-semibold leading-6 text-gray-900 hover:bg-gray-50">
                            <img class="h-8 w-8 rounded-full bg-gray-50" src="../assets/login.jpg" alt="" />
                            <span class="sr-only">Your profile</span>
                            <span aria-hidden="true">{{ userStore.user.userName }}</span>
                        </RouterLink>
                    </li>
                    </ul>
                </nav>
            </div>
        </div>

        <div class="flex flex-row flex-1 w-4/5">
            <RouterView></RouterView>
        </div>

    </div>
</template>
  
<script setup lang="ts">
import { Disclosure, DisclosureButton, DisclosurePanel } from '@headlessui/vue'

import { ChevronRightIcon } from '@heroicons/vue/20/solid'
import {
    CalendarIcon,
    ChartPieIcon,
    DocumentDuplicateIcon,
    FolderIcon,
    HomeIcon,
    UsersIcon,
} from '@heroicons/vue/24/outline'

import { useUserStore } from '../store/user'
import { RouterLink, RouterView } from 'vue-router'

const userStore = useUserStore()


const navigation = [
    { name: 'Home', to: { name: 'Login' }, icon: HomeIcon, current: false },
    {
        name: 'Teams',
        icon: UsersIcon,
        current: false,
        children: [
            { name: 'Engineering', to: { name: 'Login' }, current: false },
            { name: 'Human Resources', to: { name: 'Login' }, current: false },
            { name: 'Customer Success', to: { name: 'Login' }, current: false },
        ],
    },
    {
        name: 'Projects',
        icon: FolderIcon,
        current: false,
        children: [
            { name: 'GraphQL API', to: { name: 'Login' }, current: false },
            { name: 'iOS App', to: { name: 'Login' }, current: false },
            { name: 'Android App', to: { name: 'Login' }, current: false },
            { name: 'New Customer Portal', to: { name: 'Login' }, current: false },
        ],
    },
    { name: 'Calendar', to: { name: 'Login' }, icon: CalendarIcon, current: false },
    { name: 'Documents', to: { name: 'Login' }, icon: DocumentDuplicateIcon, current: false },
    { name: 'Reports', to: { name: 'Login' }, icon: ChartPieIcon, current: false },
]
</script>

<style scoped></style>
