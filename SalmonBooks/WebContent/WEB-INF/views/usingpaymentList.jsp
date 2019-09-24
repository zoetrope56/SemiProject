<%@page import="usingpayment.model.vo.*"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% ArrayList<UsingPayment> list = (ArrayList<UsingPayment>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>소설 구매 내역</title>
    <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/SalmonBooks/resource/css/salmonbooks.css" />
<link rel="stylesheet" type="text/css"
	href="/SalmonBooks/resource/css/myPage.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
        body{
        background :rgb(241, 238, 238);
        height: 100vh;
        width: 100%;
        margin: 0;
        }
        .wrap {
            width: 960px;
            height: 100vh;
            min-width: 360px;
            margin:0 auto 0;
            background:#fff
        }
        .content {
            display: block;
            padding-right: 15px;
            padding-left: 15px;
            margin-right: auto;
            margin-left: auto;
            margin-bottom: auto;
        }
        .loginform {
            padding: 5% 30%;
        }

        .titlelogo{
            font-family: cursive;
            font-size: 30px;
            color : #FFFFFF;
            padding: 30px;
        }

        .titlebar{
            text-align: center;
            position: relative;
            overflow: hidden;
            margin-bottom: 2rem;
            border-radius: .1rem;
            background: #FF6F61;
        }

        @media(max-width : 960px){
            .wrap{
                width: 100%;
            }
        }

        @media(max-width : 700px){
            .loginform{
                padding: 0% 10%;
            }
        }

        /*라디오버튼 숨김*/
        input {
            display: none;
        }

        label {
            display: inline-block;
            margin: 0 0 -1px;
            padding: 15px 25px;
            font-weight: 600;
            text-align: center;
            color: #ffffff;
            border: 1px solid transparent;
        }

        label:hover {
            color: #bbb;
            cursor: pointer;
        }

        /*input 클릭시, label 스타일*/
        input:checked + label {
            color: #555;
        }

        .foot{
            width: 100%;
            padding-top: 18px;
            margin-top: 117px;
            margin-right: auto;
            margin-left: auto;
            border-top: 1px solid #e6e6e6;
            /* font-family: '돋움',dotum,sans-serif; */
        }

        .outer{
		width:800px;
		height:500px;
		background:white;
		color:black;
		margin-left:auto;
		margin-right:auto;
		margin-top:10px;
	}

        table {
		border:1px solid black;
		text-align:center;
        }

        .tableArea {
            width:650px;
            height:350px;
            margin-left:auto;	
            margin-right:auto;
        }
    </style>


</head>
<body>

<div class="wrap">

    <div class="outer">
            <br>
            <h2 align="center">소설구매내역</h2><br>
            <div class="tableArea">
                <table align="center" id="listArea">
                <tr>
                    <th width="200px">구매일</th>
                    <th width="200px">제목</th>
                    <th width="200px">회차</th>
                    <th width="200px">금액</th>
                    
                </tr>
                <% for(UsingPayment up: list){ %>
			<tr>
				<td><%= up.getuDate() %></td>
				<td><%= up.getTitle() %></td>
				<td><%= up.getDno() %> 화</td>
				<td><%= up.getPay() %></td>
				
			</tr>
			<% } %>
                
            
            </table>
            </div>
            
        </div>






    <div class="foot row">
        <div class="col" style="text-align: right"><a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">©SalmonisDelicious</a></div>
        <span style="color: rgb(230, 230, 230)">|</span>
        <div class="col" style="text-align: left;"><a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">고객센터</a></div>
    </div>


</div>
</body>
</html>