<template>
<div>
  <el-aside width="200px" style="background-color: rgb(238, 241, 246)"
            v-if="hasAnyAuth('ROLE_ADMIN') && authenticated">
    <el-menu :default-openeds="['1', '3']">
      <el-submenu index="1">
        <template slot="title"><i class="el-icon-message"></i>Ma'lumotlar</template>
        <el-menu-item-group>
          <el-menu-item index="1-1">
            <router-link to="/product">Maxsulotlar</router-link>
            </el-menu-item>

            <el-menu-item index="1-1">
            <router-link to="/market-base">Ro'yxatga olish</router-link>
            </el-menu-item>
          <el-menu-item index="1-1">
            <router-link to="/market-base/list">Ombordagi Mahsulotlar</router-link>
          </el-menu-item>

        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>Navigator Two</template>
        <el-menu-item-group>
          <template slot="title">Group 1</template>
          <el-menu-item index="2-1">Option 1</el-menu-item>
          <el-menu-item index="2-2">Option 2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="Group 2">
          <el-menu-item index="2-3">Option 3</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="2-4">
          <template slot="title">Option 4</template>
          <el-menu-item index="2-4-1">Option 4-1</el-menu-item>
        </el-submenu>
      </el-submenu>
    </el-menu>
  </el-aside>
</div>
</template>

<script>
import AccountService from "../account/account-service";
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Aside",
  data(){
    return{
      hasAnyAuthorityValue:false
    }
  },
  computed:{
    authenticated(){
      return this.$store.getters.authenticated;
    }
  },
  methods:{
    hasAnyAuth(authorities){
      new AccountService(this.$router, this.$store)
          .hasAnyAuthorityAndAuth(authorities)
          .then(value => {
            this.hasAnyAuthorityValue=value;
          });
      return this.hasAnyAuthorityValue;
    }
  }
}
</script>

<style scoped>

</style>