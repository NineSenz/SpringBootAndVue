<template>
    <div>
<!--        <table>-->
<!--            <tr>-->
<!--                <th>编号</th>-->
<!--                <th>图书名称</th>-->
<!--                <th>作者</th>-->
<!--            </tr>-->
<!--            <tr v-for="item in books">-->
<!--                <td>{{ item.id }}</td>-->
<!--                <td>{{ item.name }}</td>-->
<!--                <td>{{ item.author }}</td>-->
<!--            </tr>-->
<!--        </table>-->

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
                books:[
                    {
                        id:1,
                        name:"java零基础实战",
                        author:"九练"
                    },
                    {
                        id:2,
                        name:"Vue零基础实战",
                        author:"九练"
                    },
                    {
                        id:3,
                        name:"Spring Boot零基础实战",
                        author:"九练"
                    },
                ]
            }
        },
        created() {
            const _this = this
            axios.get("http://localhost:8181/book/findAll/1/6").then(function(resp){
                console.log(resp.data.content)
                _this.books = resp.data.content;
                _this.total = resp.data.totalElements;
            })
        },
        methods: {
            page(currentPage) {
                const _this = this
                axios.get("http://localhost:8181/book/findAll/"+currentPage+"/6").then(function(resp){
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
