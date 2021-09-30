<template>
  <!-- S content -->
  <div class="contents">
    <div class="page-content">
      <div class="title-content">사용자 목록</div>
      <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="#">시스템관리</a></li>
          <li class="breadcrumb-item active" aria-current="page">사용자 관리</li>
        </ol>
      </nav>

      <div class="card-shadow mb-5"> <!-- card-shadow 클래스 추가 -- 2020.11.13 -->
        <div class="info-box mb-3">
          <div class="info">
            <span>● 사용자 관리</span>
          </div>
          <div class="wrap-btn">
            <div class="input-group">
              <select class="custom-select custom-select-sm" title="" @change="selectChange($event)">
                <option value="userId" selected="">아이디</option>
                <option value="userEmail">이메일</option>
                <option value="userName">이름</option>
                <option value="useYn">사용여부</option>
              </select>
            </div>
            <input type="text" class="form-control form-control-sm" title="text" placeholder="" v-model="searchKwd">
            <a class="btn btn-outline-dark" href="#" @click="searchBtn">검색</a>
          </div>
        </div>
        <!-- s 테이블 -->
        <div class="user-wrap">
          <div class="scroll">
            <table class="centered table">
              <colgroup>
                <col style="width:178px">
                <col style="width:178px">
                <col style="width:100px">
                <col style="width:50%">
                <col style="width:149px">
                <col style="width:179px">
              </colgroup>
              <thead>
                <tr>
                  <th style="width:214px">아이디</th>
                  <th style="width:214px">이메일</th>
                  <th style="width:114px">이름</th>
                  <th style="width:337px">설명</th>
                  <th style="width:178px">사용여부</th>
                  <th style="width:214px">권한</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for ="(item,idx) in userList" :key="idx" :class="{active: idx === selectedTab}" @click="userTabClick(item,idx)">
                  <td>{{item.userId}}</td>
                  <td>{{item.userEmail}}</td>
                  <td>{{item.userName}}</td>
                  <td>{{item.note}}</td>
                  <td>{{item.useYn | changeUserYn}}</td>
                  <td>{{item.role | changeRole}}</td>
                </tr>
                <!-- <tr>
                <td>admin</td>
                <td></td>
                <td></td>
                <td>Y</td>
                <td>관리자</td>
              </tr>
              <tr>
              <td>admin</td>
              <td></td>
              <td></td>
              <td>Y</td>
              <td>관리자</td>
            </tr>
            <tr>
            <td>admin</td>
            <td></td>
            <td></td>
            <td>Y</td>
            <td>관리자</td>
          </tr>
          <tr>
          <td>admin</td>
          <td></td>
          <td></td>
          <td>Y</td>
          <td>관리자</td>
        </tr>
        <tr>
        <td>admin</td>
        <td></td>
        <td></td>
        <td>Y</td>
        <td>관리자</td>
      </tr>
      <tr>
      <td>admin</td>
      <td></td>
      <td></td>
      <td>Y</td>
      <td>관리자</td>
    </tr>
    <tr>
    <td>admin</td>
    <td></td>
    <td></td>
    <td>Y</td>
    <td>관리자</td>
  </tr>
  <tr>
  <td>admin</td>
  <td></td>
  <td></td>
  <td>Y</td>
  <td>관리자</td>
</tr>
<tr>
<td>admin</td>
<td></td>
<td></td>
<td>Y</td>
<td>관리자</td>
</tr> -->
</tbody>
</table>
</div>
<UserPagination @paging="userListSend">
</UserPagination>
</div>
<!-- e 테이블 -->
<!-- s 버튼 영역 -->
<div class="info-box mb-0">
  <div class="wrap-btn">
    <a class="btn btn-outline-dark" v-on:click="addUser">사용자 추가</a>
  </div>
</div>
<!-- e 버튼 영역 -->
</div>

