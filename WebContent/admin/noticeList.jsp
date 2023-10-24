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
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
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
		background-color: lightyellow;
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
	<script>
		$(document).ready(function(){
			$('tr').click(function(){
				var nid = $(this).children().eq(0).text().trim();
				if(! isNaN(Number(nid))){
					location.href = '${conPath }/noticeContent.do?pageNum=${pageNum}&nid='+nid;
				}
			});
		});
	</script>
</head>
<body>
		<div id="content_form">
	<form action="${conPath}/noticeList.do" method="post">
	<table>
		<tr><td>공지사항</td></tr>	
	</table>

	<table>
		<tr>
			<th>글번호</th><th>관리자</th><th>글제목</th><th>글본문</th>
			<th>조회수</th><th>IP</th><th>작성시점</th>
		</tr>
				<c:if test="${noticeList.size() eq 0 }">
					<tr><td colspan="8">해당 페이지 글이 없습니다.</td></tr>
				</c:if>
				<c:forEach var="notice" items="${noticeList}">
					<tr>
						<td>${notice.nid}</td>
						<td>${notice.aid}</td>
						<td>${notice.ntitle}</td>
						<td>${notice.ncontent}</td>
						<td>${notice.nhit}</td>
						<td>${notice.nip}</td>
						<td>${notice.nrdate}</td>
				</c:forEach>
	</table>
	<div class="paging">
			<c:if test="${startPage > BLOCKSIZE }">
				[ <a href="${conPath }/noticeList.do?pageNum=${startPage-1}"> 이전 </a> ]
			</c:if>
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<c:if test="${i == pageNum }">
					<b> [ ${i } ] </b>
				</c:if>
				<c:if test="${i != pageNum }">
					[ <a href="${conPath }/noticeList.do?pageNum=${i}"> ${i } </a> ]
				</c:if>
			</c:forEach>
			<c:if test="${endPage<pageCnt }">
			  [ <a href="${conPath }/noticeList.do?pageNum=${endPage+1}"> 다음 </a> ]
			</c:if>
		</div>
</form>
</div>
</body>
</html>