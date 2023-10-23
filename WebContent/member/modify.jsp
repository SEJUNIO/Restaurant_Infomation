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
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<style>
		body{
		background-image: url(img/herb-fried-chicken-on-a-white-plate.jpg);
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
		<form action="${conPath}/modify.do" method="post">
			<div class="content_main">
			<table>
				<caption>정보수정</caption>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="mid" id="mid" value="${member.mid }" required="required"></td>
				</tr>
			
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="mpw" id="mpw" required="required"></td>
				</tr>
			
				<tr>
					<th>이름</th>
					<td><input type="text" name="mname" id="mname" value="${member.mname }" required="required"></td>
				</tr>
			
				<tr>
					<th>이메일</th>
					<td><input type="text" name="memail" id="memail" value="${member.memail }" required="required"></td>
				</tr>
			
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="mtel" id="mtel" value="${member.mtel }"></td>
				</tr>
			
				<tr>
					<th>생년월일</th>
					<td><input type="date" name="mbirth" id="mbirth" value="${member.mbirth }"></td>
				</tr>
			
				<tr>
					<th>주소</th>
					<td><input type="text" name="maddress" id="maddress" value="${member.maddress }"></td>
				</tr>
			
				<tr>
					<td colspan="2">
						<p>
							<input type="submit" value="정보수정" class="btn">
							<input type="button" value="초기화" onclick="location='${conPath}/loginView.do'" class="btn">
							<input type="reset" value="이전" onclick="history.back()" class="btn">
							<input type="button" value="회원탈퇴" class="btn"	onclick="location.href='${conPath}/withdrawal.do'">
						</p>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>
</body>
</html>