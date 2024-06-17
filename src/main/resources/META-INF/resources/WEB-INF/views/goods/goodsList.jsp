<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- goodsList로 mainServlet의 request가 확장됨 -->
<!-- goodsList에서 키값을 이용해 ${goodList}를 쓸 수 있다 -->
	
<div class="container">
  <div class="row">
  	<c:forEach var="dto" items="${goodsList}">
	    <div class="col border border-dark m-4 w-80">
	      <a href="goodsDetail?gCode=${dto.gCode}"> 
			<img src="images/items/${dto.gImage}.png" width="200">
		  </a>
	       <div class="mt-4 fs-6">${dto.gName}</div>
	       <div class="mt-2 fs-6">${dto.gPrice}원</div>
	    </div>
    </c:forEach>
  </div>
</div>