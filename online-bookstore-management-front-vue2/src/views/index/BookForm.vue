<template>
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" >
        <el-form-item label="书名" prop="title">
            <el-input type="text" v-model="ruleForm.title" autocomplete="off" ></el-input>
        </el-form-item>

        <el-form-item label="作者" prop="author">
            <el-input type="text" v-model="ruleForm.author" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="出版社" prop="publisher">
            <el-input type="text" v-model="ruleForm.publisher" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="ISBN" prop="isbn">
            <el-input type="text" v-model="ruleForm.isbn" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="价格" prop="price">
            <el-input type="number" min="0" step="0.01" v-model="ruleForm.price" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="库存" prop="stock">
            <el-input type="number" min="0" step="1" v-model="ruleForm.stock" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="类型" prop="type">
            <el-input type="text" v-model="ruleForm.type" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
import axios from 'axios';
import { Message } from 'element-ui';
export default {
    name: 'BookForm',
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
            ruleForm: {
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
            }
        };
    },
    methods: {
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    axios({
                        method: 'post',
                        url: 'http://localhost:3919/serve8080/book/add',
                        params: {
                            title: this.ruleForm.title,
                            author: this.ruleForm.author,
                            publisher: this.ruleForm.publisher,
                            isbn: this.ruleForm.isbn,
                            price: this.ruleForm.price,
                            stock: this.ruleForm.stock,
                            type: this.ruleForm.type,
                        }
                    }).then(function (res) {
                        if (res.data === "success") {
                            Message.success("添加图书成功！");
                        }else{
                            Message.error(res.data);
                        }
                    }).catch(function (err) {
                        console.log(err);
                    }
                    );

                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        }
    }
}

</script>

<style></style>