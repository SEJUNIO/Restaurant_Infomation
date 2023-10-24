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
		background-image: url(img/an-overhead-view-of-cherry-tomatoes-mushroom-carrot-broccoli-garlic-and-bell-pepper-on-wooden-table-with-copy-space-for-writing-the-text.jpg);
		background-size: cover;
		padding-top : 120px;
		}
		#content_form{
		position : relative;
		width: 600px;
		height: 600px;
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
			color: white;
			font-size : 1.2em;
			font-weight : bold;
			margin: 10px auto;
			width:70%;
			padding-top:10px;
		}
		table td{
			text-align : center;
		}
		table tr { 
			background-color: #2AC1BC; 
			height: 40px;
			}
		table tr:hover { 
			background-color: orange;
			cursor: pointer;
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
		a{
		text-decoration : none;	
		color: #2AC1BC;
		}
</style>
</head>
<body>
	<div id="content_form">
		<form action="${conPath}/noticeWrite.do" method="post">
			<table>
				<tr>
					<td>관리자</td><td><input type="text" name="aid" value="${admin.aid}" 	required="required"></td>
				</tr>
				<tr>
					<td>제목</td><td><input type="text" name="ntitle" 	required="required"></td>
				</tr>
				<tr>
					<td>본문</td><td><textarea name="ncontent" rows="5"></textarea></td>
				</tr>

				<tr><td colspan="2">
							<input type="submit" value="글쓰기" class="btn" >
							<input type="reset" value="취소" class="btn">
							<input type="button" value="목록" class="btn"
								onclick="location.href='${conPath}/noticeList.do'">
			</table>
		</form>
	</div>
</body>
</html>