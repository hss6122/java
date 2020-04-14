<%@page import="bean.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.PlaceMemberDTO"%>
<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자리예약하기 가능</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">

$(function() {
	
	$('#b3').click(function() {
	opener.location.href="bookingchoice.jsp";
	self.close();//닫기 함수 호출

	})//버튼 3
//---------------------------------------
	$('#b1').click(function() {
		
	})//버튼 1






})//메인 펑션
</script>
</head>
<body>


<input type="button" value="자리신청" id="b1"> 
<input type="button" value="창닫기" id="b3"> 

</body>
</html>