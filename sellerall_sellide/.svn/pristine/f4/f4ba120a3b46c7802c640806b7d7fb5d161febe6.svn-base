import Vue from 'vue'
import Router from 'vue-router'
import content from '@/views/sellide/content'

import userMgmt from '@/views/sys/userMgmt'
import menuMgmt from '@/views/sys/menuMgmt'
import rankMgmt from '@/views/sys/rankMgmt'

import crawler from '@/views/aid/crawler'
import status from '@/views/aid/status'

import productmanage from '@/views/sellide/productmanage'
import ordermanage from '@/views/sellide/ordermanage'
import customerinquiry from '@/views/sellide/customerinquiry'
import preferences from '@/views/sellide/preferences'

import temp1 from '@/views/scout/temp1'
import temp2 from '@/views/scout/temp2'
import temp3 from '@/views/scout/temp3'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
			path: '/sellide/main', name: 'Content', component: content
		},
    {
			path: '/sys/usermanage', name: 'userMgmt', component: userMgmt
		},
    {
			path: '/sys/menumanage', name: 'menuMgmt', component: menuMgmt
		},
    {
			path: '/sys/rankmanage', name: 'rankMgmt', component: rankMgmt
		},
    {
			path: '/aid/crawler', name: 'crawler', component: crawler
		},
    {
			path: '/aid/status', name: 'status', component: status
		},
		{
			path: '/sellide/productmanage', name: 'productmanage', component: productmanage
		},
		{
			path: '/sellide/ordermanage', name: 'ordermanage', component: ordermanage
		},
		{
			path: '/sellide/customerinquiry', name: 'customerinquiry', component: customerinquiry
		},
		{
			path: '/sellide/preferences', name: 'preferences', component: preferences
		},
    {
			path: '/scout/temp1', name: 'temp1', component: temp1
		},
		{
			path: '/scout/temp2', name: 'temp2', component: temp2
		},
    {
			path: '/scout/temp3', name: "temp3" , component: temp3
		},

    {
      path: '*',
      redirect: "/404"
    }
  ]
})
