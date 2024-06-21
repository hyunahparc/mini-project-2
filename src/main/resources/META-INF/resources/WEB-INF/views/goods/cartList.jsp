<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- ${cartList} --%>
<head>
<script src="/resources/jquery/jquery-3.3.1.min.js"></script>


<script type="text/javascript">
	$(document).ready(function() {

		// 체크박스 전체 선택 기능
		$("#allCheck").click(function() {
			var chk = $("#allCheck").prop("checked");
			if (chk) {
				$(".chBox").prop("checked", true);
			} else {
				$(".chBox").prop("checked", false);
			}
		});

		// 체크박스 개별 선택하면 전체 선택 박스 해제되는 코드
		$(".chBox").click(function() {
			$("#allCheck").prop("checked", false);
		});

		// 체크박스 선택 후 삭제 버튼 (개별 삭제 & 전체 삭제)
		$("#selectDelete_btn").click(function() {
			var confirm_val = confirm("선택하신 상품을 장바구니에서 삭제하시겠습니까?");

			if (confirm_val) {
				var checkArr = new Array();

				$("input[class='chBox']:checked").each(function() {
					checkArr.push($(this).attr("data-cartNum"));
				});

				var confirm_val = confirm("삭제되었습니다.");

				$.ajax({
					url : "/shop/deleteCart",
					type : "post",
					data : {
						chbox : checkArr
					},
					success : function() {
						location.href = "/shop/cartList";
					}
				});
			}
		});
		
		//선택한 상품만 주문할 페이지로 넘어가기
		$("#SelectionToOrder_btn").click(function() {
			
			var confirm_val = confirm("선택하신 상품을 주문하시겠습니까?");                                                                                              
			
			if (confirm_val) {
				var checkArr = new Array();

				$("input[class='chBox']:checked").each(function() {
					checkArr.push($(this).attr("data-cartNum"));
				});

//				var confirm_val = confirm("삭제되었습니다.");

				$.ajax({
					url : "/shop/orderList",
					type : "post",
					data : {
						chbox : checkArr
					},
					success : function() {
						location.href = "/shop/orderList";
					}
				});
			}
			
		});
		
		//장바구니 전체 주문하기
		$("#AllToOrder_btn").click(function() {
			
			var confirm_val = confirm("전체 상품을 주문하시겠습니까?");                                                                                              
			
			if (confirm_val) {
				var checkArr = new Array();

				$("input[class='chBox']").each(function() {
					checkArr.push($(this).attr("data-cartNum"));
				});
	
				$.ajax({
					url : "/shop/orderList",
					type : "post",
					data : {
						chbox : checkArr
					},
					success : function() {
						location.href = "/shop/orderList";
					}
					error: function(xhr, status, error) {
			                // 오류 처리
			        console.error("주문 요청 중 오류 발생:", error);
			                alert("주문을 처리하는 중 오류가 발생했습니다. 다시 시도해주세요.");
			            }
					
				});
			}
			
		});
		
	});
</script>
</head>

<div class="Mall">
	<div class="container">
		<div>
			<table class="table">
				<thead>
					<tr>
						<th><div class="allCheck">
								<input type="checkbox" name="allCheck" id="allCheck" /><label
									for="allCheck">전체 선택</label>
							</div></th>
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
					<c:forEach items="${cartList }" var="cartList" varStatus="status">

						<!-- 변수 선언하기 -->
						<c:set var="amount" value="${cartList.gAmount }" />
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
							<td>${cartList.gAmount }</td>
							<td>${cartList.goodsList[0].gPrice * amount }</td>
						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td colspan="3"><b>총 주문 금액 : &nbsp; ${sum} 원</b></td>
					</tr>
				</tbody>

			</table>
		</div>
		<!-- <div type="button" class="btn btn-success m-5">전체삭제</div> -->
		<div class="delBtn">
			<button type="button" id="selectDelete_btn"
				class="btn btn-success m-5"">선택 삭제</button>
			<button type="button" id="SelectionToOrder_btn"
				class="btn btn-success m-5"">선택상품주문</button>
			<button type="button" id="AllToOrder_btn" class="btn btn-success m-5"">전체상품주문</button>
		</div>
	</div>
</div>