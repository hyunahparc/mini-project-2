<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- ${cartList} --%>
<head>
<script src="/resources/jquery/jquery-3.3.1.min.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		$("#gotomain").click(function() {
		        window.location.href = "/shop/main";	
		})
	});
</script>

<style>

#total {
	text-align: right;
}
</style>
</head>

<div class="Mall">
	<div class="container">
		<div>
			<table class="table">
				<thead>
					<tr>
						<th>no</th>
						<th colspan="2">상품</th>
						<th>가격</th>
						<th>수량</th>
						<th>합계</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="sum" value="0" />
					<c:forEach items="${orderList}" var="orderList" varStatus="status">

						<!-- 변수 선언하기 -->
						<c:set var="amount" value="${orderList.gAmount}" />
						<c:set var="sum"
							value="${orderList.goodsList[0].gPrice * amount + sum}" />
						<tr>
							<%-- <td><div class="checkBox">
									<input type="checkbox" name="chBox" class="chBox"
										data-cartNum="${orderList.num}" />
								</div></td> --%>
							<td>${status.index + 1}</td>
							<td><img
								src="images/items/${orderList.goodsList[0].gImage }.png"
								width="100" height="100"></td>
							<td>${orderList.goodsList[0].gName }</td>
							<td>${orderList.goodsList[0].gPrice }</td>
							<td>${orderList.gAmount}</td>
							<td>${orderList.goodsList[0].gPrice * amount }</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="4"></td>
						<td id="total" colspan="2"><b>총 결제 금액 : &nbsp; ${sum} 원</b></td>
					</tr>
				</tbody>

			</table>
		</div>
		<!-- <div type="button" class="btn btn-success m-5">전체삭제</div> -->
		<div class="delBtn">
			<button type="button" id="gotomain" class="btn btn-success m-5"">메인으로
				돌아가기</button>
		</div>
	</div>
</div>