<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="mypage.command.MyPageTab2Handler" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>myPage_userInfo</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/myPage.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
	.outer {
		width: 100%;
		height: 300px;
		background: white;
		color: black;
		margin-left: auto;
		margin-right: auto;
		margin-top: 30px;
	}
	
	table {
		border: 1px solid black;
		text-align: center;
	}
	
	.tableArea {
		width: 100%;
		height: 300x;
		margin-left: auto;
		margin-right: auto;
	}
</style>
</head>
<body>
    <div class="wrap">
    <form action="myPage_2.do" method="post">
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
                        <a href="myPage.do" class="list-group-item list-group-item-action" id="tab1">마이페이지 홈</a>
                        <a href="myPage_1.do" class="list-group-item list-group-item-action" id="tab2">회원정보 관리</a>
                        <a href="myPage_2.do" class="list-group-item list-group-item-action" id="tab3">구매 내역</a>
                        <a href="myPage_3.do" class="list-group-item list-group-item-action" id="tab4">내 컨텐츠</a>
                    </div>
                </div>
            </div>

            <div class="col-sm-8" style="border: rgb(118, 118, 118)">
                <div class="content" id="purchaseList">
                    <div class="container">
                        <h4>내 구매내역</h4><hr>
                        <span style="font-size: 14px;">고객님이 결제하신 내역입니다.</span>
                        <%@ include file="paymentList.jsp" %>
                        <%@ include file="usingpaymentList.jsp" %>
                    </div>
                    <div class="container">
                       
                        
                    </div>
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