<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="member.command.PwdChangeHandler"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Salmon Books 임시 비밀번호 발급</title>
    <link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/myPage.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>
        body{
            background :rgb(241, 238, 238);
            height: 100vh;
            width: 100%;
            margin: 0;
        }

        /*라디오버튼 숨김*/
        input {
            display: none;
        }

        a {
            display: inline-block;
            margin: 0 0 -1px;
            padding: 15px 25px;
            font-weight: 600;
            text-align: center;
            color: #ffffff;
            border: 1px solid transparent;
        }

        a:hover {
            color: #bbb;
            cursor: pointer;
            text-decoration: none;
        }

        /*input 클릭시, label 스타일*/
        input:checked + a {
            color: #555;
        }
    </style>
</head>
<body>
    <div id="IDandPW" class="wrap">
    <form action="pwdChange.do" method="post">
        <div class="titlebar">
            <div class="titlelogo"><a href="index.jsp" style="color: #fff; text-decoration: none;">Salmon Books</a></div>
            <!-- <div class="titleMenu"> -->
            <div class="row" style="margin-left: 0px; margin-right: 0px">
                <div class="col">
                    <input id="tab1" type="radio" style="display: none" name="tabs"> <!--디폴트 메뉴-->
                    <label for="tab1"><a href="./IdSearch.html">아이디 찾기</a></label>
                </div>
                <div class="col">
                    <input id="tab2" type="radio" style="display: none" name="tabs" checked>
                    <label for="tab2"><a href="./PwdSearch.html">비밀번호 찾기</a></label>
                </div>
            </div>
        </div>
        <div class="content" id="content2">
            <div class="container" style="height:120px; padding: 10px 120px">
                <h3>임시 비밀번호가 발급되었습니다.</h3><hr>
                <p></p><br>
                <%=request.getSession().getAttribute("password") %>
            </div>
            
            <p>
                <button type="submit" class="btn btn-block" 
                    style="background-color: #FF6F61; color : #FFFFFF; border: #FF6F61; width : 10%;  margin: auto;">확인</button>
            </p>
        
        
        <div class="foot row" style="margin: 63px 0px 0px 0px;">
            <div class="col" style="text-align: right"><a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">©SalmonisDelicious</a></div>
            <span style="color: rgb(230, 230, 230)">|</span>
            <div class="col" style="text-align: left;"><a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">고객센터</a></div>
        </div>
        </form>
    </div>
    
</body>
</html>