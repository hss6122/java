<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
$(function() {
	$('#abc').click(function() {
		idValue = $(this).attr('id')
		console.log(idValue)
		idd = $('#hiden').val()
		
		$.ajax({
			url: "db1.jsp",
			data: {
			id : idValue
			},
			success: function(doc) {
				console.log("작동함")
			}
		})//ajax
	})//버튼1
})//메인


</script>
</head>
<body>
<!-- ajax를 통해 dto dao문 동작시키기 -->
<input type="text" id="hiden" value="0" style="display:none;" >
<input type="button" id="abc" class="id" value="abc">
<!-- id: #이용시 선택자   -->
</body>
</html>