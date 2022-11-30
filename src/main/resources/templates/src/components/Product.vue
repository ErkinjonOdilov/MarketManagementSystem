<template>
<div>
  <h1>Product</h1>
  <el-row :gutter="20">
    <el-col :span="18" :offset="3">
      <el-button type="primary" round @click="dialogFormVisible=true">Qo'shish</el-button>
  <el-table
      :data="tableData"
      style="width: 100%">
    <el-table-column
        label="id"
        width="50">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ scope.row.id }}</span>
      </template>
    </el-table-column>
    <el-table-column
        label="Nomi"
        width="180">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ scope.row.name }}</span>
      </template>
    </el-table-column>
    <el-table-column
        label="Code"
        width="180">
      <template slot-scope="scope">
       <span>{{ scope.row.code }}</span>
      </template>
    </el-table-column>
    <el-table-column
        label="Type"
        width="180">
      <template slot-scope="scope">
        <span>{{ scope.row.type }}</span>
      </template>
    </el-table-column>
    <el-table-column
        label="Status"
        width="180">
      <template slot-scope="scope">
        <span>{{ scope.row.status }}</span>
      </template>
    </el-table-column>
    <el-table-column
        label="Operations">
      <template slot-scope="scope">
        <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
        <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
      </template>
    </el-table-column>
  </el-table>
    </el-col>
  </el-row>

    <el-dialog title="Maxsulot kiritish" :visible.sync="dialogFormVisible">
          <el-form :model="product">
            <el-form-item label="Maxsulot nomi" :label-width="formLabelWidth">
              <el-input v-model="product.name" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="Maxsulot Kodi" :label-width="formLabelWidth">
              <el-input v-model="product.code" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="Maxsulot turi" :label-width="formLabelWidth">
              <el-select v-model="product.type" placeholder="Maxsulot o'lchovi">
                <el-option label="Kg" value="KG"></el-option>
                <el-option label="Litr" value="L"></el-option>
                <el-option label="Dona" value="PIECES"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="Maxsulot Statusi" :label-width="formLabelWidth">
              <el-select v-model="product.status" placeholder="Maxsulot statusi">
                <el-option label="ACTIVE" value="ACTIVE"></el-option>
                <el-option label="DRAFT" value="DRAFT"></el-option>
              </el-select>
            </el-form-item>
          </el-form>
            <span slot="footer" class="dialog-footer">
           <el-button @click="closeModal">Cancel</el-button>
           <el-button type="primary" @click="save" :loading="loadingButton">Saqlash</el-button>
         </span>
    </el-dialog>

</div>
</template>

<script>
import axios from "axios";
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Product",
  data() {
    return {
      tableData: [],
      dialogFormVisible: false,
      loadingButton: false,
      product: {
        id: null,
        name: null,
        code: null,
        type: null,
        status: null
      },
      formLabelWidth: '120px'
    }
  },
  methods: {
    handleEdit(index, row) {
      console.log(index, row);
      this.product = row;
      this.dialogFormVisible = true
    },
    handleDelete(index, row) {
      this.$confirm('O\'chirishga ishonchingiz komilmi?', 'Delete', {
        confirmButtonText: 'O\'chirish',
        cancelButtonText: 'Bekor qilish',
        type: 'error'
      }).then(() => {
        this.deleteProduct(row.id)
        this.$message({
          type: 'success',
          message: "Ma'lumot o'chdi"
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: 'deleted canceled'
        });
      });

    },
    save() {
      this.loadingButton = true;
      axios.post("api/product", this.product)
          .then(res => {
            this.loadingButton = false;
            this.dialogFormVisible = false;
            this.product= {};
            this.loadData();
            this.$message({
              type: 'success',
              message: "Ma'lumot saqlandi"
            });
            console.log(res);
          })
    },
    loadData() {
      axios
          .get("api/product")
          .then(res => {
            this.tableData = res.data.content;
          })
    },
    closeModal() {
      this.dialogFormVisible = false;
      this.product = {}
    },
    deleteProduct(id) {
      axios
          .delete(`api/product/${id}`)
          .then(res => {
            console.log(res)
            this.loadData();
          })
    }
  },
    created() {
      this.loadData();
    }
  }

</script>

<style scoped>

</style>