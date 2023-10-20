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
		background-image: url(img/healthy-diet-background-with-thyme-leaf-border.jpg);
		background-size: cover;
		padding-top : 120px;
		}
		#content_form{
		position : relative;
		width: 500px;
		height: 580px;
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
		<form action="${conPath}/join.do" method="post">
			<div class="content_main">
			<table>
				<caption>회원가입</caption>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="mid" id="mid" required="required"></td>
				</tr>
			
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="mpw" id="mpw" required="required"></td>
				</tr>
			
				<tr>
					<th>이름</th>
					<td><input type="text" name="mname" id="mname" required="required"></td>
				</tr>
			
				<tr>
					<th>이메일</th>
					<td><input type="text" name="memail" id="memail" required="required"></td>
				</tr>
			
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="mtel" id="mtel"></td>
				</tr>
			
				<tr>
					<th>생년월일</th>
					<td><input type="date" name="mbirth" id="mbirth"></td>
				</tr>
			
				<tr>
					<th>주소</th>
					<td><input type="text" name="maddress" id="maddress"></td>
				</tr>
			
				<tr>
					<td colspan="2">
						<p>
							<input type="submit" value="회원가입" class="btn">
							<input type="button" value="로그인" onclick="location='${conPath}/loginView.do'" class="btn">
						</p>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
</body>
</html>