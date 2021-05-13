<template>
  <div>
    <el-carousel indicator-position="outside">
      <el-carousel-item v-for="item in 4" :key="item" >
        <el-image
                style="width: 1200px; height: 300px"
                :src="'http://placehold.it/1200x300'"
        >
        </el-image>
      </el-carousel-item>
    </el-carousel>
    <el-row>
      <el-col :span="6" v-for="item in books" >
        <el-card :body-style="{ padding: '10px' }">
          <img src="http://placehold.it/200x200" class="image">
          <div style="padding: 20px;">
            <span>{{ item.name }}</span>
            <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>
              <el-button type="text" class="button">立即购买</el-button>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>


</template>
<script>
  export default {
    data() {
      return {
        currentDate: new Date(),
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
      };
    },
    created() {
      const _this = this
      axios.get("http://localhost:8181/book/findAll").then(function(resp){
        _this.books = resp.data;
      })
    }
  }
</script>
<style>
  .el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

  .el-col {
    margin: 40px;
  }
  .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }
</style>