<transition>
  <div class="box-grey box-grey-sm no-bullet mb-5" id="regForm" v-show="addFlag">
    <div class="info-box mb-3">
      <div class="info">
        <span>● 사용자 등록</span>
      </div>
    </div>
    <div class="row mb-2">
      <div class="col col-12">
        <div class="col-title">아이디<i class="fas fa-check icon-check"></i></div>
        <div class="col-desc" style="width: 450px">
          <input type="text" class="form-control form-control-sm d-inline-block" title="text" placeholder="" id="regUserId" v-model="register.userId"
          style="width: 150px">
          <a class="btn btn-sm btn-outline-dark d-inline-block" @click="duplicateIdCheck(register.userId)">중복 체크</a>
          <span class="ml-2" v-bind:class="idClassAttribute" v-show="duplicateIdCheckFlag">{{idErrorsMessage}}</span>
        </div>
        <div class="col-title">설명</div>
        <div class="col-desc" style="width: 300px">
          <input type="text" class="form-control form-control-sm" title="text" placeholder="" id="regUserNote" v-model="register.note">
        </div>
      </div>
    </div>
    <div class="row mb-2">
      <div class="col col-12">
        <div class="col-title">이메일<i class="fas fa-check icon-check"></i></div>
        <div class="col-desc" style="width: 450px">
          <input type="text" class="form-control form-control-sm d-inline-block" title="text" placeholder="" id="regUserEmail" v-model="register.userEmail"
          style="width: 150px">
          <a class="btn btn-sm btn-outline-dark d-inline-block" @click="duplicateEmailCheck(register.userEmail)">중복 체크</a>
          <span class="ml-2" v-bind:class="emailClassAttribute" v-show="duplicateEmailCheckFlag">{{emailErrorsMessage}}</span>
        </div>
        <div class="col-title">이름<i class="fas fa-check icon-check"></i></div>
        <div class="col-desc" style="width: 300px">
          <input type="text" class="form-control form-control-sm" title="text" placeholder="" id="regUserName" v-model="register.userName"
          style="width:300px">
        </div>
      </div>
    </div>
    <div class="row mb-2">
      <div class="col col-12">
        <div class="col-title">비밀번호<i class="fas fa-check icon-check"></i></div>
        <div class="col-desc" style="width: 450px">
          <input type="password" class="form-control form-control-sm" title="text" placeholder="" id="regUserPwd" v-model="register.userPwd"
          style="width:300px">
        </div>
        <div class="col-title">비밀번호 확인<i class="fas fa-check icon-check"></i></div>
        <div class="col-desc" style="width: 200px">
          <input type="password" class="form-control form-control-sm" title="text" placeholder="" v-model="passwordCheckText" @blur="passwordCheckValid"
          style="width:150px">
          <span class="color-cred ml-2" v-show="passwordCheckFlag">*비밀번호가 동일하지 않습니다.</span>
        </div>
      </div>
    </div>
    <div class="row mb-2">
      <div class="col col-12">
        <!-- <div class="col-title">관리자 권한<i class="fas fa-check icon-check"></i></div>
        <div class="col-desc" style="width: 450px">
          <div class="radio-wrap">
            <div class="custom-control custom-radio custom-control-inline">
              <input type="radio" id="regAdminY" name="Radio" class="custom-control-input" >
              <label class="custom-control-label" for="regAdminY">사용</label>
            </div>
            <div class="custom-control custom-radio custom-control-inline">
              <input type="radio" id="regAdminN" name="Radio" class="custom-control-input" checked="">
              <label class="custom-control-label" for="regAdminN">미사용</label>
            </div>
          </div>
        </div> -->
        <div class="col-title">사용 여부<i class="fas fa-check icon-check"></i></div>
        <div class="col-desc" style="width: 300px">
          <div class="radio-wrap">
            <div class="custom-control custom-radio custom-control-inline">
              <input type="radio" id="regUseY" name="usage" class="custom-control-input" value="y" v-model="register.useYn">
              <label class="custom-control-label" for="regUseY">사용</label>
            </div>
            <div class="custom-control custom-radio custom-control-inline">
              <input type="radio" id="regUseN" name="usage" class="custom-control-input" value="n" v-model="register.useYn">
              <label class="custom-control-label" for="regUseN">미사용</label>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col col-12">
        <div class="col-title">사용자 권한<i class="fas fa-check icon-check"></i></div>
        <div class="col-desc">
          <table class="centered table no-padding">
            <colgroup>
              <col v-for ="(item,idx) in roleList" :key="idx" style="width:33.333%">
              <!-- <col style="width:33.333%">
              <col style="width:33.333%"> -->
            </colgroup>
            <thead>
              <tr>
                <th v-for ="(item,idx) in roleList" :key="idx" >
                  <div class="custom-control custom-checkbox">
                    <input type="radio" class="custom-control-input" name="group2" :id="'reg'+item"  :value="item" v-model="register.role">
                    <label class="custom-control-label" :for="'reg'+item">{{item}}</label>
                  </div>
                </th>
                <!-- <th>
                  <div class="custom-control custom-checkbox">
                    <input type="radio" class="custom-control-input" name="group1" id="regAdmin" value="ADMIN" v-model="register.role">
                    <label class="custom-control-label" for="regAdmin">ADMIN</label>
                  </div>
                </th>
                <th>
                  <div class="custom-control custom-checkbox d-inline-block pr-2">
                    <input type="radio" class="custom-control-input" name="group1" id="regUser" value="USER" v-model="register.role">
                    <label class="custom-control-label" for="regUser">USER</label>
                  </div>
                </th>
                <th>
                  <div class="custom-control custom-checkbox d-inline-block pr-2">
                    <input type="radio" class="custom-control-input" name="group1" id="regGuest" value="GUEST" v-model="register.role">
                    <label class="custom-control-label" for="regGuest">GUEST</label>
                  </div>
                </th> -->
              </tr>
            </thead>

          </table>
        </div>
      </div>
    </div>
    <div class="info-box mb-0">
      <div class="wrap-btn">
        <a class="btn btn-outline-dark" v-on:click="registerSend">적용</a>
      </div>
    </div>
  </div>
