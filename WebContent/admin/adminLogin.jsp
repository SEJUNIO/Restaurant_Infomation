<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
		<style>
		body{
		background-image: url(img/delicious-black-pasta-dish-copy-space.jpg);
		background-size: cover;
		padding-top : 270px;
		}
		#content_form{
		position : relative;
		width: 430px;
		height: 280px;
		margin: auto;
		border-radius : 15px;
		background-color: white;
		text-align : center;
		border: 4px solid #2AC1BC;
		margin-top : 35px;
		line-height: 30px;
		}
		.content_main{
			width : 330px;
			height: 450px;
			margin : auto;
			margin-top: 70px;	
			margin-left: 90px;	
		}
		table{
			color: #2AC1BC;
			font-size : 1.6em;
			font-weight : bold;
		}
		.btn{
		background-color : #2AC1BC;
		width: 240px;
		height:30px;
		margin : 5px;
		color : white;
		border : 1px solid white;
		border-radius : 5px;
		}	
		#mid, #mpw, #mname, #memail, #mtel, #mbirth, #maddress { 
		border: 1px solid #2AC1BC;
		width: 90%; padding: 3px;
		outline: 0;
}
</style>
</head>
<body>
	<div id="content_form">
		<form action="${conPath}/adminLogin.do" method="post">
		<div class="content_main">
			<table>
				<caption>관리자 로그인모드</caption>
				<tr>
					<th>ID</th>
					<td><input type="text" name="aid" required="required" autofocus="autofocus"></td>
				</tr>
				
				<tr>
					<th>PW</th>
					<td><input type="password" name="apw" required="required"></td>
				</tr>
				
				<tr>
					<td colspan="2">
							<input type="submit" value="로그인" class="btn">
					</td>
				</tr>
			</table>
		</div>
		</form>
	</div>
</body>
</html>