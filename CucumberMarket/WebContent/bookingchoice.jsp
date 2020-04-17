<%@page import="javafx.scene.control.Alert"%>
<%@page import="bean.PlaceMemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.MemberDAO"%>
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
	MemberDAO dao = new MemberDAO();
	ArrayList<String> list = dao.seatcheck();
	String seat = (String)list.get(0);
	String[] seatlist = seat.split("#");
	//out.print(seatlist[1]);
	//out.print(seatlist);// 주소값 타입으로 저장되어 있음
	
	String id = "abc";
	%>
	<table border="1">
	<tr>
	<%
	for(int i = 1 ; i < 6; i++){
		
		if(seatlist[i].equals("1")){// 첫번째 조건 장터 자리 예약 유무 확인
		%>
		<td><input type="button" style="background-color: green;" >
	    <%= i  %> <%= ": 번자리" %> 예약가능</td>
		<% 
		}else{
		%>	
		<% 
		if(seatlist[i].equals(id)){ // 두번째 조건 > 예약한 사용자의 예약 취소조건
		%>
		<td><input type="button" style="background-color: yellow;" onclick="showPopup_cancel()">예약취소하기 </td>		
		<% 
		}
		else{
		%>	
		<td><input type="button" style="background-color: red;" >
		<%= i %> <%= ": 번자리" %> 예약불가 </td>
			
			<%
			}
			}
			}
			%>
	
	<tr>
	<%
	for(int i = 6 ; i < 11; i++){
		
		if(seatlist[i].equals("1")){
		%>
			<td><input type="button" style="background-color: green;"> 
			<%= i  %> <%= ": 번자리" %> 예약가능</td>
			<% 
		}else{
			%>
			<td><input type="button" style="background-color: red; ">
			<%= i %> <%= ": 번자리" %> 예약불가 </td>
			<%
			}
			}
			%>
	
	<tr>
	<%
	for(int i = 11 ; i < 16; i++){
		
		if(seatlist[i].equals("1")){
		%>
			<td><input type="button" style="background-color: green;" >
			 <%= i  %> <%= ": 번자리" %> 예약가능</td>
			<% 
		}else{
			%>
			<td><input type="button" style="background-color: red" >
			 <%= i %> <%= ": 번자리" %> 예약불가 </td>
			<%
			}
			}
			%>
		
	<tr>
	<%
	for(int i = 16 ; i < 21; i++){
		
		if(seatlist[i].equals("1")){
		%>
			<td><input type="button" style="background-color: green;" > 
			<%= i  %> <%= ": 번자리" %> 예약가능</td>
			<% 
		}else{
			%>
			<td><input type="button" style="background-color: red;" > 
			<%= i %> <%= ": 번자리" %> 예약불가 </td>
			<%
			}
			}
			%>
	</tr>
	</table>
	첫번쨰자리 <%= seatlist[1] %>
	세번쨰자리 <%= seatlist[3] %>
	
	</body>
</html>