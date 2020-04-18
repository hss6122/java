<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--jsp 동적인   -->
<!--1. 넘어 오는 값 받기  -->

<!--2. dto객체 만들어서 set메소드로 값 넣기  -->
<!--다른 패키지에 있는 클래스를 import해서 객체 생성 ,
	생성된 객체의 이름은 dto
 -->
<jsp:useBean id="dto" class="bean.PlaceMemberDTO2_test"></jsp:useBean>

<!-- 넘어오는 값 다 받아서 객체의 이름으로 지정된 dto의 메소드중 
	넘어오는 파라메터 이름이 동일하면 해당 set메소드를 불러서
	dto에 넣음.
  -->
<jsp:setProperty property="*" name="dto"/>

<!--3. dao객체 만들어서 insert()호출  -->
<%
String id = request.getParameter("id");
dto.setId(id);
MemberDAO dao = new MemberDAO();
dao.booking(dto);
%>
sql문 전송함.