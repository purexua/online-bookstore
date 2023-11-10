<template>
  <div>
    <h1>购物车</h1>
    <el-table ref="multipleTable" :data="shoppingCartItems" tooltip-effect="dark" style="width: 100%"
      @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55">
      </el-table-column>
      <el-table-column prop="itemId" label="购物车项编号" width="180">
      </el-table-column>
      <el-table-column prop="bookId" label="书籍编号" width="180">
      </el-table-column>
      <el-table-column prop="cartId" label="购物车编号" width="180">        
      </el-table-column>     
      <el-table-column prop="quantity" label="数量" width="180">   
      </el-table-column>
    </el-table>
    <div style="margin-top: 20px">
      <el-button @click="toggleSelection()">取消选择</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ShopCart',
  data() {
    return {
      multipleSelection: []
    }
  },
  computed: {
    shoppingCart() {
      return this.$store.state.shopCart.shoppingCart
    },
    user() {
      return this.$store.state.userInfo.user
    },
    shoppingCartItems() {
      return this.$store.state.shopCart.shoppingCartItems
    }
  },
  methods: {
    handleSelectionChange(val) {
      console.log(val);
      this.multipleSelection = val;
    },
    toggleSelection() {
      this.$refs.multipleTable.clearSelection();
    },
  },
  mounted() {
    this.$store.dispatch('shopCart/getShoppingCart', this.user.userId);

  },
  watch: {
    shoppingCart(newVal) {
      this.$store.dispatch('shopCart/getShoppingCartItems', newVal.cartId);
    }
  }
}
</script>

<style></style>