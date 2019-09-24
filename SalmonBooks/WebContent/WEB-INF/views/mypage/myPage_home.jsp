<%@page import="member.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Member member = (Member)request.getSession().getAttribute("member");
	int point = (int)request.getSession().getAttribute("point");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
   <link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/myPage.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    
</head>
<body>
    <div class="wrap">
    <form action="myPage.do" method="post">
        <div class="menu">
            <nav class="navbar navbar-expand-sm navbar-dark" style="background-color: #FF6F61;">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp" style="color: #fff">Salmon Books</a>
                    </li>
                </ul>
            </nav>
        </div><br>

        <div class="row" style="margin: 0px">
            <div class="col-sm-3" style="border: rgb(118, 118, 118)">
                <div class="container" style="font-size: 14px">
                    <div class="list-group-flush">
                        <a href="myPage.do" class="list-group-item list-group-item-action" id="tab">마이페이지 홈</a>
                        <a href="myPage_1.do" class="list-group-item list-group-item-action" id="tab2">회원정보 관리</a>
                        <a href="myPage_2.do" class="list-group-item list-group-item-action" id="tab3">구매 내역</a>
                        <a href="myPage_3.do" class="list-group-item list-group-item-action" id="tab4">내 컨텐츠</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-8" style="border: rgb(118, 118, 118)">
                <div class="content" id="home" >
                    <h4 style="margin-bottom:23px"><%=member.getName() %>님의 개인정보</h4>
                    <div class="container" style="padding: 10px; border: rgb(241, 238, 238) 1px solid; background-color: rgb(250, 250, 250);">
                        <div class="row">
                            <div class="col" style="border-right: rgb(241, 238, 238) 1px solid">
                                <h5 style="margin-left: 50px; padding: 10px"><%=member.getUserId() %></h5>
                                <span style="margin-left: 50px; padding-left: 10px"><%=member.getEmail() %></span><br>
                                <span style="margin-left: 50px; padding-left: 10px"><%=member.getTel() %></span>
                            </div>
                            <div class="col">
                                <h5 style="padding: 10px; text-align: center">포인트 </h5>
                                <label style="width: 100%; padding: 10px; text-align: center"><%=point %>point</label>
                            </div>
                        </div>
                    </div><br>
                </div>
            </div>
        </div>
        <div class="foot row">
            <div class="col" style="text-align: right"><a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">©SalmonisDelicious</a></div>
            <span style="color: rgb(230, 230, 230)">|</span>
            <div class="col" style="text-align: left;"><a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">고객센터</a></div>
        </div>
    </form>
    </div>
    
</body>
</html>