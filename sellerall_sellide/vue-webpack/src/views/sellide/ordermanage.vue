<template>
  <div class="contents">
    <div class="page-content">
      <div class="title-content">주문관리</div>
      <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="#">셀리드</a></li>
          <li class="breadcrumb-item active" aria-current="page">주문관리</li>
        </ol>
      </nav>

      <div class="nav nav-tabs mb-3" id="tabs" role="tablist">
        <button class="nav-item nav-link" v-for="(tab, index) in tabs" :key="tab.id"
        v-bind:class="{active: currentTab === index}"
        v-on:click="currentTab = index">{{tab}}
        </button>
      </div>

      <div class="tab-content">		
		    <!-- 주문수집(전체) -->
        <div v-show="currentTab==0">
          <div class="card-shadow">
            <div class="box-grey">
              <div class="row">
              <div class="col-form">
                <div class="row">
                <div class="col col-12">
                  <div class="col-title" data-text="PD_0001_12">일자</div>
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
                    <a class="btn btn-outline-dark btn-sm" href="#" data-text="PD_0001_16">1개월</a>
                  </div>
                  </div>
                </div>
                </div>
              </div>
              </div>
              <br>
              <div class="row">
              <div class="col-form">
                <div class="row">
                <div class="col col-12">
                  <div class="col-title" data-text="PD_0001_12">검색</div>
                  <div class="col-desc">
                  <div class="input-group float-left" style="width: 150px">
                  <select class="custom-select custom-select-sm" title="">
                    <option selected="">작업명 전체</option>
                    <option>네이버페이</option>
                  </select>		                  
                  </div>
                  <span class="wave float-left">&nbsp;</span>
                  <div class="input-group float-left" style="width: 150px">
                  <select class="custom-select custom-select-sm" title="">
                    <option selected="">작업상태 전체</option>
                    <option>주문상태 전체</option>
                    <option>배송준비</option>
                    <option>송장등록</option>
                    <option>송장전송완료</option>
                    <option>배송완료</option>
                    <option>취소요청</option>
                    <option>취소완료</option>
                    <option>배송보류</option>
                    <option>교환요청</option>
                    <option>교환완료</option>
                    <option>반품요청</option>
                    <option>반품완료</option>
                  </select>
                  </div>
                  <span class="wave float-left">&nbsp;</span>
                  <div class="input-group float-left" style="width: 150px">
                  <select class="custom-select custom-select-sm" title="">
                    <option selected="">작업자 아이디</option>
                    <option>클레임 있음</option>
                  </select>
                  </div>		                  
                  <span class="wave float-left">&nbsp;</span>
                  <div class="input-group float-left" style="width: 250px">
                    <input type="text" class="form-control form-control-sm" title="text" placeholder="">
                  </div>
                  </div>
                </div>
                </div>
              </div>
              </div>	        
              <br>
              <div class="info-box my-2">
              <div class="wrap-btn">
                <a class="btn btn-outline-dark" href="#">검색</a>
                <a class="btn btn-outline-dark" href="#">초기화</a>
              </div>
              </div>	        
            </div>            
          </div>
          <div class="card-shadow">
            <table class="centered table mb-2">
              <colgroup>
                <col style="width:10%">
                <col style="width:20%">
                <col style="width:10%">
                <col style="width:10%">
                <col style="width:10%">
                <col style="width:10%">
                <col style="width:20%">
                <col style="width:10%">
              </colgroup>
              <thead>
              <tr>
                <th>NO.</th>
                <th>작업명</th>
                <th>작업자 아이디</th>
                <th>시작일시</th>
                <th>종료일시</th>
                <th>경과시간</th>
                <th>작업상태</th>
                <th>상세내역</th>                
              </tr>
              </thead>
              <tbody>
              <tr>
                <td>10</td>
                <td>주문수집</td>
                <td>manhwa81</td>
                <td>2021-08-18 11:23:58</td>
                <td>2021-08-18 11:23:58</td>
                <td>09:00:00</td>
                <td>작업중</td>
                <td><a class="btn btn-outline-dark" href="#">보기</a></td>
              </tr>
              <tr>
                <td>9</td>
                <td>클레임 수집</td>
                <td>manhwa81</td>
                <td>2021-08-18 11:23:58</td>
                <td>2021-08-18 11:23:58</td>
                <td>09:00:00</td>
                <td>작업완료</td>
                <td><a class="btn btn-outline-dark" href="#">보기</a></td>
              </tr>               
              </tbody>
            </table>
          </div>          		
        </div>

        <!-- 주문수집(개별) -->
        <div v-show="currentTab==1">
          <div class="card-shadow">
        	*주문자동수집시 쇼핑몰의 주문은 신규주문 상태로 남아있으며, 배송준비 처리시에 쇼핑몰의 주문에 대한 자동 배송준비 처리가 이루어집니다.
          <br><br>
          <table class="centered table mb-2">
            <colgroup>
              <col style="width:30%">
              <col style="width:70%">
            </colgroup>
            <thead>
              <tr>
              <th>주문 수집기간</th>
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
              <th>클레임수집 여부</th>
              <td>0</td>
              </tr>               
            </thead>
            </table>
            <br>
            주문수집 쇼핑몰 선택
            <br><br>
            <table class="centered table mb-2">
              <colgroup>
                <col style="width:15%">
                <col style="width:15%">
                <col style="width:40%">
                <col style="width:15%">
                <col style="width:15%">
              </colgroup>
              <thead>
              <tr>
                <th>No.</th>
                <th>선택</th>
                <th>쇼핑몰명</th>
                <th>아이디</th>
                <th>쇼핑몰 로그인</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td>
                  <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" title="checkbox">
                    <label class="custom-control-label"></label>
                  </div>
                </td>
                <td>스마트 스토어</td>
                <td>1</td>
                <td>asa018@naver.com</td>
                <td><a class="btn btn-outline-dark btn-sm" href="#" data-text="PD_0001_13">쇼핑몰 로그인</a></td>
              </tr>               
              </tbody>
            </table>
          </div>
          <br>
          <div class="card-shadow">
            <div class="info-box my-2">
              <div class="wrap-btn">
                <a class="btn btn-outline-dark" href="#">주문 수집하기</a>
              </div>
            </div>
          </div>        
        </div>

        <!-- 신규주문 -->
        <div v-show="currentTab==2">
          <div class="card-shadow">
            <div class="box-grey">
              <div class="row">
                <div class="col-form">
                  <div class="row">
                    <div class="col col-12">
                      <div class="col-title" data-text="PD_0001_12">일자</div>
                      <div class="col-desc">                	
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">주문수집일</option>
                          <option>고객주문일</option>
                          <option>취소요청일</option>
                          <option>취소완료일</option>
                          <option>송장등록일</option>
                          <option>송장전송일</option>
                          <option>반품요청일</option>
                          <option>반품입고일</option>
                          <option>반품완료일</option>
                          <option>교환요청일</option>
                          <option>교환완료일</option>
                        </select>		                  
                        </div>		                	
                        <span class="wave float-left">&nbsp;</span>
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
                          <a class="btn btn-outline-dark btn-sm" href="#" data-text="PD_0001_16">1개월</a>
                          <a class="btn btn-outline-dark btn-sm" href="#" data-text="PD_0001_17">3개월</a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
				      <br>
              <div class="row">
                <div class="col-form">
                  <div class="row">
                    <div class="col col-12">
                      <div class="col-title" data-text="PD_0001_12">검색</div>
                      <div class="col-desc">
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">알림 전체</option>
                          <option>네이버페이</option>
                        </select>		                  
                        </div>
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">신규주문</option>
                          <option>주문상태 전체</option>
                          <option>배송준비</option>
                          <option>송장등록</option>
                          <option>송장전송완료</option>
                          <option>배송완료</option>
                          <option>취소요청</option>
                          <option>취소완료</option>
                          <option>배송보류</option>
                          <option>교환요청</option>
                          <option>교환완료</option>
                          <option>반품요청</option>
                          <option>반품완료</option>
                        </select>
                        </div>
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">클레임유무</option>
                          <option>클레임 있음</option>
                        </select>
                        </div>
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">주문자명</option>
                          <option>수취인명</option>
                          <option>수취인핸드폰</option>
                          <option>수취인전화</option>
                          <option>송장번호</option>
                          <option>거래번호</option>
                          <option>쇼핑몰 주문번호</option>
                          <option>쇼핑몰 아이디</option>
                          <option>쇼핑몰 상품코드</option>
                          <option>주문 상품명</option>
                          <option>옵션항목</option>
                        </select>
                        </div>		                  
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 250px">
                          <input type="text" class="form-control form-control-sm" title="text" placeholder="">
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>	        
		          <br>
              <div class="info-box my-2">
                <div class="wrap-btn">
                  <a class="btn btn-outline-dark" href="#">검색</a>
                  <a class="btn btn-outline-dark" href="#">초기화</a>
                </div>
              </div>	        
		        </div>			
          </div>  
          <br>
          <div class="card-shadow">
            <div class="info-box mb-3">
              <div class="info">
                <span>● 자료수: 총2 건</span>
              </div>
              <div class="wrap-btn">
                <a class="btn btn-outline-dark" href="#">송장정보 저장</a>
                <a class="btn btn-outline-dark" href="#">주문일괄변경</a>
                <a class="btn btn-outline-dark" href="#">엑셀작업</a>
                <!--  <a class="btn btn-file mr-0" href="#"><i class="fal fa-file-alt"></i></a> 문서모양막아놓기-->
                <a class="btn btn-file" href="#"><i class="far fa-file-download"></i></a>
              </div>
            </div>
            <table class="centered table mb-2">
              <colgroup>
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">                                                                                                                      
              </colgroup>
              <thead>
              <tr>
                <th>선택</th>
                <th>알림</th>
                <th>주문수집일</th>
                <th>쇼핑몰 주문번호</th>
                <th>주문상태</th>
                <th>쇼핑몰(ID)</th>
                <th>주문자</th>
                <th>상품명(옵션)</th>
                <th>택배사</th>
                <th>송장번호</th>
                <th>수량</th>
                <th>주문액</th>
                <th>수취인</th>
                <th>휴대번호</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td>
                  <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" title="checkbox">
                    <label class="custom-control-label"></label>
                  </div>
                </td>
                <td>묶음</td>
                <td>2021-08-08</td>
                <td>5195561922</td>
                <td>배송준비</td>
                <td>asa@naver.com</td>
                <td>홍길동</td>
                <td>GPS 수신</td>
                <td>택배사</td>
                <td>1234-5678</td>
                <td>1</td>
                <td>125,000</td>
                <td>홍길동</td>
                <td>010-1234-1234</td>
              </tr>
              <tr>
                <td>
                  <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" title="checkbox">
                    <label class="custom-control-label"></label>
                  </div>
                </td>
                <td>묶음</td>
                <td>2021-08-08</td>
                <td>5195561922</td>
                <td>배송준비</td>
                <td>asa@naver.com</td>
                <td>홍길동</td>
                <td>GPS 수신</td>
                <td>택배사</td>
                <td>1234-5678</td>
                <td>1</td>
                <td>125,000</td>
                <td>홍길동</td>
                <td>010-1234-1234</td>
              </tr>               
              </tbody>
            </table>
            <div class="info-box my-2">
              <div class="wrap-btn">
                <a class="btn btn-outline-dark" href="#">주문삭제</a>
                <a class="btn btn-outline-dark" href="#">일괄문자전송</a>
              </div>
            </div>
          </div>        
        </div>

        <!-- 배송준비 -->
        <div v-show="currentTab==3">
          <div class="card-shadow">
            <div class="box-grey">
              <div class="row">
                <div class="col-form">
                  <div class="row">
                    <div class="col col-12">
                      <div class="col-title" data-text="PD_0001_12">일자</div>
                      <div class="col-desc">                	
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">주문수집일</option>
                          <option>고객주문일</option>
                          <option>취소요청일</option>
                          <option>취소완료일</option>
                          <option>송장등록일</option>
                          <option>송장전송일</option>
                          <option>반품요청일</option>
                          <option>반품입고일</option>
                          <option>반품완료일</option>
                          <option>교환요청일</option>
                          <option>교환완료일</option>
                        </select>		                  
                        </div>		                	
                        <span class="wave float-left">&nbsp;</span>
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
                          <a class="btn btn-outline-dark btn-sm" href="#" data-text="PD_0001_15">1개월</a>
                          <a class="btn btn-outline-dark btn-sm" href="#" data-text="PD_0001_16">3개월</a>
                          <a class="btn btn-outline-dark btn-sm" href="#" data-text="PD_0001_17">1년</a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
				      <br>
              <div class="row">
                <div class="col-form">
                  <div class="row">
                    <div class="col col-12">
                      <div class="col-title" data-text="PD_0001_12">검색</div>
                      <div class="col-desc">
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">알림 전체</option>
                          <option>네이버페이</option>
                        </select>		                  
                        </div>
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">신규주문</option>
                          <option>주문상태 전체</option>
                          <option>배송준비</option>
                          <option>송장등록</option>
                          <option>송장전송완료</option>
                          <option>배송완료</option>
                          <option>취소요청</option>
                          <option>취소완료</option>
                          <option>배송보류</option>
                          <option>교환요청</option>
                          <option>교환완료</option>
                          <option>반품요청</option>
                          <option>반품완료</option>
                        </select>
                        </div>
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">클레임유무</option>
                          <option>클레임 있음</option>
                        </select>
                        </div>
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">주문자명</option>
                          <option>수취인명</option>
                          <option>수취인핸드폰</option>
                          <option>수취인전화</option>
                          <option>송장번호</option>
                          <option>거래번호</option>
                          <option>쇼핑몰 주문번호</option>
                          <option>쇼핑몰 아이디</option>
                          <option>쇼핑몰 상품코드</option>
                          <option>주문 상품명</option>
                          <option>옵션항목</option>
                        </select>
                        </div>		                  
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 250px">
                          <input type="text" class="form-control form-control-sm" title="text" placeholder="">
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>	        
		          <br>
              <div class="info-box my-2">
                <div class="wrap-btn">
                  <a class="btn btn-outline-dark" href="#">검색</a>
                  <a class="btn btn-outline-dark" href="#">초기화</a>
                </div>
              </div>	        
		        </div>			
          </div> 
          <br>
          <div class="card-shadow">
            <div class="info-box mb-3">
              <div class="info">
                <span>● 자료수: 총2 건</span>
              </div>
              <div class="wrap-btn">
                <a class="btn btn-outline-dark" href="#">송장정보 저장</a>
                <a class="btn btn-outline-dark" href="#">주문일괄변경</a>
                <a class="btn btn-outline-dark" href="#">엑셀작업</a>
                <!--  <a class="btn btn-file mr-0" href="#"><i class="fal fa-file-alt"></i></a> 문서모양막아놓기-->
                <a class="btn btn-file" href="#"><i class="far fa-file-download"></i></a>
              </div>
            </div>
            <table class="centered table mb-2">
              <colgroup>
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">                                                                                                                      
              </colgroup>
              <thead>
              <tr>
                <th>선택</th>
                <th>알림</th>
                <th>주문수집일</th>
                <th>쇼핑몰 주문번호</th>
                <th>주문상태</th>
                <th>쇼핑몰(ID)</th>
                <th>주문자</th>
                <th>상품명(옵션)</th>
                <th>택배사</th>
                <th>송장번호</th>
                <th>수량</th>
                <th>주문액</th>
                <th>수취인</th>
                <th>휴대번호</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td>
                  <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" title="checkbox">
                    <label class="custom-control-label"></label>
                  </div>
                </td>
                <td>묶음</td>
                <td>2021-08-08</td>
                <td>5195561922</td>
                <td>배송준비</td>
                <td>asa@naver.com</td>
                <td>홍길동</td>
                <td>GPS 수신</td>
                <td>택배사</td>
                <td>1234-5678</td>
                <td>1</td>
                <td>125,000</td>
                <td>홍길동</td>
                <td>010-1234-1234</td>
              </tr>
              <tr>
                <td>
                  <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" title="checkbox">
                    <label class="custom-control-label"></label>
                  </div>
                </td>
                <td>묶음</td>
                <td>2021-08-08</td>
                <td>5195561922</td>
                <td>배송준비</td>
                <td>asa@naver.com</td>
                <td>홍길동</td>
                <td>GPS 수신</td>
                <td>택배사</td>
                <td>1234-5678</td>
                <td>1</td>
                <td>125,000</td>
                <td>홍길동</td>
                <td>010-1234-1234</td>
              </tr>               
              </tbody>
            </table>          
            <div class="info-box my-2">
              <div class="wrap-btn">
                <a class="btn btn-outline-dark" href="#">주문삭제</a>
                <a class="btn btn-outline-dark" href="#">일괄문자전송</a>
              </div>
            </div>
          </div>         
        </div>

        <!-- 송장등록 -->
        <div v-show="currentTab==4">
          <div class="card-shadow">
            <div class="box-grey">
              <div class="row">
                <div class="col-form">
                  <div class="row">
                    <div class="col col-12">
                      <div class="col-title" data-text="PD_0001_12">일자</div>
                      <div class="col-desc">                	
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">주문수집일</option>
                          <option>고객주문일</option>
                          <option>취소요청일</option>
                          <option>취소완료일</option>
                          <option>송장등록일</option>
                          <option>송장전송일</option>
                          <option>반품요청일</option>
                          <option>반품입고일</option>
                          <option>반품완료일</option>
                          <option>교환요청일</option>
                          <option>교환완료일</option>
                        </select>		                  
                        </div>		                	
                        <span class="wave float-left">&nbsp;</span>
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
                          <a class="btn btn-outline-dark btn-sm" href="#" data-text="PD_0001_16">1개월</a>
                          <a class="btn btn-outline-dark btn-sm" href="#" data-text="PD_0001_17">3개월</a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
				      <br>
              <div class="row">
                <div class="col-form">
                  <div class="row">
                    <div class="col col-12">
                      <div class="col-title" data-text="PD_0001_12">검색</div>
                      <div class="col-desc">
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">알림 전체</option>
                          <option>네이버페이</option>
                        </select>		                  
                    </div>
                    <span class="wave float-left">&nbsp;</span>
                      <div class="input-group float-left" style="width: 150px">
                      <select class="custom-select custom-select-sm" title="">
                        <option selected="">신규주문</option>
                        <option>주문상태 전체</option>
                        <option>배송준비</option>
                        <option>송장등록</option>
                        <option>송장전송완료</option>
                        <option>배송완료</option>
                        <option>취소요청</option>
                        <option>취소완료</option>
                        <option>배송보류</option>
                        <option>교환요청</option>
                        <option>교환완료</option>
                        <option>반품요청</option>
                        <option>반품완료</option>
                      </select>
                      </div>
                      <span class="wave float-left">&nbsp;</span>
                      <div class="input-group float-left" style="width: 150px">
                      <select class="custom-select custom-select-sm" title="">
                        <option selected="">클레임유무</option>
                        <option>클레임 있음</option>
                      </select>
                      </div>
                      <span class="wave float-left">&nbsp;</span>
                      <div class="input-group float-left" style="width: 150px">
                      <select class="custom-select custom-select-sm" title="">
                        <option selected="">주문자명</option>
                        <option>수취인명</option>
                        <option>수취인핸드폰</option>
                        <option>수취인전화</option>
                        <option>송장번호</option>
                        <option>거래번호</option>
                        <option>쇼핑몰 주문번호</option>
                        <option>쇼핑몰 아이디</option>
                        <option>쇼핑몰 상품코드</option>
                        <option>주문 상품명</option>
                        <option>옵션항목</option>
                      </select>
                      </div>		                  
                      <span class="wave float-left">&nbsp;</span>
                      <div class="input-group float-left" style="width: 250px">
                        <input type="text" class="form-control form-control-sm" title="text" placeholder="">
                      </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>	        
		          <br>
              <div class="info-box my-2">
                <div class="wrap-btn">
                  <a class="btn btn-outline-dark" href="#">검색</a>
                  <a class="btn btn-outline-dark" href="#">초기화</a>
                </div>
              </div>	        
		        </div>
          </div>
          <br>
          <div class="card-shadow">
            <div class="info-box mb-3">
              <div class="info">
                <span>● 자료수: 총2 건</span>
              </div>
              <div class="wrap-btn">
                <a class="btn btn-outline-dark" href="#">송장정보 저장</a>
                <a class="btn btn-outline-dark" href="#">주문일괄변경</a>
                <a class="btn btn-outline-dark" href="#">엑셀작업</a>
                <!--  <a class="btn btn-file mr-0" href="#"><i class="fal fa-file-alt"></i></a> 문서모양막아놓기-->
                <a class="btn btn-file" href="#"><i class="far fa-file-download"></i></a>
              </div>
            </div>
            <table class="centered table mb-2">
              <colgroup>
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">                                                                                                                      
              </colgroup>
              <thead>
              <tr>
                <th>선택</th>
                <th>알림</th>
                <th>주문수집일</th>
                <th>쇼핑몰 주문번호</th>
                <th>주문상태</th>
                <th>쇼핑몰(ID)</th>
                <th>주문자</th>
                <th>상품명(옵션)</th>
                <th>택배사</th>
                <th>송장번호</th>
                <th>수량</th>
                <th>주문액</th>
                <th>수취인</th>
                <th>휴대번호</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td>
                  <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" title="checkbox">
                    <label class="custom-control-label"></label>
                  </div>
                </td>
                <td>묶음</td>
                <td>2021-08-08</td>
                <td>5195561922</td>
                <td>배송준비</td>
                <td>asa@naver.com</td>
                <td>홍길동</td>
                <td>GPS 수신</td>
                <td>택배사</td>
                <td>1234-5678</td>
                <td>1</td>
                <td>125,000</td>
                <td>홍길동</td>
                <td>010-1234-1234</td>
              </tr>
              <tr>
                <td>
                  <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" title="checkbox">
                    <label class="custom-control-label"></label>
                  </div>
                </td>
                <td>묶음</td>
                <td>2021-08-08</td>
                <td>5195561922</td>
                <td>배송준비</td>
                <td>asa@naver.com</td>
                <td>홍길동</td>
                <td>GPS 수신</td>
                <td>택배사</td>
                <td>1234-5678</td>
                <td>1</td>
                <td>125,000</td>
                <td>홍길동</td>
                <td>010-1234-1234</td>
              </tr>               
              </tbody>
            </table>          
            <div class="info-box my-2">
              <div class="wrap-btn">
                <a class="btn btn-outline-dark" href="#">주문삭제</a>
                <a class="btn btn-outline-dark" href="#">일괄문자전송</a>
              </div>
            </div>
          </div>           
        </div>

        <!-- 송장전송 완료 -->
        <div v-show="currentTab==5">
          <div class="card-shadow">
            <div class="box-grey">
              <div class="row">
                <div class="col-form">
                  <div class="row">
                    <div class="col col-12">
                      <div class="col-title" data-text="PD_0001_12">일자</div>
                      <div class="col-desc">                	
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">주문수집일</option>
                          <option>고객주문일</option>
                          <option>취소요청일</option>
                          <option>취소완료일</option>
                          <option>송장등록일</option>
                          <option>송장전송일</option>
                          <option>반품요청일</option>
                          <option>반품입고일</option>
                          <option>반품완료일</option>
                          <option>교환요청일</option>
                          <option>교환완료일</option>
                        </select>		                  
                        </div>		                	
                        <span class="wave float-left">&nbsp;</span>
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
                          <a class="btn btn-outline-dark btn-sm" href="#" data-text="PD_0001_16">1개월</a>
                          <a class="btn btn-outline-dark btn-sm" href="#" data-text="PD_0001_17">3개월</a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
				      <br>
              <div class="row">
                <div class="col-form">
                  <div class="row">
                    <div class="col col-12">
                      <div class="col-title" data-text="PD_0001_12">검색</div>
                      <div class="col-desc">
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">알림 전체</option>
                          <option>네이버페이</option>
                        </select>		                  
                        </div>
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">신규주문</option>
                          <option>주문상태 전체</option>
                          <option>배송준비</option>
                          <option>송장등록</option>
                          <option>송장전송완료</option>
                          <option>배송완료</option>
                          <option>취소요청</option>
                          <option>취소완료</option>
                          <option>배송보류</option>
                          <option>교환요청</option>
                          <option>교환완료</option>
                          <option>반품요청</option>
                          <option>반품완료</option>
                        </select>
                        </div>
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">클레임유무</option>
                          <option>클레임 있음</option>
                        </select>
                        </div>
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">주문자명</option>
                          <option>수취인명</option>
                          <option>수취인핸드폰</option>
                          <option>수취인전화</option>
                          <option>송장번호</option>
                          <option>거래번호</option>
                          <option>쇼핑몰 주문번호</option>
                          <option>쇼핑몰 아이디</option>
                          <option>쇼핑몰 상품코드</option>
                          <option>주문 상품명</option>
                          <option>옵션항목</option>
                        </select>
                        </div>		                  
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 250px">
                          <input type="text" class="form-control form-control-sm" title="text" placeholder="">
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>	        
		        <br>
		        <div class="info-box my-2">
	            <div class="wrap-btn">
	              <a class="btn btn-outline-dark" href="#">검색</a>
	              <a class="btn btn-outline-dark" href="#">초기화</a>
	            </div>
	          </div>	        
		        </div>
          </div>
          <br>
          <div class="card-shadow">
            <div class="info-box mb-3">
              <div class="info">
                <span>● 자료수: 총2 건</span>
              </div>
              <div class="wrap-btn">
                <a class="btn btn-outline-dark" href="#">송장정보 저장</a>
                <a class="btn btn-outline-dark" href="#">주문일괄변경</a>
                <a class="btn btn-outline-dark" href="#">엑셀작업</a>
                <!--  <a class="btn btn-file mr-0" href="#"><i class="fal fa-file-alt"></i></a> 문서모양막아놓기-->
                <a class="btn btn-file" href="#"><i class="far fa-file-download"></i></a>
              </div>
            </div>
            <table class="centered table mb-2">
              <colgroup>
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">
                <col style="width:7%">                                                                                                                      
              </colgroup>
              <thead>
              <tr>
                <th>선택</th>
                <th>알림</th>
                <th>주문수집일</th>
                <th>쇼핑몰 주문번호</th>
                <th>주문상태</th>
                <th>쇼핑몰(ID)</th>
                <th>주문자</th>
                <th>상품명(옵션)</th>
                <th>택배사</th>
                <th>송장번호</th>
                <th>수량</th>
                <th>주문액</th>
                <th>수취인</th>
                <th>휴대번호</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td>
                  <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" title="checkbox">
                    <label class="custom-control-label"></label>
                  </div>
                </td>
                <td>묶음</td>
                <td>2021-08-08</td>
                <td>5195561922</td>
                <td>배송준비</td>
                <td>asa@naver.com</td>
                <td>홍길동</td>
                <td>GPS 수신</td>
                <td>택배사</td>
                <td>1234-5678</td>
                <td>1</td>
                <td>125,000</td>
                <td>홍길동</td>
                <td>010-1234-1234</td>
              </tr>
              <tr>
                <td>
                  <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" title="checkbox">
                    <label class="custom-control-label"></label>
                  </div>
                </td>
                <td>묶음</td>
                <td>2021-08-08</td>
                <td>5195561922</td>
                <td>배송준비</td>
                <td>asa@naver.com</td>
                <td>홍길동</td>
                <td>GPS 수신</td>
                <td>택배사</td>
                <td>1234-5678</td>
                <td>1</td>
                <td>125,000</td>
                <td>홍길동</td>
                <td>010-1234-1234</td>
              </tr>               
              </tbody>
            </table>          
            <div class="info-box my-2">
              <div class="wrap-btn">
                <a class="btn btn-outline-dark" href="#">주문삭제</a>
                <a class="btn btn-outline-dark" href="#">일괄문자전송</a>
              </div>
            </div>
          </div>        
        </div>

        <!-- 수집실패 -->
        <div v-show="currentTab==6">
          <div class="card-shadow">
            <div class="box-grey">
              <div class="row">
                <div class="col-form">
                  <div class="row">
                    <div class="col col-12">
                      <div class="col-title" data-text="PD_0001_12">수집 실행 기간</div>
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
				      <br>
              <div class="row">
                <div class="col-form">
                  <div class="row">
                    <div class="col col-6">
                      <div class="col-title" data-text="PD_0001_12">작업명</div>
                      <div class="col-desc">
                        <div class="input-group float-left" style="width: 300px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">전체</option>
                          <option>클레임 수집</option>
                          <option>주문수집</option>
                        </select>		                  
                        </div>
                      </div>
                    </div>		              
                    <div class="col col-6">
                      <div class="col-title" data-text="PD_0001_12">쇼핑몰</div>
                      <div class="col-desc">
                        <div class="input-group float-left" style="width: 300px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">쇼핑몰 전체</option>
                          <option>스마트스토어</option>
                        </select>		                  
                        </div>
                      </div>
                    </div>	              
                  </div>
                </div>
              </div>	        
		          <br>
		          <div class="info-box my-2">
	              <div class="wrap-btn">
	               <a class="btn btn-outline-dark" href="#">검색</a>
	             </div>
	            </div>	        
		        </div>
          </div>
          <br>
          <div class="card-shadow">
          </div>           
        </div>

        <!-- 송장전송실패 -->
        <div v-show="currentTab==7">
          <div class="card-shadow">
            <div class="box-grey">
              <div class="row">
                <div class="col-form">
                  <div class="row">
                    <div class="col col-12">
                      <div class="col-title" data-text="PD_0001_12">일자</div>
                      <div class="col-desc">                	
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">주문수집일</option>
                          <option>고객주문일</option>
                          <option>취소요청일</option>
                          <option>취소완료일</option>
                          <option>송장등록일</option>
                          <option>송장전송일</option>
                          <option>반품요청일</option>
                          <option>반품입고일</option>
                          <option>반품완료일</option>
                          <option>교환요청일</option>
                          <option>교환완료일</option>
                        </select>		                  
                        </div>		                	
                        <span class="wave float-left">&nbsp;</span>
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
                          <a class="btn btn-outline-dark btn-sm" href="#" data-text="PD_0001_16">1개월</a>
                          <a class="btn btn-outline-dark btn-sm" href="#" data-text="PD_0001_17">3개월</a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <br>
              <div class="row">
                <div class="col-form">
                  <div class="row">
                    <div class="col col-12">
                      <div class="col-title" data-text="PD_0001_12">검색</div>
                      <div class="col-desc">
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">알림 전체</option>
                          <option>네이버페이</option>
                        </select>		                  
                        </div>
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">주문상태 전체</option>
                          <option>주문상태 전체</option>
                          <option>배송준비</option>
                          <option>송장등록</option>
                          <option>송장전송완료</option>
                          <option>배송완료</option>
                          <option>취소요청</option>
                          <option>취소완료</option>
                          <option>배송보류</option>
                          <option>교환요청</option>
                          <option>교환완료</option>
                          <option>반품요청</option>
                          <option>반품완료</option>
                        </select>
                        </div>
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">클레임유무</option>
                          <option>클레임 있음</option>
                        </select>
                        </div>
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 150px">
                        <select class="custom-select custom-select-sm" title="">
                          <option selected="">주문자명</option>
                          <option>수취인명</option>
                          <option>수취인핸드폰</option>
                          <option>수취인전화</option>
                          <option>송장번호</option>
                          <option>거래번호</option>
                          <option>쇼핑몰 주문번호</option>
                          <option>쇼핑몰 아이디</option>
                          <option>쇼핑몰 상품코드</option>
                          <option>주문 상품명</option>
                          <option>옵션항목</option>
                        </select>
                        </div>		                  
                        <span class="wave float-left">&nbsp;</span>
                        <div class="input-group float-left" style="width: 250px">
                          <input type="text" class="form-control form-control-sm" title="text" placeholder="">
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>	        
              <br>
              <div class="info-box my-2">
                <div class="wrap-btn">
                  <a class="btn btn-outline-dark" href="#">검색</a>
                  <a class="btn btn-outline-dark" href="#">초기화</a>
                </div>
              </div>	        
            </div>
          </div>
          <br>
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
      tabs: ['쇼핑몰계정관리', '그룹관리', '택배관리', '사용자권한관리'
            ,'송장등록', '송장전송완료', '수집실패', '송장전송실패']
    }
  }
}
</script>

<style scoped>
</style>
