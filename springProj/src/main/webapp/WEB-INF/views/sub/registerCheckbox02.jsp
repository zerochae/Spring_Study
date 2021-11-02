<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>체크박스 요소</title>
﻿<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
		let count = 1;
	
		$(function() {
		
		//id = "btnAdd" 인 div 요소의 마지막 요소로써 복사한 데이터를  추가
		
// 		<p class="zero">
// 		카드1 - 번호 <input type="text" name="cardList[0].no" value="123456">
// 		카드1 - 유효기간 <input type="text" name="cardList[0].validMonth"
// 			value="25/10">
// 	</p>


		$("#btnAdd").on("click", function() {
			
			if(count > 0){
				
			count++;
			
			console.log(count);
			
			let html = "<p class='card'> 카드 "+count+" - 번호 <input type='text' name='cardList["+count+"].no' value='123456'> "
					 + "카드 "+count+" - 유효기간 <input type='text' name='cardList["+count+"].validMonth' value='25/10'> </p>"
			
			$('#divCard').append(html);
			}
		});
		
		$('#btnDel').on("click",function(){
			if(count > 1){
				
			$('.card').last().remove();
			
			count--;
			console.log(count);
			}
			
		});
		
		
	});
</script>
</head>
<body>

	<form action="/board/registerCheckbox" method="post">

		<p>hobbyList</p>
		<p>회원 ID</p>
		<p>
			<input type="text" name="memId" value="a001">
		</p>
		<p>회원이름</p>
		<p>
			<input type="text" name="memName" value="김은대">
		</p>

		<!-- MemberVO의 AddressVO 타입의 addressVo 필드 
		중첩된(nested) 자바빈즈
	-->

		<p>우편번호</p>
		<p>
			<input type="text" name="addressVo.postCode" value="123-456">
		</p>
		<p>주소</p>
		<p>
			<input type="text" name="addressVo.location" value="대전 중구 대흥동">
		</p>




		<label for="hobbylist1"> <input type="checkbox"
			id="hobbylist1" name="hobbyList" value="Sports" />Sports
		</label> <label for="hobbylist2"> <input type="checkbox"
			id="hobbylist2" name="hobbyList" value="Music" /> Music
		</label> <label for="hobbylist3"><input type="checkbox"
			id="hobbylist3" name="hobbyList" value="Movie" /> Movie </label> 
			<p></p>
			<input type="button" id="btnAdd" value="+"> &nbsp; 
			<input type="button" id="btnDel" value="-">
		<div id="divCard">
			<p>
				카드 1 - 번호 <input type="text" name="cardList[0].no" value="123456">
				카드 1 - 유효기간 <input type="text" name="cardList[0].validMonth"
					value="25/10">
			</p>
		</div>
		<input type="submit" name="registerCheckbox02" />
	</form>

	<p class="zero" style="display:none">
		카드 1 - 번호 <input type="text" name="cardList[0].no" value="123456">
		카드 1 - 유효기간 <input type="text" name="cardList[0].validMonth"
			value="25/10">
	</p>

</body>
</html>