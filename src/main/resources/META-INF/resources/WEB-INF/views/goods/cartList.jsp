<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- ${cartList} --%>

<script type="text/javascript">
	$(document).ready(function() {
	
		// 장바구니 상품 개별 삭제하기
		$("form").on("submit", function(){
			alert("cartDelete submit");
			this.action="deleteByNum";  // CartController - cartAdd의 맵핑값
			this.method="post";
		});
		
	});
</script>


<div class="TodoApp">
	<div class="container">
		<form class="row g-3 m-4">
		<div>
			<table class="table">
				<thead>
					<tr>
						<th><input type="checkbox" name="allCheck" id="allCheck">&nbsp;전체&nbsp;선택</th>
						<th></th>
						<th>이름</th>
						<th>가격</th>
						<th>수량</th>
						<th>합계</th>
						<th></th>
					</tr>
				</thead>
				<tbody>

					<c:set var="sum" value="0" />
					<c:forEach var="dto" items="${cartList }" varStatus="status">

						<!-- 변수 선언하기 -->
						<c:set var="amount" value="${dto.gAmount }" />
						<c:set var="sum" value="${dto.goodsList[0].gPrice * amount + sum}" />
						<tr>
							<td><input type="checkbox" name="check" class="check"></td>
							<%-- <td>${dto.num }</td> --%>
							<td><img src="images/items/${dto.goodsList[0].gImage }.png"
								width="100" height="100"></td>
							<td>${dto.goodsList[0].gName }</td>
							<td>${dto.goodsList[0].gPrice }</td>
							<td>${dto.gAmount }</td>
							<td>${dto.goodsList[0].gPrice * amount }</td>
							<!-- <td><a href="#" class="btn btn-warning">Delete</a></td> -->
							<td><button type="submit" class="btn btn-primary mt-3">Delete</button></td>
							
						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td colspan="3">총 주문금액 : &nbsp; ${sum } 원</td>
					</tr>
				</tbody>

			</table>
		</div>
		<div class="btn btn-success m-5">전체삭제</div>
		<div class="btn btn-success m-5">선택삭제</div>
		</form>
	</div>
</div>