<template>
  <div class="contents">
    <div class="page-content">
      <div class="title-content">고객문의관리</div>
      <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="#">셀리드</a></li>
          <li class="breadcrumb-item active" aria-current="page">고객문의관리</li>
        </ol>
      </nav>

      <div class="nav nav-tabs mb-3" id="tabs" role="tablist">
        <button class="nav-item nav-link" v-for="(tab, index) in tabs" :key="tab.id"
        v-bind:class="{active: currentTab === index}"
        v-on:click="currentTab = index">{{tab}}
        </button>
      </div>

      <div class="tab-content">
        <!-- 고객문의 수집 -->
        <div v-show="currentTab==0">
          <div class="card-shadow">
            <table class="centered table mb-2">
              <colgroup>
                <col style="width:30%">
                <col style="width:70%">
              </colgroup>
              <thead>
              <tr>
                <th>기간</th>
                <td>
                  <div class="input-group date float-left" data-provide="datepicker" data-date-today-highlight="true" data-date-language="kr" data-date-format="yyyy.mm.dd" autoclose="true" style="width: 150px">
                    <input type="text" id="datePicker1" class="form-control form-control-sm" value="2020.02.23" title="datepicker" data-autohide="true">
                    <button class="btn btn-outline-light btn-calendar btn-calendar-sm add-on" type="submit"><i class="far fa-calendar-alt"></i></button>
                  </div>
                  <span class="wave float-left">~</span>
                  <div class="input-group date float-left" data-provide="datepicker" data-date-today-highlight="true" data-date-language="kr" data-date-format="yyyy.mm.dd" autoclose="true" style="width: 150px">
                    <input type="text" id="datePicker2" class="form-control form-control-sm" value="2020.02.23" title="datepicker" data-autohide="true">
                    <button class="btn btn-outline-light btn-calendar btn-calendar-sm add-on" type="submit"><i class="far fa-calendar-alt"></i></button>
                  </div>                  
                </td>
              </tr>
              <tr>
                <th>수집 쇼핑몰</th>
                <td>
                <div class="custom-control custom-checkbox float-left">
                  <input type="checkbox" class="custom-control-input" title="checkbox">
                  <label class="custom-control-label">스마트 스토어</label>
                </div>
                </td>
              </tr>               
              </thead>
            </table>
            <br>             			
          </div>
          <br>
          <div class="card-shadow">
            <div class="info-box my-2">
              <div class="wrap-btn">
                <a class="btn btn-outline-dark" href="#">고객문의 수집</a>
              </div>
            </div>
          </div>
        </div>

        <!-- 답변 준비중 -->
        <div v-show="currentTab==1">
          <div class="card-shadow">
            <div class="box-grey">
              <div class="row">
                <div class="col-form">
                  <div class="row">
                    <div class="col col-12">
                      <div class="col-title" data-text="PD_0001_12">문의수집 일자</div>
                      <div class="col-desc">                	
                        <div class="input-group date float-left" data-provide="datepicker" data-date-today-highlight="true" data-date-language="kr" data-date-format="yyyy.mm.dd" autoclose="true" style="width: 150px">
                          <input type="text" id="datePicker1" class="form-control form-control-sm" value="2020.02.23" title="datepicker" data-autohide="true">
                          <button class="btn btn-outline-light btn-calendar btn-calendar-sm add-on" type="submit"><i class="far fa-calendar-alt"></i></button>
                        </div>
                        <span class="wave float-left">~</span>
                        <div class="input-group date float-left" data-provide="datepicker" data-date-today-highlight="true" data-date-language="kr" data-date-format="yyyy.mm.dd" autoclose="true" style="width: 150px">
                          <input type="text" id="datePicker2" class="form-control form-control-sm" value="2020.02.23" title="datepicker" data-autohide="true">
                          <button class="btn btn-outline-light btn-calendar btn-calendar-sm add-on" type="submit"><i class="far fa-calendar-alt"></i></button>
                        </div>
                        <div class="btn-wrap float-left">
                          <a class="btn btn-outline-dark btn-sm" href="#" data-text="PD_0001_13">오늘</a>
                          <a class="btn btn-outline-dark btn-sm" href="#" data-text="PD_0001_14">일주일</a>
                          <a class="btn btn-outline-dark btn-sm" href="#" data-text="PD_0001_15">이번달</a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-form">
                  <div class="row">
                    <div class="col col-6">
                      <div class="col-title" data-text="PD_0001_12">검색</div>
                      <div class="col-desc">
                        <div class="input-group float-left" style="width: 100px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">준비중</option>
                          <option>답변완료</option>
                        </select>		                  
                        </div>
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 100px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">주문자명</option>
                          <option>쇼핑몰 주문번호</option>
                          <option>쇼핑몰 상품코드</option>
                          <option>쇼핑몰 아이디</option>
                        </select>		                  
                        </div>
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 200px">
                          <input type="text" class="form-control form-control-sm" title="text" placeholder="">
                        </div>				          
                      </div>
                    </div>		              	              
                  </div>
                </div>
              </div>		        
              <br>    
              <br>
              <!-- 버튼 -->
              <div class="info-box my-2">
                <div class="wrap-btn">
                  <a class="btn btn-outline-dark" href="#">검색</a>
                </div>
              </div>	        
            </div>			
          </div>
        </div>

        <!-- 답변 임시저장 -->
        <div v-show="currentTab==2">
          <div class="card-shadow">
          </div>
        </div>

        <!-- 답변 완료 -->
        <div v-show="currentTab==3">
         	<div class="card-shadow">
         	</div>          
        </div>
          
        <!-- 수집/답변 실패 -->
        <div v-show="currentTab==4">
         	<div class="card-shadow">
         	</div>          
        </div> 

      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'tabs',
  data(){
    return{
      currentTab: 0,
      tabs: ['고객문의수집', '답변준비중', '답변임시저장', '답변완료', '수집/답변실패']
    }
  }
}
</script>

<style scoped>
</style>
