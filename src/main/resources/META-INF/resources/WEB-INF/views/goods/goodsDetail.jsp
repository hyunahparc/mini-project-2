<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">


	$(document).ready(function() {
		
		$("#up").on("click", function() {
			var gAmount = Number.parseInt( $("#gAmount").val());
			$("#gAmount").val(gAmount+1);
		});
		
		$("#down").on("click", function() {
			var gAmount = Number.parseInt( $("#gAmount").val());
			if(gAmount == 1) {
				$("#gAmount").val(1);
			} else {
				$("#gAmount").val(gAmount-1);
			}
		})
		
		// 카트 서브밋
		$("form").on("submit", function(){
			//alert("cartAdd submit");
			this.action="cartAdd";  // CartController - cartAdd의 맵핑값
			this.method="post";
		});
		
	});
	
</script>


<div class="container">
	<form class="row g-3 m-4">
	  <input type="hidden" name="gCode" value="${goodsDetail.gCode}">
	  <div class="row">    
		<div class="card" style="width:25rem;">
		  <img src="images/items/${goodsDetail.gImage}.png" class="card-img-top" alt="...">
		  <div class="card-body">
		    <h6 class="card-title">
		        <span class="fw-bold">제품코드:</span>  
		        ${goodsDetail.gCode}</h6>
		    <h6 class="card-text">
		      <span class="fw-bold ">상품명:</span>
		       ${goodsDetail.gName}</h6>
		    <h6 class="card-text">
		      <span class="fw-bold ">가격:</span>
		       ${goodsDetail.gPrice}</h6>
		     <h6 class="card-text">
			      <span class="fw-bold ">주문수량:</span>
			      <input type="text" name="gAmount" value="1" id="gAmount">
			      <img src="images/up.PNG" id="up"> 
			      <img src="images/down.PNG" id="down">
		     
		      </h6>
		    <a href="#" class="btn btn-primary mt-3">구매</a>
		    <button type="submit" class="btn btn-primary mt-3">장바구니</button>
		  </div>
		</div>
	   
	  </div>
	</form>
</div>