<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
	<%
	//1.클라이언트로 부터 온 데이터 받아야함.
	String good =request.getParameter("good");
	String bad =request.getParameter("bad");
	
	out.print("당신이 좋아하는 음식 "+good+"<br>");
	out.print("당신이 좋아하는 음식 "+bad+"<br>");
	
	%>
	</body>
</html>