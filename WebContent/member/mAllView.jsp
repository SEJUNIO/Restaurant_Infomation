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
			font-size : 1.6em;
			font-weight : bold;
			margin: 10px auto;
			width:90%;
			padding-top:10px;
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
	<c:if test="${not empty adminLoginResult }">
		<script>
			alert('${adminLoginResult}');
		</script>
	</c:if>
	<c:if test="${not empty adminLoginErrorMsg }">
		<script>
			alert('${adminLoginErrorMsg}');
			history.back();
		</script>
	</c:if>
		<div id="content_form">
		<table>
			<tr><td onclick="location='${conPath}/main.do'">모든회원</td></tr>
		</table>
		
		<table>
			<tr>
				<th>이름</th><th>이메일</th><th>전화번호</th><th>생년월일</th><th>주소</th>
			</tr>
			<c:if test="${dto.size() eq 0 }">
				<tr><td colspan="5">해당 페이지 글이 없습니다</td></tr>
			</c:if>
				<c:forEach var="dto" items="${members}">
					<tr>			
							<td>${dto.mname}</td>
							<td>${dto.memail}</td>
							<td>${dto.mtel}</td>
							<td>${dto.mbirth}</td>
							<td>${dto.maddress}</td>
					</tr>					
				</c:forEach>
		</table>
			<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
			[ <a href="${conPath }/allView.do?pageNum=${startPage-1}">이전</a> ]
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
				[ <b>${i }</b> ]
			</c:if>
			<c:if test="${i != pageNum }">
				[ <a href="${conPath }/allView.do?pageNum=${i}">${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			[ <a href="${conPath }/allView.do?pageNum=${endPage+1}">다음</a> ]
		</c:if>
	</div>
	</div>
</body>
</html>