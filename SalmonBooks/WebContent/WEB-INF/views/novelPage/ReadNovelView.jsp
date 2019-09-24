<%@page import="novel.vo.DetailNovel"%>
<%@page import="auth.service.User"%>
<%@page import="novelComment.vo.NovelComment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<%@page import="java.util.ArrayList"%>

<%
	User user = (User) request.getSession().getAttribute("authUser");
	DetailNovel dn = (DetailNovel)request.getAttribute("dn");
	int dno = Integer.parseInt(request.getParameter("dno"));
	int nno = Integer.parseInt(request.getParameter("nno"));
	int listCount = Integer.parseInt(request.getParameter("listcount"));
	String free = (String)request.getAttribute("free");
	ArrayList<NovelComment> cList = (ArrayList<NovelComment>)request.getAttribute("cList");
%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Salmon Books</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">

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

a:hover {
	color: white;
	text-decoration: none;
}

.text {
	overflow: hidden;
	height: auto;
}

.page {
	display: inline-block;
	position: sticky;
	top: 0px;
	width: 80px;
	height: 60px;
	background: white;
	text-align: center;
	font-size: 30px;
	margin-top: 10px;
}



/* 파일 업로드 css */
input.upload_text {
	/*읽기전용 인풋텍스트*/
	float: left;
	width: 230px;
	/* 버튼 포함 전체 가로 길이*/
	height: 19px;
	line-height: 19px;
	padding: 0 3px;
	border: 1px solid #bbb;
}

div.upload-btn_wrap input.input_file {
	/*파일찾기 폼 투명하게*/
	position: absolute;
	top: 0;
	right: 0;
	cursor: pointer;
	opacity: 0;
	filter: alpha(opacity = 0);
	-ms-filter: "alpha(opacity=0)";
	-moz-opacity: 0;
}

div.upload-btn_wrap {
	/*버튼테두리 감싼 div*/
	overflow: hidden;
	position: relative;
	float: left;
	width: 70px;
	/*width, height 값은 button(찾아보기)값과 같아야함 */
	height: 21px;
	padding-left: 3px;
}

div.upload-btn_wrap button {
	/*버튼 div*/
	width: 70px;
	height: 21px;
	font-weight: bold;
	background: #333;
	border: 1px solid #333;
	color: #fff;
}

.fontsel {
	width: 210px;
	padding: .2em .5em;
	border: 1px solid #999;
	font-family: inherit;
	background: url('/SalmonBooks/resource/image/arrow.jpg') no-repeat 95%
		50%;
	border-radius: 0px;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
}

select::-ms-expand {
	display: none;
}

.filebox input[type="file"] {
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0;
}


