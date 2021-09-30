<template>
  <!-- s 팝업 -->
  <transition name="modal">
    <div class="modal-mask">
      <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-container">
          <div class="modal-header">
            <span class="modal-title">쇼핑몰 추가</span>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close" @click="$emit('close-modal')">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body pb-0">
            <div class="table table-vertical mb-4">
              <table class="v-table">
                <colgroup>
                  <col style="width: 30%;">
                  <col style="width: 70%;">
                </colgroup>
                <tbody>
                  <tr>
                    <td class="text-center">쇼핑몰 선택<i class="fas fa-check icon-check"></i></td>
                    <td id="passFormId">
                      <div class="input-group float-left" style="width: 200px">
                        <select v-model="selectedShop" class="custom-select custom-select-sm">
                          <option disabled value="">쇼핑몰을 선택하세요.</option>
                          <option v-for="shop in shopList" v-bind:value="shop" :key="shop">
                            {{shop.shopName}}
                          </option>
                        </select>          
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="text-center">아이디<i class="fas fa-check icon-check"></i></td>
                    <td>
                      <div class="form-group">
                        <label>아이디</label>
                        <input type="text" class="form-control form-control-sm"  v-model="userId">
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="text-center">비밀번호<i class="fas fa-check icon-check"></i></td>
                    <td>
                      <div class="form-group">
                        <label>비밀번호</label>
                        <input type="password" class="form-control form-control-sm"  v-model="userPw">
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="text-center">API 연동용 판매자 ID<i class="fas fa-check icon-check"></i></td>
                    <td>
                      <div class="form-group">
                        <label>API 연동용 판매자 ID</label>
                        <input type="text" class="form-control form-control-sm"  v-model="sellerId">
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="text-center">API 아이디<i class="fas fa-check icon-check"></i></td>
                    <td>
                      <div class="form-group">
                        <label>API 아이디</label>
                        <input type="text" class="form-control form-control-sm"  v-model="apiId">
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="text-center">도메인 아이디<i class="fas fa-check icon-check"></i></td>
                    <td>
                      <div class="form-group">
                        <label>도메인 아이디</label>
                        <input type="text" class="form-control form-control-sm"  v-model="domainId">
                      </div>
                    </td>
                  </tr>                                    
                </tbody>
              </table>
            </div>
          </div>
          <div class="modal-footer pt-0">
            <button type="button" class="btn btn-primary com-modal-btn" @click="shopSave" >저장</button>
            <button type="button" class="btn btn-outline-secondary com-modal-btn" data-dismiss="modal" @click="$emit('close-modal')">닫기</button>
          </div>
        </div>
      </div>
    </div>
  </transition>
  <!-- e 팝업 -->
</template>


<script>
export default {
  name: 'registerShopModal',
  props: ['sendData'],
  data(){
    return{
      shopList : [],
      selectedShop : '',

      modalMessage:"",
      passwordCheck:'',
      shopInfo : {     //쇼핑몰 객체
        userId : this.userId,
        userPw : this.userPw,
        sellerId : this.sellerId,
        apiId : this.apiId,
        domainId : this.domainId
      },
      isModalViewed: false
    }
  },
  mounted(){
    axios.post('/api/preferences/v1/shopList',{
    }).then(res => {
      this.shopList = res.data;
    })
  },
  methods: {
    shopSave : function() {
      if(this.selectedShop == null || this.selectedShop == ""){
        alert("쇼핑몰을 선택해주세요");
        return;
      }
      if(this.userId == null || this.userId == ""){
        alert("아이디를 입력해주세요.");
        return;
      }
      if(this.userPw == null || this.userPw == ""){
        alert("비밀번호를 입력해주세요.");
        return;
      }
      if(this.sellerId == null || this.sellerId == ""){
        alert("판매자 아이디를 입력해주세요.");
        return;
      }
      if(this.apiId == null || this.apiId == ""){
        alert("API 아이디를 입력해주세요.");
        return;
      }
      if(this.domainId == null || this.domainId == ""){
        alert("도메인 아이디를 입력해주세요.");
        return;
      }
      axios.post('/api/preferences/v1/saveShopInfo',{
        shopCode : this.selectedShop.shopCode,
        shopName : this.selectedShop.shopName,
        userId : this.userId,
        userPw : this.userPw,
        sellerId : this.sellerId,
        apiId : this.apiId,
        domainId : this.domainId
      }).then(res => {
        alert(res.data);
        this.$emit('close-modal');
        reloadShop;
      })
    },
    reloadShop : function(){
      axios.post('/api/preferences/v1/shopList',{
      }).then(res => {
        this.shopList = res.data;
      })
    }
  }
}
</script>


<style>
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, .5);
  display: table;
  transition: opacity .3s ease;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}

.modal-container {
  position: relative;
  display: flex;
  flex-direction: column;
  width: 100%;
  pointer-events: auto;
  background-color: #fff;
  background-clip: padding-box;
  outline: 0;

  margin: 0px auto;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, .33);
  transition: all .3s ease;
}


/*
* The following styles are auto-applied to elements with
* transition="modal" when their visibility is toggled
* by Vue.js.
*
* You can easily play with the modal transition by editing
* these styles.
*/

.modal-enter {
  opacity: 0;
}

.modal-leave-active {
  opacity: 0;
}

.modal-enter .modal-container,
.modal-leave-active .modal-container {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}
</style>
