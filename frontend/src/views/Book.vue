<template>
    <div>
        <table>
            <tr>
                <th>编号</th>
                <th>图书名称</th>
                <th>作者</th>
            </tr>
            <tr v-for="item in books">
                <td>{{ item.id }}</td>
                <td>{{ item.name }}</td>
                <td>{{ item.author }}</td>
            </tr>
        </table>
        {{ msg }}
    </div>
</template>

<script>
    export default {
        name: "Book",
        data() {
            return{
                msg: "Hello Vue",
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
            axios.get("http://localhost:8181/book/findAll").then(function(resp){
                _this.books = resp.data;
            })
        }
    }
</script>

<style scoped>

</style>
