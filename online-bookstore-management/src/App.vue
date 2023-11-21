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
    this.$router.push('/login')
  },
  befordDestroy() {
  }
} 
</script>

<style>

</style>
