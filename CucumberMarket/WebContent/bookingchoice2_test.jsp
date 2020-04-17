<%@page import="java.util.ArrayList"%>
<%@page import="bean.PlaceMemberDTO2_test"%>
<%@page import="bean.MemberDAO"%>
<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오프라인 장터 자리 예약.</title>

<link rel="stylesheet" type="text/css" href="css/shop.css">
<script type="text/javascript" src="js/jquery-3.4.1.js"></script> 
<script type="text/javascript">
 function showPopup_booking() {window.open("popup_booking.jsp", "a", "width=400, height=300, left=100, top=50"); }
 function showPopup_cancel() {window.open("popup_cancel.jsp", "a", "width=400, height=300, left=100, top=50"); }
</script>
</head>
<body>
	<div id="total">배경이미지</div>
	<%
	//MemberDAO dao = new MemberDAO();
	//ArrayList<PlaceMemberDTO2_test> list = dao.list();
	
	MemberDAO dao = new MemberDAO();
	ArrayList <PlaceMemberDTO2_test> list = dao.list1();
	 
	String id = "abc";
	%>
	
	<table border="1">
	<tr>
		<th width="100">자리넘버</th>
		<th width="150">id</th>
		<th width="100">예약가능여부</th>
	</tr>
	
	<%
	for(PlaceMemberDTO2_test dto2 : list){
	%>
	
	
	<tr>
	<td>
	<input type="button" style="background-color:yellow; "> 
	<%=dto2.getSeatnumber() %> : 번</td>
	
	<td>
	<input type="button" style="background-color:blue;">
	<%=dto2.getId()%> : 아이디 </td>
	
	<%
	if(dto2.getSeatnum().equals("1") ){
	%>
	
	<td><input type="button" style="background-color: red;">
	<%=dto2.getSeatnum() %> 예약불가</td>
	<% 
	}else{
	%>	
	<td><input type="button"style="background-color: green;">
	<%=dto2.getSeatnum() %>예약가능</td>
	</tr>	
		<%
		}
		}//for문
		%>
	</table>
	
	</body>
</html>