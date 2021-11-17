<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- 구글 차트 호출을 위한 js 파일 라으브러리 -->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<title>Insert title here</title>
<script type="text/javascript">
	google.load("visualization", "1", {
		"packages" : [ "corechart" ]
	});

	// 불러오는 작업이 완료되어 로딩이 완료되면 drawChart함수 호출
	// .responseText : json을 텍스트로 로컬로 읽어들임 .console에서 확인 가능
	google.setOnLoadCallback(drawChart);

	function drawChart() {
		var jsonData = $.ajax({
			url : "/resources/json/sampleData.json",
			dataType : "json",
			async : false
		}).responseText;

		console.log("jsonData : " + jsonData);

		var data = new google.visualization.DataTable(jsonData);

		var chart = new google.visualization.LineChart(document
				.getElementById("chart_div"));

		chart.draw(data, {
			title : "차트 예제",
			width : 600,
			height : 400,
		});
	}
</script>
</head>


<body>

	<div class="card shadow mb-4">
		<div class="card-body">
			<div id="chart_div"></div>
		</div>
	</div>

</body>
</html>