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
<link href="${conPath}/Restaurant_info.css" rel="stylesheet">
</head>
<body>
	<c:if test="${empty member }"> <!-- 로그인 후에만 글쓰기 가능 -->
		<script>
			location.href='${conPath}/adminLoginView.do?next=noticeModifyView.do';
		</script>
	</c:if>
	<div id="content_form">
		<form action="${conPath}/noticeModify.do" method="post">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<input type="hidden" name="nid" value="${notice.nid }">
			<table>
				<caption>${notice.nid}번 글 수정</caption>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="aid" required="required" value="${notice.aid}님" readonly="readonly"></td>
				</tr>
				
				<tr>
					<th>제목</th>
					<td><input type="text" name="ntitle" required="required" value="${notice.ntitle}"></td>
				</tr>	
				
				<tr>
					<th>본문</th>
					<th><textarea name="ncontent" id="ncontent" rows="5"></textarea></th>
				</tr>		
				
				<tr><td colspan="2">
						<input type="submit" value="수정" class="btn">
						<input type="reset" value="이전" class="btn" onclick="history.back()">
						<input type="button" value="목록"  class="btn"
							onclick="location='${conPath}/noticeList.do?pageNum=${param.pageNum }'">
					</td>
			</tr>
			</table>
		</form>
	</div>
</body>
</html>