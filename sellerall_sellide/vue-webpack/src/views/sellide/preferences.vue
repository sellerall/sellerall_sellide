passwordCheck<template>
  <div class="contents">
    <div class="page-content">
      <div class="title-content">환경설정</div>
      <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="#">셀리드</a></li>
          <li class="breadcrumb-item active" aria-current="page">환경설정</li>
        </ol>
      </nav>

      <div class="nav nav-tabs mb-3" id="tabs" role="tablist">
        <button class="nav-item nav-link" v-for="(tab, index) in tabs" :key="tab.id"
        v-bind:class="{active: currentTab === index}"
        v-on:click="currentTab = index">{{tab}}
        </button>
      </div>

      <div class="tab-content">
      	<!-- 쇼핑몰계정관리 -->
        <div v-show="currentTab==0">
          <div class="info-box my-3">
            <div class="info">
              <div class="input-group" style="width: 200px">
                <select class="custom-select custom-select-sm" title="">
                  <option selected="">전체 쇼핑몰 보기</option>
                  <option>스마트스토어</option>
                </select>
              </div>
            </div>
          </div>
          <div class="card-shadow mb-5">
            <div class="info-box my-3">
              <div class="info">
                <span>● 등록쇼핑몰: 총1 개</span>
              </div>
            </div>
            <div class="scroll">
              <table class="centered table mb-2">
                <colgroup>
                  <col style="width:20%">
                  <col style="width:20%">
                  <col style="width:20%">
                  <col style="width:20%">
                  <col style="width:20%">
                </colgroup>
                <thead>
                <tr>
                  <th style="width:10%">선택</th>
                  <th style="width:10%">쇼핑몰</th>
                  <th style="width:20%">아이디</th>
                  <th style="width:20%">API아이디</th>
                  <th style="width:20%">도메인아이디</th>
                </tr>
                </thead>
                <tbody>
                  <tr v-for ="shopInfo in shopInfoList" :key="shopInfo">
                    <td>
                      <div class="custom-control custom-checkbox">
                        <input type="checkbox" v-model="shop_check" :value="shopInfo.userId" class="custom-control-input">
                        <label class="custom-control-label"></label>
                      </div>
                    </td>             
                    <td>{{shopInfo.shopName}}</td>
                    <td>{{shopInfo.userId}}</td>
                    <td>{{shopInfo.apiId}}</td>
                    <td>{{shopInfo.domainId}}</td>
                  </tr>
                </tbody>
              </table>
            </div>
            <ShopPagination @paging="shopListSend">
            </ShopPagination>           
            <div class="info-box mt-2">
              <div class="wrap-btn">
                <a class="btn btn-outline-dark" @click="loginShop">로그인</a>
                <a class="btn btn-outline-dark" @click="registerShop">쇼핑몰 추가</a>
                <!--<a class="btn btn-outline-dark" @click="editShop">선택 수정</a>-->
                <a class="btn btn-outline-dark" @click="deleteShop">선택 삭제</a>
              </div>
            </div>               
          </div>
        </div>

        <!-- 그룹관리 -->
      	<div v-show="currentTab==1">
      		<div class="card-shadow">
      		</div>
      	</div>
      	
      	<!-- 택배관리 -->
      	<div v-show="currentTab==2">
      	  <div class="card-shadow">
      		</div>
      	</div>
      	
      	<!-- 사용자권한관리 -->
      	<div v-show="currentTab==3">
      		<div class="card-shadow">
      		</div>
      	</div>
          	
      </div>
    <ModalView :send-data="modalMessage" v-if="isModalViewed" @close-modal="isModalViewed=false">
    </ModalView>
    <ShopModalView :send-data="modUserInfo" v-if="isShopModalViewed" @close-modal="isShopModalViewed=false">
    </ShopModalView>
    <EditShopView :send-data="modUserInfo" v-if="isEditShopViewed" @close-modal="isEditShopViewed=false">
    </EditShopView>
    </div>
  </div>
</template>

<script>
import ShopPagination from "../../components/common/pagination"
import ModalView from "../../components/common/alterPopupModal"
import ShopModalView from "../../components/common/registerShopModal";
import EditShopView from "../../components/common/EditShopModal"

export default {
  name: 'tabs',
  data(){
    return{
      currentTab: 0,
      tabs: ['쇼핑몰계정관리', '그룹관리', '택배관리', '사용자권한관리'],
      shopInfoList: [],
      isShopModalViewed: false,
      isEditShopViewed: false,
      shop_check: [],
      modUserInfo : {     //사용자 수정 객체
        userId:"",
        userName:"",
        userEmail:"",
        note: "",
        useYn:"",
        role:""
      },
    }
  },
  components: {
    ShopPagination,
    ShopModalView,
    EditShopView
  },
  created(){
    this.shopListSend();
  },
  methods: {
    shopListSend : function(){
      axios.post('/api/preferences/v1/shopInfoList',{
      }).then(res => {
        this.shopInfoList = res.data;
      })
    },
    loginShop : function(){
      if(this.shop_check == null || this.shop_check == ""){
        alert("로그인할 쇼핑몰을 선택해주세요.");
      } 
      else if(this.shop_check.length > 1){
        alert("한개만 선택해주세요.");
      }
      else {
        alert(this.shop_check);
        axios.post('/api/preferences/v1/loginShop',{
          userId : this.shop_check
        }).then(res => {
          alert(res.data);
        })
      }
    },
    registerShop : function(){
      this.isShopModalViewed = true;
    },
    editShop : function(){
      if(this.shop_check == null || this.shop_check == ""){
        alert("수정할 쇼핑몰을 선택해주세요.");
      }
      else if(this.shop_check.length > 1){
        alert("한개만 선택해주세요.");
      }
      else {
        this.isEditShopViewed = true;
      }
    },
    deleteShop : function(){
      if(this.shop_check == null || this.shop_check == ""){
        alert("삭제할 쇼핑몰을 선택해주세요.");
      }
      else if(this.shop_check.length > 1){
        alert("하나만 선택해주세요.");
      } 
      else {
        alert(this.shop_check);
        axios.post('/api/preferences/v1/deleteShop',{
          userId : this.shop_check
        }).then(res => {
          alert(res.data);
        })
      }
    },
  }
}
</script>

<style scoped>
.v-enter-active,
.v-leave-active {
  transition: opacity 1s, transform 1s;
}
/* 출력할 때는 왼쪽에서 오른쪽으로 */
.v-enter {
  opacity: 0;
  transform: translateX(-10px);
}
/* 사라질 때는 아래로 */
.v-leave-to {
  opacity: 0;
  transform: translateY(10px);
}
</style>
