<template>
<div>
  <el-row>
    <el-col :span="12">
      <el-col :span="23">
      <el-input
          size="mini"
          v-model="productCode"
          style="margin-bottom: 12px;margin-top: 2%"
          @keyup.enter.native="onEnter"
          placeholder="Maxsulot kodi">
      </el-input>
      </el-col>
     <span v-if="hasProduct">
       <el-col :span="5">{{marketBase.product.code }}</el-col>
       <el-col :span="6" style="border-right: 1px  dashed black; border-left: 1px dashed black">{{marketBase.product.name}}</el-col>
       <el-col :span="4" style="border-right: 1px dashed black">
         <el-input size="mini" style="width: 100px" v-model="marketBase.quantity"></el-input>
       </el-col>
       <el-col :span="4" style="border-right: 1px dashed black">
          <el-input size="mini" style="width: 100px" v-model="marketBase.price"></el-input>
       </el-col>
       <el-col :span="4">
          <el-input size="mini" style="width: 100px" v-model="marketBase.currentPrice"  @keyup.enter.native="addMarketBase"></el-input>
       </el-col>
     </span>
    </el-col>

    <el-col :span="12" style="border-left: 1px dashed black">
      <el-button type="success" round style="margin-left: 85%;margin-bottom: 20px" @click="saveData">Saqlash</el-button>
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
    </el-col>
  </el-row>
</div>
</template>

<script>
import axios from 'axios'
export default {
  name: "MarketBase",
  data() {
    return {
      tableData: [],
      marketBaseList:[],
      marketBase:{
        quantity: null,
        price:null,
        currentPrice:null,
        product:{
          id: null,
          name: null,
          code:null
        }
      },
      productCode:null,
      hasProduct:false,
      product: null
    }
  },
  methods:{
    getProduct(){
      axios
          .get(`api/product/code?code=${this.productCode}`)
          .then(res=>{
            if(res.data!=null && res.data!=undefined && res.data!='' && this.tableData.length==0){
            this.hasProduct = true;
            this.product=res.product
            this.marketBase.product=res.data;
            }
          })
    },
    onEnter(){
      this.getProduct();
    },
    saveData(){
        axios
            .post("api/market-base/list", this.marketBaseList)
            .then(res=>{
              console.log(res)
              this.marketBaseList=[]
            })

    },
    addMarketBase(){
        this.marketBaseList.push(this.marketBase)
        this.marketBase={}
        this.product={}
        this.hasProduct = false;
       this.productCode=null;


    }
  }
}
</script>

<style scoped>

</style>