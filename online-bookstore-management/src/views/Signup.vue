<template>
    <div>
        <h1>用户注册</h1>
        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

            <el-form-item label="用户名" prop="userNamr">
                <el-input v-model="ruleForm.userName" autocomplete="off"></el-input>
            </el-form-item>

            <el-form-item label="密码" prop="password">
                <el-input type="password" v-model="ruleForm.password" autocomplete="off">
                </el-input>
            </el-form-item>

            <el-form-item label="真实姓名" prop="realName">
                <el-input v-model.trim="ruleForm.realName" autocomplete="off"></el-input>
            </el-form-item>

            <el-form-item label="邮箱" prop="email">
                <el-input v-model.trim="ruleForm.email" autocomplete="off"></el-input>
            </el-form-item>

            <el-form-item label="地址" prop="address">
                <el-input v-model.trim="ruleForm.address" autocomplete="off"></el-input>

            </el-form-item>

            <el-form-item label="电话号码" prop="phoneNumber">
                <el-input v-model.trim="ruleForm.phoneNumber" autocomplete="off"></el-input>
            </el-form-item>

            <el-form-item label="余额" prop="balance">
                <el-input v-model="ruleForm.balance" autocomplete="off" :disabled="true" placeholder="0"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="register('ruleForm')">注册</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import axios from 'axios';
export default {

    name: 'SignUp',
    data() {
        var validateRealName = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请输入真实姓名'));
            } else {
                callback();
            }
        };

        var validateEmail = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请输入邮箱'));
            } else {
                if (!/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test(value)) {
                    callback(new Error('邮箱格式不正确'));
                } else {
                    callback();
                }
            }
        };

        var validateAddress = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请输入地址'));
            } else {
                callback();
            }
        };

        var validatePhoneNumber = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请输入电话号码'));
            } else {
                if (!/^[0-9]{11}$/.test(value)) {
                    callback(new Error('电话号码格式不正确'));
                } else {
                    callback();
                }
            }
        };
        return {
            ruleForm: {
                userId: '',
                userName: '',
                password: '',
                realName: '',
                email: '',
                address: '',
                phoneNumber: '',
                balance: 0
            },
            rules: {
                realName: [
                    { validator: validateRealName, trigger: 'blur' }
                ],
                email: [
                    { validator: validateEmail, trigger: 'blur' }
                ],
                address: [
                    { validator: validateAddress, trigger: 'blur' }
                ],
                phoneNumber: [
                    { validator: validatePhoneNumber, trigger: 'blur' }
                ]
            }
        };
    },
    methods: {
        register(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    console.log(this.ruleForm);
                    axios({
                        method : 'post',
                        url :  `http://localhost:3919/serve8080/register`,
                        params : {
                            userName : this.ruleForm.userName,
                            password : this.ruleForm.password,
                            realName : this.ruleForm.realName,
                            email : this.ruleForm.email,
                            address : this.ruleForm.address,
                            phoneNumber : this.ruleForm.phoneNumber,
                            balance : this.ruleForm.balance
                        }
                    }).then(res => {
                        if (res.data === 'success') {
                            this.$message({
                                message: '注册成功',
                                type: 'success'
                            })
                            this.$router.push('/login')
                        } else {
                            this.$message({
                                message: '注册失败',
                                type: 'error'
                            })
                        }
                    }).catch(err => {
                        console.log(err)
                    })
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


<style lang="scss" scoped></style>
