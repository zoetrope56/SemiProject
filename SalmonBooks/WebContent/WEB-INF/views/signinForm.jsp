<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Salmon Books 회원가입</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/salmonbooks.css" />
    <link rel="stylesheet" href="/SalmonBooks/resource/css/custom.css">
    <style>
        body {
            background: rgb(241, 238, 238);
            height: 100vh;
            /* width: 100%; */
            /* margin: 0; */
        }

        .wrap {
            width: 960px;
            height: 100vh;
            min-width: 360px;
            margin: 0 auto 0;
            background: #fff
        }

        @media(max-width : 960px) {
            .wrap {
                width: 100%;
            }
        }

        .container {
            padding-right: 15px;
            padding-left: 15px;
            margin-right: auto;
            margin-left: auto;
            margin-bottom: auto;
        }

        .main {
            padding: 1rem 1rem;
            margin-bottom: 6rem;
            border-radius: .1rem;
        }

        .loginform {
            padding: 0% 22%;
            /* margin-bottom: 100% */
        }

        .foot {
            padding-top: 18px;
            margin-top: 80px;
            border-top: 1px solid #e6e6e6;
            /* font-family: '돋움',dotum,sans-serif; */
        }

        .type1 {
            margin-left: auto;
            margin-right: auto;
        }

        .h4 {
            display: inline-block;
            padding-left: 45%;
            margin-left: auto;
            margin-right: auto;
        }

        .btn-block {
            margin-left: auto;
            margin-right: auto;
        }   

        .inline-input {
            display: inline;
            margin-bottom: 2%;
        }
        span{
            font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,"Noto Sans",sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol","Noto Color Emoji";
            font-size: 10pt;
        }
    </style>

    <script>
    
    var idCheckFlag = false;
        window.onload = function () {
            var birth = document.getElementById("year");
            var month = document.getElementById("month");
            var day = document.getElementById("day");
            for (var i = 19; i >= 0; i--) {
                var option = document.createElement('option');
                var value = i < 10 ? '200' + i : '20' + i;
                option.value = value;
                option.innerHTML = value;
                birth.appendChild(option);
            }
            for (var i = 100; i >= 0; i--) {
                var option = document.createElement('option');
                var value = i < 10 ? '190' + i : '19' + i;
                // if( i < 10) {
                //     value = '190'+i;
                // }else{   x
                //     value = '19'+i;
                // }
                option.value = value;
                option.innerHTML = value;
                birth.appendChild(option);
            }
            for (var i = 1; i <= 12; i++) {
                var option = document.createElement('option');
                var value = i < 10 ? '0' + i : i;
                option.value = value;
                option.innerHTML = i;
                month.appendChild(option);
            }
            for (var i = 1; i <= 31; i++) {
                var option = document.createElement('option');
                var value = i < 10 ? '0' + i : i;
                option.value = value;
                option.innerHTML = i;
                day.appendChild(option);
            }
        }
        
        $(function(){
           $("#emailSelect").change(function(){
              if($(this).val() != ""){
                 $("input[name='emailBack']").val($(this).val());
              } else {
                 $("input[name='emailBack']").val("");
                 $("input[name='emailBack']").focus();
              }
           });
           
           $("#duplicateCheckButton").click(function(){
               if($("#id").val() == ""){
               alert("아이디를 입력해주세요.");
               $("#id").focus();
               return false;
                   }
               
               
               
               $.ajax({
                   url:"duplicateCheck.do",
                   type : "POST",
                   data:{
                      id : $("#id").val()
                       },
                   success : function(data){
                       if(data.result){
                          $("#duplicateMessage").html("중복된 아이디입니다.<br>");
                          idCheckFlag = false;
                        }else{
                           $("#duplicateMessage").html("사용가능한 아이디입니다.<br>");
                           idCheckFlag = true;
                        }
                    }
                });
            });
        });
        
        function fnFormCheck(){
            
            
            if($("#id").val() == ""){
               alert("아이디를 입력해주세요.");
               $("#id").focus();
               return false;
            }
            
            if($("#password").val() == ""){
               alert("비밀번호를 입력해주세요.");
               $("#password").focus();
               return false;
            }
            
            if($("#confirmPassword").val() == ""){
               alert("비밀번호 확인을 입력해주세요.");
               $("#confirmPassword").focus();
               return false;
            } else {
               if($("#password").val() != $("#confirmPassword").val()){
                  alert("비밀번호와 비밀번호 확인 값이 다릅니다.\n확인후 다시 입력해주세요.");
                   $("#password").focus();
                  return false;   
            }
            }
                  
                if($("#name").val() == ""){
                    alert("이름을 입력해주세요.");
                    $("#name").focus();
                    return false;
                }
                
                if($("#tel2").val() == ""){
                    alert("휴대폰번호를 입력해주세요.");
                    $("#tel2").focus();
                    return false;

                }
                
                if($("#tel3").val() == ""){
                    alert("휴대폰번호를 입력해주세요.");
                    $("#tel3").focus();
                    return false;
                }
                
                if($("#emailFront").val() == ""){
                    alert("이메일주소를 입력해주세요.");
                    $("#emailFront").focus();
                    return false;
                }
                
                if($("#emailBack").val() == ""){
                    alert("이메일주소를 입력해주세요.");
                    $("#emailBack").focus();
                    return false;
                }
             

            
      if(!idCheckFlag){
           alert("아이디 중복 체크를 해주세요.");
               return false;
         } 
           
           return true;
        }
     
    </script>
