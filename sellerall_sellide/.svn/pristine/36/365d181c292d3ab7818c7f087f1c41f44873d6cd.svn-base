<template>
  <transition name="modal">
    <div class="modal-mask">
      <div class="modal-dialog modal-sm modal-dialog-centered"  role="document">
        <div class="modal-container">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close" @click="$emit('close-modal')">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body text-center">
            {{sendData}}
          </div>
          <div class="modal-footer pt-0">
            <button type="button" class="btn btn-primary com-modal-btn" data-dismiss="modal" data-text="LJ_0102_43" @click="$emit('close-modal')">확인</button>
          </div>
        </div>
      </div>
    </div>
  </transition>
</template>

<script>
export default {
  name: 'alterPopupModal',
  props: ['sendData'],
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
