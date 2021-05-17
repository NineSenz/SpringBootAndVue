<template>
    <div>
        <el-table
                :data="books"
                border
                style="width: 100%">
            <el-table-column
                    prop="id"
                    label="编号"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="图书名称"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="author"
                    label="作者">
            </el-table-column>
        </el-table>
        <el-pagination
                background
                layout="prev, pager, next"
                :total=total
                @current-change="page"
        >
        </el-pagination>
    </div>
</template>

<script>
    export default {
        name: "Book",
        data() {
            return{
                msg: "Hello Vue",
                total: null,
                books:null
            }
        },
        created() {
            const _this = this
            axios.get("http://localhost:8181/book/findAll/0/6").then(function(resp){
                console.log(resp.data.content)
                _this.books = resp.data.content;
                _this.total = resp.data.totalElements;
            })
        },
        methods: {
            page(currentPage) {
                const _this = this
                axios.get("http://localhost:8181/book/findAll/"+ (currentPage-1) +"/6").then(function(resp){
                    console.log(resp.data.content)
                    _this.books = resp.data.content;
                    _this.total = resp.data.totalElements;
                })
            }
        }
    }
</script>

<style scoped>

</style>
