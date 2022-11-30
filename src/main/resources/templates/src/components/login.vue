<template>
<div style="margin-top: 130px">
  <el-row :gutter="12">
    <el-col :span="10" :offset="5">
  <el-card shadow="always">
    <h2>Login</h2>
  <el-row :gutter="12">
    <el-col :span="15" :offset="5">
        <div class="grid-content bg-purple">
          <el-input
                size="small"
                v-model="loginVM.username"
                placeholder="Loginni kiriting">
          </el-input>
          <el-input
                size="small"
                placeholder="Parolni kiriting"
                v-model="loginVM.password"
                show-password>
          </el-input>
        </div>
    </el-col>
  </el-row>
  <el-row :gutter="20" style="margin-top: 10px;">
    <el-col :span="24" >
      <el-col :span="8" :offset="4">
        <el-checkbox v-model="checked" style="margin-left:-20px">Eslab qolish</el-checkbox>
      </el-col>

      <el-col :span="12">
        <el-button type="primary" plain style="margin-right:-3px" @click="login">Login</el-button>
      </el-col>
    </el-col>
  </el-row>
  </el-card>
    </el-col>
  </el-row>
</div>
</template>

<script>
import axios from 'axios'
import AccountService from "../account/account-service";
export default {
// eslint-disable-next-line vue/multi-word-component-names
name: "login",
  data(){
      return{
        loginVM: {
          username: null,
          password: null
        },
        checked: false
      }
  },
  methods:{
  login(){
    axios.post('api/login',this.loginVM)
    .then(res =>{
        console.log(res)
      const token= res.data.token;
      if(this.checked){
        localStorage.setItem('market-token',token);
      }else {
        sessionStorage.setItem('market-token',token)
      }
      new AccountService(this.$route,this.$store).retrieveAccount();
      this.$router.push("/")
    })
  }
  }
}
</script>

<style scoped>

</style>