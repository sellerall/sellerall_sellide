var login = {
    init : function () {
    	 var _this = this;
    	 
    	$('#btnLogin').on('click', function (){
			if($("#userId").val()==""){
				alert("아이디를 입력하세요.");
				return false;
			} else if($("#userPwd").val()==""){
			} else {
				_this.login();
				/*$('#infoForm').submit();*/
			}
		});

		$('#userId,#userPwd').keydown(function (key) {
            if(key.keyCode == 13){
            	if($("#userId").val()==""){
    				alert("아이디를 입력하세요.");
    				return false;
    			} else if($("#userPwd").val()==""){
    			} else {
    				_this.login();
    				/*$('#infoForm').submit();*/
    			}
            }
        });
		
		/*$('.snsBtn').on('click', function (){
			_this.snsLogin(this);
		});*/
		
        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
        
        var $idCheckMsgBox = $('#idCheckMsgBox');
        var $idCheckMsg = $('#idCheckMsg');
        var $passCheckMsgBox = $('#passCheckMsgBox');
        var $passCheckMsg = $('#passCheckMsg');
        var $emailCheckMsgBox = $('#emailCheckMsgBox');
        var $emailCheckMsg = $('#emailCheckMsg');
        $('#passForm')
        // 엔터 키 처리.
        .on('keydown', 'input[type="text"], input[type="password"], input[type="number"]', function (e) {
            if (e.keyCode === 13) {
                e.stopPropagation();
                return false;
            }
        })
        // 아이디 문자열 치완
        .on('keyup', '#id', function () {
            var inputVal = this.value;
            if (/[^a-z0-9\_]/gi.test(inputVal)) {
            	$idCheckMsg.text('4 ~ 20자의 영문, 숫자와 특수문자(_)만 사용 가능').show();
                this.value = inputVal.replace(/[^a-z0-9\_]/gi, '');
            }
        })
        .on('focus', '#id', function() {
        	$idCheckMsg.html('<span class="less_important">4 ~ 20자의 영문, 숫자와 특수문자(_)만 사용 가능</span>').css('color','#a4a3a3').show();
            $idCheckMsgBox.show();
        })
        .on('focusout', '#id', function() {
            this.value = this.value.replace(/[^a-z0-9\_]/gi, '');
        })
        .on('blur', '#id', function() {
        	_this.idExsistCheck(this.value);
        })
        .on('focus', '#passPwd', function() {
            if (this.value === '') {
            	$passCheckMsg.html('<span>8~16자리 영문 대소문자, 숫자, 특수문자 중 3가지 이상 조합</span>').css('color','#a4a3a3').show();  
            	$passCheckMsgBox.show();
            }
        })
        .on('focusout', '#passPwd', function() {
        	//$passCheckMsg.hide();
        })
        .on('keyup', '#passPwd', function(e) {
        	_this.verifyPasswdStrength(e.currentTarget);
        })
        .on('blur', '#passPwd', function(e) {
        	_this.verifyPasswdStrength(e.currentTarget);
        })
        .on('keyup', '#Email', function(e) {
            var $msg_area = $emailCheckMsgBox;
            var email_patten = /[ㄱ-ㅎㅏ-ㅣ가-힣]/gi;
            $msg_area.hide();
            if (email_patten.test(this.value)) {
                this.value = this.value.replace(email_patten, '');
                $msg_area.show();
            }
        })
        .on('blur', '#Email', function() {
        	_this.chkEmail(this);
        })
        
        ;
    },
    
    idExsistCheck : function (id_val) {
    	var $id = $('#id');
	    var $idCheckMsgBox = $('#idCheckMsgBox');
	    var $idCheckMsg = $('#idCheckMsg');
	    id_val = id_val.replace(/[^a-z0-9\_]/gi, '');

	    if (id_val === '' || $id.get(0).getAttribute('placeholder') === id_val) {
	    	$idCheckMsg.html('<span class="less_important">4 ~ 20자의 영문, 숫자와 특수문자(_)만 사용 가능</span>').css('color','#ff0000').show();
	        return false;
	    }

	    $id.val(id_val);
	    $('#id_chk_ok').val('0');

	    if (id_val.length < 4) {
	    	$idCheckMsg.html('4 ~ 20자의 영문, 숫자와 특수문자(_)만 사용 가능').css('color','#ff0000').show();
	        return false;
	    }
	    
	    common.commonApiAjax('/api/login/user/id/'+id_val,'',function(data){
	    	if (data.message === "duplicate") {
	    		$idCheckMsg.text('이미 사용중인 아이디입니다.').css('color','#ff0000').show();
                return false;
            } else {
                if (id_val.replace(" ", "") !== id_val || id_val.length < 4 || !engornum(id_val)) {
                	$idCheckMsg.text('다른 아이디를 입력해주세요.').show();
                    return false;
                } else {
                	$idCheckMsg.text('사용가능한 아이디입니다.').css('color','#1880ea').show();
                }
                $('#loading').hide();
                $('#id_chk_ok').val('1');
                return true;
            }
		});

	    function engornum(strdata) {
	        for (a = 0; a < strdata.length; a++) {
	            var sid = strdata.substring(a, a + 1);
	            if ((sid < "0" || sid > "9") && (sid < "a" || sid > "z") && (sid < "A" || sid > "Z") && sid != "_") {
	                return false;
	            }
	        }
	        return true;
	    }
    },
    
    verifyPasswdStrength : function (elmt) {
    	var password = elmt.value;
        var $passCheckMsgBox = $('#passCheckMsgBox');
	    var $passCheckMsg = $('#passCheckMsg');
        var id_val = $('#id').val();

        if ($.trim(password) === '' || elmt.getAttribute('placeholder') === password) {
        	$passCheckMsg.html('<span class="less_important">8~16자리 영문 대소문자, 숫자, 특수문자 중 3가지 이상 조합</span>').css('color','#ff0000').show();
            return false;
        }

        if (password.length > 16) {
            $(elmt).val(password.substr(0, 16));
            $passCheckMsg.html('<span class="less_important">8~16자리 영문 대소문자, 숫자, 특수문자 중 3가지 이상 조합</span>').css('color','#ff0000').show();
        }

        if (PasswordStrength.verify(password, "", id_val)) {
            //var testVal = PasswordStrength.verify(elmt.value, "", "");
        	$passCheckMsg.text(PasswordStrength.getStrength()).css('color','#1880ea').show();
        	$('#pass_chk_ok').val('1');
        	return true;
        }
        $passCheckMsg.html(PasswordStrength.getStrength() + '<br><span style="color:#a4a3a3;">' + PasswordStrength.getMessage() + '</span>').css('color','#ff0000').show();
        return false;
    },
    chkEmail : function (obj) {
    	var $email_id = $('#Email');
        var $emailCheckMsgBox = $('#emailCheckMsgBox');
	    var $emailCheckMsg = $('#emailCheckMsg');
        var valEmailId = $.trim($email_id.val())
        ;

        $emailCheckMsgBox.hide();

        if (valEmailId === '') {
        	$emailCheckMsg.text('이메일 주소를 다시 확인해주세요.').css('color','#ff0000');
        	$emailCheckMsgBox.show()
            return false;
        }

        var email = $email_id.val();

        var reg_email = /^[0-9a-z_+-]+([\.]*[0-9a-z_+-])*@([0-9a-z_-]+\.)+[a-z]{2,10}$/i;
        if (email !== '' && email.search(reg_email) == -1) {
        	$emailCheckMsg.text('이메일 주소를 다시 확인해주세요.').css('color','#ff0000');
        	$emailCheckMsgBox.show();
            return false;
        }
        
        common.commonApiAjax('/api/login/user/em/'+valEmailId,'',function(data){
	    	if (data.message === "duplicate") {
	    		$emailCheckMsg.text('이미 사용중인 Email입니다.').css('color','#ff0000').show();
	    		$emailCheckMsgBox.show();
                return false;
            }
		});
        $('#email_chk_ok').val('1');
        return true;
    },
    save : function () {
        var data = {
            userId: $('#id').val(),
            userName: $('#userName').val(),
            userPwd: $('#passPwd').val(),
            userEmail: $('#Email').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/login/user',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원가입이 완료되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert('알수없는 오류가 발생 하였습니다. 문제가 지속될 경우 관리자에게 문의하여 주시기 바랍니다.');
        });
    },
    
    login : function () {
        var data = {
            userId: $('#userId').val(),
            userPwd: $('#userPwd').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/authentications',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('로그인 성공');
            window.location.href = '/sellide/main';
        }).fail(function (error) {
            alert('알수없는 오류가 발생 하였습니다. 문제가 지속될 경우 관리자에게 문의하여 주시기 바랍니다.');
        });
    },
    
    snsLogin : function (btn) {
    	var btnText = $(btn).text();
    	var snsUrl = '';

        if(btnText == 'Google Login'){
        	snsUrl = '/oauth2/authorization/google';
        }else if(btnText == 'Naver Login'){
        	snsUrl = '/oauth2/authorization/naver';
        }

        $.ajax({
            type: 'GET',
            url: snsUrl,
        }).done(function() {
            alert('소셜 로그인 완료되었습니다.');
        }).fail(function (error) {
            alert('알수없는 오류가 발생 하였습니다. 문제가 지속될 경우 관리자에게 문의하여 주시기 바랍니다.');
        });
    },

};

login.init();
