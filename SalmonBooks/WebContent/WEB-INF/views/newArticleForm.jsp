<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/salmonbooks.css" />
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <style>
        /* .titleMenuIcon:hover{
        animation-duration: 2s;
        animation-name: slidein;  
    } */
        body{
            font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,"Noto Sans",sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol","Noto Color Emoji";
   			 background :rgb(241, 238, 238);
    		width: 100%;
    		margin: 0;
        }
        .a {
            animation-duration: 2s;
            animation-name: slidein;
            font-size: 15px;
            margin-top: 10px;
            display: inline-block;
        }

        .novelPanel {
            animation-duration: 2s;
            animation-name: slidein2;
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

        [contenteditable=true]:empty:before {
            content: attr(placeholder);
            display: block;
            /* For Firefox */
        }

        div[contenteditable=true] {
            border: 1px solid #ddd;
            color: #333;
            font-size: 12px;
            width: 300px;
            padding: 5px;
        }
        .btn-salmon{
        	    background: #FF6F61;
        	    color:white;
        }

    </style>
    <script>
        document.execCommand('styleWithCSS', false, true);
                document.execCommand('insertBrOnReturn', false, true);
                $(document).ready(function() {
                  $("#text").focus();
                  $('button').click(function(){
                    document.execCommand($(this).attr('id'), false, true);
                  });
                  $('select').change(function(){
                    document.execCommand($(this).attr('id'), false, $(this).val());
                  });
                });
        function iBeliveMe(){
            if(document.articleForm.title.value==''){
                alert("제목을 입력하세요!!");
                document.articleForm.title.focus();
              }else{
            	  document.getElementsByName('content')[0].value = document.getElementById('text').innerHTML;
            	  document.articleForm.submit(); 
            	  return true;
              }
            }
    </script>
</head>

<body>
    <div class="titlebar">
        <div style="float: right;">
        
        <u:isLogin>
        <div class="dropdown">
                <a href="../logout.do" style="text-decoration: none; color : white">Logout</a>
                <div class="dropdown-content">
                    <a href="../myPage.do">마이페이지</a>
                    <a href="../payment.do">결제샵</a>
                </div>
            </div>
        </u:isLogin>
        <u:notLogin>
        	<a href="../login.do" style="text-decoration: none; color : white">Login</a>
        </u:notLogin>
        </div>
                <div class="titlelogo"><a href ="/SalmonBooks/" style="text-decoration: none; color:white;">Salmon Books</a></div>
        <div class="titleMenu">
            <div class="titleMenuIcon"><a href="../" style="text-decoration: none; color:white;">홈</a>
            </div>
            <div class="titleMenuIcon"><a href="../FreeNovelList.do?FREE=TRUE&COMPLATE=FALSE" style="text-decoration: none; color:white;">무료</a></div>
            <div class="titleMenuIcon"><a href="../PayNovelList.do?FREE=FALSE&COMPLATE=FALSE" style="text-decoration: none; color:white;">유료</a></div>
            <div class="titleMenuIcon"><a style="border-bottom: 5px solid bisque; text-decoration: none; color:white;" href = "list.do" >커뮤니티</a>
                <div class="a"><a href="../freeboard/list.do" style="text-decoration: none; color:white;">자유게시판</a></div>
                <div class="a"><a href="../reviewboard/list.do" style="text-decoration: none; color:white;">감상평</a></div>
            </div>
        </div>
    </div>
    <div class="novelContainer">
        <div class="novelPanel" style="margin-top: 0px; position: relative;">
            <div style="width : 90%; padding: 10px; margin-left: auto; margin-right: auto;">
                <select id="fontName" width="50px">
                    <option value="">글꼴 선택</option>
                    <option value="돋움">돋움</option>
                    <option value="굴림">굴림</option>
                    <option value="궁서">궁서</option>
                    <option value="바탕">바탕</option>
                    <option value="맑은 고딕">맑은 고딕</option>
                </select>
                <select id="fontSize" width="50px">
                    <option value="">글자 크기</option>
                    <option value="1">4px</option>
                    <option value="2">8px</option>
                    <option value="3">10px</option>
                    <option value="4">12px</option>
                    <option value="5">16px</option>
                    <option value="6">20px</option>
                    <option value="7">30px</option>
                </select>
                <select id="foreColor" width="50px">
                    <option value="">글자 색깔</option>
                    <option value="#f00">빨강</option>
                    <option value="#00f">파랑</option>
                    <option value="#0f0">초록</option>
                    <option value="#ffff00">노랑</option>
                    <option value="#000">검정</option>
                </select>
                <select id="hiliteColor" width="50px">
                    <option value="">글자 배경색</option>
                    <option value="#f00">빨강</option>
                    <option value="#00f">파랑</option>
                    <option value="#0f0">초록</option>
                    <option value="#ffff00">노랑</option>
                    <option value="#000">검정</option>
                    <option value="#FFFFFF">흰색</option>
                </select>
                  <button class="te-button btn btn-warning btn-salmon" id="selectAll">전체선택</button>
                  <button class="te-button btn btn-warning btn-salmon" id="bold">굵게</button>
                  <button class="te-button btn btn-warning btn-salmon" id="italic">기울임</button>
                  <button class="te-button btn btn-warning btn-salmon" id="underLine">밑줄</button>
                  <button class="te-button btn btn-warning btn-salmon" id="justifyLeft">왼쪽정렬</button>
                  <button class="te-button btn btn-warning btn-salmon" id="justifyCenter">가운데정렬</button>
                  <button class="te-button btn btn-warning btn-salmon" id="justifyRight">오른쪽정렬</button>
                  <br><br>
                </div>
                <form action="write.do" method="post" name="articleForm" onsubmit="iBeliveMe(); return false">
                   <select name="category">
                		<option value="잡담" selected>잡담</option>
                		<option value="기타">기타</option>
                	</select>
                	<input type="text" name = "title" class="form-control"  placeholder="제목을 입력해주세요"> 
                	<div id="text" contenteditable="true" style="width:100%; padding : 0px; height: 400px; margin-left: auto; margin-right: auto;"></div>
                	<textarea name= "content" rows="" cols="" style="visibility: hidden;"></textarea>
                	<div style="text-align:center;">
                	<button type="submit" class="te-button btn btn-warning btn-salmon" onclick="">등록</button>
                	</div>
                </form>
            </div>
    </div>
</body>	
</html>