</transition>

<transition>
  <div class="box-grey box-grey-sm no-bullet mb-1" id="editForm" v-show="modFlag">
    <div class="info-box mb-3">
      <div class="info">
        <span>● 사용자 수정</span>
      </div>
    </div>
    <div class="row mb-2">
      <div class="col col-12">
        <div class="col-title">이름<i class="fas fa-check icon-check"></i></div>
        <div class="col-desc" style="width: 450px">{{modUserInfo.userName}}</div>
        <div class="col-title">비밀번호</div>
        <div class="col-desc" style="width: 300px">
          <a class="btn btn-sm btn-outline-dark" @click="pwdModal">비밀번호 변경</a>
          <input type="hidden" id="editPwdConfirm" />
        </div>
      </div>
    </div>
    <div class="row mb-2">
      <div class="col col-12">
        <div class="col-title">이메일<i class="fas fa-check icon-check"></i></div>
        <div class="col-desc" style="width: 450px">{{modUserInfo.userEmail}}</div>
        <div class="col-title">설명</div>
        <div class="col-desc" style="width: 300px">
          <input type="text" class="form-control form-control-sm" title="text" placeholder="" v-bind:value="modUserInfo.note" v-model="modUserInfo.note">
        </div>
      </div>
    </div>
    <div class="row mb-2">
      <div class="col col-12">
        <!-- <div class="col-title">관리자 여부<i class="fas fa-check icon-check"></i></div>
        <div class="col-desc" style="width: 450px">
          <div class="radio-wrap">
            <div class="custom-control custom-radio custom-control-inline">
              <input type="radio" id="yes3" name="admin" class="custom-control-input" checked="">
              <label class="custom-control-label" for="yes3">사용</label>
            </div>
            <div class="custom-control custom-radio custom-control-inline">
              <input type="radio" id="no3" name="admin" class="custom-control-input" >
              <label class="custom-control-label" for="no3">미사용</label>
            </div>
          </div>
        </div> -->
        <div class="col-title">사용 여부<i class="fas fa-check icon-check"></i></div>
        <div class="col-desc" style="width: 300px">
          <div class="radio-wrap">
            <div class="custom-control custom-radio custom-control-inline">
              <input type="radio" id="yes4" name="usage2" class="custom-control-input" value="y" v-model="modUserInfo.useYn">
              <label class="custom-control-label" for="yes4">사용</label>
            </div>
            <div class="custom-control custom-radio custom-control-inline">
              <input type="radio" id="no4" name="usage2" class="custom-control-input" value="n" v-model="modUserInfo.useYn">
              <label class="custom-control-label" for="no4">미사용</label>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col col-12">
        <div class="col-title">사용자 권한<i class="fas fa-check icon-check"></i></div>
        <div class="col-desc">
          <table class="centered table no-padding">
            <colgroup>
              <col v-for ="(item,idx) in roleList" :key="idx" style="width:33.333%">
              <!-- <col style="width:33.333%">
              <col style="width:33.333%">
              <col style="width:33.333%"> -->
            </colgroup>
            <thead>
              <tr>
                <th v-for ="(item,idx) in roleList" :key="idx" >
                  <div class="custom-control custom-checkbox">
                    <input type="radio" class="custom-control-input" name="group2" :id="'mod'+item"  :value="item" v-model="modUserInfo.role">
                    <label class="custom-control-label" :for="'mod'+item">{{item}}</label>
                  </div>
                </th>

                <!-- <th>
                  <div class="custom-control custom-checkbox">
                    <input type="radio" class="custom-control-input" name="group2" id="adminMod"  value="ADMIN" v-model="modUserInfo.role">
                    <label class="custom-control-label" for="adminMod">ADMIN</label>
                  </div>
                </th>
                <th>
                  <div class="custom-control custom-checkbox d-inline-block pr-2">
                    <input type="radio" class="custom-control-input" name="group2" id="userMod"  value="USER" v-model="modUserInfo.role">
                    <label class="custom-control-label" for="userMod">USER</label>
                  </div>
                </th>
                <th>
                  <div class="custom-control custom-checkbox d-inline-block pr-2">
                    <input type="radio" class="custom-control-input" name="group2" id="guestMod"  value="GUEST" v-model="modUserInfo.role">
                    <label class="custom-control-label" for="guestMod">GUEST</label>
                  </div>
                </th> -->
              </tr>
            </thead>

          </table>
        </div>
      </div>
    </div>
    <div class="info-box mb-0">
      <div class="wrap-btn">
        <a class="btn btn-outline-dark" v-on:click="modifySend">적용</a>
      </div>
    </div>
  </div>
