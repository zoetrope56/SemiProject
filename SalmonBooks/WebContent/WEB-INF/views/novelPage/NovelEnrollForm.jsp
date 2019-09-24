<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Salmon Books</title>
<link rel="stylesheet" type="text/css"
	href="/SalmonBooks/resource/css/salmonbooks.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/SalmonBooks/resource/css/DetailNovelPage.css" />
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
	background: url('/SalmonBooks/resource/image/arrow.jpg') no-repeat 95% 50%;
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

	//포인트 체크박스 제거 js
	$(document).ready(function() {
		// 라디오버튼 클릭시 이벤트 발생
		$("input:radio[name=chk_free]").click(function() {
			console.log('ddd');
			if ($("input[name=chk_free]:checked").val() == "TRUE") {
                $("select[name=pay]").attr('style', "display:none;");
				// radio 버튼의 value 값이 1이라면 활성화

			} else if ($("input[name=chk_free]:checked").val() == "FALSE") {
				$("select[name=pay]").attr('style', "display:hidden;");
				// radio 버튼의 value 값이 0이라면 비활성화
			}
		});
	});
	
	//파일 업로드 js
	var fileTarget = $('.filebox .upload-hidden');
	console.log('AAAAA');
	fileTarget.on('change', function() { // 값이 변경되면
		if (window.FileReader) { // modern browser
			var filename = $(this)[0].files[0].name;
		} else { // old IE
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
			<h4 style="padding-top: 2%; padding-left: 50px;">새 작품 등록</h4>
			<hr>
			<form style="padding-left: 50px; padding-right: 50px;"
				action="<%=request.getContextPath()%>/novelEnroll.do"
				method="post" name="articleForm"
				onsubmit="iBeliveMe(); return false" enctype="multipart/form-data">
				<input style="border: none; padding-bottom: 0px;" type="text"
					name="title" class="form-control" placeholder="작품 제목">
				<hr>
				<span> &nbsp장르&nbsp&nbsp:&nbsp&nbsp <select name="genre">
						<option value="">장르 선택</option>
						<option value="무협">무협</option>
						<option value="판타지">판타지</option>
						<option value="로맨스">로맨스</option>
				</select> <span style="float: right; padding-right: 10px;"> 연재 방식 : <input
						type="radio" id="r1" name="chk_free" value="TRUE">무료 연재 <input
						type="radio" id="r2" name="chk_free" value="FALSE">유료 연재
				</span>
				</span>
				<hr>
				<div class="filebox">
					&nbsp메인 이미지&nbsp&nbsp:&nbsp&nbsp <input class="upload-name"
						value="파일선택" disabled="disabled" style="margin-bottom: .5rem;">
					<label for="novel_filename" style="padding: .5em .75em;">업로드</label> <input
						type="file" id="novel_filename" name="file"
						class="upload-hidden">
						
						
						<span style="float: right; margin-bottom: 0;">
					<select name="pay">
							<option value="0">편당 요금</option>
							<option value="100">100포인트</option>
							<option value="200">200포인트</option>
							<option value="300">300포인트</option>
							<option value="400">400포인트</option>
							<option value="500">500포인트</option>
					</select></span>
				</div>
				<hr>
				&nbsp작품 소개
				<textarea cols="30" rows="5" name="simpleContent" class="txtarea"
					style="height: 100px; width: 100%; margin-top: 5px;"></textarea>
				<button
					style="margin-left: 50%; margin-bottom: 20px; margin-top: 30px;"
					type="submit" class="te-button btn btn-warning btn-salmon">제출</button>
				<input type="hidden" name="nno" value="" />
			</form>
			<div class="novelPanel"
				style="margin-top: 20px; padding-top: 40px; position: relative; height: 100px; text-align: center;">
				<div style="padding-left: 6%;">
					<a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">©SalmonisDelicious</a>
					<span style="color: rgb(230, 230, 230); display: inline;">|</span>
					<span
						style="text-align: left; text-align: center; display: inline;"><a
						href="#" style="font-size: 60%; color: rgb(118, 118, 118)">고객센터</a></span>
				</div>
			</div>
		</div>
		<script>
		</script>
</body>

</html>