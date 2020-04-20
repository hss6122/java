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
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	function showPopup_booking(ca) {
		window.open("popup_booking.jsp?id=" + ca, "a",
				"width=10, height=5, left=100, top=50");
	}
	function showPopup_cancel(ca) {
		window.open("popup_cancel.jsp?id=" + ca, "a",
				"width=10, height=5, left=100, top=50");
	}

	function showPopup_seller(ca) {
		window.open("popup_seller.jsp?id=" + ca, "a",
				"width=700, height=400, left=100, top=50");
	}
</script>
<link rel="stylesheet" type="text/css" href="css/shop.css">
</head>
	<body>
	<div id="total"></div>
	<br>
	<br>
	<div >
		<%
			MemberDAO dao = new MemberDAO();
			ArrayList<PlaceMemberDTO2_test> list = dao.list1();
		%>
		<table border="1">
			<tr>
				<th width="100">자리넘버</th>
				<th width="150">id</th>
				<th width="150">예약가능여부</th>
			</tr>
			<%
				for (PlaceMemberDTO2_test dto2 : list) {
			%>
			<tr>
				<td><input type="hidden" style="background-color: yellow;">
					<%=dto2.getSeatnumber()%> : 번</td>

				<td><input type="submit" value="상품보기"
					style="background-color: blue;"
					onclick="showPopup_seller('<%=dto2.getId()%>')"><%=dto2.getId()%>
					": 님"</td>

				<%
					if (dto2.getSeatnum().equals("1")) {
				%>
				<td><input type="button" style="background-color: red;"
					name="<%=dto2.getId()%>" value="<%=dto2.getId()%>"
					onclick="showPopup_cancel('<%=dto2.getId()%>')"> <%=dto2.getSeatnum()%>
					예약불가</td>
				<%
					} else {
				%>
				<td><input type="button" style="background-color: green;"
					name="<%=dto2.getId()%>" value="<%=dto2.getId()%>"
					onclick="showPopup_booking('<%=dto2.getId()%>')"> <%=dto2.getSeatnum()%>예약가능</td>
			</tr>
			<%
				}
				} //for문
			%>
		</table>
	</div>
</body>
</html>