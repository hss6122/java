<%@page
	import="com.sun.org.apache.xpath.internal.axes.SelfIteratorNoPredicate"%>
<%@page import="javafx.scene.control.Alert"%>
<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약취소 가능</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function() {

		$('#b4').click(function() {
			opener.location.href = "bookingchoice2_test.jsp";
			self.close();//닫기 함수 호출
		})//버튼 3
		//---------------------------------------
		$("#b3").click(function() {
			idValue = $(this).attr('value')//id로 선언된 태그의 값을 가져올 수 있다.
			console.log(idValue)
			alert(idValue)
			$.ajax({
				url : "Cancel_db.jsp",
				data : {
					id : idValue
				},
				success : function(doc) {
					console.log("작동함")
				}

			})//ajax
		})//버튼 1
	})//메인 펑션
</script>
</head>
<body>

	<button type="button" id="b3" class="cancel" value="<%= request.getParameter("id")%>">예약취소</button>
	<!-- 					▲로그인세션으로 대체	 -->
	<input type="button" id="b4" value="닫기">

</body>
</html>