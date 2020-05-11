<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<h2>가입성공</h2>
당신의 id :${memberDTO.id}<br>
당신의 pw :${memberDTO.pw} <br>
당신의 name :${memberDTO.name}<br>
당신의 tel:${memberDTO.email}<br>
당신의 tel:${memberDTO.adress}<br>
<button type="button" onclick="location.href='Login.jsp' ">로그인하러가기</button>
</body>
</html>