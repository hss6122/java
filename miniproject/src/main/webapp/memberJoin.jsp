<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("#alert-success").hide(); // 처음페이지는 경고글을 숨겨둔다.
		$("#alert-danger").hide(); // 처음페이지는 경고글을 숨겨둔다.
		$("#alert-successId").hide(); // 처음페이지는 경고글을 숨겨둔다.
		$("#alert-dangerId").hide();

		$("input").keyup(function() {
			var pwd1 = $("#pw1").val(); //비밀번호 기입 1 필드의 id 값을 가져온다.
			var pwd2 = $("#pw2").val();
			if (pwd1 != "" || pwd2 != "") { // 비밀번호 기입 1,2 필드의 같이 같을시
				if (pwd1 == pwd2) {
					$("#alert-success").show(); //화면을 보이게 설정
					$("#alert-danger").hide(); // 화면을 보이지 않게 숨겨줌
					$("#submit").removeAttr("disabled");
				} else {
					$("#alert-success").hide();
					$("#alert-danger").show();
					$("#submit").attr("disabled", "disabled");
				}
			}
		}); //키업

		$("#id").keyup(function() {
			$.ajax({
				url : "checkId.do",
				data : {
					id : $("#id").val()
				},
				success : function(result) {
					console.log(result)
					if (result == 1) {
						$("#alert-dangerId").show(); //화면을 보이게 설정
						$("#alert-successId").hide(); // 화면을 보이지 않게 숨겨줌
					} else {
						$("#alert-successId").show(); //화면을 보이게 설정
						$("#alert-dangerId").hide(); // 화면을 보이지 않게 숨겨줌

					}//else
				}//if
			})//ajax
		})// id중복검사 키업 

	});//메인
</script>
</head>
<body>
	<form action="Join2.do">
		아이디 입력 <input type="text" name="id" id="id"><br>
	<div class="alert alert-successId" id="alert-successId">아이디사용가능</div>
	<div class="alert alert-dangerId" id="alert-dangerId">아이디 중복</div>
		비밀번호 입력 <input type="password" name="pw" id="pw1"><br>
		
		비밀번호 확인<input type="password"  id="pw2"><br>
	<div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div>
	<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>
		
		이름 <input type="text" name="name"><br> 
		이메일 <input type="text" name="email"><br> 
		주소 <input type="text" name="adress"><br>
		<input type="submit" value="가입신청"><br>
	</form>


</body>
</html>