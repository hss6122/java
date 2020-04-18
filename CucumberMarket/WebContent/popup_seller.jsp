<%@page import="java.util.ArrayList"%>
<%@page import="bean.SellerMemberDTO"%>
<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자리예약하기 가능</title>
<jsp:useBean id="dto" class="bean.SellerMemberDTO"></jsp:useBean>
<jsp:setProperty property="id" name="dto" />

<%
	String id = request.getParameter("id");
	MemberDAO dao = new MemberDAO();
	SellerMemberDTO dto2 = dao.sellerselect(dto);
	//out.print(id);
%>



<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function() {
		$('#b4').click(function() {
			opener.location.href = "bookingchoice2_test.jsp";
			self.close();//닫기 함수 호출

		})//버튼 3
	})//메인 펑션
</script>
</head>
<body>
	<hr>

	<table border="1">
		<tr>
			<th width="50">사용자 id</th>
			<th width="50">제목</th>
			<th width="50">카테고리</th>
			<th width="50">가격</th>
			<th width="50">내용</th>
			<th width="50">사진</th>
			<th width="50">판매여부</th>
			<th width="50">상품넘버</th>
			<th width="50">상품코드</th>
		</tr>
		
		<tr>
			<td><%=dto2.getId() %></td>
			<td><%=dto2.getTitle() %></td>
			<td><%=dto2.getCategory() %></td>
			<td><%=dto2.getPrice() %></td>
			<td><%=dto2.getContents() %></td>
			<td><%=dto2.getPhoto() %></td>
			<td><%=dto2.getSale() %></td>
			<td><%=dto2.getItemnum() %></td>
			<td><%=dto2.getItemcode() %></td>
		</tr>
		


	</table>


	<input type="button" value="닫기" id="b4">
</body>
</html>