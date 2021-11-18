<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<title>구글차트</title>
</head>
<script type="text/javascript">
	google.load("visualization", "1", {
		"packages" : [ "corechart" ]
	});
	
	google.setOnLoadCallback(drawChart);
	function drawChart(){
		
		//chart/chart02_money
		var jsonData = $.ajax({
			url:"/chart/chart02_money",
			dataType : "json",
			async : false
		}).responseText;
		
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
<body>

	<div class="card shadow mb-4">
		<div class="card-body">
			<div id="chart_div"></div>
		</div>
	</div>
	
</body>
</html>