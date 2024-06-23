<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jQuery webjar -->
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>

<style>
#center {
	text-align: center;
	margin: 0 auto;
	display: flex;
	justify-content: center;
	padding: 0 auto;
}
.errorMessage {
	color: red;
}
</style>


<script type="text/javascript">
	$(document).ready(function() {
		 $("#loginForm").on("submit", function(event) {
		        // 폼 제출을 일시 중지
		        event.preventDefault();

		        // 사용자에게 confirm 창을 띄우기
		        var confirmSubmit = confirm("환영합니다!");

		        // 사용자가 확인 클릭 시 화면 전환
		        if (confirmSubmit) {
		            $(this).off("submit").submit(); // 폼 제출
		            
		        }
		    });

		 /* // 로그인 서브밋
		 $("form").on("submit", function() {

			var errorMessage = '${errorMessage}';

			// 에러 메시지가 존재하면 alert 창으로 표시
			 if (errorMessage) {
				alert(errorMessage);
			}
		}); */

		// 취소
		$("#cancelButton").click(function() {
			window.location.href = "/shop/main"; // /main 페이지로 리다이렉트
		});// cancelButton

	});// ready()
</script>

<!-- 로그인 실패시 오류 메세지 띄우기 -->
<c:if test="${not empty sessionScope.errorMessage}">
	<div class="errorMessage">
		<p>${sessionScope.errorMessage}</p>
	</div>
	<% session.removeAttribute("errorMessage"); %>
</c:if>

<div class="container" id="center">
	<form action="auth" method="post" id="loginForm" class="row g-3 m-4">
		<div class="row mb-3" id="center">
			<div>${errorMessage }</div>
			<label for="userid" class="col-sm-2 col-form-label">아이디</label>
			<div class="col-auto">
				<input type="text" class="form-control" id="userid" name="userid">
			</div>
		</div>
		<div class="row mb-3" id="center">
			<label for="password" class="col-sm-2 col-form-label">비밀번호</label>
			<div class="col-auto">
				<input type="password" class="form-control" id="passwd"
					name="passwd">
			</div>
		</div>
		<div class="col-12">
			<button type="submit" class="btn btn-primary">로그인</button>
			<button type="reset" class="btn btn-primary" id="cancelButton">취소</button>
		</div>
	</form>
</div>
