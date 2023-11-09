<template>
    <div>
        <h1>{{ this.bookType }}类分区</h1>
        <div>
            <el-form :inline="true" :model="formInline" class="demo-form-inline">
                <el-form-item label="书名">
                    <el-input v-model="formInline.title" placeholder="书名"></el-input>
                </el-form-item>
                <el-form-item label="作者">
                    <el-input v-model="formInline.author" placeholder="作者"></el-input>
                </el-form-item>
                <el-form-item label="ISBN">
                    <el-input v-model="formInline.isbn" placeholder="ISBN"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit">查询</el-button>
                </el-form-item>
            </el-form>
        </div>
        <div>
            <el-table :data="tableData" stripe style="width: 100%" height="530">
                <el-table-column prop="bookId" label="图书ID" width="180">
                </el-table-column>
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
                        <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
                            v-if="user.userId === 1">Edit</el-button>
                        <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)"
                            v-if="user.userId === 1">Delete</el-button>
                    </template>
                </el-table-column>
            </el-table>

            <!--  -->

            <el-dialog title="修改图书信息" :visible.sync="dialogFormVisible">
                <el-form :model="editForm" status-icon :rules="rules" ref="editForm" label-width="100px"
                    class="demo-ruleForm">
                    <el-form-item label="图书ID" prop="bookId">
                        <el-input type="text" v-model="editForm.bookId" autocomplete="off" :disabled="true"></el-input>
                    </el-form-item>

                    <el-form-item label="书名" prop="title">
                        <el-input type="text" v-model="editForm.title" autocomplete="off"></el-input>
                    </el-form-item>

                    <el-form-item label="作者" prop="author">
                        <el-input type="text" v-model="editForm.author" autocomplete="off"></el-input>
                    </el-form-item>

                    <el-form-item label="出版社" prop="publisher">
                        <el-input type="text" v-model="editForm.publisher" autocomplete="off"></el-input>
                    </el-form-item>

                    <el-form-item label="ISBN" prop="isbn">
                        <el-input type="text" v-model="editForm.isbn" autocomplete="off"></el-input>
                    </el-form-item>

                    <el-form-item label="价格" prop="price">
                        <el-input type="number" min="0" step="0.01" v-model="editForm.price" autocomplete="off"></el-input>
                    </el-form-item>

                    <el-form-item label="库存" prop="stock">
                        <el-input type="number" min="0" step="1" v-model="editForm.stock" autocomplete="off"></el-input>
                    </el-form-item>

                    <el-form-item label="类型" prop="type">
                        <el-input type="text" v-model="editForm.type" autocomplete="off"></el-input>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="exit('editForm')">取 消</el-button>
                    <el-button type="primary" @click="save('editForm')">确 定</el-button>
                </div>
            </el-dialog>

            <!--  -->

            <div class="footer">
                <el-pagination background layout="prev, pager, next" :total="pageInfo.totalItems"
                    :page-size="pageInfo.pageSize" @current-change="handleCurrentChange" :current-page="pageInfo.pageNum">
                </el-pagination>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios'
