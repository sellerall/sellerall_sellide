<template>
  <div class="contents">
    <div class="page-content">
      <div>
        {{data}}
      </div>
      <!-- <frameset rows="0,*" frameborder="no" framespacing="0">
          <frame src="about:blank" frameborder="No" framespacing="0" marginheight="" marginwidth="0" noresize scrolling="no">
        	<frame name="main" :src="mySrc" frameborder="No" framespacing="0" noresize scrolling="auto">
      </frameset> -->
    <button type="button" name="button" @click="onclickRedirect()"> naver
    </button>
  </div>
    </div>

</template>

<script>
import axios from 'axios';

//axios.defaults.baseURL = 'http://localhost:8001';
//axios.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8';
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

export default {
  name: 'productmanage',
  data(){
    return{
      data : "",
    }
  },
  mounted () {
    this.dataTest();
  },
  computed: {
    mySrc: {
      get: function(){
        return 'https://sell.smartstore.naver.com/#/products/create'
      }
    }
  },
  methods:{
    onclickRedirect: function(){
      window.open("https://sell.smartstore.naver.com/#/products/create", "_blank");
    },
    dataTest:function () {
      axios.post('https://sell.smartstore.naver.com/#/products/create',{

      }).then(res => {
        this.data = res.data;
      })
    }
  }
}
</script>

<style scoped>
iframe {
  width: 100%;
  height: 100%;
}
</style>
