<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!--이페이지는 자바로 만들어진 것   -->
<!--tomcat에게 java로 지시 !: 지시자  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/*자바코드 넣는 부분  */
		//스크립트릿
		//1.클라이언트로 부터 온 데이터 받아야함.
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String company = request.getParameter("company");
		String tel = request.getParameter("tel");

		out.print("당신의 이름은 " + name + "<br>");
		out.print("당신의 나이는 " + age + "<br>");
		out.print("당신의 회사는 " + company + "<br>");
		out.print("당신의 번호는 " + tel + "<br>");
	%>
</body>
</html>