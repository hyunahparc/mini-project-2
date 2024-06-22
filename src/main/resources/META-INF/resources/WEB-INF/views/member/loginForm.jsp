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
</style>
<script type="text/javascript">


		$(document).ready(function() {
		<%-- 
		// 로그인 서브밋
		$("form").on("submit", function() {

		
	 var errorMessage = "<%=request.getAttribute("errorMessage")%>
	";
			console.log(errorMessage);
			// 에러 메시지가 존재하면 alert 창으로 표시
			if (errorMessage) {
				alert("메롱");
			}
			this.action = "login"; // LoginController의 맵핑값
			this.method = "post";
			
			
			<!-- JavaScript를 이용하여 실패 시 알림 표시 -->
			 // URL에 error 파라미터가 있으면 실패 메시지를 표시
			 if (window.location.href.indexOf("error") > -1) {
			 $('#alertMsg').show();
			 }
		});
 --%>

		// 취소
		$("#cancelButton").click(function() {
			window.location.href = "/shop/main"; // /main 페이지로 리다이렉트
		});// cancelButton
		
	});// ready()
</script>

<div class="container" id="center">
	<form action="auth" method="post" class="row g-3 m-4">
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
