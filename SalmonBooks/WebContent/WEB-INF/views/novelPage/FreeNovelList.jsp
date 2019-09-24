<%@page import="sun.security.util.Length"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="novel.vo.NovelInfo"%>
<%@page import="novel.vo.PageInfo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<%
	PageInfo pi = (PageInfo) request.getAttribute("pi");

	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SalmonBooks</title>
<meta name="viewport"
	content="width=device-width, maximum-scale=1, minimum-scale=1, user-scalable=no" />
<meta name="format-detection" content="telephone=no">

<script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="/SalmonBooks/resource/css/addView.css" />
<link rel="stylesheet" type="text/css"
	href="/SalmonBooks/resource/css/fontAni.css" />
<link rel="stylesheet" type="text/css"
	href="/SalmonBooks/resource/css/hoverAugmentation.css" />
<link rel="stylesheet" type="text/css"
	href="/SalmonBooks/resource/css/NovelList.css" />

<link rel="stylesheet" type="text/css"
	href="/SalmonBooks/resource/css/salmonbooks.css" />
<style>
.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    right: 0;
    background-color: #f1f1f1;
    min-width: 120px;
    font-size: 13px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}
.dropdown-content a:hover {background-color: #ddd;}
.dropdown:hover .dropdown-content {display: block;}


.searchdiv {
	height: 40px;
	width: 220px !important;
	border: 1px solid #FF6F61;
	background: #ffffff;
	border: 1px solid #FF6F61;
}

.searchinput {
	font-size: 16px;
	width: 150px;
	padding: 10px;
	border: 0px;
	outline: none;
	float: left;
}

.searchbtn {
	width: 50px;
	height: 100%;
	border: 0px;
	background: #FF6F61;
	outline: none;
	float: right;
	color: #ffffff;
}

input::placeholder {
	color: gray;
	text-align: center;
}
</style>
<script type="text/javascript">
function textLengthOverCut(txt, len, lastTxt) {
    if (len == "" || len == null) { // 기본값
        len = 20;
    }
    if (lastTxt == "" || lastTxt == null) { // 기본값
        lastTxt = "...";
    }
    if (txt.length > len) {
        txt = txt.substr(0, len) + lastTxt;
    }
    return txt;
}
</script>

</head>
<body>
	<div class="titlebar">
		<div style="float: right;">
        
        <u:isLogin>
        <div class="dropdown">
                <a href="logout.do" style="text-decoration: none; color : white">Logout</a>
                <div class="dropdown-content">
                    <a href="myPage.do">마이페이지</a>
                    <a href="payment.do">결제샵</a>
                </div>
            </div>
        </u:isLogin>
        <u:notLogin>
        	<a href="login.do" style="text-decoration: none; color : white">Login</a>
        </u:notLogin>
        </div>
                <div class="titlelogo"><a href ="/SalmonBooks/">Salmon Books</a></div>
        <div class="titleMenu">
			<div class="titleMenuIcon">
				<a href="index.jsp">홈</a>
			</div>
			<div class="titleMenuIcon">
				<a href="FreeNovelList.do?FREE=TRUE&COMPLATE=FALSE"
					style="border-bottom: 5px solid bisque;">무료</a>
				<div class="a">
					<a href="freeGenreList.do?FREE=TRUE&COMPLATE=FALSE&GENRE=판타지">판타지</a>
				</div>
				<div class="a">
					<a href="freeGenreList.do?FREE=TRUE&COMPLATE=FALSE&GENRE=무협">무협</a>
				</div>
				<div class="a">
					<a href="freeGenreList.do?FREE=TRUE&COMPLATE=FALSE&GENRE=로맨스">로맨스</a>
				</div>

			</div>
			<div class="titleMenuIcon">
				<a href="PayNovelList.do?FREE=FALSE&COMPLATE=FALSE">유료</a>
			</div>
			<div class="titleMenuIcon">
				<div class="titleMenuIcon"><a href="freeboard/list.do">커뮤니티</a></div>
			</div>
		</div>
	</div>
	<div class="novelContainer">
		<div id="hotNovelDiv" height="10%"
			style="background: white; margin: 10px 0 0 0;">
			<h3 class="textani">
				<span>조</span><span>회</span><span>수</span>&nbsp<span>T</span><span>O</span><span>P</span><span>3</span>
			</h3>
		</div>
		<div class="hotnovelPanel">
			<ul class="hotNovelListUl">
				<c:forEach var="top3list" items="${top3list}">
					<div class="hotframe">
						<li><a href="selectOne.do?nno=${top3list.nno}"
							class="linkNovel">
								<div class="novel_pic">
									<img src="${top3list.img}">
								</div>
								<div class="novel_ingfo">
									<p class="subj">${top3list.ntitle}&nbsp<span class="icon_up" >무</span>
									</p>
									
									<p class="author">
										<span class="authorName">${top3list.nWriter}</span><span
											class="num_total">&nbsp총 ${top3list.total}화</span>
									</p>
									<p class="rating">
										<%-- <span class="score_area"><span
                                            class="icon_star">별점</span>&nbsp;<span class="counter">${top3list.rate}</span></span> --%>
									</p>
								</div>
						</a></li>
					</div>
				</c:forEach>
			</ul>
		</div>
	</div>

	<div class="novelContainer">
		<div id="uplNovelDiv" height="10%"
			style="background: white; margin: 10px 0 0 0;">
			<h3 class="textani">
				<span>업</span><span>로</span><span>드</span><span>된</span>&nbsp</span><span>무</span><span>료</span>&nbsp<span>웹</span><span>소</span><span>설</span>
			</h3>
		</div>
		<form class="searchdiv" style="float: right;" action="<%=request.getContextPath()%>/novelsearch.do">
			<input class="searchinput" type="text" placeholder="작가/작품" name="keyword">
			<input class="searchbtn" type="submit" value="검색"/>
		</form>
		<div id="uplnovelPanel" class="main">
			<ul class="uplNovelLists">
				<c:forEach var="list" items="${list}">
				<c:set var="ntitle" value="${list.ntitle}"/>
				<c:set var="ntitlelen" value="${fn:length(ntitle)}"/>
					<div class="uplNovelLists__item uplnovelPanel">
						<li><a href="selectOne.do?nno=${list.nno}" class="linkNovel">

								<div class="novel_pic">
									<img src="${list.img}">
								</div>
								<div class="novel_info">
								
									<p class="subj">
									
									<c:choose>
								    <c:when test="${10 lt ntitlelen}">
								       	${fn:substring(ntitle, 0, 10)}...
								    </c:when>
								
								
								
								    <c:otherwise>
								        ${ntitle}
								    </c:otherwise>
								
								
								</c:choose>

									<span class="icon_up" >무</span>
									</p>
									<p class="author">
										<span class="authorName">${list.nWriter}</span><span
											class="num_total">&nbsp총 ${list.total}화</span>
									</p><br>
									<p class="rating">
										<%-- <span class="score_area"><span
                                            class="icon_star">별점</span>&nbsp;<span class="counter">${top3list.rate}</span></span> --%>
									</p>
								</div>
						</a></li>
					</div>
				</c:forEach>
			</ul>


			<div class="pbtnlist">
				<%-- 페이지 처리 --%>
				<div class="pagingArea" align="center">
					<button
						onclick="location.href='<%=request.getContextPath()%>/FreeNovelList.do?currentPage=1&FREE=TRUE&COMPLATE=FALSE'"><<</button>
					<%
						if (currentPage <= 1) {
					%>
					<button disabled><</button>
					<%
						} else {
					%>
					<button
						onclick="location.href='<%=request.getContextPath()%>/FreeNovelList.do?currentPage=<%=currentPage - 1%>&FREE=TRUE&COMPLATE=FALSE'"><</button>
					<%
						}
					%>

					<%
						for (int p = startPage; p <= endPage; p++) {
							if (p == currentPage) {
					%>
					<button disabled><%=p%></button>
					<%
						} else {
					%>
					<button
						onclick="location.href='<%=request.getContextPath()%>/FreeNovelList.do?currentPage=<%=p%>&FREE=TRUE&COMPLATE=FALSE'"><%=p%></button>
					<%
						}
					%>
					<%
						}
					%>

					<%
						if (currentPage >= maxPage) {
					%>
					<button disabled>></button>
					<%
						} else {
					%>
					<button
						onclick="location.href='<%=request.getContextPath()%>/FreeNovelList.do?currentPage=<%=currentPage + 1%>&FREE=TRUE&COMPLATE=FALSE'">></button>
					<%
						}
					%>
					<button
						onclick="location.href='<%=request.getContextPath()%>/FreeNovelList.do?currentPage=<%=maxPage%>&FREE=TRUE&COMPLATE=FALSE'">>></button>



				</div>
				
			</div>


		</div>


		<div id="js-btn-wrap" class="btn-wrap">
			<a href="javascript:;" class="button">더보기</a>
		</div>


	</div>
	<!--  container end-->



	<!-- 더보기 script -->
	<script>
		$(window).on('load', function() {
			var current =
	<%=currentPage%>
		;
			if (current == 1) {
				load('#uplnovelPanel', '3');
				$("#js-btn-wrap .button").on("click", function() {
					load('#uplnovelPanel', '3', '#js-btn-wrap');
				})
			} else {
				load('#uplnovelPanel', '9');
			}

		});

		function load(id, cnt, btn) {
			var novels_list = id + " .uplnovelPanel:not(.active)";
			var novels_length = $(novels_list).length;
			var novels_total_cnt;
			if (cnt < novels_length) {
				novels_total_cnt = cnt;
			} else {
				novels_total_cnt = novels_length;
				$('.button').hide()
				$('.pbtnlist').show()
				$('.pbtnlist').css('margin-bottom', '50px');
			}
			$(novels_list + ":lt(" + novels_total_cnt + ")").addClass("active");
		}
		
		

	</script>


</body>
</html>