<template>
  <div class="contents">
    <div class="page-content">
      <div class="title-content">메뉴 관리</div>
      <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="#">시스템관리</a></li>
          <li class="breadcrumb-item active" aria-current="page">메뉴 관리</li>
        </ol>
      </nav>


      <div class="card-shadow mb-5"> <!-- card-shadow mb-5 클래스 추가 -- 2020.11.13 -->
        <div class="info-box mb-3">
          <div class="info">
            <span>● 메뉴 관리</span>
          </div>
        </div>

        <div class="scroll-wrap">
          <div class="scroll">
            <table class="centered table" id="sortTable">
              <colgroup>
                <col style="width:138px">
                <col style="width:30%">
                <col style="width:78px">
                <col style="width:145px">
                <col style="width:108px">
                <col style="width:100px">
              </colgroup>
              <thead>
                <tr>
                  <th style="width: 175px"><span class="order-false">메뉴명</span></th>
                  <th style="width: 30%"><span class="order-false">URL</span></th>
                  <th style="width: 100px"><span class="order-false">사용여부</span></th>
                  <th style="width: 186px"><span class="order-false">수정일</span></th>
                  <th style="width: 138px"><span class="order-false">수정자</span></th>
                  <th style="width: 147px"><span>정렬</span></th>
                </tr>
              </thead>




              <tbody v-for="menuGrp in menuGrps">
                <tr :key="menuGrp+idx" :class="{active: menuGrp.menuGrpName+idx === selectedTab}" @click="menuTabClick('ROOT',menuGrp,menuGrp.menuGrpName+idx)">
                  <td><div class="color-link text-left">{{menuGrp.menuGrpName}}</td>
                    <td></td>
                    <td></td>
                    <td>{{menuGrp.uptDate}}</td>
                    <td>{{menuGrp.uptName}}</td>
                    <td>{{menuGrp.sortOrdr}}</td>
                  </tr>
                  <tr v-for="(menu,idx) in menuGrp.menuMst" :key="menu+idx" :class="{active: menu.menuName+idx === selectedTab}" @click="menuTabClick(menuGrp.menuGrpSeq,menu,menu.menuName+idx)">
                    <td class="pl-4"><div class="color-link">{{menu.menuName}}</td>
                      <td>{{menu.menuUrl}}</td>
                      <td>{{menu.useYn}}</td>
                      <td>{{menu.uptDate}}</td>
                      <td>{{menu.uptName}}</td>
                      <td>{{menu.sortOrdr}}</td>
                    </tr>
                    <!-- <tr class="depth_second">
                    <td><a href="#" class="color-link">사용자관리</a></td>
                    <td></td>
                    <td>Y</td>
                    <td>2020.10.19</td>
                    <td>konan1</td>
                    <td>3</td>
                  </tr>
                  <tr class="depth_second">
                  <td><a href="#" class="color-link">메뉴관리</a></td>
                  <td></td>
                  <td>N</td>
                  <td>2020.10.19</td>
                  <td>konan1</td>
                  <td>2</td>
                </tr>
                <tr class="depth_second">
                <td><a href="#" class="color-link">코드관리</a></td>
                <td></td>
                <td>Y</td>
                <td>2020.10.19</td>
                <td>konan1</td>
                <td>1</td>
              </tr>
              <tr class="depth_first">
              <td><a href="#" class="color-link">코드관리</a></td>
              <td></td>
              <td>Y</td>
              <td>2020.10.19</td>
              <td>konan1</td>
              <td>2</td>
            </tr>
            <tr class="depth_second">
            <td><a href="#" class="color-link">코드관리</a></td>
            <td></td>
            <td>Y</td>
            <td>2020.10.19</td>
            <td>konan1</td>
            <td>3</td>
          </tr>
          <tr class="depth_second">
          <td><a href="#" class="color-link">코드관리</a></td>
          <td></td>
          <td>Y</td>
          <td>2020.10.19</td>
          <td>konan1</td>
          <td>2</td>
        </tr>
        <tr class="depth_second">
        <td><a href="#" class="color-link">코드관리</a></td>
        <td></td>
        <td>N</td>
        <td>2020.10.19</td>
        <td>konan1</td>
        <td>1</td>
      </tr>
      <tr class="depth_second">
      <td><a href="#" class="color-link">코드관리</a></td>
      <td></td>
      <td>N</td>
      <td>2020.10.19</td>
      <td>konan1</td>
      <td>2</td>
    </tr>
    <tr class="depth_second">
    <td><a href="#" class="color-link">코드관리</a></td>
    <td></td>
    <td>N</td>
    <td>2020.10.19</td>
    <td>konan1</td>
    <td>1</td>
  </tr> -->
