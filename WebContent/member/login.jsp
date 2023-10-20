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
		background-image: url(img/ingredients-for-cooking-on-a-gray-concrete.jpg);
		background-size: cover;
		padding-top : 200px;
		}
		#content_form{
		position : relative;
		width: 400px;
		height: 360px;
		margin: auto;
		border-radius : 15px;
		background-color: white;
		text-align : center;
		border: 4px solid #2AC1BC;
		margin-top : 35px;
		line-height: 30px;
		}
		.content_main{
			width : 230px;
			height: 250px;
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
		#mid, #mpw { 
		border: 1px solid #2AC1BC;
		width: 90%; padding: 3px;
		outline: 0;
}
</style>
</head>
<body>
	<c:if test="${not empty joinResult }">
		<script>
			alert('${joinResult}');
		</script>
	</c:if>
	
	<c:if test="${not empty joinErrorMsg }">
		<script>
			alert('${joinErrorMsg}');
			history.back();
		</script>
	</c:if>
	<div id="content_form">
		<form action="login.do" method="post">
		<input type="hidden" name="next" value="${param.next }">
			<div class="content_main">
			<table>
				<caption>로그인</caption>
				<tr>
					<th>ID</th>
					<td class="box"><input type="text" name="mid" id="mid" value="${mid}" required="required"></td>
				</tr>
				
				<tr>
					<th>PW</th>
					<td class="box"><input type="password" name="mpw" id="mpw" value="${mpw}" required="required"></td>
				</tr>
				
				<tr>
				<td colspan="2">
					<p>
						<input type="submit" value="로그인" class="btn">
						<input type="button" value="회원가입" onclick="location='${conPath}/joinView.do'" class="btn">
					</p>
				</td>
				</tr>
			</table>
		</div>
		</form>
	</div>
</body>
</html>