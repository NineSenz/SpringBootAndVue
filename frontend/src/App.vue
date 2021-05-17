<template>
  <div id="app">
    <el-container>
      <el-header>Header</el-header>
      <el-container>
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
          <el-menu router>
            <el-menu-item index="/">首页</el-menu-item>
            <el-menu-item index="/AddBook">添加书籍</el-menu-item>
            <el-menu-item index="/BookList">查看书籍</el-menu-item>
          </el-menu>
        </el-aside>
        <el-container>
          <el-main>
            <router-view>
              <router-link to="/">Home</router-link>
              <router-link to="/about">About</router-link>
              <router-link to="/book">Book</router-link>
            </router-view>
          </el-main>
        </el-container>
      </el-container>
      <el-footer>Footer</el-footer>
    </el-container>

  </div>
</template>

<script>
import Home from './views/Home'
export default {
  name: 'app',
  components: {
    Home
  }
}
</script>

<style>
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
    height:100px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 60px;
    height: 500px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
  .content{
    margin-bottom:130px;
  }
</style>
