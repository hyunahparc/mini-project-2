<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>

<style>
div {
	font-family: sans-serif;
}

#gName {
	font-size: 20px;
	font-weight: bold;
	font-family: sans-serif;
}
</style>


</head>

<!-- goodsList로 mainServlet의 request가 확장됨 -->
<!-- goodsList에서 키값을 이용해 ${goodList}를 쓸 수 있다 -->

<%-- <div class="card" style="width: 18rem;">
  <img src="images/items/${dto.gImage}.png" width="200" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div> --%>
<div class="container">
	<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
		<c:forEach var="dto" items="${goodsList}">
			<div class="card shadow-sm">
				<a href="goodsDetail?gCode=${dto.gCode}"> <img
					src="images/items/${dto.gImage}.png" width="200">
				</a>
				<div class="card-body">
					<p class="card-text">
					<div id="gName">${dto.gName}</div>
					<div>${dto.gPrice}원</div>
					</p>
				</div>
			</div>
		</c:forEach>
	</div>
</div>



<%-- <div class="container">
		<div class="row">
			<c:forEach var="dto" items="${goodsList}">
				<div class="col border border-dark m-4 w-80">
					<a href="goodsDetail?gCode=${dto.gCode}"> <img
						src="images/items/${dto.gImage}.png" width="200">
					</a>
					<div class="mt-4 fs-6">${dto.gName}</div>
					<div class="mt-2 fs-6">${dto.gPrice}원</div>
				</div>
			</c:forEach>
		</div>
	</div> --%>