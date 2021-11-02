<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<script type="text/javascript" src="/resources/js/jquery-3.6.0.js"></script>
<title>아작스를 통한 이미지 업로드</title>
<script type="text/javascript">
$(function(){
	
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	var maxSize = 5242880; // 5Mb
	
	// 파일명과 파일크기를 체크하는 함수
	function checkExtension(fileName, fileSize){
		// 파일 크기 체크
		if(fileSize >= maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		//파일명 체크
		if(regex.test(fileName)){
			alert("해당 종류의 파일읍 업로드 할 수 없습니다.")
			return false;
		}
		
		return true;
	}
	
	$('#uploadBtn').on("click",function(e){
		//jQuery를 이용하여 파일 업로드를 하기위해
		//formData  객체(가상의 form 태그) 이용.
		// 해당 객체에 필요한 파라미터를 담아서 전송함
		var formData = new FormData();
		// input 요소의 name 속성의 값이 uploadFile인 것을 찾아서
		// 자바스크립트의  inputFile 객체에 할당
		var inputFile = $("input[name='uploadfile']");
		// 첫번째 파일 객체 안에 업로드 할 이미지들이 있는데
		// 그 이미지 객체들을 files 객체에 할당
		var files = inputFile[0].files;
		
		console.log("files : " + files);
		
		//파일객체(files)를 가상의 form(formdata)에 추가
		for(var i=0; i<files.length; i++){
			formData.append("uploadFile",files[i]);
		}
		
		console.log("formData :" + formData);
		// ajax를 통해서 formData 자체를 전송 시
		// processData:false, contentType:false 이어야 함.
		$.ajax({
			url:'/uploadAjaxAction',
			processData:false,
			contentType:false,
			data : formData ,
			type: "POST",
			success : function (result){
				alert("uploaded");
			}
			
		})
	});
});
</script>
</head>
<body>

	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">아작스를 통한 이미지 업로드</h1>
		</div>
	</div>

	<div class="container">
		<div class="form-group row">
			<label class="col-sm-2">이미지</label>
			<div class="col-sm-3">
				<input type="file" name="uploadfile" multiple />
			</div>
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" id="uploadBtn" class="btn btn-primary"
					value="업로드"/>
			</div>
		</div>
	</div>


</body>
</html>