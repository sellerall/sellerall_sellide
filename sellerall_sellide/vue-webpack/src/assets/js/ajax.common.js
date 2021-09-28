var isLoding = false;
$.ajaxSetup({
    beforeSend : function( xhr ) {
    	$('#loading').show();
        /*if(sessionStorage.getItem('access_token')!=null && sessionStorage.getItem('access_token')!=''){
            xhr.setRequestHeader( 'Authorization', 'BEARER ' + sessionStorage.getItem('access_token') );
        }else{
        }*/
    },
    error : function(xhr, status, err) {
        if (xhr.status == 401) {
            alert("인증에 실패 했습니다. 로그인 페이지로 이동합니다.");
            location.href = "/";
        } else if (xhr.status == 403) {
            alert("세션이 만료가 되었습니다. 로그인 페이지로 이동합니다.");
            location.href = "/";
        } else if (xhr.status == 404) {
            alert("Element not found.");
        } else {
        	/* 
        	if (xhr.responseJSON != null){
        		alert("Error: " + status + ": " + xhr.responseJSON.exception.message);
        	} else {
        		alert("Error: " + status + ": " + xhr);
        		console.log(xhr);
        	}
        	*/
        }
        $('#loading').hide();
    },
    complete:function() {
    	$('#loading').hide();
    }
});
