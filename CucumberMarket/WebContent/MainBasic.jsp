<%@page import="java.util.ArrayList"%>
<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수분충전!!!아삭아삭한 오이마켓입니다.</title>
<link rel="stylesheet" href="css/basicstyle.css">
</head>
<body>

<% 
	String id = request.getParameter("id");
	
%>

<hr>
<table border="0" class='loginfixed'>
	<tr><% if(id == null){ %>
		<td><form action="LoginView.jsp">
		<input type="submit" value="로그인">
		</form></td> 
		<td>
		<form action="Member.jsp">
		<input type="submit" value="회원가입">
		</form>
		</td>
	</tr>


		<tr><% } 
		else { %>
		<td><form action="MyPage.jsp">
		<input type="submit" value="<%=id%>님">
		</form></td> 
		<td>
		<form action="#">
		<input type="submit" value="로그아웃">
		</form>
		</td>
	</tr>
		<% 
		} %>
</table>


<div class='center'><h1 style="font-size:50px;">오이 먹고 수분 충전 마켓</h1></div>



<hr>

<ul class="leftfixed" style="text-align:center">
<li>카테고리</li>
<li><a href="#" style="text-decoration:none" >가전</a></li>
<li><a href="#"  style="text-decoration:none">의류</a></li>
<li><a href="#"  style="text-decoration:none">의류</a></li>
<li><a href="#"  style="text-decoration:none">책</a></li>
<li><a href="#"  style="text-decoration:none">식품</a></li>
</ul>


<ul class='rightfixed' style="text-align:center">
<li><button id="sellgood" class="but">판매물건등록</button></li>
<li><button id="mygood" class="but">관심제품보기</button></li>
<li><button type="button" id="opmarket" class="but" onclick="location.href='bookingchoice.jsp'">
오프라인장터</button></li>

<li><button id="mypage" class="but">마이페이지</button></li>
<li><button id="aftercode" class="but">거래후기등록</button></li>
</ul>


<!--
css 조건 style="width:800px; margin:auto;" 가능
.layer{
 	width: 800px;
    margin: auto
}  -->

<div class='layer'>

<!-- 기능별 이용시 나타는 화면 구성하는 곳  -->
<!-- 이곳 기준으로 내용을 만들어주세요!  -->


</div><!-- 전체공간  -->


</body>
</html>