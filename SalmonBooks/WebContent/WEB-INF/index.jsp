<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/salmonbooks.css" />
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
</head>
<body>
    <div class="titlebar">

        <div style="float: right;">
        
        <u:isLogin>
        	<a href="logout.do" style="text-decoration: none; color : white">Logout</a></div>
        </u:isLogin>
        <u:notLogin>
        	<a href="login.do" style="text-decoration: none; color : white">Login</a></div>
        </u:notLogin>
                <div class="titlelogo"><a href ="/SalmonBooks/">Salmon Books</a></div>
        <div class="titleMenu">
            <div class="titleMenuIcon"><a style="border-bottom: 5px solid bisque;">홈</a></div>
            <div class="titleMenuIcon"><a href="/FreeNovelPage.html">무료</a></div>
            <div class="titleMenuIcon"><a href="ChargedNovelPage.html">유료</a></div>
            <div class="titleMenuIcon"><a href="EndNovelPage.html">완결</a></div>
            <div class="titleMenuIcon"><a href="freeboard/list.do">커뮤니티</a></div>
        </div>
    </div>
    <div class="novelContainer">
        <div>
            <img class="advertisementImage" src="/SalmonBooks/resource/image/sample.png">
        </div>
        <div height="10%" style="background: white; margin: 10px 0 0 0;">
            <h3>으아아아아아악!!</h3>
        </div>
        <div class="novelPanel">
            <ul class="novelList">
                <li class="novelListItem">
                    <a href="viewer.html">
                            <table>
                                    <tr>
                                        <td rowspan="3"><img class="novelImage" src="/SalmonBooks/resource/image/sampleicon.png"></td>
                                        <td class="novelSubject">
                                            <h4>제목을 넣는 칸이에욤<br><br></h4>
                                            <p class="novelFont">있는 척 줄거리를 적어욤</p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="novelFont"> 352.2만 | 순정 | 초예지</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                    </tr>
                                    <tr></tr>
                                </table>
                    </a>
                </li>
                <li class="novelListItem">
                    <table>
                        <tr>
                            <td rowspan="3"><img class="novelImage" src="/SalmonBooks/resource/image/sampleicon.png"></td>
                            <td class="novelSubject" style="">
                                <h4>제목을 넣는 칸이에욤<br><br></h4>
                                <p class="novelFont">있는 척 줄거리를 적어욤</p>
                            </td>
                        </tr>
                        <tr>
                            <td class="novelFont"> 352.2만 | 순정 | 초예지</td>
                        </tr>
                        <tr>
                            <td style="color : white;">&nbsp;</td>
                        </tr>
                        <tr></tr>
                    </table>
                </li>
                <li class="novelListItem">
                    <table>
                        <tr>
                            <td rowspan="3"><img class="novelImage" src="/SalmonBooks/resource/image/sampleicon.png"></td>
                            <td class="novelSubject" style="">
                                <h4>제목을 넣는 칸이에욤<br><br></h4>
                                <p class="novelFont">있는 척 줄거리를 적어욤</p>
                            </td>
                        </tr>
                        <tr>
                            <td class="novelFont"> 352.2만 | 순정 | 초예지</td>
                        </tr>
                        <tr>
                            <td style="color : white;">&nbsp;</td>
                        </tr>
                        <tr></tr>
                    </table>
                </li>
            </ul>
            <div
                style="border-top: 1px solid gray; height : 10%; width : 50%; padding :5% 0% 5% 40%; margin-left: auto; margin-right : auto; background: white;">
                <div style="text-align: center; display: inline;"><a href="#"
                        style="font-size: 60%; color: rgb(118, 118, 118)">©SalmonisDelicious</a></div>
                <span style="color: rgb(230, 230, 230); display: inline;">|</span>
                <div style="text-align: left; text-align: center;  display : inline;"><a href="#"
                        style="font-size: 60%; color: rgb(118, 118, 118)">고객센터</a></div>
            </div>
        </div>
        <div>
        </div>
    </div>
</body>
</html>