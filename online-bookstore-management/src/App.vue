<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {
  },
  mounted() {
    localStorage.setItem('isLogin', false)
    this.$router.push('/login')
  },
  befordDestroy() {
    localStorage.removeItem('isLogin')
  }
} 
</script>

<style>

</style>
