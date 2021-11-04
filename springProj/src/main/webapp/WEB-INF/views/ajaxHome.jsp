<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Headers 매핑</title>
<script src="/resources/js/jquery-3.6.0.js" type="text/javascript"></script>
<script type="text/javascript">

	$(function(){
		$('#putBtn').on("click",function(){
			
		var boardNo = $("#boardNo").val();
		var title = $("#title").val();
		var content = $("#content").val();
		var writer = $("#writer").val();
		
		var boardObject = {
				no : boardNo,
				tit : title,
				cont : content,
				wri : writer
		}
		
		// JSON.stringify => 배열을 JSON데이터로 바꿔줌
		// type => get, post, put(post방식, 데이터가 RequestBody에 들어가요)
		// data => 보낼 데이터
		// contentType => 보내는 데이터의 타입
		
		// dataType => 받는 데이터의 타입
		$.ajax({
			type:"put",
			url:"/board/"+boardNo,
			data:JSON.stringify(boardObject),
			contentType : "application/json;charset=utf-8",
			success:function(result){
				console.log(result);
			}
			});
		});
	});

</script>
</head>
<body>
	<p> <input type="text" name="boardNo" id="boardNo" value="1"/> </p>
	<p> <input type="text" name="title" id="title" value="제목"/> </p>
	<p> <textarea rows="10" cols="10" name="content" id="content"></textarea> </p>
	<p> <input type="text" name="writer" id="writer" value="개똥이"/> </p>
	<p> <input type="button" id="putBtn" value="전송"/> </p>
</body>
</html>