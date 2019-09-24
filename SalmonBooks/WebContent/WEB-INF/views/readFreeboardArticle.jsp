<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/salmonbooks.css" />
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
        $(function(){
            $("#reply_btn").click(function(){
    	    	if($("#content").val().trim() === ""){
    	    		alert("댓글을 입력하세요.");
    	    		$("#content").val("12345").focus();
    	    	}else{
    	    		$.ajax({	
    	    			url: "commentWrite.do",
    	                type: "POST",
    	                data: {
    	                    no : $("#no").val(),
    	                    content : $("#content").val(),
    	                    count : $("#count").val()
    	                },
    	                success: function (data) {
        	                console.log(data.result.list.length);
        	                for(var i = 0; i < data.result.list.length; i++){
            	            	$("#commentList").append('<img src="/SalmonBooks/resource/image/sushiauthor.png"  border="0" width="50" > &nbsp;  <b>' +   data.result.list[i].writerId +'</b> &nbsp; '+data.result.list[i].content+'<br>');    
        	                }
        	                $("#count").val( data.result.commentCount);
    	                	$("#content").val("");	
    	                },
    	    		})
    	    	}	
    	    });
    	    $("#recommendDiv").click(function(){
        	    $.ajax({
            	    url:"recommend.do",
            	    type : "POST",
            	    data:{
            	    	no : $("#no").val()
                	    },
                	success : function(data){
                    	console.log($("#recommendCount").html());
                    		$("#recommendCount").html(data.result+"");
                    	}
            	    });
        	    });
            });

    </script>
    <style>
    	.reply_btn{
  
    	margin-left:50%;
    		
    	}
    
    	body{
    		background-color:	rgb(241, 238, 238);
    	}
    	
    	
    	
    </style>
    
    
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
            <div class="titleMenuIcon"><a style="border-bottom: 5px solid bisque; text-decoration: none; color:white;" href = "list.do">커뮤니티</a>
                <div class="a"><a href="../freeboard/list.do" style="text-decoration: none; color:white;">자유게시판</a></div>
                <div class="a"><a href="../reviewboard/list.do" style="text-decoration: none; color:white;">감상평</a></div>
            </div>
        </div>
    </div>
    <div class="novelContainer">
        <div class="novelPanel" style="margin-top : 0px;">
        <br>
            <div style=" border-bottom: 1px solid gray; width : 80%; margin-left: auto; margin-right: auto; margin-bottom: 10px;">
                	<h4>[${articleData.article.category}]${articleData.article.title }</h4>   </div> <div style="/*border-bottom: 1px solid gray;*/ 
                	width: 80%; margin-left: auto; margin-right: auto; margin-bottom: 10px; text-align:right;">
                	<div style="font-size: 60%; color: black;">작성자</div><h5>${articleData.article.writer.id }</h5></div>
           
            <div style="font-size: 13px; border-bottom: 1px solid gray; width : 80%; margin-left: auto; margin-right: auto; margin-top: 10px; margin-bottom: 10px;">
                <br><br>
                <div style="">
                                ${articleData.content }
                </div>
                <div id="recommendDiv" style ="text-align: center;">
                <img style = "width : 15%; " src = "/SalmonBooks/resource/image/recommand2.png">
                	<h1 id="recommendCount">${articleData.article.recommend }</h1>
                </div>	
            </div>
            <div id="commentList" style ="width : 80%; margin-left: auto; margin-right: auto; margin-top: 10px; margin-bottom: 10px; ">
                <br><br><br><br><br>
                <c:forEach var="comment" items="${articleData.commentList }">
                <img src="/SalmonBooks/resource/image/sushiauthor.png"  border="0" width="50" > &nbsp; <b> ${comment.writerId }</b>  &nbsp; ${comment.content }<br>
                </c:forEach>
            </div>
            <input type = "text" value="${articleData.article.number }" name ="no"  id= "no"style="visibility: hidden;">
            <input type = "text" value="${articleData.commentCount }" name ="count"  id= "count"style="visibility: hidden;">
            <textarea id = "content"name = "content" class="form-control" rows="3"></textarea>
            
            <div style="margin-left: 50%;">
            <button id="reply_btn" name = "reply_btn">등록</button>
            </div>
            
                <button type="button" class="list_btn" onclick="location.href = 'list.do'">목록</button>
            
            
            <br><br>
           
            <div
                style="border-top: 1px solid gray; height : 10%; width : 100%; padding: 5% 0% 5% 40%;margin-left: auto; margin-right : auto; background: white;">
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