</head>

<body>
    <div class="titlebar">
        <div style="float: right;" onclick="{ this.innerHTML = 'logout';}"><a href="LoginPeage.html"
                style="text-decoration: none; color : white">Login</a></div>
        <div class="titlelogo"><a href="index.jsp" style="color: #fff; text-decoration: none;">Salmon Books</a></div>

    </div>
    <div id="login" class="wrap center-block">
        <div class="main" id="head">
            <h4 class="h4">회원가입</h4>
            <br>
            <form action="signin.do" method="post" onsubmit="return fnFormCheck();">
                <div
                style="margin-bottom: 5%; padding-left: 30%; margin-left: auto; margin-right: auto; display: inline-block;">
              <h6>아이디</h6>
              <input type="text" id= "id" name = "id"   class="inline-input">      
              <button type="button" id="duplicateCheckButton" class="btn btn-primary"
              onclick=""style="background-color: #FF6F61; color : #FFFFFF; border: #FF6F61; width : 20%;">중복체크</button>
              <br>
              <span id = "duplicateMessage"></span>
              
                <!----<span class="info">아이디 입력후'아이디 중복확인'버튼을 클릭해주세요</span> -->
                <br>
                <h6>비밀번호</h6>
                <input type="password"  id="password" name="password" class="inline-input">
                <!-- <span class="info">비밀번호는 4~10자리로 입력해주시기 바랍니다.</span>  -->
                <br>
                
                <h6>비밀번호 확인</h6>
                <input type="password" name="confirmPassword" id="confirmPassword" class="inline-input">
                <br>
                
                <h6>이름</h6>
                <input type="text" name ="name" id="name" class="inline-input">
                <!----<span class="info">아이디 입력후'아이디 중복확인'버튼을 클릭해주세요</span> -->
                <br>
                
                <h6>휴대폰번호</h6>
                <select type="number" style="height: 30px" name= "tel1">
                    <option>010</option>
                    
                </select>
               -
                <input name="tel2" id = "tel2"class="inline-input" maxlength="4" size="5" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/> -
                <input name="tel3" id = "tel3"class="inline-input" maxlength="4" size="5" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>


                <br>
                
                <h6>생년월일</h6>
                <select style="height: 30px" id="year" name ="year">
                </select>
                <select style="height: 30px" id="month" name = "month">
                </select>
                <select style="height: 30px" id="day" name = "day">
                </select>
                <br>
            <br>
                
                <h6>이메일 주소</h6>
                <input type="text" id="emailFront" name="emailFront" class="inline-input" size="15">
                @
                <input type="text" id="emailBack" name ="emailBack" class="inline-input" size="15">
                  <select id="emailSelect" style="height: 30px">
                    <option value="">직접입력</option>
                    <option value="naver.com">naver.com</option>
                    <option value="gmail.com">gmail.com</option>
                    <option value="daum.net">daum.net</option>
                </select>
                <br>

            </div>
            <p>
                <button type="submit" class="btn btn-block"
                    style="background-color: #FF6F61; color : #FFFFFF; border: #FF6F61; width : 40%;">회원가입</button>
            </p>
            </form>
        </div>
    </div>
</body>
</html>