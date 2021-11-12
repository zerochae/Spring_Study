<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
 
    <title>SB Admin 2 - Register</title>

    <!-- Custom fonts for this template-->
    <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>
 
<body class="bg-gradient-primary">
<form id="frm" method="post" action="/emp/deletePost">
	<input type="text" name="empNo" value="${param.empNo}"/>
</form>

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                            </div>
                            <form:form method="post" modelAttribute="emp" action="/emp/detailPost" class="user">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <form:input path="empNo" readonly="true" class="form-control form-control-user" placeholder="직원번호" />
                                        <font color="red"> <form:errors path="empNo"/> </font> 
                                    </div>
                                    <div class="col-sm-6">
                                        <form:input class="form-control form-control-user" readonly="true" placeholder="이름" path="nm"/>
                                        <font color="red"> <form:errors path="nm"/> </font> 
                                    </div>
                                    <!-- 
                                    <폼 태그> : 폼 항목에 바인딩되는 폼 객체의 프로퍼티를 지정
                                    2 readonly : 폼 항목을 읽기 전용으로 만들지 여뷰
                                    3. disabled : 폼 항모을 비화렁화  여부 =>
                                     -->
                                </div>
                                <div class="form-group">
                                    <form:input class="form-control form-control-user" readonly="true" placeholder="연락처" path="hp"/>
                                    <font color="red"> <form:errors path="hp"/> </font> 
                                </div>
                                <div class="form-group">
                                    <form:input class="form-control form-control-user" readonly="true" placeholder="우편번호" path="postNo"/>
                                    <font color="red"> <form:errors path="postNo"/> </font> 
                                </div>
                                <div class="form-group">
                                    <form:input class="form-control form-control-user" readonly="true" placeholder="주소" path="addr"/>
                                    <font color="red"> <form:errors path="addr"/> </font>
                                </div>
                                <div class="form-group">
                                    <form:input class="form-control form-control-user" readonly="true" placeholder="상세주소" path="addr2"/>
                                    <font color="red"> <form:errors path="addr2"/> </font>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <form:input path="password" class="form-control form-control-user" readonly="true" placeholder="비밀번호"/>
                                        <font color="red"> <form:errors path="password"/> </font>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password"  class="form-control form-control-user" readonly="true" id="password2" placeholder="비밀번호 확인">
                                        <font color="red" size="1" id="idFont" style="display:none;"> 비밀번호가 다릅니다. </font>
                                    </div>
                                </div>
                                <div class="editBox">
	                                <div class="row d-flex" style="justify-content: space-between;margin:6px">
	                                <a href="#" id="isUpdate" class="btn btn-primary btn-user col-5">
	                                    Update
	                                </a>
	                                <a href="#" id="isDelete" class="btn btn-danger btn-user col-5">
	                                    Delete
	                                </a>
	                                </div>
                                </div>
                                <div class="submitBox" style="display: none;">
	                                <div class="row d-flex" style="justify-content: space-between;margin:6px">
	                                <a href="#" id="isSubmit" class="btn btn-info btn-user col-5">
	                                    Submit
	                                </a>
	                                <a href="#" id="isCancel" class="btn btn-danger btn-user col-5" >
	                                    Cancel
	                                </a>
	                                </div>
                                </div>
                            </form:form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="forgot-password.html">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="login.html">Already have an account? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    
    <!-- Modal 추가 시작 -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
    	<div class="modal-dialog">
	    	<div class="modal-content">
	    		<div class="modal-header">
<!-- 	    			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> -->
	    			<h4 class="modal-title" id="myModalLabel">Modal Title</h4>
	    		</div>
	    		<div class="modal-body"> 처리가 완료되었습니다 </div>
	    		<div class="modal-footer">
	    			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	    		</div>
	    	</div>
	    </div>
	</div>
    <!-- Modal 추가 끝 -->

    <!-- Bootstrap core JavaScript-->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/js/sb-admin-2.min.js"></script>
	<script type="text/javascript">
	
	$(function(){
		$('#isUpdate').on('click',function(){
			$('.user *').attr('readonly',false); 
			
			$('.editBox').css("display","none");
			$('.submitBox').css("display","block");
		});
		
		$('#isCancel').on('click',function(){
			$('.user *').attr('readonly',true); 
			
			$('.editBox').css("display","block");
			$('.submitBox').css("display","none");
		});
		
		$('#isSubmit').on('click',function(){
			
			if($('#password').val()==$('#password2').val()){
			$('.user').submit();
			} else {
				$('.modal-body').html("비밀번호가 다릅니다.");
				$("#myModal").modal("show");
				$('#idFont').show();
			}
		});
		
		$('isDelete').on('click',function(){
			var yn = confirm("퇴직처리 하시겠습니까?");
			
			if(yn == true){
				$('#frm').submit();
			}
		});
	});
	
	</script>
</body>

</html>