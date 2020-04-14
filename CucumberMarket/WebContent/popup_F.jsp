<%@page import="javafx.scene.control.Alert"%>
<%@page import="java.io.Console"%>
<%@page import="bean.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.PlaceMemberDTO"%>
<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약취소 가능</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">

$(function() {
	
	$('#b3').click(function() {
	opener.location.href="bookingchoice.jsp";
	self.close();//닫기 함수 호출

	})//버튼 3
//---------------------------------------
	$('#b1').click(function() {
		<%
		MemberDAO dao = new MemberDAO();
		ArrayList<String> list = dao.seatcheck();
		String seat = (String)list.get(0);
		String[] seatlist = seat.split("#");
		%>
		console.log(테스트중);
		<%
		for( int i = 1; i< 21; i++){
			if(seatlist[i].equals("1")){
				dao.update();
				
			%>
			<%
			}
			}
			%>
	})//버튼 1
})//메인 펑션
</script>
</head>
<body>


<input type="button" value="자리신청취소" id="b1"> 
<input type="button" value="창닫기" id="b3"> 

</body>
</html>