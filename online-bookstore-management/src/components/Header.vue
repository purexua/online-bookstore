<template>
  <div class="container">
    <p v-if="user.userId === 1">欢迎来到，超级后台！</p>
    <p v-else>欢迎来到，网上书店。</p>
    <el-dropdown class="icon" @command="handleCommand">
      <el-button type="text">
        <el-avatar icon="el-icon-user-solid"></el-avatar>
      </el-button>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item command="a">修改信息</el-dropdown-item>
        <el-dropdown-item command="b">修改密码</el-dropdown-item>
        <el-dropdown-item command="c" v-if="user.userId !== 1">充值</el-dropdown-item>
        <el-dropdown-item command="d">登出</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>

<script>
export default {
  name: 'Header',
  computed: {
    user() {
      return this.$store.state.userInfo.user
    }
  },
  methods: {
    handleCommand(command) {
      if (command === 'a') {
        this.$router.push({
          name: 'changeInfo',
        })
      } else if (command === 'b') {
        this.$router.push({
          name: 'changePass',
        })
      } else if (command === 'c') {
        this.$router.push({
          name: 'recharge',
        })
      }
      else if (command === 'd') {
        this.$router.push({
          name: 'login',
        })
      }
    }
  },
  mounted() {

  }
}
</script>

<style scoped>
p {
  text-align: center;
  font-size: 30px;
  font-weight: bold;
  margin: 10px 0;
}

.container {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: row;
}

.icon {
  position: absolute;
  right: 50px;
  top: 22px;
}
</style>