<template>
  <div class="contents">
    <div class="page-content">
      <div class="title-content">권한 관리
        <span class="color-cred ml-2">*(권한 추가,삭제 는 관리자에게 문의 바랍니다.)</span>
      </div>
      <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="#">시스템관리</a></li>
          <li class="breadcrumb-item active" aria-current="page">권한 관리</li>
        </ol>
      </nav>


      <div class="card-shadow mb-5"> <!-- card-shadow mb-5 클래스 추가 -- 2020.11.13 -->
        <div class="info-box mb-3">
          <div class="info">
            <span>● 권한 관리</span>
          </div>
        </div>

        <div class="scroll-wrap">
          <div class="scroll">
            <table class="centered table" id="sortTable">
              <colgroup>
                <col style="width:130px">
                <col style="width:180px">
                <col style="width:35%">
                <col style="width:110px">
                <col style="width:210px">
                <col style="width:110px">
              </colgroup>
              <thead>
                <tr>
                  <th style="width: 140px"><span class="order-false">권한명</span></th>
                  <th style="width: 200px"><span class="order-false">권한코드</span></th>
                  <th style="width: 30%"><span class="order-false">설명</span></th>
                  <th style="width: 120px"><span class="order-false">수정자</span></th>
                  <th style="width: 230px"><span class="order-false">수정일</span></th>
                  <th style="width: 120px"><span>정렬</span></th>
                </tr>
              </thead>




              <tbody>
                <tr v-for ="(item,idx) in rankList" :key="idx" :class="{active: idx === selectedTab}" @click="rankTabClick(item,idx)">
                  <td>{{item.role}}</td>
                  <td>{{item.authCode}}</td>
                  <td>{{item.note}}</td>
                  <td>{{item.uptName}}</td>
                  <td>{{item.uptDate}}</td>
                  <td>{{item.sortOrdr}}</td>
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
      <span>● 권한 수정 </span>
    </div>
  </div>
  <div class="box-grey no-bullet mb-1">
    <div class="row mb-2">
      <div class="col col-12">
        <div class="col-title">권한 번호</div>
        <div class="col-desc" style="width: 300px">{{rankBindInfo.rankSeq}}</div>
        <div class="col-title">설명</div>
        <div class="col-desc" style="width: 300px">
          <input type="text" class="form-control form-control-sm d-inline-block" title="text" placeholder="" id="modRankNote" v-model="rankBindInfo.note"
          style="width: 150px">
        </div>
      </div>
    </div>
    <div class="row mb-2">
      <div class="col col-12">
        <div class="col-title">권한 명<i class="fas fa-check icon-check"></i></div>
        <div class="col-desc" style="width: 300px">
          <input type="text" class="form-control form-control-sm" title="text" placeholder="" id="modRankRole"   v-model="rankBindInfo.role"
          style="width: 150px">
        </div>
        <div class="col-title">권한 코드<i class="fas fa-check icon-check"></i></div>
        <div class="col-desc" style="width: 300px">
          <input type="text" class="form-control form-control-sm" title="text" placeholder="" id="modRankAuthCode"   v-model="rankBindInfo.authCode">
        </div>
      </div>
    </div>
    <div class="row mb-2">
      <div class="col col-12">
        <div class="col-title">정렬<i class="fas fa-check icon-check"></i></div>
        <div class="col-desc" style="width: 300px">
          <input type="text" class="form-control form-control-sm d-inline-block" title="text" placeholder="" id="modRankSort" v-model="rankBindInfo.sortOrdr"
          style="width: 150px">
        </div>
        <div class="col-title">사용여부</div>
        <div class="col-desc" style="width: 300px">
          <div class="input-group d-inline-block" style="width:100px">
            <select class="custom-select custom-select-sm" title="" v-model="rankBindInfo.useYn">
              <option selected="">y</option>
              <option>n</option>
            </select>
          </div>
        </div>
      </div>
    </div>

</div> <!-- mb-1 클래스 변경 -- 2020.11.13 -->
<!-- s 버튼 영역 -->
<div class="info-box mt-1"> <!-- mb-5 클래스 제거 -- 2020.11.13 -->
  <div class="wrap-btn">
    <a class="btn btn-outline-dark" @click="rankReset">초기화</a>
    <a class="btn btn-outline-dark" @click="rankDelete">삭제</a>
    <a class="btn btn-primary" @click="rankInsert">적용</a>
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
      rankList:[],        // 권한 리스트
      selectedTab : "",
      isModalViewed: false,
      modalMessage: "",
      rankBindInfo: {
        rankSeq: 0,
        role: "USER",
        authCode: "",
        note: "",
        sortOrdr: "",
        useYn:"y",
      },
    }
  },
  components: {
    ModalView
  },

  mounted () {
    this.rankListSend();
  },
  filters:{

  },

  methods: {
    rankListSend : function(){
      axios.post('/api/sys/v1/rank/list').then(res => {
        this.rankList = res.data;
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
    rankTabClick: function(item,idx) {
      this.selectedTab = idx;
      this.rankInsertOrModify(item);

    },
    //수정 화면
    rankInsertOrModify: function(item) {
      this.rankBindInfo.rankSeq= item.rankSeq;
      this.rankBindInfo.role= item.role;
      this.rankBindInfo.authCode= item.authCode;
      this.rankBindInfo.note= item.note;
      this.rankBindInfo.sortOrdr= item.sortOrdr;
      this.rankBindInfo.useYn= item.useYn;
    },
    rankReset:function () {
      this.rankBindInfo.rankSeq= 0;
      this.rankBindInfo.role= "";
      this.rankBindInfo.authCode= "";
      this.rankBindInfo.note= "";
      this.rankBindInfo.sortOrdr= "";
      this.rankBindInfo.useYn= "y";
    },
    rankDelete:function () {
      //console.log(this.menuBindInfo.menuTopName);
      axios.delete('/api/sys/v1/rank/'+this.rankBindInfo.rankSeq).then(res => {
        this.rankListSend();
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
    },
    rankInsert:function () {
      //console.log(this.menuBindInfo.menuTopName);
      axios.post('/api/sys/v1/rank',{
        rankSeq: this.rankBindInfo.rankSeq,
        role: this.rankBindInfo.role,
        authCode: this.rankBindInfo.authCode,
        sortOrdr: this.rankBindInfo.sortOrdr,
        useYn: this.rankBindInfo.useYn,
        note: this.rankBindInfo.note
      }).then(res => {
        this.rankListSend();
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
    },
  }
}
</script>

<style>
</style>