</tbody>
</table>
</div>
</div>
</div>
<script>
$(function() {
  $("#sortTable").tablesorter({
    headers : {
      '.order-false' : {
        sorter : false
      }
    },
  });
});
</script>
<div class="card-shadow">
  <div class="info-box my-3">
    <div class="info">
      <span>● 메뉴 추가</span>
    </div>
  </div>
  <div class="box-grey no-bullet mb-1">
    <div class="row mb-2">
      <div class="col col-12">
        <div class="col-title">메뉴 번호</div>
        <div class="col-desc" style="width: 300px">{{menuBindInfo.menuSeq}}</div>
        <div class="col-title">상위메뉴명</div>
        <div class="col-desc" style="width: 300px">
          <div class="input-group d-inline-block" style="width: 100px">
            <select class="custom-select custom-select-sm" title="" v-model="menuBindInfo.menuTopName">
              <option selected="">ROOT</option>
              <option v-for ="(item,idx) in menuGrp" :key="idx" :value="item.menuGrpSeq">{{item.menuGrpName}}</option>
            </select>
          </div>
        </div>
      </div>
    </div>
    <div class="row mb-2">
      <div class="col col-12">
        <div class="col-title">정렬</div>
        <div class="col-desc" style="width: 300px">
          <input type="text" class="form-control form-control-sm" title="text" placeholder="" v-model="menuBindInfo.sortOrdr"
          style="width: 100px">
        </div>
        <div class="col-title">사용여부</div>
        <div class="col-desc" style="width: 300px">
          <div class="input-group d-inline-block" style="width:100px">
            <select class="custom-select custom-select-sm" title="" v-model="menuBindInfo.useYn">
              <option selected="">Y</option>
              <option>N</option>
            </select>
          </div>
        </div>
      </div>
    </div>
    <div class="row mb-2">
      <div class="col col-12">
        <div class="col-title">권한</div>
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
                    <input type="checkbox" class="custom-control-input" :name="'group'+idx" :id="'reg'+item"  :value="item" v-model="checkedValues">
                    <label class="custom-control-label" :for="'reg'+item">{{item}}</label>
                  </div>
                </th>

                <!-- <th>
                <div class="custom-control custom-checkbox">
                <input type="radio" class="custom-control-input" name="group1" id="regAdmin" value="ADMIN" v-model="menuBindInfo.role">
                <label class="custom-control-label" for="regAdmin">ADMIN</label>
              </div>
            </th>
            <th>
            <div class="custom-control custom-checkbox d-inline-block pr-2">
            <input type="radio" class="custom-control-input" name="group1" id="regUser" value="USER" v-model="menuBindInfo.role">
            <label class="custom-control-label" for="regUser">USER</label>
          </div>
        </th>
        <th>
        <div class="custom-control custom-checkbox d-inline-block pr-2">
        <input type="radio" class="custom-control-input" name="group1" id="regGuest" value="GUEST" v-model="menuBindInfo.role">
        <label class="custom-control-label" for="regGuest">GUEST</label>
      </div>
    </th> -->
  </tr>
</thead>

</table>
</div>
</div>
</div>
<div class="row mb-2">
  <div class="col col-12">
    <div class="col-title">메뉴명</div>
    <div class="col-desc">
      <input type="text" class="form-control form-control-sm" title="text" placeholder="" v-model="menuBindInfo.menuName"
      style="width: 300px">
    </div>
  </div>
