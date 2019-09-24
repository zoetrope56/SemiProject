<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/salmonbooks.css" />
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

    <style>
        /* .titleMenuIcon:hover{
        animation-duration: 2s;
        animation-name: slidein;  
    } */
        .a {
            animation-duration: 2s;
            animation-name: slidein;
            font-size: 15px;
            margin-top: 10px;
            display: inline-block;
        }

        @keyframes slidein {
            from {
                font-size: 0px;
                color: #FF6F61;
            }

            to {
                font-size: 15px;
                color: white;
            }
        }
    </style>
</head>

<body>
    <div class="titlebar">
        <div style="float: right;" onclick="{ this.innerHTML = 'logout';}"><a href="LoginPage.html"
                style="text-decoration: none; color : white">Login</a></div>
        <div class="titlelogo"><a href="index.jsp" style="color: #fff; text-decoration: none;">Salmon Books</a></div>
        <div class="titleMenu">
            <div class="titleMenuIcon"><a style="border-bottom: 5px solid bisque;"><a href="/index.html">홈</a>
            </div>
            <div class="titleMenuIcon"><a href="FreeNovelPage.html">무료</a></div>
            <div class="titleMenuIcon"><a href="ChargedNovelPage.html">유료</a></div>
            <div class="titleMenuIcon"><a href="EndNovelPage.html">완결</a></div>
            <div class="titleMenuIcon"><a style="border-bottom: 5px solid bisque;" href="community.html">커뮤니티</a>
                <div class="a">자유게시판</div>
                <div class="a">감상평</div>
            </div>
        </div>
    </div>
    <div class="novelContainer">
        <div class="novelPanel" style="margin-top: 0px;">
            <h1>${param.id }님, 회원가입에 성공했습니다.</h1>
        </div>
        <div>
        </div>
    </div>
</body>

</html>