<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<style>
#gName, #gPrice {
	font-size: 18px;
}

.center {
	text-align: center;
	margin: 0 auto;
	display: flex;
  	justify-content: center;
}
</style>

</head>


<script type="text/javascript">
	$(document).ready(function() {

		$("#up").on("click", function() {
			var gAmount = Number.parseInt($("#gAmount").val());
			$("#gAmount").val(gAmount + 1);
		});

		$("#down").on("click", function() {
			var gAmount = Number.parseInt($("#gAmount").val());
			if (gAmount == 1) {
				$("#gAmount").val(1);
			} else {
				$("#gAmount").val(gAmount - 1);
			}
		})

		// 카트 서브밋
		$("form").on("submit", function() {
			//alert("cartAdd submit");
			this.action = "cartAdd"; // CartController - cartAdd의 맵핑값
			this.method = "post";
		});

	});
</script>


<div class="container">
<div class="center">
	<form class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
		<input type="hidden" name="gCode" value="${goodsDetail.gCode}">
		<div class="card shadow-sm" style="width: 25rem;">
			<img src="images/items/${goodsDetail.gImage}.png"
				class="card-img-top" alt="...">
			<div class="card-body">
				<%-- <h6 class="card-title">
		        <span class="fw-bold">제품코드:</span>  
		        ${goodsDetail.gCode}</h6> --%>
				<h6 class="card-text" id="gName">
					<span class="fw-bold">${goodsDetail.gName}</span>
				</h6>
				<h6 class="card-text" id="gPrice">
					<span class="fw-bold">가격 :</span> ${goodsDetail.gPrice} 원
				</h6>
				<br>
				<h6 class="card-text">
					<span class="fw-bold ">주문 수량 :</span> <input type="text"
						name="gAmount" value="1" id="gAmount"> <img
						src="images/up.PNG" id="up"> <img src="images/down.PNG"
						id="down">

				</h6>
				<a href="#" class="btn btn-primary mt-3">구매</a>
				<button type="submit" class="btn btn-primary mt-3">장바구니</button>
			</div>

		</div>
	</form>
	</div>
</div>