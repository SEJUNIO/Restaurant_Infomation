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
		width: 1200px;
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
		color: white;
		}
</style>
</head>
<body>
	<form action="${conPath}/boardList.do" method="post">
	<table>
		<tr><td onclick="location='${conPath}/writeView.do'">글쓰기</td></tr>	
	</table>
	
	<table>
		<tr>
			<th>글번호</th><th>writer</th><th>글제목</th><th>글본문</th>
			<th>조회수</th><th>IP</th><th>작성시점</th>
		</tr>
				<c:if test="${boardList.size() eq 0 }">
					<tr><td colspan="8">해당 페이지 글이 없습니다.</td></tr>
				</c:if>
				<c:forEach var="dto" items="${boardList}">
					<tr>
						<td>${dto.bid}</td>
						<td>${dto.mid}</td>
						<td>${dto.btitle}</td>
						<td>${dto.bcontent}</td>
						<td>${dto.bhit}</td>
						<td>${dto.bip}</td>
						<td>${dto.brdate}</td>
				</c:forEach>
	</table>
</form>
</body>
</html>