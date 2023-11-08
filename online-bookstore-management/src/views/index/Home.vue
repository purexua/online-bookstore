<template>
  <div>
    <el-carousel :interval="4000" type="card" height="300px">
      <el-carousel-item v-for="item in 5" :key="item">
        <img :src="require(`@/assets/images/${item}.jpg`)" class="image-style">
      </el-carousel-item>
    </el-carousel>

    <div class="introduction">
      <!-- <h1>Welcome to Our Online Bookstore</h1>
      <p>Explore a World of Knowledge and Adventure</p>
      <p>Find your next favorite book from our extensive collection.</p>
      <p>Enjoy a seamless shopping experience and discover the joy of reading.</p> -->
      <h1>Welcome to Our Online Bookstore</h1>
      <p>探索知识和冒险的世界</p>
      <p>从我们丰富的藏书中找到您下一本喜爱的书籍</p>
      <p>享受无缝的购物体验，发现阅读的乐趣</p>
    </div>

  </div>
</template>

<script>
export default {
  name: 'Home',
};
</script>

<style scoped>
.image-style {
  width: 100%;
  height: 300px;
  object-fit: cover;
}

.introduction {
  text-align: center;
  margin-top: 30px;
}

.introduction h1 {
  font-size: 2.5em;
  margin-bottom: 20px;
}

.introduction p {
  font-size: 1.2em;
  margin-bottom: 10px;
  color: #666;
}
</style>
