<%@page import="novel.service.NovelService"%>
<%@page import="novel.vo.NovelInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<% ArrayList<NovelInfo> ftop3list = null; 
   ArrayList<NovelInfo> ptop3list = null; 
   NovelService ns = new NovelService();
   ftop3list = ns.selectTop3List("TRUE", "FALSE");
   ptop3list = ns.selectTop3List("FALSE", "FALSE");
   
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/salmonbooks.css" />
    <link rel="stylesheet" type="text/css"
	href="/SalmonBooks/resource/css/fontAni.css" />
	<link rel="stylesheet" type="text/css"
	href="/SalmonBooks/resource/css/NovelList.css" />
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        window.onload = function () {
            var selection = document.getElementsByClassName('titleMenuIcon');
            console.log(selection);
            for (var i = 0; i < selection.length; i++) {
                var item = selection.item(i);
                item.addEventListener("click", function () {
                    clikedMenu();
                    this.style.borderBottom = '5px solid bisque';
                }, false);
            }
        }
        function clikedMenu() {
            var selection = document.getElementsByClassName('titleMenuIcon');
            console.log(selection);
            for (var i = 0; i < selection.length; i++) {
                var item = selection.item(i);
                item.style.borderBottom = 'none';
            }
        }
    </script>
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
            <div class="titleMenuIcon"><a style="border-bottom: 5px solid bisque;">홈</a></div>
            <div class="titleMenuIcon"><a href="FreeNovelList.do?FREE=TRUE&COMPLATE=FALSE">무료</a></div>
            <div class="titleMenuIcon"><a href="PayNovelList.do?FREE=FALSE&COMPLATE=FALSE">유료</a></div>
            <div class="titleMenuIcon"><a href="freeboard/list.do">커뮤니티</a></div>
        </div>
    </div>
    <div class="novelContainer">
        <div>
            <img class="advertisementImage" src="/SalmonBooks/resource/image/sample.png">
        </div>
    	<div id="hotNovelDiv" height="10%"
			style="background: white; margin: 10px 0 0 0;">
			<h3 class="textani">
				<span>무</span><span>료</span>&nbsp<span>베</span><span>스</span><span>트</span>&nbsp<span>소</span><span>설</span>
			</h3>
		</div>
        <div class="novelPanel">
            <ul class="hotNovelListUl">
            	<% for(NovelInfo n : ftop3list) { %>
					<div class="hotframe">
						<li>
                            <a href="selectOne.do?nno=<%=n.getNno()%>"class="linkNovel">
								<div class="novel_pic">
									<img src="<%=n.getImg()%>">
								</div>
								<div class="novel_ingfo">
									<p class="subj"><%=n.getNtitle()%>&nbsp<span class="icon_up" >무</span></p>
									
									<p class="author">
                                        <span class="authorName"><%=n.getnWriter()%></span>
                                        <span class="num_total">&nbsp총<%=n.getTotal() %>화</span>
									</p>
									<p class="rating">
										<%-- <span class="score_area"><span class="icon_star">별점</span>&nbsp;<span class="counter">${top3list.rate}</span></span> --%>
									</p>
                                </div>
                            </a>
                        </li>
					</div>
				<%} %>
			</ul>
        </div>
         <div class="novelContainer">

    	<div id="hotNovelDiv" height="10%"
			style="background: white; margin: 10px 0 0 0;">
			<h3 class="textani">
				<span>유</span><span>료</span>&nbsp<span>베</span><span>스</span><span>트</span>&nbsp<span>소</span><span>설</span>
			</h3>
		</div>
        <div class="novelPanel">
            <ul class="hotNovelListUl">
            	<% for(NovelInfo n : ptop3list) { %>
					<div class="hotframe">
						<li>
                            <a href="selectOne.do?nno=<%=n.getNno()%>" class="linkNovel">
								<div class="novel_pic">
									<img src="<%=n.getImg()%>">
								</div>
								<div class="novel_ingfo">
									<p class="subj"><%=n.getNtitle()%>&nbsp<span class="icon_up" >무</span></p>
									<p class="author">
                                        <span class="authorName"><%=n.getnWriter()%></span>
                                        <span class="num_total">&nbsp총<%=n.getTotal() %>화</span>
									</p>
									<p class="rating">
										<%-- <span class="score_area"><span class="icon_star">별점</span>&nbsp;<span class="counter">${top3list.rate}</span></span> --%>
									</p>
                                </div>
                            </a>
                        </li>
					</div>
				<%} %>
			</ul>
            <div style="border-top: 1px solid gray; height : 10%; width : 50%; padding :5% 0% 5% 40%; margin-left: auto; margin-right : auto; background: white;">
                <div style="text-align: center; display: inline;">
                    <a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">©SalmonisDelicious</a>
                </div>
                <span style="color: rgb(230, 230, 230); display: inline;">|</span>
                <div style="text-align: left; text-align: center;  display : inline;">
                    <a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">고객센터</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>