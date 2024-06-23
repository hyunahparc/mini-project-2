<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- ${cartList} --%>
<head>
<script src="/resources/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						function sumPrice() {
							var totalPrice = 0;
							$("input.chBox:checked")
									.each(
											function() {
												var price = parseInt($(this)
														.closest("tr").find(
																".subtotal")
														.text());
												totalPrice += price;
											});

							$("td#totalPrice").text(totalPrice + "원"); // 총 결제할 금액을 표시하는 td 태그 업데이트
						}

						// 체크박스 전체 선택 기능
						$("#allCheck").click(function() {
							var chk = $("#allCheck").prop("checked");
							if (chk) {
								$(".chBox").prop("checked", true);
							} else {
								$(".chBox").prop("checked", false);
							}

							sumPrice(); // 전체 선택 후 가격 합계 업데이트
						});

						// 체크박스 개별 선택하면 전체 선택 박스 해제되는 코드
						$(".chBox").click(function() {
							$("#allCheck").prop("checked", false);
							sumPrice(); // 전체 선택 후 가격 합계 업데이트
						});

						// 체크박스 선택 후 삭제 버튼 (개별 삭제 & 전체 삭제)
						$("#selectDelete_btn")
								.click(
										function() {

											var checkArr = []; // 빈 배열로 초기화

											// 체크할 상품이 없는 경우
											if ($("input.chBox:checked").length === 0) {
												alert("삭제할 상품이 없습니다.");
												return; // 함수 종료
											}

											var confirm_val = confirm("선택하신 상품을 장바구니에서 삭제하시겠습니까?");
											if (confirm_val) {

												$(
														"input.chBox:checked")
														.each(
																function() {
																	checkArr
																			.push($(
																					this)
																					.attr(
																							"data-cartNum"));
																});

												var confirm_val = confirm("삭제되었습니다.");

												$
														.ajax({
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
						$("#orderAddSelected_btn")
								.click(
										function() {

											var checkArr = []; // 빈 배열로 초기화

											// 체크할 상품이 없는 경우
											if ($("input.chBox:checked").length === 0) {
												alert("주문할 상품이 없습니다.");
												return; // 함수 종료
											}

											var confirm_val = confirm("선택하신 상품을 주문하시겠습니까?");
											if (confirm_val) {

												$(
														"input.chBox:checked")
														.each(
																function() {
																	checkArr
																			.push($(
																					this)
																					.attr(
																							"data-cartNum"));
																});

												$
														.ajax({
															url : "/shop/orderAddSelected",
															type : "post",
															data : {
																chbox : checkArr
															},
															success : function() {
																alert("선택 상품 주문 완료 \n ♡＼(´▽ `)ノ♡ ");
																location.href = "/shop/orderList";
															}
														});
											}

										});
						
						
						 // 체크박스 전체 선택 기능 함수 정의
					    function checkAllBoxes(chk) {
					        if (chk) {
					            $(".chBox").prop("checked", true);
					        } else {
					            $(".chBox").prop("checked", false);
					        }
					        sumPrice(); // 전체 선택 후 가격 합계 업데이트
					        if (typeof callback === 'function') {

					        callback(); // 콜백 함수 호출
					        }
					    }
		

						
			            // 장바구니 전체 주문하기
			            $("#AllToOrder_btn").click(function() {
			                var checkArr = []; // 빈 배열로 초기화
			                // 체크할 상품이 없는 경우
			                if ($("input.chBox:checked").length === 0) {
			                    alert("주문할 상품이 없습니다.");
			                    return; // 함수 종료
			                }
			                checkAllBoxes(true); // 모든 체크박스 선택

			                // 모든 체크박스 선택 후 confirm 창 띄우기
			                setTimeout(function() {
			                    var confirm_val = confirm("전체 상품을 주문하시겠습니까?");
			                    if (confirm_val) {
			                        $("input.chBox:checked").each(function() {
			                            checkArr.push($(this).attr("data-cartNum"));
			                        });

			                        confirm("전체 상품 주문 완료 \n ♡＼(´▽ `)ノ♡");

			                        $.ajax({
			                            url: "/shop/orderAddById",
			                            type: "post",
			                            data: {
			                                chbox: checkArr
			                            },
			                            success: function() {
			                                location.href = "/shop/orderList";
			                            }
			                        });
			                    } else {
			                        // 사용자가 확인을 취소한 경우 체크박스 선택 취소
			                        checkAllBoxes(false);
			                    }
			                }, 100); // 약간의 시간 지연을 줘서 체크박스 선택이 먼저 반영되도록 함
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
						<%--<c:set var="sum"
							value="${cartList.goodsList[0].gPrice * amount + sum}" />
						 --%>
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
							<td class="subtotal">${cartList.goodsList[0].gPrice * amount }</td>
						</tr>


					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td colspan="2"><b>결제할 금액 : </b></td>
						<td id="totalPrice"></td>
					</tr>
				</tbody>

			</table>
		</div>
		<!-- <div type="button" class="btn btn-success m-5">전체삭제</div> -->
		<div class="delBtn">
			<button type="button" id="selectDelete_btn"
				class="btn btn-success m-5"">선택 삭제</button>
			<button type="button" id="orderAddSelected_btn"
				class="btn btn-success m-5"">선택상품주문</button>
			<button type="button" id="AllToOrder_btn" class="btn btn-success m-5"">전체상품주문</button>
		</div>
	</div>
</div>