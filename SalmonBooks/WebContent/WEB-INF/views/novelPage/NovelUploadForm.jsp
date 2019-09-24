<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
	
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





select {
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

select {
	width: 210px;
	padding: .2em .5em;
	border: 1px solid #999;
	font-family: inherit;
	background: url('arrow.jpg') no-repeat 95% 50%;
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

.filebox label {
	display: inline-block;
	padding: .5em .75em;
	color: #999;
	font-size: inherit;
	line-height: normal;
	vertical-align: middle;
	background-color: #fdfdfd;
	cursor: pointer;
	border: 1px solid #ebebeb;
	border-bottom-color: #e2e2e2;
	border-radius: .25em;
}

/* named upload */
.filebox .upload-name {
	display: inline-block;
	padding: .5em .75em;
	/* label의 패딩값과 일치 */
	font-size: inherit;
	font-family: inherit;
	line-height: normal;
	vertical-align: middle;
	background-color: #f5f5f5;
	border: 1px solid #ebebeb;
	border-bottom-color: #e2e2e2;
	border-radius: .25em;
	-webkit-appearance: none;
	/* 네이티브 외형 감추기 */
	-moz-appearance: none;
	appearance: none;
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
	document.execCommand('styleWithCSS', false, true);
	document.execCommand('insertBrOnReturn', false, true);
	$(document).ready(function() {
		$("#text").focus();
		$('span').click(function() {
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
	// 파일 업로드 js
        var fileTarget = $('.filebox .upload-hidden');

        fileTarget.on('change', function () { // 값이 변경되면
            if (window.FileReader) { // modern browser
                var filename = $(this)[0].files[0].name;
            }
            else { // old IE
                var filename = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출
            }

            // 추출한 파일명 삽입
            $(this).siblings('.upload-name').val(filename);
        });
       
</script>
</head>

<body>
	<div class="titlebar" id="test">
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
                <div class="titlelogo"><a href ="/SalmonBooks/" style="text-decoration: none; color:white;">Salmon Books</a></div>
		<div class="titleMenu">
			<div class="titleMenuIcon">
				<a href="index.jsp" style="text-decoration: none; color:white;">홈</a>
			</div>
			<div class="titleMenuIcon">
				<a href="FreeNovelList.do?FREE=TRUE&COMPLATE=FALSE" style="text-decoration: none; color:white;">무료</a>
			</div>
			<div class="titleMenuIcon">
				<a href="PayNovelList.do?FREE=FALSE&COMPLATE=FALSE" style="text-decoration: none; color:white;">유료</a>
			</div>
			<div class="titleMenuIcon"><a href="freeboard/list.do" style="text-decoration: none; color:white;">커뮤니티</a></div>
		</div>
	</div>

	<div class="novelContainer">
		<div class="novelPanel" style="margin-top: 30px; position: relative;">
			<h4 style="padding-top: 2%; padding-left: 50px;">소설 업로드</h4>
			<hr>
			<form style="padding-left: 50px; padding-right: 50px;"
				action="<%=request.getContextPath()%>/novelUpload.do" method="post"
				name="articleForm" onsubmit="iBeliveMe(); return false"
				enctype="multipart/form-data">
				<input type="text" name="nno" value="<%=request.getAttribute("nno") %>"/>
				<input style="border: none; padding-bottom: 0px;" type="text"
					name="title" class="form-control" placeholder="제목">
				<hr>
				<div class="filebox">
					&nbsp이미지&nbsp&nbsp:&nbsp&nbsp <input class="upload-name"
						value="파일선택" disabled="disabled" style="margin-bottom: .5rem;">
					<label for="filename" style="padding: .5em .75em;">업로드</label> <input
						type="file" id="filename" name="file" class="upload-hidden">

				</div>
				<hr>
				<select id="fontName" width="50px">
					<option value="">글꼴 선택</option>
					<option value="돋움">돋움</option>
					<option value="굴림">굴림</option>
					<option value="궁서">궁서</option>
					<option value="바탕">바탕</option>
					<option value="맑은 고딕">맑은 고딕</option>
				</select> <select id="fontSize" width="50px">
					<option value="">글자 크기</option>
					<option value="1">4px</option>
					<option value="2">8px</option>
					<option value="3">10px</option>
					<option value="4">12px</option>
					<option value="5">16px</option>
					<option value="6">20px</option>
					<option value="7">30px</option>
				</select> <select id="foreColor" width="50px">
					<option value="">글자 색깔</option>
					<option value="#f00">빨강</option>
					<option value="#00f">파랑</option>
					<option value="#0f0">초록</option>
					<option value="#ffff00">노랑</option>
					<option value="#000">검정</option>
				</select> <select id="hiliteColor" width="50px">
					<option value="">글자 배경색</option>
					<option value="#f00">빨강</option>
					<option value="#00f">파랑</option>
					<option value="#0f0">초록</option>
					<option value="#ffff00">노랑</option>
					<option value="#000">검정</option>
				</select>

				<div class="novelContainer" style="margin-top: 20px;">

					<span class="te-button btn btn-warning btn-salmon" id="selectAll">전체선택</span>
					<span class="te-button btn btn-warning btn-salmon" id="bold">굵게</span>
					<span class="te-button btn btn-warning btn-salmon" id="italic">기울임</span>
					<span class="te-button btn btn-warning btn-salmon" id="underLine">밑줄</span>
					<span class="te-button btn btn-warning btn-salmon" id="justifyLeft">왼쪽정렬</span>
					<span class="te-button btn btn-warning btn-salmon"
						id="justifyCenter">가운데정렬</span> <span
						class="te-button btn btn-warning btn-salmon" id="justifyRight">오른쪽정렬</span>

					<div id="text" contenteditable="true"
						style="width: 100%; padding: 0px; height: 400px; margin-top: 20px; margin-left: auto; margin-right: auto;">
					</div>
					<textarea name="content" rows="" cols=""
						style="visibility: hidden;"></textarea>
					<div style="margin-left: 45%;">
						<button type="submit" class="te-button btn btn-warning btn-salmon">제출</button>
					</div>
			</form>
		</div>
		<div class="novelPanel"
			style="margin-top: 20px; padding-top: 40px; position: relative; height: 100px; text-align: center;">
			<div style="padding-right: 3%;">
				<a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">©SalmonisDelicious</a>
				<span style="color: rgb(230, 230, 230); display: inline;">|</span> <span
					style="text-align: left; text-align: center; display: inline;"><a
					href="#" style="font-size: 60%; color: rgb(118, 118, 118)">고객센터</a></span>
			</div>
		</div>

	</div>
</body>

</html>