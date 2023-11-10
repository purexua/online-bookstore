<template>
  <el-dialog title="订单信息" :visible.sync="dialogFormVisible">
            <el-form :model="form" size="mini">
                <el-form-item label="用户 ID" :label-width="formLabelWidth">
                    <el-input v-model="form.userId" autocomplete="off" disabled></el-input>
                </el-form-item>
                <el-form-item label="订单 ID" :label-width="formLabelWidth">
                    <el-input v-model="form.orderId" autocomplete="off" disabled></el-input>
                </el-form-item>
                <el-form-item label="图书 ID" :label-width="formLabelWidth">
                    <el-input v-model="form.bookId" autocomplete="off" disabled></el-input>
                </el-form-item>
                <el-form-item label="图书名称" :label-width="formLabelWidth">
                    <el-input v-model="form.bookName" autocomplete="off" disabled></el-input>
                </el-form-item>
                <el-form-item label="图书作者" :label-width="formLabelWidth">
                    <el-input v-model="form.bookAuthor" autocomplete="off" disabled></el-input>
                </el-form-item>
                <el-form-item label="图书出版社" :label-width="formLabelWidth">
                    <el-input v-model="form.bookPublisher" autocomplete="off" disabled></el-input>
                </el-form-item>
                <el-form-item label="图书 ISBN" :label-width="formLabelWidth">
                    <el-input v-model="form.bookIsbn" autocomplete="off" disabled></el-input>
                </el-form-item>
                <el-form-item label="图书价格" :label-width="formLabelWidth">
                    <el-input v-model="form.bookPrice" autocomplete="off" disabled></el-input>
                </el-form-item>
                <el-form-item label="图书类型" :label-width="formLabelWidth">
                    <el-input v-model="form.bookType" autocomplete="off" disabled></el-input>
                </el-form-item>
                <el-form-item label="订单时间" :label-width="formLabelWidth">
                    <el-input v-model="form.orderDate" autocomplete="off" disabled></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="cancel">取 消</el-button>
                <el-button type="primary" @click="confirm">确 定</el-button>
            </div>
        </el-dialog>
</template>

<script>
export default {

}
</script>

<style>

</style>