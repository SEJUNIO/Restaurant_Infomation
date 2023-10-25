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
		padding-top : 220px;
		}
		table{
			margin : 150px;
			padding : 3px;
		}
		#aid, #ntitle, #ncontent { 
		border: 1px solid #2AC1BC;
		width: 90%; padding: 3px;
		outline: 0;
		}	
		#content_form{
		position : relative;
		width: 1000px;
		height: 320px;
		margin: auto;
		border-radius : 15px;
		background-color: lightyellow;
		text-align : center;
		border: 4px solid #2AC1BC;
		padding-top:10px;
		margin-top : 35px;
		line-height: 30px;
		}
	table{
		color: white;
		font-size : 1.2em;
		font-weight : bold;
		margin: 10px auto;
		width:80%;
		padding-top:20px;
	}
	table td{
		text-align : center;
	}
	table td:last-child {
		background-color: lightyellow;
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
		width: 245px;
		height:40px;
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
		border : 1px solid white;
		padding-top:10px;
		font-size : 1.4em;
	}
</style>
</head>
<body>
	<div id="content_form">
		<form action="${conPath}/noticeWrite.do" method="post">
			<table>
				<caption>글쓰기</caption>
				<tr>
					<th>관리자</th><th><input type="text" name="aid" id="aid" value="${admin.aid}" 	required="required"></th>
				</tr>
				<tr>
					<th>제목</th><th><input type="text" name="ntitle" id="ntitle" 	required="required"></th>
				</tr>
				<tr>
					<th>본문</th><th><textarea name="ncontent" id="ncontent" rows="5"></textarea></th>
				</tr>

					<tr>
						<td colspan="2">
							<input type="submit" value="글쓰기" class="btn" >
							<input type="reset" value="취소" class="btn">
							<input type="button" value="목록" class="btn"
								onclick="location.href='${conPath}/noticeList.do'">
						</td>
					</tr>
			</table>
		</form>
	</div>
</body>
</html>