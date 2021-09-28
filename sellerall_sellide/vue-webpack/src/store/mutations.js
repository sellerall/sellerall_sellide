export default {
  updateMyData (state, data) {
     state.userId =  data.userId,
     state.userName =  data.userName,
     state.userEmail =  data.userEmail,
     state.userPhone =  data.userPhone,
     state.userPicture =  data.userPicture,
     state.role =  data.role
     return state;
  },
  logout (state) {
    state.userId =  "",
    state.userName =  "",
    state.userEmail =  "",
    state.userPhone =  "",
    state.userPicture =  "",
    state.role =  ""
  }
}
