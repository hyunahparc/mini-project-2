<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- ${cartList} --%>
<head>
<script src="/resources/jquery/jquery-3.3.1.min.js"></script>


<script type="text/javascript">
	$(document).ready(function() {

		});
</script>
</head>

<div class="Mall">
	<div class="container">
		<div>
			<table class="table">
				<thead>
					<tr>
<!-- 						<th><div class="allCheck">
								<input type="checkbox" name="allCheck" id="allCheck" /><label
									for="allCheck">전체 선택</label>
							</div></th>
						<th></th> -->
						<th>상품명</th>
						<th>가격</th>
						<th>수량</th>
						<th>합계</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:set var="sum" value="0" />
					<c:forEach items="${cartList }" var="cartList" varStatus="status">

						<!-- 변수 선언하기 -->
						<c:set var="amount" value="${cartList.gAmount}" />
						<c:set var="sum"
							value="${cartList.goodsList[0].gPrice * amount + sum}" />
						<tr>
							<td><div class="checkBox">
									<input type="checkbox" name="chBox" class="chBox"
									data-cartNum="${cartList.num}" />
								</div></td>
							<td><img
								src="images/items/${cartList.goodsList[0].gImage }.png"
								width="100" height="100"></td>
							<td>${cartList.goodsList[0].gName }</td>
							<td>${cartList.goodsList[0].gPrice }</td>
							<td>${cartList.gAmount}</td>
							<td>${cartList.goodsList[0].gPrice * amount }</td>
						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td colspan="3"><b>총 주문 금액 : &nbsp; ${sum } 원</b></td>
					</tr>
				</tbody>

			</table>
		</div>
		<!-- <div type="button" class="btn btn-success m-5">전체삭제</div> -->
		<div class="delBtn">
			<button type="button" id="" class="btn btn-success m-5"">주문 및 결제</button>
		</div>
	</div>
</div>