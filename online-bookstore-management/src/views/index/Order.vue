<template>
    <div>
        <h1>订单管理</h1>
        <!-- <div>
            <el-form :inline="true" :model="formInline" class="demo-form-inline">
                <el-form-item label="订单号">
                    <el-input v-model="formInline.orderId" placeholder="订单号"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit">查询</el-button>
                </el-form-item>
            </el-form>
        </div> -->
        <!-- 废弃该功能 -->

        <el-table :data="order" style="width: 100%" height="564">
            <el-table-column sortable prop="orderId" label="订单 ID" width="180">
            </el-table-column>
            <el-table-column sortable default-sort prop="orderDate" label="订单时间" width="180" :formatter="formatter">
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="100">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
                </template>
            </el-table-column>
        </el-table>


        <el-dialog title="订单信息" :visible.sync="dialogTableVisible">
            <el-table :data="gridData">
                <el-table-column property="orderItemId" label="订单项 ID" width="150"></el-table-column>
                <el-table-column property="orderId" label="订单 ID" width="200"></el-table-column>
                <el-table-column property="bookId" label="图书 ID"></el-table-column>
                <el-table-column fixed="right" label="操作" width="100">
                <template slot-scope="scope">
                    <el-button @click="handleClick2(scope.row)" type="text" size="small">详细图书信息</el-button>
                </template>
            </el-table-column>
            </el-table>
        </el-dialog>

        <el-dialog title="详细订单信息" :visible.sync="dialogFormVisible">
            <el-form :model="bookById" size="mini">
                <el-form-item label="图书 ID" :label-width="formLabelWidth">
                    <el-input v-model="bookById.bookId" autocomplete="off" disabled></el-input>
                </el-form-item>
                <el-form-item label="图书名称" :label-width="formLabelWidth">
                    <el-input v-model="bookById.title" autocomplete="off" disabled></el-input>
                </el-form-item>
                <el-form-item label="图书作者" :label-width="formLabelWidth">
                    <el-input v-model="bookById.author" autocomplete="off" disabled></el-input>
                </el-form-item>
                <el-form-item label="图书出版社" :label-width="formLabelWidth">
                    <el-input v-model="bookById.publisher" autocomplete="off" disabled></el-input>
                </el-form-item>
                <el-form-item label="图书 ISBN" :label-width="formLabelWidth">
                    <el-input v-model="bookById.isbn" autocomplete="off" disabled></el-input>
                </el-form-item>
                <el-form-item label="图书价格" :label-width="formLabelWidth">
                    <el-input v-model="bookById.price" autocomplete="off" disabled></el-input>
                </el-form-item>
                <el-form-item label="图书类型" :label-width="formLabelWidth">
                    <el-input v-model="bookById.type" autocomplete="off" disabled></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="cancel">取 消</el-button>
                <el-button type="primary" @click="confirm">确 定</el-button>
            </div>
        </el-dialog>

        

        <div class="footer">
            <el-pagination background layout="prev, pager, next" :total="pageInfoOrder.totalItems"
                :page-size="pageInfoOrder.pageSize" @current-change="handleCurrentChange"
                :current-page="pageInfoOrder.pageNum">
            </el-pagination>
        </div>
    </div>
</template>

<script>
import dayjs from 'dayjs'
export default {
    name: 'Order',
    data() {
        return {
            formInline: {
                orderId: ''
            },
            orderDescription: {
                userId: '',
                orderId: '',
                bookId: '',
                bookName: '',
                bookAuthor: '',
                bookPublisher: '',
                bookIsbn: '',
                bookPrice: '',
                bookType: '',
                orderDate: ''
            },
            gridData: [],
            dialogTableVisible: false,
            dialogFormVisible: false,
            formLabelWidth: '120px',
        }
    },
    computed: {
        user() {
            return this.$store.state.userInfo.user
        },
        order() {
            return this.$store.state.orderInfo.order
        },
        orderById() {
            return this.$store.state.orderInfo.orderById
        },
        pageInfoOrder() {
            return this.$store.state.orderInfo.pageInfoOrder
        },
        orderItemById(){
            return this.$store.state.orderInfo.orderItemById
        },
        bookById(){
            return this.$store.state.bookInfo.bookById
        }

    },
    methods: {
        onSubmit() {
            this.handleCurrentChange(1)
        },
        formatter(row, column) {
            return dayjs(row.orderDate).format('YYYY年MM月DD日 HH:mm:ss')
        },
        handleCurrentChange(val) {
            this.$store.commit('orderInfo/SETPAGENUM', val)
            if (this.formInline.orderId === '') {
                this.$store.dispatch('orderInfo/getOrderData', this.user.userId)
            } else {
                const data = {
                    userId: this.user.userId,
                    orderId: this.formInline.orderId
                }
                this.$store.dispatch('orderInfo/getOrderById', data)
            }
        },
        handleClick(row) {
            this.dialogTableVisible = true;
            this.$store.dispatch('orderInfo/getOrderItemById', row.orderId)
        },
        handleClick2(row) {
            this.dialogFormVisible = true;
            this.$store.dispatch('bookInfo/getBookById', row.bookId)
        },
        cancel() {
            this.dialogFormVisible = false;
        },
        confirm() {
            this.dialogFormVisible = false;
        },

    },
    mounted() {
        this.$store.dispatch('orderInfo/getOrderData', this.user.userId)
    },
    watch: {
        orderItemById(newVal) {
            this.gridData = newVal;
        }
    },
}
</script>

<style scoped>
.footer {
    display: flex;
    justify-content: center;
    margin: 20px 0;
}
</style>