<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인홈페이지</title>
<style type="text/css">
.App {
	text-align: center;
	font-size: 16px;
}

label, input, button {
	margin: 10px;
	padding: 5px;
}

footer {
	bottom: 0;
	position: absolute;
	width: 90%;
	height: 40px;
}
</style>
<link rel="stylesheet"
	href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
</script>
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<div class="App">
		<jsp:include page="common/top.jsp" flush="true" /><br>
		<jsp:include page="common/menu.jsp" flush="true" />
		<hr>
		<jsp:include page="goods/goodsList.jsp" flush="true" />
		<!-- goodsList로 mainServlet의 request가 확장됨 -->
		<!-- goodsList에서 키값을 이용해 ${goodList}를 쓸 수 있다 -->
	</div>
</body>
</html>