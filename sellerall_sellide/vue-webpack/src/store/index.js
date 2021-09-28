import Vue from 'vue'
import Vuex from 'vuex'
import * as getters from './getters'
import * as actions from './actions'
import mutations from './mutations'

Vue.use(Vuex);

const state = {
  userId: "",
  userName: "",
  userEmail: "",
  userPhone: "",
  userPicture: "",
  role: ""
}

export default new Vuex.Store({
  // count state 속성 추가
  state,
  getters,
  actions,
  mutations
})
