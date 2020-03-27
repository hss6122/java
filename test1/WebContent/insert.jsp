<%@page import="DB.MemberDAO"%>
<%@page import="DB.MemberDTO"%>
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
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String email = request.getParameter("email");
	String adress = request.getParameter("adress");
	String tel = request.getParameter("tel");
	
	
	MemberDTO dto = new MemberDTO();
	dto.setName(name);
	dto.setId(id);
	dto.setPw(pw);
	dto.setEmail(email);
	dto.setAdress(adress);
	dto.setTel(tel);
	
	MemberDAO dao = new MemberDAO();
	dao.insert(dto);
	
	
	
	%>
	
	
	
	</body>
</html>