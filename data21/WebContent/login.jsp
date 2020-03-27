<%@page import="DB.MemberDTO"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.NEW"%>
<%@page import="DB.MemberDAO"%>
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
	/* 스트립트릿 */
	//request: 내장된 객체, 클라이언트 >> 웹서버
	// 		    클라이언트가 입력하여 전송한 데이터를
	//			웹서버가 받아주는 역할
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	
	MemberDTO dto = new MemberDTO();
	dto.setId(id);
	dto.setPw(pw);

	MemberDAO dao = new MemberDAO();
	int result = dao.idCheck(dto);
	if(result == 1 ){
		out.print("로그인 ok");
	}else{
		out.print("로그인 실패");
	}
	
	%>
	
	</body>
</html>