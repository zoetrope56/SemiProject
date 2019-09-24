<!DOCTYPE html>
<html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Salmon Books</title>
            <link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/salmonbooks.css" />
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
            <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
            <style>
                /* .titleMenuIcon:hover{
                animation-duration: 2s;
                animation-name: slidein;  
            } */

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


                /**/
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
                        background: white;
                        color:#FF6F61;
                        border:1px solid #FF6F61
                }

                

                body{
    background :rgb(241, 238, 238);
    width: 100%;
    margin: 0;
}
.titlebar{
    color : white;
	font-family : 'Malgun Gothic';
    text-align: center;
    position: relative;
    overflow: hidden;
    background: #FF6F61;
}
.titlelogo{
	font-family: cursive;
    font-size: 30px;
    color : white;
    padding: 30px;
}
.titleMenu{
		font-size : 25px; 
		width: auto;
}
.titleMenuIcon{
		    display: inline-block;
            margin: 0 5px 20px 20px;
}
.novelList{
            list-style: none;
}
.novelContainer{
        position : relative;
}
.advertisementImage{
  width:100%;
  height:auto;
  max-width:960px;
}
.novelPanel{
    width: 100%;    
    margin-top: 10px;
    background: white;
    font-family: 'AppleSDGothicNeo-Light', 'NanumGothic', 'Dotum', 'Helvetica', 'sans-serif';
}
.novelImage{
    width : 100%;
    max-width: 182px;
}
.novelFont{
    font-size: 10px; 
    color : gray;
    padding: 5px;
}
a{
    text-decoration: none;
    color : white;
}
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
@media only screen and (min-width: 769px) {
    .titlebar {
    position:static;
    overflow:visible;
    }
	.titleMenuIcon{
		display: inline-block;
        margin: 0 5px 20px 20px;
    }
}  
@media only screen and (min-width: 961px) {
    .titlebar{
        width:960px;
        margin-left:auto;
        margin-right:auto;
    }
    .titleMenu{
		position : relative;
		color : white;
		font-family : 'Malgun Gothic';
		font-size : 25px; 
		width: auto;
	}
	.titleMenuIcon{
		    display: inline-block;
            margin: 0 5px 20px 20px;
	}
    .novelContainer{
        width: 960px;
        margin-left:auto;
        margin-right:auto;
    }
    .novelContainer div{
        width: 100%;
    }
    img{
        display: inline-block;
    }
    .list{
        position: relative; 
        left: 20%;
        width: 20%; 
        display: inline-block;
    }
    .novelListItem{ 
        height : 100%;
    }
    .novelSubject{
        padding :5px;
    }
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
            <div class="titlebar" id="test">
                <div style="float: right;" onclick="{ this.innerHTML = 'logout';}"><a href="LoginPage.html"
                        style="text-decoration: none; color : white">Login</a></div>
                <div class="titlelogo">Salmon Page</div>
                <div class="titleMenu">
                    <div class="titleMenuIcon"><a>홈</a></div>
                    <div class="titleMenuIcon"><a style="border-bottom: 5px solid bisque;">무료</a>
                        <div class="a">무협</div>
                        <div class="a">판타지</div>
                        <div class="a">로맨스</div>
                    </div>
                    <div class="titleMenuIcon"><a>유료</a></div>
                    <div class="titleMenuIcon"><a>완결</a></div>
                    <div class="titleMenuIcon"><a>커뮤니티</a>
                    </div>
                    <div class="titleMenuIcon"><a>고객센터</a></div>
                </div>
            </div>

            <div class="novelContainer">                
                <div class="novelPanel" style="margin-top: 30px; position: relative;">
                    <h4 style="padding-top: 2%; padding-left: 50px;">새 작품 쓰기</h4>
                    <hr>
                    <form style="padding-left: 50px; padding-right: 50px;" action="write.do" method="post" name="articleForm" onsubmit="iBeliveMe(); return false">
                        <input style="border: none; padding-bottom: 0px;" type="text" name = "title" class="form-control"  placeholder="작품 제목">
                        <hr>
                            <span>
                            &nbsp장르&nbsp&nbsp:&nbsp&nbsp   
                                <select name="category">
                                    <option value="">장르 선택</option>
                                    <option value="무협">무협</option>
                                    <option value="판타지">판타지</option>
                                    <option value="로맨스">로맨스</option>
                                </select>
                                
                                <span style="float: right; padding-right: 10px;">
                                    연재 방식 : 
                                    <input type="radio" name="chk_free" value="HTML">무료 연재
                                    <input type="radio" name="chk_free" value="CSS">유료 연재
                                </span>             
                            </span>
                            <hr>
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
                                </select>
                        </form>
                        <div class="novelContainer" style="margin-top: 20px; padding-left: 50px; padding-right: 50px;">
                            

                            <button class="te-button btn btn-warning btn-salmon" id="selectAll">전체선택</button>
                            <button class="te-button btn btn-warning btn-salmon" id="bold">굵게</button>
                            <button class="te-button btn btn-warning btn-salmon" id="italic">기울임</button>
                            <button class="te-button btn btn-warning btn-salmon" id="underLine">밑줄</button>
                            <button class="te-button btn btn-warning btn-salmon" id="justifyLeft">왼쪽정렬</button>
                            <button class="te-button btn btn-warning btn-salmon" id="justifyCenter">가운데정렬</button>
                            <button class="te-button btn btn-warning btn-salmon" id="justifyRight">오른쪽정렬</button>
                            <div id="text" contenteditable="true" style="width:100%; padding : 0px; height: 400px; margin-top:20px; margin-left: auto; margin-right: auto;">텍스트편집기</div>
                            <textarea name= "content" rows="" cols="" style="visibility: hidden;"></textarea>
                            <button style="margin-left: 20%; margin-bottom: 20px;" type="submit" class="te-button btn btn-warning btn-salmon"  onclick="">제출</button>
                                
                        </div>
                    
            </div>
        </body>	
        </html>