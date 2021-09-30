<template>
  <!-- s 팝업 -->
  <transition name="modal">
    <div class="modal-mask">
      <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-container">
          <div class="modal-header">
            <span class="modal-title">패스워드변경</span>
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
                    <td class="text-center">이메일</td>
                    <td id="passFormId">{{sendData.userEmail}}</td>
                  </tr>
                  <tr>
                    <td class="text-center">비밀번호<i class="fas fa-check icon-check"></i></td>
                    <td>
                      <div class="form-group">
                        <label for="passPwd">비밀번호</label>
                        <input type="password" placeholder="" id="passPwd" title="text" class="form-control form-control-sm"  v-model="modUserInfo.userPwd">
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td class="text-center">비밀번호 확인<i class="fas fa-check icon-check"></i></td>
                    <td>
                      <div class="form-group">
                        <label for="passPwdConfirm">비밀번호</label>
                        <input type="password" placeholder="" id="passPwdConfirm" title="text" class="form-control form-control-sm"  v-model:value="passwordCheck" @blur="passwordCheckValid">
                        <span class="color-cred ml-2" v-show="passwordCheckFlag">*비밀번호가 동일하지 않습니다.</span>
                      </div>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
          <div class="modal-footer pt-0">
            <button type="button" class="btn btn-primary com-modal-btn" @click="modifySend" >저장</button>
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
  name: 'passwordPopupModal',
  props: ['sendData'],
  data(){
    return{
      modalMessage:"",
      passwordCheck:'',
      modUserInfo : {     //사용자 수정 객체
        userId:this.sendData.userId,
        userPwd:'',
        userName:this.sendData.userName,
        userEmail:this.sendData.userEmail,
        note: this.sendData.note,
        useYn:this.sendData.useYn,
        role:this.sendData.role
      },
      isModalViewed: false,
      passwordCheckFlag: false,
    }
  },
  methods: {
    //사용자 수정 적용 axios
    modifySend: function() {
      if(this.passwordCheckFlag ==true){
        alert("비밀번호를 확인해 주세요.")
        return ;
      }
      //console.log(this.modUserInfo);
      axios.put('/api/sys/v1/user',this.modUserInfo).then(res => {
        console.log(this.modUserInfo);
        alert("수정 완료");
        this.$emit('close-modal');
      })
      .catch(res => {
        if(res.response.status =="403"){
          this.modalMessage="수정 권한이 없습니다.";
          alert(this.modalMessage);
        }else if(res.response.status =="401"){
          alert("인증 기간이 만료되었습니다.");
          this.$router.go('/');
        }else{
          this.modalMessage=res.response.data;
          alert(this.modalMessage);
        }
      })
    },
    //비밀번호 확인
    passwordCheckValid: function () {
      //console.log(" 비밀번호 확인 ");
      if (this.modUserInfo.userPwd === this.passwordCheck) {
        this.passwordCheckFlag = false;
      } else {
        this.passwordCheckFlag = true;
      }
    },
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
