<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="novel.vo.NovelInfo"%>  
<%@page import="novel.vo.DetailNovel"%>
<%@page import="usingpayment.model.vo.UsingPayment"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<%
   NovelInfo ni = (NovelInfo)request.getAttribute("NovelInfo");
   DetailNovel dn = (DetailNovel)request.getAttribute("DetailNovel");
   UsingPayment up = (UsingPayment)request.getAttribute("UsingPayment");
   
   int dno = Integer.parseInt(request.getParameter("dno"));
   int nno = Integer.parseInt(request.getParameter("nno"));
   int listcount = Integer.parseInt(request.getParameter("listcount"));
   String title = ni.getNtitle(); //
   int pay = ni.getPay();
   String img = ni.getImg();
%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>DetailPayment</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
   <link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
   <link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/addView.css" />
   <link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/fontAni.css" />
   <link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/hoverAugmentation.css" />
   <link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/NovelList.css" />

<link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/salmonbooks.css" />
<script language="javascript">
  function showPayPopup() { window.open("/SalmonBooks/WEB-INF/views/HTML/PayPopup.html", "유료소설알리미", "width=400, height=200, left=550, top=300"); }
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

        /* 라디오버튼 숨김 */
        /* input {
            display: none;
        } */

        label {
            display: inline-block;
            margin: 0 0 -1px;
            padding: 15px 25px;
            font-weight: 600;
            text-align: center;
            color: #000000;
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

        .payment{ 
           
            margin-top: 120px;
            margin-left: 220px;
           
        }

        .paymentbt{

            margin-top: 30px;
            margin-left: 150px;

        }
        .textch{
        
        }
      
    </style>


</head>
<body>

<div class="titlebar">
        <div style="float: right;" onclick=""><a href="LoginPage.html"
                style="text-decoration: none; color : white">
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
        <div class="titlelogo">Salmon Page</div>
        <div class="titleMenu">
            <div class="titleMenuIcon"><a href="index.jsp">홈</a></div>
            <div class="titleMenuIcon"><a href="FreeNovelList.do?FREE=TRUE&COMPLATE=FALSE">무료</a></div>
            <div class="titleMenuIcon"><a href="PayNovelList.do?FREE=FALSE&COMPLATE=FALSE" style="border-bottom: 5px solid bisque;">유료</a>
                <div class="a"><a href = "payGenreList.do?FREE=FALSE&COMPLATE=FALSE&GENRE=판타지">판타지</a></div>
                <div class="a"><a href = "payGenreList.do?FREE=FALSE&COMPLATE=FALSE&GENRE=무협">무협</a></div>
                <div class="a"><a href = "payGenreList.do?FREE=FALSE&COMPLATE=FALSE&GENRE=로맨스">로맨스</a></div>           
            </div>            
<!--             <div class="titleMenuIcon"><a href="EndNovelPage.html">완결</a></div> -->
            <div class="titleMenuIcon"><a href="community.html">커뮤니티</a></div>
        </div>

        <div class="hotnovelPanel">
            
 




<form action = "usingcheck.do" method ="post" style="color:black;">
   <input type="text" name="nno"  style="visibility: hidden;" value=<%=nno%> /><br>
   <input type="text" name="dno"  style="visibility: hidden;" value=<%=dno%> /><br>
   <input type="text" name="title"  style="visibility: hidden;" value=<%=title%> /><br>
   <input type="text" name="listcount" style="visibility : hidden;" value="<%=listcount %>"/><br>
   <input type="text" name="pay"  style="visibility: hidden;" value=<%=pay%> /><br>
   <img src="<%=img%>" style="width: 200px; height:auto; padding-right: 50px;">
   <div class="textch" style="display : inline-block;">  <h4><%=title%> ,<%=dno%>화 <%=pay %>포인트 입니다. 결제하시겠습니까?</h4>
   </div>
   <br>
   <br>
   <button type="submit" 
               style="background-color: #FF6F61; color : #FFFFFF; border: #FF6F61; height: 30px; width : 15%;">결제하기</button>
              <button type="button" style="background-color: #FF6F61; color : #FFFFFF; border: #FF6F61; height: 30px; width : 15%;"onclick="location.href='index.jsp'">취소</button><br>
    <br>
   <br>
</form>













<div class="foot row">
    <div class="col" style="text-align: right"><a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">©SalmonisDelicious</a></div>
    <span style="color: rgb(230, 230, 230)">|</span>
    <div class="col" style="text-align: left;"><a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">고객센터</a></div>
</div>


</div>
</body>
</html>

