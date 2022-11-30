<template>
  <div>
    <el-dropdown>
      <i class="el-icon-setting" style="margin-right: 15px"></i>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item>View</el-dropdown-item>
        <el-dropdown-item v-if="!authenticated"><span @click="login">Kirish</span></el-dropdown-item>
        <el-dropdown-item v-else-if="authenticated"><span @click="logout">Chiqish</span></el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
    <span>{{userName}}</span>
  </div>
</template>

<script>
export default {
// eslint-disable-next-line vue/multi-word-component-names
  name: "header",
  computed: {
    authenticated() {
      return this.$store.getters.authenticated;
    }
  },
  data(){
    return{
      userName:this.$store.getters.account.userName
    }
  },
  methods: {
    login() {
      this.$router.push("/login");
    },
    logout() {
      localStorage.removeItem("market-token")
      sessionStorage.removeItem("request-url")
      sessionStorage.removeItem("market-token")
      this.$store.commit("logout")
      this.$router.push("/login")
    }
  }

}
</script>

<style scoped>

</style>