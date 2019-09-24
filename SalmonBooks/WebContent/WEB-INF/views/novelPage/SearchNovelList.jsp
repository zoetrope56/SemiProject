<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="novel.vo.NovelInfo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>

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
	href="/SalmonBooks/resource/css/fontAni.css" />

<link rel="stylesheet" type="text/css"
	href="/SalmonBooks/resource/css/NovelList.css" />

<link rel="stylesheet" type="text/css"
	href="/SalmonBooks/resource/css/salmonbooks.css" />
<style type="text/css">
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
</style>

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
				<a href="FreeNovelList.do?FREE=TRUE&COMPLATE=FALSE">무료</a>
			</div>
			<div class="titleMenuIcon">
				<a href="PayNovelList.do?FREE=FALSE&COMPLATE=FALSE">유료</a>
			</div>
			<div class="titleMenuIcon"><a href="freeboard/list.do">커뮤니티</a></div>
		</div>
	</div>
	<div class="novelContainer">
		<div id="hotNovelDiv" height="10%"
			style="background: white; margin: 10px 0 0 0;">
			<h3 class="textani">
				<span>검</span><span>색</span>&nbsp<span>결</span><span>과</span>
		</div>
		<div class="hotnovelPanel">
			<ul class="hotNovelListUl">
				<c:forEach var="list" items="${list}">
				<c:set var = "pay" value = "${list.pay}"/>
					<div class="hotframe">
						<li><a href="selectOne.do?nno=${list.nno}"
							class="linkNovel">
								<div class="novel_pic">
									<img src="${list.img}">
								</div>
								<div class="novel_ingfo">
									<p class="subj">${list.ntitle}
									<c:choose>
									<c:when test="${pay eq 0}"> <span class="icon_up">무</span> </c:when>
									<c:otherwise> <span class="icon_up">유</span> </c:otherwise>
									</c:choose>
									</p>
									 <p class="author"><span class="authorName" >${list.nWriter}</span><span class="num_total">&nbsp총
                                        ${list.total}화 |<span style="color : #FF6F61"> ${list.pay}P</span></span></p>
									
								</div>
						</a></li>
					</div>
				</c:forEach>
			</ul>
		</div>
	</div>


</body>
</html>