/*메인 css*/
body {
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		"Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji",
		"Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
	background: rgb(241, 238, 238);
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

@
keyframes slidein {from { font-size:0px;
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

.btn-salmon {
	background: white;
	color: #FF6F61;
	border: 1px solid #FF6F61
}


body {
	background: rgb(241, 238, 238);
	width: 100%;
	margin: 0;
}

.titlebar {
	color: white;
	font-family: 'Malgun Gothic';
	text-align: center;
	position: relative;
	overflow: hidden;
	background: #FF6F61;
}

.titlelogo {
	font-family: cursive;
	font-size: 30px;
	color: white;
	padding: 30px;
}

.titleMenu {
	font-size: 25px;
	width: auto;
}

.titleMenuIcon {
	display: inline-block;
	margin: 0 5px 20px 20px;
}

.novelList {
	list-style: none;
}

.novelContainer {
	position: relative;
}

.advertisementImage {
	width: 100%;
	height: auto;
	max-width: 960px;
}

.novelPanel {
	width: 100%;
	margin-top: 10px;
	background: white;
	font-family: 'AppleSDGothicNeo-Light', 'NanumGothic', 'Dotum',
		'Helvetica', 'sans-serif';
}

.novelImage {
	width: 100%;
	max-width: 182px;
}

.novelFont {
	font-size: 10px;
	color: gray;
	padding: 5px;
}

a {
	text-decoration: none;
	color: white;
}

.a {
	animation-duration: 2s;
	animation-name: slidein;
	font-size: 15px;
	margin-top: 10px;
	display: inline-block;
}

@
keyframes slidein {from { font-size:0px;
	color: #FF6F61;
}

to {
	font-size: 15px;
	color: white;
}

}
@media only screen and (min-width: 769px) {
	.titlebar {
		position: static;
		overflow: visible;
	}
	.titleMenuIcon {
		display: inline-block;
		margin: 0 5px 20px 20px;
	}
}

@media only screen and (min-width: 961px) {
	.titlebar {
		width: 960px;
		margin-left: auto;
		margin-right: auto;
	}
	.titleMenu {
		position: relative;
		color: white;
		font-family: 'Malgun Gothic';
		font-size: 25px;
		width: auto;
	}
	.titleMenuIcon {
		display: inline-block;
		margin: 0 5px 20px 20px;
	}
	.novelContainer {
		width: 960px;
		margin-left: auto;
		margin-right: auto;
	}
	.novelContainer div {
		width: 100%;
	}
	img {
		display: inline-block;
	}
	.list {
		position: relative;
		left: 20%;
		width: 20%;
		display: inline-block;
	}
	.novelListItem {
		height: 100%;
	}
	.novelSubject {
		padding: 5px;
	}
}
</style>
<script>
	// 파일 업로드 js
	document.execCommand('styleWithCSS', false, true);
	document.execCommand('insertBrOnReturn', false, true);
	$(document).ready(function() {
		$("#text").focus();
		$('button').click(function() {
			document.execCommand($(this).attr('id'), false, true);
		});
		$('select').change(function() {
			document.execCommand($(this).attr('id'), false, $(this).val());
		});
	});
	function iBeliveMe() {
		if (document.articleForm.title.value == '') {
			alert("제목을 입력하세요!!");
			document.articleForm.title.focus();
		} else {
			document.getElementsByName('content')[0].value = document
					.getElementById('text').innerHTML;
			document.articleForm.submit();
			return true;
		}
	}
	// 편집기 입력 불가 js
	$(document).ready(function() {
		$("#text").on("keypress", function(e) {
			e.preventDefault();
		});
	});
</script>
</head>

<body>

	<div class="titlebar">

        <div style="float: right;">
        
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
                <div class="titlelogo"><a href ="/SalmonBooks/">Salmon Books</a></div>
        <div class="titleMenu">
            <div class="titleMenuIcon"><a href="index.jsp">홈</a></div>
            <div class="titleMenuIcon"><a href="FreeNovelList.do?FREE=TRUE&COMPLATE=FALSE">무료</a></div>
            <div class="titleMenuIcon"><a href="PayNovelList.do?FREE=FALSE&COMPLATE=FALSE">유료</a></div>
            <div class="titleMenuIcon"><a href="freeboard/list.do">커뮤니티</a></div>
        </div>
    </div>

	<div class="novelContainer">
		<div class="novelPanel" style="margin-top: 30px; position: relative;">
			<div style="height: 50px; width: 960px;">
				<span style="float: left; padding-top: 2%; padding-left: 50px;">
					<h2>${dn.nTitle}</h2>
				</span><span
					style="color: #FF6F61; float: right; padding-top: 2%; padding-right: 50px; font-family: 'Malgun Gothic';">
					<h2>Salmon'S Novel</h2>
				</span>

			</div>
			<!-- <h4 style="padding-top: 2%; padding-left: 50px;">Salmon'S Novel</h4> -->
			<form style="padding-left: 50px; padding-right: 50px;"
				action="write.do" method="post" name="articleForm"
				onsubmit="iBeliveMe(); return false">
				<hr>
				<select class="fontsel" id="fontName" width="50px">
					<option value="">글꼴 선택</option>
					<option value="돋움">돋움</option>
					<option value="굴림">굴림</option>
					<option value="궁서">궁서</option>
					<option value="바탕">바탕</option>
					<option value="맑은 고딕">맑은 고딕</option>
				</select> <select class="fontsel" id="fontSize" width="50px">
					<option value="">글자 크기</option>
					<option value="1">4px</option>
					<option value="2">8px</option>
					<option value="3">10px</option>
					<option value="4">12px</option>
					<option value="5">16px</option>
					<option value="6">20px</option>
					<option value="7">30px</option>
				</select> <select class="fontsel" id="foreColor" width="50px">
					<option value="">글자 색깔</option>
					<option value="#f00">빨강</option>
					<option value="#00f">파랑</option>
					<option value="#0f0">초록</option>
					<option value="#ffff00">노랑</option>
					<option value="#000">검정</option>
				</select> <select class="fontsel" id="hiliteColor" width="50px">
					<option value="">글자 배경색</option>
					<option value="#f00">빨강</option>
					<option value="#00f">파랑</option>
					<option value="#0f0">초록</option>
					<option value="#ffff00">노랑</option>
					<option value="#000">검정</option>
				</select>
			</form>
			<div class="novelContainer"
				style="margin-top: 20px; padding-left: 50px; padding-right: 50px;">


				<button class="te-button btn btn-warning btn-salmon" id="selectAll">전체선택</button>
				<button class="te-button btn btn-warning btn-salmon" id="bold">굵게</button>
				<button class="te-button btn btn-warning btn-salmon" id="italic">기울임</button>
				<button class="te-button btn btn-warning btn-salmon" id="underLine">밑줄</button>
				<button class="te-button btn btn-warning btn-salmon"
					id="justifyLeft">왼쪽정렬</button>
				<button class="te-button btn btn-warning btn-salmon"
					id="justifyCenter">가운데정렬</button>
				<button class="te-button btn btn-warning btn-salmon"
					id="justifyRight">오른쪽정렬</button>
				<select class="te-button btn btn-warning btn-salmon" id="asmrbox" style="width: 150px; height: 38px; float: right;">
				    <option value="">ASMR선택</option>
				    <option value="빗소리">빗소리</option>
				    <option value="바람소리">바람소리</option>
				    <option value="숲소리">숲소리</option>
				    <option value="새소리">새소리</option>
				    <option value="백색소음">백색소음</option>
				    <option value="시장소리">시장소리</option>
				    <option value="알약">알약</option>
				    <option value="얼음먹방">얼음먹방</option>
				    <option value="키보드">키보드</option>
				</select>
				<div class="page">
					<%
						if (dno <= 1) {
					%>
					<span
						style="color: gray; float: left; border: gray 1.5px solid; position: relative; visibility: hidden">
						<h1><</h1>
					</span>
					<%
						} else {
					%>
					<span
						style="color: gray; float: left; border: gray 1.5px solid; position: relative; cursor: pointer;"
						onclick="location.href='<%=request.getContextPath()%>/ViewNovel.do?nno=<%=nno%>&dno=<%=dno - 1%>&listcount=<%=listCount%>&free=<%=free%>'">
						<h1><</h1> <%
						}
					%>
					</span> <span>${dn.dTitle} </span>
					<%
						if (dno >= listCount) {
					%>
					<span
						style="color: gray; float: left; border: gray 1.5px solid; position: relative; visibility: hidden">
						<h1><</h1>
					</span>
					<%
						} else {
					%>
					<span
						style="color: gray; float: right; border: gray 1.5px solid; position: relative; cursor: pointer;"
						onclick="location.href='<%=request.getContextPath()%>/ViewNovel.do?nno=<%=nno%>&dno=<%=dno + 1%>&listcount=<%=listCount%>&free=<%=free%>'">
						<h1>></h1>
					</span>
					<%
						}
					%>
				</div>
				<div id="text" contenteditable="true"
					style="width: 100%; padding: 0px; margin-top: 20px; margin-left: auto; margin-right: auto;">
					${dn.content}</div>
				<textarea name="content" rows="" cols="" style="visibility: hidden; resize: none;"></textarea>


			</div>
			<hr style="width: 90%">
		 	<!-- 댓글 영역 start -->
			<div class="replyArea">
			<%if( user != null) { %>
			<div class="replyWriteArea">
				<form action="/SalmonBooks/insertComment.do" method="post">
					<input type="hidden" name="writer" value="<%=user.getId()%>"/>
					<input type="hidden" name="listcount" value="<%=listCount%>" />
					<input type="hidden" name="free" value="<%=free%>" />
					<input type="hidden" name="nno" value="<%=nno%>" />
					<input type="hidden" name="dno" value="<%=dno%>" />
					<input type="hidden" name="refcno" value="0" />
					<input type="hidden" name="clevel" value="1" />
					
					<table align="center">
						<tr>
							<td><textArea rows="3" cols="80" id="replyContent" name="replyContent" style="resize: none; margin-left: 40px;width: 90%; height: 50px; border:1px solid #FF6F61"></textArea></td>
							<td><button type="submit" id="addReply" style="border:1px solid #FF6F61; background-color: white; color: #FF6F61">댓글 등록</button></td>
						</tr>
					</table>
				</form>
			</div>
			<%} %>
			<div id="replySelectArea">
			<!-- 게시글의 댓글들을 보여주는 부분  -->
			<% if (cList != null) { %>
				<% for(NovelComment nco : cList) { %>
				
				<table id="replySelectTable" style="margin-left : 0; width : 820px;" class="replyList<%=nco.getClevel()%>">
		  		<tr style = "width:800px">
		  			
					<td style = "font-family: 'Malgun Gothic';padding-left: 80px; color:gray;">작성자 : <%= nco.getCwriter() %></td>
					<td style="float : right; "><%= nco.getCdate() %></td>
				</tr>
				<tr class="comment replyList<%=nco.getClevel()%>">
					<td colspan="3" style="background : transparent;">
					<textarea class="reply-content" cols="105" rows="3"
					 readonly="readonly" style="resize: none; border:1px solid #FF6F61; margin-left: 10%;width : 750px; height: 50px; border:1px solid #d3d3d3; color:gray"><%= nco.getCcontent() %></textarea>
					</td>
				</tr>
			</table>
			
			<% } } %>
			</div>
		</div> 

			<div class="novelPanel"
				style="margin-top: 20px; padding-top: 40px; position: relative; height: 100px; text-align: center; overflow: hidden; height: auto;">
				<div style="padding-right: 3%;">
					<a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">©SalmonisDelicious</a>
					<span style="color: rgb(230, 230, 230); display: inline;">|</span>
					<span
						style="text-align: left; text-align: center; display: inline;"><a
						href="#" style="font-size: 60%; color: rgb(118, 118, 118)">고객센터</a></span>
				</div>
			</div>

		</div>
			<script>
	function updateReply(obj) {
		// 현재 위치와 가장 근접한 textarea 접근하기
		$(obj).parent().parent().next().find('textarea')
		.removeAttr('readonly');
		
		// 수정 완료 버튼을 화면 보이게 하기
		$(obj).siblings('.updateConfirm').css('display','inline');
		
		// 수정하기 버튼 숨기기
		$(obj).css('display', 'none');
	}
	
	function updateConfirm(obj) {
		// 댓글의 내용 가져오기
		var content
		  = $(obj).parent().parent().next().find('textarea').val();
		
		// 댓글의 번호 가져오기
		var cno = $(obj).siblings('input').val();
		
		// 소설 가져오기
		var nno = <%=nno%>;
		var dno = <%=dno%>;
		location.href="/SalmonBooks/updateComment.bo?"
				 +"cno="+cno+"&bno="+bno+"&content="+content;
	}
	
	function deleteReply(obj) {
		// 댓글의 번호 가져오기
		var cno = $(obj).siblings('input').val();
		
		// 소설 가져오기
		var nno = <%=nno%>;
		var dno = <%=dno%>;
		
		location.href="/myWeb/deleteComment.bo"
		+"?cno="+cno+"&bno="+bno;
	}
	
	function reComment(obj){
		// 추가 완료 버튼을 화면 보이게 하기
		$(obj).siblings('.insertConfirm').css('display','inline');
		
		// 클릭한 버튼 숨기기
		$(obj).css('display', 'none');
		
		// 내용 입력 공간 만들기
		var htmlForm = 
			'<tr class="comment"><td></td>'
				+'<td colspan="3" style="background : transparent;">'
					+ '<textarea class="reply-content" style="background : ivory;" cols="105" rows="3"></textarea>'
				+ '</td>'
			+ '</tr>';
		
		$(obj).parents('table').append(htmlForm);
		
	}
	var audio;
	$(function(){
		$('#asmrbox').change(function(){
			if(audio)audio.pause();
			audio = new Audio("/SalmonBooks/resource/audio/"+this.value+".mp3");
			audio.play();
			
		});
	})
	
	</script>
		
</body>


</html>