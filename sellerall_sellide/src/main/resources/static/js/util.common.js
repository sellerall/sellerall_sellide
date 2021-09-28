var common = {
	commonApiAjax : function(url,params,logic){
		var data = {};
		
		$.ajax({
			type : "POST",
			url : url,
			dataType : "json",
			data: encodeURI(params) ,
			success: function(result){
				data = result;
				logic(data);
			}
			,timeout:100000
		});
	},
	openAlertPopup : function(msg, callback){
		var txt = ""; 
			txt+='<div id="popupAlert" class="modal fade show" id="alertType02" tabindex="-1" role="dialog" aria-modal="true">';
			txt+='  <div class="modal-dialog modal-sm modal-dialog-centered" role="document">';
			txt+='	<div class="modal-content">';
			txt+='	  <div class="modal-header">';
			txt+='		<button type="button" class="close" data-dismiss="modal" aria-label="Close">';
			txt+='		  <span aria-hidden="true">×</span>';
			txt+='		</button>';
			txt+='	  </div>';
			txt+='	  <div class="modal-body text-center">';
			txt+='		포함되어 있습니다.<br/>';
			txt+='		판매자에게 통보할 반려 사유를';
			txt+='	  </div>';
			txt+='	  <div class="modal-footer pt-0">';
			txt+='		<button type="button" class="btn btn-primary com-modal-btn" data-dismiss="modal" data-text="LJ_0102_43">확인</button>';
			txt+='	  </div>';
			txt+='	</div>';
			txt+='  </div>';
			txt+='</div>';
			
		if ( $("#popupAlert").length < 1 ) {
			$("body").append(txt).trigger("create");
		}
		
		if (msg==null || msg=="" ) {
			msg = "선택한 데이터를 삭제 하시겠습니까?";
		}
		$("#popupAlert .text-center").html(msg);
		
		// 확인 버튼 
		$("#popupAlert #btnPopupCancel").off().on("click", function(){
			closeAlertPopup(callback); 
		});
		
		$("#popupAlert").modal('show');
	},
	openAlertPopup : function(items, callback, msg){
		var txt = ""; 
			txt+='<div class="modal fade show" id="popupConfirm" tabindex="-1" role="dialog" aria-modal="true" style="display: none;>';
			txt+='	  <form id="confirmForm">';
			txt+='	  </form>';
			txt+='    <div class="modal-dialog modal-sm modal-dialog-centered" role="document">';
			txt+='        <div class="modal-content">';
			txt+='            <div class="modal-header">';
			txt+='                <button type="button" class="close" data-dismiss="modal" aria-label="Close" >';
			txt+='                    <span aria-hidden="true">×</span>';
			txt+='                </button>';
			txt+='            </div>';
			txt+='            <div id="confirmMessage" class="modal-body text-center">';
			txt+='                검증 리포트의 모든 항목을 검수하였습니까?<br /> [확인] 하시면 판매자에게 검수완료를 통보합니다.<br /> 확인하시겠습니까?';
			txt+='            </div>';
			txt+='            <div class="modal-footer pt-0">';
			txt+='                <button type="button" class="btn btn-outline-secondary com-modal-btn" data-dismiss="modal" data-text="LJ_0101_07" id="btnPopupCancel">취소</button>';
			txt+='                <button type="button" class="btn btn-primary com-modal-btn" data-text="LJ_0102_43" id="btnPopupSubmit" >확인</button>';
			txt+='            </div>';
			txt+='        </div>';
			txt+='    </div>';
			txt+='<div>';
			
		if ( $("#popupConfirm").length < 1 ) { 
			$("body").append(txt).trigger("create");
		}
		
		if (msg==null || msg=="" ) {
			msg = "선택한 데이터를 삭제 하시겠습니까?" ; 
		}
		
		$("#confirmMessage").html(msg);
		
		$("#popupConfirm #confirmForm input").remove();
		
		for (var key in items) {
			console.log(key + ": " + items[key]);
			$("#popupConfirm #confirmForm").append('<input type="hidden" name="'+key+'" value="'+items[key]+'" />');
		} 
	
		// 취소 버튼 
		$("#popupConfirm #btnPopupCancel").off().on("click", function(){
			closeConfirmPopup();
		});
	
		// 확인 버튼
		$("#popupConfirm #btnPopupSubmit").off().on("click", function(){
			callback(); 
			closeConfirmPopup();
		});
		
		$("#popupConfirm").modal('show');
		//$("#popupConfirm").show();
	}
}
