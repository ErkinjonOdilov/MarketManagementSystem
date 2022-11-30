<template>
<div>
  <el-table
      :data="marketBaseList"
      border
      style="width: 100%">
    <el-table-column
        prop="product.code"
        label="Maxsulot kodi"
        width="150">
    </el-table-column>
    <el-table-column
        prop="product.name"
        label="Maxsulot nomi"
        width="150">
    </el-table-column>
    <el-table-column
        prop="quantity"
        label="Miqdori">
      <template #default="{row}">
          <span>{{row.quantity}}  {{row.product.type}}</span>
      </template>
    </el-table-column>
    <el-table-column
        prop="price"
        label="Kelgan narxi">
    </el-table-column>
    <el-table-column
        prop="currentPrice"
        label="Sotlish narxi">
    </el-table-column>
  </el-table>
</div>
</template>

<script>
import axios from "axios";
export default {
  name: "MarketBaseList",
  data(){
    return{
      marketBaseList:[]
    }
  },
  methods:{
    loadData(){
      axios
          .get("api/market-base")
          .then(res=>{
            console.log(res)
            this.marketBaseList=res.data.content;
          })
    }
  },
  created() {
    this.loadData()
  }
}
</script>

<style scoped>

</style>