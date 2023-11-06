<template>
  <p>欢迎来到，网上书店。</p>
</template>

<script>
export default {
  name: 'Header',
  computed: {
    user() {
      return this.$store.state.userInfo.user
    }
  },
  mounted() {

  }
}
</script>

<style scoped>

p {
  text-align: center;
  font-size: 30px; /* Adjust as needed */
  font-weight: bold;
  margin:  10px 0;
}
</style>