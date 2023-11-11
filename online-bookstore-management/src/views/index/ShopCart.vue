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
      <el-button @click="pay()">支付</el-button>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import order from '@/store/order'
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
    },
    insertOrderId() {
      return this.$store.state.orderInfo.insertOrderId
    },
    bookById() {
      return this.$store.state.bookInfo.bookById
    }
  },
  methods: {
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    toggleSelection() {
      this.$refs.multipleTable.clearSelection();
    },
    async shengcheng() {


      const orderId = this.$store.state.orderInfo.insertOrderId;

      console.log('orderId=', orderId);

    },
    async pay() {
      console.log('userId=', this.user.userId);
      this.$store.dispatch('orderInfo/insertOrder', {
        userId: this.user.userId,
        multipleSelection: this.multipleSelection,
      });

      for (let i = 0; i < this.multipleSelection.length; i++) {
        await this.$store.dispatch('bookInfo/getBookById', this.multipleSelection[i].bookId);
        const money = this.$store.state.bookInfo.bookById.price * this.multipleSelection[i].quantity;
        console.log('money=', money);
        this.$store.dispatch('userInfo/pay', {
          userId: this.user.userId,
          money: money
        });
        await this.$store.dispatch('shopCart/delete', {
          cartId: this.shoppingCart.cartId,
          itemId: this.multipleSelection[i].itemId
        });

        this.$store.dispatch('bookInfo/updateBookAfterPay', {
          bookId: this.multipleSelection[i].bookId,
          quantity: this.multipleSelection[i].quantity
        });
      }
    },
  },
  mounted() {
    this.$store.dispatch('shopCart/getShoppingCart', this.user.userId);
    // this.$store.dispatch('orderInfo/insertOrder', this.user.userId);
  },
  watch: {
    shoppingCart(newVal) {
      this.$store.dispatch('shopCart/getShoppingCartItems', newVal.cartId);
    }
  }
}

</script>

<style></style>