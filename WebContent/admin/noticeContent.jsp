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
	<link href="${conPath}/css/style.css" rel="stylesheet">
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
		color: #2AC1BC;
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
			<tr><td>작성자</td><td>${nContent.aid}님</td>	</tr>
			<tr><td>제목</td>	 <td>${nContent.ntitle }</td></tr>
			<tr><td>본문</td>	 <td><pre>${nContent.ncontent}</pre></td></tr>
			<tr><th>조회수</th><td>${nContent.nhit }</td></tr>
			
			<tr>
				<td colspan="2">
					<c:if test="${member.mid eq board.mid }">
				 		<button onclick="location='${conPath}/boardModifyView.do?fid=${board.fid }&pageNum=${param.pageNum }'">수정</button>
				 	</c:if>
				 	<c:if test="${member.mid eq board.mid or not empty admin}">
	 					<!-- 
				 		<button onclick="location='${conPath}/boardDelete.do?fid=${board.fid }&pageNum=${param.pageNum }'">삭제</button>
				 		-->
						<button onclick="location='${conPath}/boardDelete.do?fgroup=${board.fgroup }&fstep=${board.fstep }&findent=${board.findent }&pageNum=${param.pageNum }'">삭제</button>
			 		</c:if>
				 	<c:if test="${not empty member }">
				 		<button onclick="location='${conPath}/boardReplyView.do?fid=${board.fid }&pageNum=${param.pageNum }'">답변</button>
				 	</c:if>
				 	<button onclick="location='${conPath}/boardList.do?pageNum=${param.pageNum }'">목록</button>
		</table>
	</div>
</body>
</html>