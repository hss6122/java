<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
<%
// 세션값 가져오기
String id = (String) session.getAttribute("id"); // Object 타입이므로 다운캐스팅
%>
<h1>Main page</h1>
<%=id %> 님이 로그인하였습니다.
<input type="button" onclick="location.href='Logout2.jsp' " value="LogOut" />
</body>
</html>