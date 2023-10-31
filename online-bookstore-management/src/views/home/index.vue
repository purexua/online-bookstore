<template>
    <div class="home">
        <h1>Hello</h1>
        <h2>网上书店管理系统</h2>
    </div>
</template>

<script>
export default {
    name: 'Home',
    computed:{
        user(){
            return this.$store.state.user.user
        }
    },
    components: {
    },
    mounted() {
    }
}
</script>

<style>

</style>