</transition>
<ModalView :send-data="modalMessage" v-if="isModalViewed" @close-modal="isModalViewed=false">
</ModalView>
<PasswordModalView :send-data="modUserInfo" v-if="isPasswordModalViewed" @close-modal="isPasswordModalViewed=false">
</PasswordModalView>

</div>
</template>

<script>
import ModalView from "../../components/common/alterPopupModal";
import PasswordModalView from "../../components/common/passwordPopupModal";
import UserPagination from "../../components/common/pagination";
import {EventBus} from "../../components/event/event-bus";

export default {
  name: 'userMgmt',
  data(){
    return{
      searchKwd:"",
      searchStatus:"",
      searchParam : {     //검색 파라미터
        userId:"",
        userName:"",
        userEmail:"",
        useYn:"",
      },
      isModalViewed: false,
      isPasswordModalViewed: false,
      modalMessage: "",
      addFlag : false,
      modFlag : false,
      idErrorsMessage:"",
      idClassAttribute:"",
      duplicateIdCheckFlag : false,
      emailErrorsMessage:"",
      emailClassAttribute:"",
      duplicateEmailCheckFlag : false,
      passwordCheckText: '',
      passwordCheckFlag: false,
      userList : [],      // 유저 리스트
      selectedTab : 0,
      modUserInfo : {     //사용자 수정 객체
        userId:"",
        userName:"",
        userEmail:"",
        note: "",
        useYn:"",
        role:""
      },
      register : {      //사용자 등록 객체
        userId :"",
        userEmail :"",
        userPwd :"",
        note :"",
        userName :"",
        useYn:"y",
        role:"USER"
      },
      userPagination: {   //페이징 객체
        totalCount: 0,
        pageSize: 10,
        pageIndex: 1
      },
      roleList:[]
    }
  },
  components: {
    ModalView,
    PasswordModalView,
    UserPagination
  },

  mounted () {
    this.userListSend();
    this.roleListSend();
  },
  filters:{
    'changeUserYn'(value){
      if(value.toLowerCase() == "y"){
        return "사용";
      }else{
        return "미사용";
      }
    },
    'changeRole'(value){
      if(typeof value === 'undefined' || value == null){
        return value+"(권한없음)";
      }else{
        if(value.toUpperCase() == "SUPER"){
          return value+"(루트관리자)";
        }else if(value.toUpperCase() == "ADMIN"){
          return value+"(관리자)";
        }else if(value.toUpperCase() == "USER"){
          return value+"(일반회원)";
        }else if(value.toUpperCase() == "GUEST"){
          return value+"(손님)";
        }else if(value.toUpperCase() == "SELLIDE"){
          return value+"(셀리드)";
        }else if(value.toUpperCase() == "AID"){
          return value+"(에이드)";
        }else if(value.toUpperCase() == "SCOUT"){
          return value+"(스카우터)";
        }else{
          return value+"(미확인)";
        }
      }
    }
  },

  methods: {
    //유저 리스트 axios
    userListSend : function(index){
      axios.post('/api/sys/v1/user/list',{
          userId : this.searchParam.userId,
          userEmail : this.searchParam.userEmail,
          userName : this.searchParam.userName,
          useYn : this.searchParam.useYn,
          pageIndex : index ? index : this.userPagination.pageIndex,
          pageSize : this.userPagination.pageSize
      }).then(res => {
        this.userList = res.data.resultList;
        this.userPagination.totalCount = res.data.totalCount;
        this.userPagination.pageSize = res.data.pageSize;
        this.userPagination.pageIndex = res.data.pageIndex;

        EventBus.$emit("paginationInfo",this.userPagination)
      }).catch(res => {
        if(res.response.status =="401"){
          alert("인증 기간이 만료되었습니다.");
          this.$router.go('/');
        }else{
          this.modalMessage=res.response.data;
          this.isModalViewed=true;
        }
      })
    },
    //사용자 권한 리스트 axios
    roleListSend: function() {
      axios.post('/api/sys/v1/user/role').then(res => {
        this.roleList = res.data;
      })
      .catch(res => {
        if(res.response.status =="401"){
          alert("인증 기간이 만료되었습니다.");
          this.$router.go('/');
        }else{
          this.modalMessage=res.response.data;
          this.isModalViewed=true;
        }
      })
    },
    //사용자 추가 화면
    addUser: function() {
      this.addFlag = !this.addFlag;
      this.modFlag = false;
    },
    //사용자 수정 화면
    modUser: function(item) {
      this.addFlag = false;
      this.modFlag = true;
      this.modUserInfo.userId = item.userId;
      this.modUserInfo.userEmail = item.userEmail;
      this.modUserInfo.userName = item.userName;
      this.modUserInfo.note = item.note;
      this.modUserInfo.useYn=item.useYn;
      this.modUserInfo.role=item.role;
    },
    //사용자 리스트 탭 클릭
    userTabClick: function(item,idx) {
      this.selectedTab = idx;
      this.modUser(item);
    },
    //사용자 추가 적용
    registerSend: function() {
      if(this.passwordCheckFlag ==true){
        alert("비밀번호를 확인해 주세요.")
        return ;
      }

      axios.post('/api/sys/v1/user',  this.register).then(res => {
        this.userListSend();
        this.register.userId ="";
        this.register.userEmail ="";
        this.register.userPwd ="";
        this.register.note ="";
        this.register.userName ="";
        this.register.useYn="y";
        this.register.role="USER";
        this.passwordCheckText="";
        alert("사용자 추가 완료");
      }).catch(res => {
        if(res.response.status =="400"){
          this.modalMessage="회원가입 실패(Id,Email 입력오류)";
          this.isModalViewed=true;
        }else if(res.response.status =="403"){
          this.modalMessage="ADMIN 적용 권한이 없습니다.";
          this.isModalViewed=true;
        }else if(res.response.status =="401"){
          alert("인증 기간이 만료되었습니다.");
          this.$router.go('/');
        }else{
          this.modalMessage=res.response.data;
          this.isModalViewed=true;
        }
      })
    },
    //사용자 수정 적용 axios
    modifySend: function() {
      axios.put('/api/sys/v1/user',this.modUserInfo).then(res => {
        this.userListSend();
        alert("수정 완료");
      })
      .catch(res => {
        if(res.response.status =="403"){
          this.modalMessage="수정 권한이 없습니다.";
          this.isModalViewed=true;
        }else if(res.response.status =="401"){
          alert("인증 기간이 만료되었습니다.");
          this.$router.go('/');
        }else{
          this.modalMessage=res.response.data;
          this.isModalViewed=true;
        }
      })
    },
    //아이디 중복 체크 axios
    duplicateIdCheck: function(id) {
      this.idErrorsMessage="";
      if(!id){
        this.idErrorsMessage = "id를 입력해주세요";
        this.idErrorSet();
        return;
      }
      let url = "/api/login/user/id/"+id;
      axios.post(url).then(res => {
        if(res.data.message =="ok"){
          this.idErrorsMessage="*사용 가능한 아이디입니다.";
          this.idSuccessSet();
        }else if(res.data.message =="duplicate"){
          this.idErrorsMessage="*사용 불가한 아이디입니다.";
          this.idErrorSet();
        }
      }).catch(res => {
        if(res.response.status =="401"){
          alert("인증 기간이 만료되었습니다.");
          this.$router.go('/');
        }else{
          this.modalMessage=res.response.data;
          this.isModalViewed=true;
        }
      })
    },
    //이메일 중복 체크 axios
    duplicateEmailCheck: function(email) {
      this.emailErrorsMessage="";
      if(!email){
        this.emailErrorsMessage = "email를 입력해주세요";
        this.emailErrorSet();
        return;
      }
      if(!this.validEmail(email)){
        this.emailErrorsMessage = "email 형식을 확인하세요";
        this.emailErrorSet();
        return;
      }
      let url = "/api/login/user/em/"+email;
      axios.post(url).then(res => {
        if(res.data.message =="ok"){
          this.emailErrorsMessage = "*사용 가능한 이메입니다.";
          this.emailSuccessSet();
        }else if(res.data.message =="duplicate"){
          this.emailErrorsMessage = "*사용 불가한 이메일입니다.";
          this.emailErrorSet();
        }
      }).catch(res => {
        if(res.response.status =="401"){
          alert("인증 기간이 만료되었습니다.");
          this.$router.push('/');
        }else{
          this.modalMessage=res.response.data;
          this.isModalViewed=true;
        }
      })
    },
    //비밀번호 확인
    passwordCheckValid: function () {
      if (this.register.userPwd === this.passwordCheckText) {
        this.passwordCheckFlag = false;
      } else {
        this.passwordCheckFlag = true;
      }
    },
    //이메일 확인
    validEmail: function(email) {
      var re = /^[0-9a-z_+-]+([\.]*[0-9a-z_+-])*@([0-9a-z_-]+\.)+[a-z]{2,10}$/i;
      return re.test(email);
    },
    //에러,성공 클래스 속성 적용
    idErrorSet:function(){
      this.idClassAttribute = "color-cred";
      this.duplicateIdCheckFlag = true;
    },
    idSuccessSet:function(){
      this.idClassAttribute = "color-skyblue";
      this.duplicateIdCheckFlag = true;
    },
    emailErrorSet:function(){
      this.emailClassAttribute = "color-cred";
      this.duplicateEmailCheckFlag = true;
    },
    emailSuccessSet:function(){
      this.emailClassAttribute = "color-skyblue";
      this.duplicateEmailCheckFlag = true;
    },
    //셀렉트 박스 변경
    selectChange:function(event){
      this.searchStatus = event.target.value;
    },
    //검색 버튼
    searchBtn:function(){
      if(this.searchStatus =="userId"){
        this.searchParam.userId=this.searchKwd;
        this.searchParam.userEmail="";
        this.searchParam.userName="";
        this.searchParam.useYn="";
      }else if(this.searchStatus =="userEmail"){
        this.searchParam.userId="";
        this.searchParam.userEmail=this.searchKwd;
        this.searchParam.userName="";
        this.searchParam.useYn="";
      }else if(this.searchStatus =="userName"){
        this.searchParam.userId="";
        this.searchParam.userEmail="";
        this.searchParam.userName=this.searchKwd;
        this.searchParam.useYn="";
      }else if(this.searchStatus =="useYn"){
        this.searchParam.userId="";
        this.searchParam.userEmail="";
        this.searchParam.userName="";
        if(this.searchKwd == "사용"){
          this.searchParam.useYn="y";
        }else{
          this.searchParam.useYn="n";
        }
      }
      //onsole.log(this.searchKwd);
      //console.log(this.searchParam);

      this.userListSend();
    },
    pwdModal: function(){
      this.isPasswordModalViewed =true;
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
