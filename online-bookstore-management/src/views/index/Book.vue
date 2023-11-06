<template>
    <div>
        <BookHead></BookHead>
        <div>
            <el-table :data="tableData" stripe style="width: 100%" height="600">
                <el-table-column prop="title" label="书名" width="180">
                </el-table-column>
                <el-table-column prop="author" label="作者" width="180">
                </el-table-column>
                <el-table-column prop="publisher" label="出版社">
                </el-table-column>
                <el-table-column prop="isbn" label="ISBN">
                </el-table-column>
                <el-table-column prop="price" label="价格">
                </el-table-column>
                <el-table-column prop="stock" label="库存">
                </el-table-column>
                <el-table-column align="right" label="操作">
                    <template slot-scope="scope">
                        <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
                        <el-button size="mini" type="danger"
                            @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
                    </template>
                </el-table-column>
            </el-table>

            <div class="footer">
                <el-pagination background layout="prev, pager, next" :total="pageInfo.totalItems"
                    :page-size="pageInfo.pageSize" @current-change="handleCurrentChange">
                </el-pagination>
            </div>
        </div>
    </div>
</template>

<script>
import BookHead from '../../components/BookHead.vue'

export default {
    name: 'Book',
    data() {
        return {
            bookType: this.$route.params.bookType,
        }
    },
    computed: {
        pageInfo() {
            return this.$store.state.bookInfo.pageInfo
        },
        tableData() {
            return this.$store.state.bookInfo.tableData
        },
    },
    components: {
        BookHead
    },
    methods: {
        handleEdit(index, row) {
            console.log(index, row);
        },
        handleDelete(index, row) {
            console.log(index, row);
        },
        handleCurrentChange(val) {
            this.$store.commit('bookInfo/SETPAGENUM', val)
            this.$store.dispatch('bookInfo/getBookData', this.bookType)
        },
    },
    mounted() {
        this.$store.dispatch('bookInfo/getBookData', this.bookType)
    },
    watch: {
    $route(to, from) {
        if (to.params.bookType !== this.bookType) {
            this.bookType = to.params.bookType;
            this.$store.dispatch('bookInfo/getBookData', this.bookType);
        }
    },
},

}
</script>

<style>
.footer {
    display: flex;
    justify-content: center;
    margin: 20px 0;
}
</style>