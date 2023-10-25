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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="${conPath}/js/fullpage.js"></script> <!--풀페이지 연동코드-->
<link rel="stylesheet" href="${conPath}/css/fullpage.css"> 
<link rel="stylesheet" href="${conPath}/css/배민.css"> 
</head>
<body>
	<c:if test="${not empty param.next && empty loginErrorMsg && empty modifyResult}">
		<script>
			location.href = '${conPath}/${param.next}';
		</script>
	</c:if>
	<c:if test="${not empty loginErrorMsg }">
		<script>
			alert('${loginErrorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty modifyResult }">
		<script>
			alert('${modifyResult}');
		</script>
	</c:if>
	<c:if test="${not empty modifyErrorMsg }">
		<script>
			alert('${modifyErrorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty withdrawalResult }">
		<script>
			alert('${withdrawalResult}');
		</script>
	</c:if>
	<div class="top-fixed"> 
		<div class="top"></div>
		<ul class="sns-list">
		
		<c:if test="${not empty member}"> <!-- 로그인전화면 --> <!-- 로그인후 회원이름 출력 -->
		<li>
			<a href="${conPath}/main.do">${member.mname}님</a>
		</li>
		</c:if>
		
		<c:if test="${empty member}"> <!-- 로그인전화면 -->
		<li>
			<a href="${conPath}/loginView.do">로그인</a>
		</li>
		</c:if>
		
		<c:if test="${not empty member}"> <!-- 로그인후화면 -->
		<li>
			<a href="${conPath}/modifyView.do">회원정보수정</a>
		</li>
		</c:if>
		
		<c:if test="${empty member}"> <!-- 회원가입전화면 -->
		<li>
			<a href="${conPath}/joinView.do">회원가입</a>
		</li>
		</c:if>
		
		<c:if test="${not empty member}"> <!-- 회원가입후화면 -->
		<li>
			<a href="${conPath}/noticeList.do">공지사항</a>
		</li>
		</c:if>
		
		<c:if test="${empty member}"> <!-- 회원가입전화면 -->
		<li>
			<a href="${conPath}/adminLoginView.do">관리자</a>
		</li>
		</c:if>
		
		<c:if test="${not empty member}"> <!-- 로그아웃화면 -->
		<li>
			<a href="logOut.do">로그아웃</a>
		</li>
		</c:if>
		
		</ul>
</div>

	<div id="fullpage">

	<section class="section">
	 <!-- first content -->
        <div class="header-content">
          <div class="header-text">
            <div class="container"><img src="${conPath}/img/main_text_03@2x.png" width="440" height="298" alt="가볍게 맛있게 먹고 싶을 때"></div>     
		</div>
	</div>
	</section>
	
	<!-- 그것이 무엇이든 다~있다-->
	<section class="section 2">
		<div class="content">
          <div class="cont-text">
            <h2 class="con-txt1-app-cont01-text">
			<img src="${conPath}/img/image.png" width="500" height="272" alt="그것이 무엇이든 다~ 있다"></h2>
          </div>
          <p class="cont-desc">
            3천만 이상이 선택한 배달의민족,<br>
            업계 최다 배달가능 업소 보유 중!
            <span class="sub-desc">(2017년 11월 기준)</span>
          </p>
          <div class="animation">
            <div class="road">
              <img src="${conPath}/img/img-road@2x.png" width="231" height="453" alt="배달이">
            </div>
            <div class="bike">
              <img src="${conPath}/img/img-bike@2x.png" width="200" height="228" alt="배달이">
            </div>
          </div>
        </div>
	</section>
	<!--찾아가던 맛집을 원하는 곳에서-->
	<section class="section 3">
		<h2></h2>
		<div class="content">
          <div class="cont-text">
            <h2 class="con-txt1-app-cont02-text"><img src="${conPath}/img/ctn02_text_03@2x.png" width="500" height="271" alt="찾아가던 맛집을 원하는 곳에서"></h2>
          </div>
          <p class="cont-desc">
            배달이 안되던 동네 맛집까지 ~ <br>
            배민라이더스가 직접 배달해드립니다.
			<br>
            <span class="sub-desc">서울 전지역, 경기 및 광역시 일부 지역에서 서비스 이용 가능!</span>
          </p>
          <div class="animation1"><img src="${conPath}/img/img-people@2x.png" width="400"  height="236" alt="사람들"></div>
        </div>    
	</section>
	<!-- 너에게 밥을 보낸다 배민 선물하기 -->
	<section class="section 4">
		<h2></h2>
		<div class="content">
          <div class="cont-text">
            <h2 class="con-txt1-app-cont03-text"><img src="${conPath}/img/ctn05_text_01@2x.png" width="500" height="271" alt="너에게 밥을 보낸다 배민선물하기"></h2>
          </div>
          <p class="cont-desc">
            지금 밥 한끼 보내주고 싶은 사람에게 선물해보세요.<br>
            선물 받은 상품권으로 배민에서 자유롭게 주문할 수 있습니다.
			<br>
            <span class="sub-desc">* 단, 전국별미, 사전예약 제외</span>
          </p>
          <div class="animation2"><img src="${conPath}/img/img-present@2x.png" width="360" height="400" alt=""></div>
        </div>
	</section>
      </div>   
<script>
 new fullpage("#fullpage", {
	 licenseKey: "",
	 sectionsColor:['#2AC1BC','#2AC1BC','#2AC1BC','#2AC1BC'], //배민색//
});
</script>
</body>
</html>