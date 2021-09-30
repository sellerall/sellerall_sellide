<template>
	<!-- <body> -->
	<div class="main-menu">
		<div class="header_wrap">
			<div class="login_section">
				<router-link to="/sellide/main" class="logo _logo"> <!--sellide/main-->
					<img src="../../../assets/img/logo/aside_logo.png" alt="로고">
				</router-link>
				<div class="login_wrap">
					<span class="login_name"><span class="name">{{userInfo.userName}}</span>님</span> <!--{{userName}}-->
				</div>
			</div>
			<ul class="icon_menu">
				<li class="login_icon" id="logOutLi"><a href="/logout"><i class="fal fa-sign-out-alt"></i>로그아웃</a></li>
			</ul>
		</div>
		<div class="main-menu-content _scroll" style="height: calc(100% - 179px);">
			<div>
				<ul class="navigation" v-for="menuGrp in menuGrps" >
					<li class="navigation-header"><i class="fas fa-info-circle"></i><span class="menu-title">{{menuGrp.menuGrpName}}</span></li>
					<li class="nav-item" v-for="(menu,idx) in menuGrp.menuMst" :key="menu+idx" :class="{active: menu.menuSeq === selectedTab}" @click="menuTabClick(menu,menu.menuSeq)"><router-link v-bind:to="`${menu.menuUrl}`"><span class="menu-title">{{menu.menuName}}</span></router-link></li>

					<!-- <li class="navigation-header"><i class="fas fa-info-circle"></i><span class="menu-title">관리자</span></li>
					<li class="nav-item active"><router-link to="#"><span class="menu-title">사용자관리</span></router-link></li>
					<li class="nav-item"><router-link to="#"><span class="menu-title">메뉴관리</span></router-link></li>
					<li class="nav-item"><router-link to="#"><span class="menu-title">코드관리</span></router-link></li>
					<li class="navigation-header"><i class="fas fa-info-circle"></i><span class="menu-title">에이드</span></li>
					<li class="nav-item"><router-link to="#"><span class="menu-title">B2B 수집</span></router-link></li>
					<li class="nav-item"><router-link to="#"><span class="menu-title">B2B 상태</span></router-link></li>
					<li class="navigation-header"><i class="fas fa-info-circle"></i><span class="menu-title">셀리드</span></li>
					<li class="nav-item"><router-link to="/sellide/productmanage"><span class="menu-title">상품관리</span></router-link></li>
					<li class="nav-item"><router-link to="/sellide/ordermanage"><span class="menu-title">주문관리</span></router-link></li>
					<li class="nav-item"><router-link to="/sellide/customerinquiry"><span class="menu-title">고객문의관리</span></router-link></li>
					<li class="nav-item"><router-link to="/sellide/preferences"><span class="menu-title">환경설정</span></router-link></li>
					<li class="navigation-header"><i class="fas fa-info-circle"></i><span class="menu-title">스카우터</span></li>
					<li class="nav-item"><router-link to="#"><span class="menu-title">준비중</span></router-link></li>
					<li class="nav-item"><router-link to="#"><span class="menu-title">준비중</span></router-link></li> -->
				</ul>
			</div>
		</div>

	</div>
	<!-- </body> -->
</template>

<script>
import { mapState ,mapGetters,mapMutations } from 'vuex'


export default {
	name: 'aside',
	data(){
		return{
			menuGrps:[],
			selectedTab : 0,
		}
	},
	components: {

	},
	computed: {
		...mapGetters([
			'userInfo'
		])
	},
	mounted (){
		axios.get('/api/login/user') .then(res => {
			this.$store.commit('updateMyData',res.data);
		}),

		axios.post('/api/menu/v1/all-list').then(res => {
			this.menuGrps = res.data;
			//console.log(res.data);
			$('._scroll').mCustomScrollbar();
		})
	},

	methods: {
		menuTabClick: function(item,idx) {
			this.selectedTab = idx;
		},
	}
}
</script>

<style>
</style>
