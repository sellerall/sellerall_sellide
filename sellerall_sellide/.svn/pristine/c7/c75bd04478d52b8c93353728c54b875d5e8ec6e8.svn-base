<template>
  <ul id="pagination" class="pagination justify-content-center mt-3">

    <!-- {{sendData.pageSize}} -->
    <li v-if="currentPagePlag" class="page-item first disabled" @click="sendPage(1)"><a  class="page-link"><i class="fal fa-chevron-double-left"><span class="sr-only">첫페이지</span></i></a></li>
    <li v-else="currentPagePlag"class="page-item first" @click="sendPage(1)"><a  class="page-link"><i class="fal fa-chevron-double-left"><span class="sr-only">첫페이지</span></i></a></li>
    <li v-if="currentPagePlag" class="page-item prev disabled" @click="sendPage(prev)"><a  class="page-link"><i class="fal fa-chevron-left"><span class="sr-only">이전</span></i></a></li>
    <li v-else="currentPagePlag"class="page-item prev" @click="sendPage(prev)"><a  class="page-link"><i class="fal fa-chevron-left"><span class="sr-only">이전</span></i></a></li>

    <li v-for ="(item,idx) in list()" class="page-item" :class="{active: currentPage == item}" :key="item" @click="sendPage(item)"><a  class="page-link">{{item}}</a></li>

    <li v-if="totalPagePlag" class="page-item next disabled" @click="sendPage(next)"><a  class="page-link"><i class="fal fa-chevron-right"><span class="sr-only">다음</span></i></a></li>
    <li v-else="totalPagePlag" class="page-item next" @click="sendPage(next)"><a  class="page-link"><i class="fal fa-chevron-right"><span class="sr-only">다음</span></i></a></li>
    <li v-if="totalPagePlag" class="page-item last disabled" @click="sendPage(totalPage)"><a  class="page-link"><i class="fal fa-chevron-double-right"><span class="sr-only">마지막</span></i></a></li>
    <li v-else="totalPagePlag" class="page-item last" @click="sendPage(totalPage)"><a  class="page-link"><i class="fal fa-chevron-double-right"><span class="sr-only">마지막</span></i></a></li>

  </ul>
</template>

<script>
import {EventBus} from "../../components/event/event-bus";

export default {
  name: 'pagination',
  data(){
    return{
      totalData: 0,
      totalData: 0,
      currentPage: 0,
      dataPerPage: 0,
      pageCount: 0,
      totalPage: 0,
      pageGroup: 0,
      last: 0,
      first: 0,
      next: 0,
      prev: 0,
      currentPagePlag: false,
      pageListPlag:false,
      totalPagePlag: false,
      list: function(){
        let list =[];
        for(let i=this.first ; i <=this.last; i++) list.push(i);
        return list;
      }
    }
  },
  updated () {
    //this.init();
  },
  mounted (){
    EventBus.$on("paginationInfo",userPagination=>{
      this.init(userPagination);
    })
    EventBus.$on("dbPaginationInfo",userPagination=>{
      this.init(userPagination);
    })
    EventBus.$on("domePaginationInfo",userPagination=>{
      this.init(userPagination);
    })
    EventBus.$on("storagePaginationInfo",userPagination=>{
      this.init(userPagination);
    })
  },

  methods: {
    init : function(data){
      this.totalData = data.totalCount;   //총 데이터
      this.currentPage = data.pageIndex; //현재 페이지
      this.dataPerPage = data.pageSize;  //한 페이지에 나타날 데이터 수
      this.pageCount = 5;                         //한 화면에 나타낼수 페이지 수

      this.totalPage = Math.ceil(this.totalData/this.dataPerPage);  //총 페이지 수
      this.pageGroup = Math.ceil(this.currentPage/this.pageCount);  //페이지 그룹
      this.last = this.pageGroup * this.pageCount;                  // 화면에 보여질 마지막 페이지 번호
      if(this.last > this.totalPage) this.last = this.totalPage;
      this.first = ((this.pageGroup - 1) * this.pageCount) + 1;     //화면에 보여질 첫번째 페이지 번호
      this.next = this.last+1;                                      //다음
      if (this.next > this.totalPage ) this.next = this.totalPage ;
      this.prev = this.first-1;                                     //이전
      if (this.prev <1 ) this.prev = 1;

      if(1==this.currentPage){
        this.currentPagePlag=true;
      }else{
        this.currentPagePlag=false;
      }
      if(this.totalPage == this.currentPage){
        this.totalPagePlag=true;
      }else{
        this.totalPagePlag=false;
      }
    },
    sendPage(page){
    //  console.log("클릭됨 :" + page);
      this.$emit("paging",page);
    },

  }
}
</script>

<style>
</style>