import BookHead from '../../components/BookHead.vue'
export default {
    name: 'Book',
    data() {
        var validateISBN = (rule, value, callback) => {
            if (!value) {
                return callback(new Error('ISBN不能为空'));
            }
            // ISBN校验规则，可以根据具体的ISBN格式进行修改
            var regex = /^(?=(?:\D*\d){10}(?:(?:\D*\d){3})?$)[\d-]+$/;
            if (!regex.test(value)) {
                return callback(new Error('请输入有效的ISBN'));
            } else {
                callback();
            }
        };
        var validateTitle = (rule, value, callback) => {
            // 校验书名的规则
            if (!value) {
                return callback(new Error('书名不能为空'));
            } else {
                callback();
            }
        };
        var validateAuthor = (rule, value, callback) => {
            // 校验作者的规则
            if (!value) {
                return callback(new Error('作者不能为空'));
            } else {
                callback();
            }
        };

        var validatePublisher = (rule, value, callback) => {
            // 校验出版社的规则
            if (!value) {
                return callback(new Error('出版社不能为空'));
            } else {
                callback();
            }
        };

        var validatePrice = (rule, value, callback) => {
            // 校验价格的规则
            if (!value) {
                return callback(new Error('价格不能为空'));
            } else if (value <= 0) {
                return callback(new Error('价格必须大于0'));
            } else {
                callback();
            }
        };

        var validateStock = (rule, value, callback) => {
            // 校验库存的规则
            if (!value) {
                return callback(new Error('库存不能为空'));
            } else if (value < 0) {
                return callback(new Error('库存不能为负数'));
            } else {
                callback();
            }
        };

        var validateType = (rule, value, callback) => {
            // 定义图书类别校验规则
            var validTypes = ['科幻', '历史', '计算机', '科普', '儿童读物'];
            if (!value) {
                return callback(new Error('类型不能为空'));
            } else if (!validTypes.includes(value)) {
                return callback(new Error('请输入有效的图书类别，包括: 科幻, 历史, 计算机, 科普, 儿童读物'));
            } else {
                callback();
            }
        };
        return {
            bookType: this.$route.params.bookType,
            formInline: {
                title: '',
                author: '',
                isbn: '',
            },
            editForm: {
                bookId: '',
                title: '',
                author: '',
                publisher: '',
                isbn: '',
                price: '',
                stock: '',
                type: '',
            },
            rules: {
                title: [
                    { validator: validateTitle, trigger: 'blur' }
                ],
                author: [
                    { validator: validateAuthor, trigger: 'blur' }
                ],
                publisher: [
                    { validator: validatePublisher, trigger: 'blur' }
                ],
                isbn: [
                    { validator: validateISBN, trigger: 'blur' }
                ],
                price: [
                    { validator: validatePrice, trigger: 'blur' }
                ],
                stock: [
                    { validator: validateStock, trigger: 'blur' }
                ],
                type: [
                    { validator: validateType, trigger: 'blur' }
                ],
            },
            dialogFormVisible: false,
            searchChange: false,
        }
    },
    computed: {
        pageInfo() {
            return this.$store.state.bookInfo.pageInfo
        },
        tableData() {
            return this.$store.state.bookInfo.tableData
        },
        user() {
            return this.$store.state.userInfo.user
        }
    },
    components: {
        BookHead,
    },
    methods: {
        onSubmit() {
            this.handleCurrentChange(1)
        },
        handleEdit(index, row) {
            // console.log(row.title, row.author, row.publisher, row.isbn, row.price, row.stock, row.type)
            this.editForm.bookId = row.bookId
            this.editForm.title = row.title
            this.editForm.author = row.author
            this.editForm.publisher = row.publisher
            this.editForm.isbn = row.isbn
            this.editForm.price = row.price
            this.editForm.stock = row.stock
            this.editForm.type = row.type
            this.dialogFormVisible = true
        },
        handleDelete(index, row) {
            // console.log(row.title, row.author, row.publisher, row.isbn, row.price, row.stock, row.type)
            this.$confirm('此操作将永久删除, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                axios({
                    method: 'DELETE',
                    url: `http://localhost:3919/serve8080/book/delete/${row.bookId}`,
                }).then(res => {
                    if (res.data === "success") {
                        this.$message({
                            type: 'success',
                            message: '删除图书信息成功！'
                        });
                        // 更新表格数据
                        this.$store.dispatch('bookInfo/getBookData', this.bookType);
                    } else {
                        this.$message({
                            type: 'error',
                            message: res.data
                        })
                    }
                }).catch(err => {
                    console.log(err);
                })
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });
            });


        },
        handleCurrentChange(val) {
            this.$store.commit('bookInfo/SETPAGENUM', val)
            if (this.formInline.title === '' && this.formInline.author === '' && this.formInline.isbn === '') {
                this.$store.dispatch('bookInfo/getBookData', this.bookType)
            } else {
                const data = {
                    pageNum: this.pageInfo.pageNum,
                    pageSize: this.pageInfo.pageSize,
                    title: this.formInline.title,
                    author: this.formInline.author,
                    isbn: this.formInline.isbn,
                    type: this.bookType,
                }
                this.$store.dispatch('bookInfo/getBookDataExist', data)
            }
        },
        exit(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.dialogFormVisible = false
                    this.editForm.bookId = ''
                    this.editForm.title = ''
                    this.editForm.author = ''
                    this.editForm.publisher = ''
                    this.editForm.isbn = ''
                    this.editForm.price = ''
                    this.editForm.stock = ''
                    this.editForm.type = ''
                    this.$message({
                        type: 'info',
                        message: '取消修改图书信息！'
                    });
                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
        save(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.dialogFormVisible = false
                    axios({
                        method: 'PUT',
                        url: 'http://localhost:3919/serve8080/book/update',
                        params: {
                            bookId: this.editForm.bookId,
                            title: this.editForm.title,
                            author: this.editForm.author,
                            publisher: this.editForm.publisher,
                            isbn: this.editForm.isbn,
                            price: this.editForm.price,
                            stock: this.editForm.stock,
                            type: this.editForm.type,
                        }
                    }).then(res => {
                        if (res.data === "success") {
                            this.$message({
                                type: 'success',
                                message: '修改图书信息成功！'
                            });
                            // 更新表格数据
                            this.$store.dispatch('bookInfo/getBookData', this.bookType);
                        } else {
                            this.$message({
                                type: 'error',
                                message: res.data
                            });
                        }
                    }).catch(err => {
                        console.log(err);
                    })
                    this.editForm.bookId = ''
                    this.editForm.title = ''
                    this.editForm.author = ''
                    this.editForm.publisher = ''
                    this.editForm.isbn = ''
                    this.editForm.price = ''
                    this.editForm.stock = ''
                    this.editForm.type = ''
                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
    },
    mounted() {
        this.$store.dispatch('bookInfo/getBookData', this.bookType)
    },
    watch: {
        $route(to, from) {
            if (to.params.bookType !== this.bookType) {
                this.bookType = to.params.bookType;
                // 重置页数为第一页
                this.$store.commit('bookInfo/SETPAGENUM', 1);
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