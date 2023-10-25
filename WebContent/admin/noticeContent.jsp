<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		padding-top : 160px;
	}
	#content_form{
		position : relative;
		width: 930px;
		height: 430px;
		margin: auto;
		border-radius : 15px;
		background-color: lightyellow;
		text-align : center;
		border: 4px solid #2AC1BC;
		margin-top : 35px;
		line-height: 30px;
		padding-top : 20px;
	}
	table td{
		text-align : center;
		width: 80%;
		color:white;
	}
	table tr:hover { 
		background-color: orange;
		cursor: pointer;
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
		padding-top:40px;
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
		width: 200px;
		height:30px;
		margin : 5px;
		color : white;
		border : 2px solid white;
		border-radius : 5px;
	}	
	a{
		text-decoration : none;	
		color: #2AC1BC;
	}
	caption{
		color: #2AC1BC;
		font-size : 1.4em;
		font-weight : bold;
	}
</style>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script>
		$(document).ready(function(){
			
		});
	</script>
</head>
<body>
	<div id="content_form">
		<table>
				<caption>${notice.nid}글 상세보기</caption>
				<tr><th>작성자</th><td>${nContent.aid} 님</td>	</tr>
				<tr><th>제목</th>	 <td>${nContent.ntitle }</td></tr>
				<tr><th>본문</th>	 <td><pre>${nContent.ncontent}</pre></td></tr>
				<tr><th>조회수</th><td>${nContent.nhit }</td></tr>
				<tr><th>IP</th><td>${nContent.nip }</td></tr>
			
			<tr>
				<td colspan="2">
				 	<button onclick="location='${conPath}/noticeModifyView.do?nid=${param.nid }&pageNum=${param.pageNum }'" class="btn">수정</button>
					<button onclick="location='${conPath}/noticeDelete.do?nid=${param.nid }&ngroup=${notice.ngroup }&nstep=${notice.nstep }&nindent=${notice.nindent }&pageNum=${param.pageNum }'" class="btn" >삭제</button>
				 	<button onclick="location='${conPath}/noticeList.do?pageNum=${param.pageNum }'" class="btn">목록</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>