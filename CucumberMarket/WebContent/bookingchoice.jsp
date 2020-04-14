<%@page import="java.io.Console"%>
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

 <script type="text/javascript">
 function showPopup_T() {window.open("popup_T.jsp", "a", "width=400, height=300, left=100, top=50"); }
 function showPopup_F() {window.open("popup_F.jsp", "a", "width=400, height=300, left=100, top=50"); }
 </script>
<link rel="stylesheet" type="text/css" href="./css/shop.css">
</head>
<body>
	<div id="total">배경이미지
	
	</div>
	<%
	MemberDAO dao = new MemberDAO();
	ArrayList<String> list = dao.seatcheck();
	String seat = (String)list.get(0);
	String[] seatlist = seat.split("#");
	%>
	<table border="1">
	<tr>
	<%
	for(int i = 1 ; i < 6; i++){
		
		if(seatlist[i].equals("1")){
		%>
			<td><input type="submit" style="background-color: red" id="" onclick="showPopup_F();">
			 <%= i  %> <%= ": 번자리" %> 예약불가</td>
			 
			<% 
		}else{
			%>
			<td><input type="submit" style="background-color: green" id="" onclick="showPopup_T();">
			 <%= i %> <%= ": 번자리" %> 예약가능 </td>
			
			<%
			}
			}
			%>
	
	<tr>
	<%
	for(int i = 6 ; i < 11; i++){
		
		if(seatlist[i].equals("1")){
		%>
			<td><input type="submit" style="background-color: red" id="" onclick="showPopup_F();"> 
			<%= i  %> <%= ": 번자리" %> 예약불가</td>
			<% 
		}else{
			%>
			<td><input type="submit" style="background-color: green" id="" onclick="showPopup_T();">
			<%= i %> <%= ": 번자리" %> 예약가능 </td>
			<%
			}
			}
			%>
	
	<tr>
	<%
	for(int i = 11 ; i < 16; i++){
		
		if(seatlist[i].equals("1")){
		%>
			<td><input type="submit" style="background-color: red" id="" onclick="showPopup_F();">
			 <%= i  %> <%= ": 번자리" %> 예약불가</td>
			<% 
		}else{
			%>
			<td><input type="submit" style="background-color: green" id="" onclick="showPopup_T();">
			 <%= i %> <%= ": 번자리" %> 예약가능 </td>
			<%
			}
			}
			%>
		
	<tr>
	<%
	for(int i = 16 ; i < 21; i++){
		
		if(seatlist[i].equals("1")){
		%>
			<td><input type="submit" style="background-color: red" id="" onclick="showPopup_F();"> 
			<%= i  %> <%= ": 번자리" %> 예약불가</td>
			<% 
		}else{
			%>
			<td><input type="submit" style="background-color: green" id="" onclick="showPopup_T();"> 
			<%= i %> <%= ": 번자리" %> 예약가능 </td>
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