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
<link rel="stylesheet" type="text/css" href="../css/shop.css">
 <script type="text/javascript">
 function showPopup() {window.open("08_2_popup.html", "a", "width=400, height=300, left=100, top=50"); }
 </script>
</head>
	<body>
	
	
	<%
	MemberDAO dao = new MemberDAO();
	ArrayList<PlaceMemberDTO> list = dao.list();
	
	%>
	
	<table border="1">
	<tr>
	<td width="100">판매자 id</td> 
	<td width="100">자리.NO</td> 
	<td width="100">제목</td> 
	<td width="100">카테고리</td> 
	<td width="100">가격</td> 
	<td width="100">내용</td> 
	<td width="100">포토 준비중</td> 
	<td width="100">판매여부</td> 
	<td width="100">상품판매등록번호</td> 
	<td width="100">상품코드</td> 
	<td width="100">오프라인자리예약가능여부</td> 
	</tr>
	<%
	for(PlaceMemberDTO x : list){
	%>
	<tr>	
		<td><%= x.getId() %></td>
		<td><%= x.getSeatdayno() %></td>
		<td><%= x.getTitle() %></td>
		<td><%= x.getCategory() %></td>
		<td><%= x.getPrice() %></td>
		<td><%= x.getContents() %></td>
		<td><%= x.getPhoto() %></td>
		<td><%= x.getSale() %></td>
		<td><%= x.getItemnum() %></td>
		<td><%= x.getItemcode() %></td>
		<td>
		<a href="selection.jsp?id=<%= x.getSeatok() %>" onclick="showPopup();">
		
		<%= x.getSeatok() %>
		</a>
		</td>
	
	</tr>
	<% 
	}
	%>
	</table>
	</body>
</html>