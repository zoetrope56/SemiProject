<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>포인트 부족!!</title>
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
<%

   String check = request.getParameter("resultCode");

   System.out.println(check);
%>

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

body {
	background: rgb(241, 238, 238);
	height: 100vh;
	width: 100%;
	margin: 0;
}

.wrap {
	width: 960px;
	height: 100vh;
	min-width: 360px;
	margin: 0 auto 0;
	background: #fff
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

.titlelogo {
	font-family: cursive;
	font-size: 30px;
	color: #FFFFFF;
	padding: 30px;
}

.titlebar {
	text-align: center;
	position: relative;
	overflow: hidden;
	margin-bottom: 2rem;
	border-radius: .1rem;
	background: #FF6F61;
}

@media ( max-width : 960px) {
	.wrap {
		width: 100%;
	}
}

@media ( max-width : 700px) {
	.loginform {
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
input:checked+label {
	color: #555;
}

.foot {
	width: 100%;
	padding-top: 18px;
	margin-top: 117px;
	margin-right: auto;
	margin-left: auto;
	border-top: 1px solid #e6e6e6;
	/* font-family: '돋움',dotum,sans-serif; */
}

#btn_group button {
	border: 1px solid #FF6F61;
	background-color: #FF6F61;
	color: rgb(255, 255, 255);
	padding: 5px;
}

</style>


</head>
<body>
	<div class="titlebar">

		<div style="float: right;">

			<u:isLogin>
				<div class="dropdown">
					<a href="logout.do" style="text-decoration: none; color: white">Logout</a>
					<div class="dropdown-content">
						<a href="myPage.do">마이페이지</a> <a href="payment.do">결제샵</a>
					</div>
				</div>
			</u:isLogin>
			<u:notLogin>
				<a href="login.do" style="text-decoration: none; color: white">Login</a>
			</u:notLogin>
		</div>
		<div class="titlelogo">Salmon Books</div>
		<div class="titleMenu">
			<div class="titleMenuIcon">
				<a style="border-bottom: 5px solid bisque;">홈</a>
			</div>
			<div class="titleMenuIcon"
				onclick="location.href='/SalmonBooks/FreeNovelList.do?FREE=TRUE&COMPLATE=FALSE'">무료</div>
			<div class="titleMenuIcon"
				onclick="location.href='/SalmonBooks/PayNovelList.do?FREE=FALSE&COMPLATE=FALSE'">유료</div>
			
			<div class="titleMenuIcon">
				<a href="freeboard/list.do">커뮤니티</a>
			</div>
		</div>
	</div>


	

	<div class="wrap">
        <br>
	<h2 align="center">포인트가 부족합니다! 포인트를 충전하세요!!!!</h2>
	
	<br><br><br><br>
	
	
	
   
		<div id="btn_group" align="center">

			<button type="button" onclick="location.href='payment.do'">&nbsp;&nbsp;충전하기&nbsp;&nbsp;</button>
            <button type="button" onclick="location.href='PayNovelList.do?FREE=FALSE&COMPLATE=FALSE'">&nbsp;&nbsp;취소&nbsp;&nbsp;</button>
		</div>
		
		
	</div>




	<div class="foot row">
		<div class="col" style="text-align: right">
			<a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">©SalmonisDelicious</a>
		</div>
		<span style="color: rgb(230, 230, 230)">|</span>
		<div class="col" style="text-align: left;">
			<a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">고객센터</a>
		</div>
	</div>


	</div>
</body>
</html>