</div>
<div class="row">
  <div class="col col-12">
    <div class="col-title">URL</div>
    <div class="col-desc">
      <input type="text" class="form-control form-control-sm" title="text" placeholder=""  v-model="menuBindInfo.menuUrl">
    </div>
  </div>
</div>
</div> <!-- mb-1 클래스 변경 -- 2020.11.13 -->
<!-- s 버튼 영역 -->
<div class="info-box mt-1"> <!-- mb-5 클래스 제거 -- 2020.11.13 -->
  <div class="wrap-btn">
    <a class="btn btn-outline-dark" @click="menuReset">초기화</a>
    <a class="btn btn-outline-dark" @click="menuDelete">삭제</a>
    <a class="btn btn-primary" @click="menuInsert">적용</a>
  </div>
</div>
<!-- e 버튼 영역 -->
</div>
</div>

<ModalView :send-data="modalMessage" v-if="isModalViewed" @close-modal="isModalViewed=false">
</ModalView>
</div>
</template>

<script>
import ModalView from "../../components/common/alterPopupModal";

export default {
  name: 'menuMgmt',
  data(){
    return{
      menuGrps:[],        // 메뉴 리스트
      menuGrp:[],        // 메뉴그룹 리스트
      rankList:{},        // 권한 리스트
      selectedTab : "",
      isModalViewed: false,
      modalMessage: "",
      menuBindInfo: {
        menuSeq: 0,
        menuGrpSeq: 0,
        menuTopName: "ROOT",
        sortOrdr: "",
        useYn: "Y",
        authCode: "",
        menuName: "",
        menuUrl: "",
      },
      roleList:[],
      checkedValues:[],
    }
  },
  components: {
    ModalView
  },

  mounted () {
    this.menuListSend();
    this.roleListSend();
    this.menuGrpListSend();
    this.rankListSend();
  },
  filters:{

  },

  methods: {
    //유저 리스트 axios
    menuListSend : function(){
      axios.post('/api/sys/v1/menu/list').then(res => {
        this.menuGrps = res.data;
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
    //유저 리스트 axios
    menuGrpListSend : function(){
      axios.post('/api/sys/v1/menugroup/list').then(res => {
        //console.log(res.data);
        this.menuGrp = res.data;
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
    menuTabClick: function(menuTopName,item,idx) {
      this.selectedTab = idx;
      this.menuInsertOrModify(menuTopName,item);
    },
    //사용자 수정 화면
    menuInsertOrModify: function(menuTopName,item) {
      if(typeof item.menuSeq === 'undefined'){    //menuGrp
        this.menuBindInfo.menuSeq= item.menuGrpSeq;
        this.menuBindInfo.menuName= item.menuGrpName;
        this.menuBindInfo.menuTopName= menuTopName;
        this.menuBindInfo.menuUrl= "";
        this.checkedValues=[];
      }else{  //menuMst
        this.menuBindInfo.menuSeq= item.menuSeq;
        this.menuBindInfo.menuGrpSeq= item.menuGrpSeq;
        this.menuBindInfo.menuName= item.menuName;
        this.menuBindInfo.menuTopName= menuTopName;
        this.menuBindInfo.menuUrl= item.menuUrl;
        this.menuBindInfo.authCode= item.authCode;

        this.checkedValues=[];
        for(let i=0; i< this.roleList.length; i++){ //권한 체크박스
          let access = parseInt(item.authCode,2)&parseInt(this.authCodeToRole(this.roleList[i]),2);
          if(access == 0){
            continue;
          }else{
            this.checkedValues.push(this.roleList[i]);
          }
        }
      }
      this.menuBindInfo.sortOrdr= item.sortOrdr;
      this.menuBindInfo.useYn= item.useYn;

    },
    menuReset:function () {
      this.menuBindInfo.menuSeq= 0;
      this.menuBindInfo.menuTopName= "ROOT";
      this.menuBindInfo.sortOrdr= "";
      this.menuBindInfo.useYn= "Y";
      this.menuBindInfo.authCode= "";
      this.menuBindInfo.menuName= "";
      this.menuBindInfo.menuUrl= "";
      this.checkedValues=[];
    },
    menuDelete:function () {
      //console.log(this.menuBindInfo.menuTopName);
      if(this.menuBindInfo.menuTopName == "ROOT"){
        axios.delete('/api/sys/v1/menugroup/'+this.menuBindInfo.menuSeq).then(res => {
          this.menuListSend();
          this.menuReset();
          this.modalMessage="삭제 완료";
          this.isModalViewed=true;
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
      }else{
        axios.delete('/api/sys/v1/menu/'+this.menuBindInfo.menuSeq).then(res => {
          this.menuListSend();
          this.menuReset();
          this.modalMessage="삭제 완료";
          this.isModalViewed=true;
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
      }
    },
    menuInsert:function () {
      //console.log(this.menuBindInfo.menuTopName);
      if(this.menuBindInfo.menuTopName == "ROOT"){
        axios.post('/api/sys/v1/menugroup',{
          menuGrpSeq: this.menuBindInfo.menuSeq,
          menuGrpName: this.menuBindInfo.menuName,
          sortOrdr: this.menuBindInfo.sortOrdr,
          useYn: this.menuBindInfo.useYn
        }).then(res => {
          this.menuListSend();
          this.menuGrpListSend();
          this.modalMessage="적용 완료";
          this.isModalViewed=true;
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
      }else{
        if(this.checkedValues.length == 0){
          alert("권한을 체크해 주세요.");
          return ;
        }
        this.menuBindInfo.authCode=this.getAuthCode();
        axios.post('/api/sys/v1/menu',{
          menuSeq: this.menuBindInfo.menuSeq,
          menuGrpSeq:(this.menuBindInfo.menuTopName),
          menuName: this.menuBindInfo.menuName,
          menuUrl: this.menuBindInfo.menuUrl,
          sortOrdr: this.menuBindInfo.sortOrdr,
          useYn: this.menuBindInfo.useYn,
          authCode: this.menuBindInfo.authCode,
        }).then(res => {
          this.menuListSend();
          this.modalMessage="적용 완료";
          this.isModalViewed=true;
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
      }
    },
    rankListSend : function(){
      axios.post('/api/sys/v1/rank/list').then(res => {
        for(let i=0; i< res.data.length; i++){
          this.rankList[res.data[i].role] = res.data[i].authCode;
        }
        //console.log(this.rankList);
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
    authCodeToRole:function(data){
        if(this.rankList[data] != null || typeof this.rankList[data] !="undefined"){
          return this.rankList[data];
        }else{
          return "00000000";
        }

      // switch(data) {			// 코드 (00000000 길이8) (+ 스카우트,셀리드,에이드,관리자)
      //   case 'SUPER':				//루트관리자
      //   return "00000011";
      //   case 'ADMIN':				//관리자
      //   return "00000001";
      //   case 'USER':				//일반유저(셀리드)
      //   return "00110000";
      //   case 'GUEST':				//손님
      //   return "00000000";
      //   case 'SELLIDE':			//셀리드,에이드 사용자
      //   return "00111100";
      //   case 'AID':				// 에이드 사용자
      //   return "00001100";
      //   case 'SCOUT':				//스카우터 사용자
      //   return "11000000";
      //   default :
      //   return "00000000";
      // }
    },
    getAuthCode:function () {
      let authCode = 0;
      for(let i=0; i< this.checkedValues.length; i++){
        if(authCode == 0){
          authCode = this.authCodeToRole(this.checkedValues[i]);
        }
        authCode = parseInt(authCode.toString(2),2) | parseInt(this.authCodeToRole(this.checkedValues[i]),2);
      }
      //console.log("결과 : "+authCode.toString(2).padStart(8,'0')  );
      return authCode.toString(2);
    }
  },
}
</script>

<style scoped>
</style>
