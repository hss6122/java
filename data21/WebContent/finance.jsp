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
		//조금맣게 자버 코드의 일부부을 스크립트로 쓰면 됨.
		//스트립트 릿
		// 클라이언가 보낸 company 변수값을 받으면 된다.
		String comapny = request.getParameter("company");
		// 주식 정보를 db연동해서 찾음
		out.print(comapny+" 회사의 주가는 "+ 48000 +" 입니다");
	%>

</body>
</html>