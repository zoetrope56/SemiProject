<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
	Cookie[] cookie = request.getCookies();
	String saveId = "";
	String id = "";
	String pwd = "";
	if(cookie != null) {
		for(Cookie ck : cookie){
			if(ck.getName().trim().equals("saveId")){
				saveId = ck.getValue();
			}
		}
	}
	System.out.println("[loginForm] : "+id+" "+pwd);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Salmon Books 로그인</title>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
   href="/SalmonBooks/resource/css/myPage.css" />
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
a:active{
text-decoration: none;
color : white;
}
a{
text-decoration: none;
color : white;

}
</style>
<script>
function checkForm(){
    if($("#id").val() == ""){
         alert("아이디를 입력해주세요.");
         $("#id").focus();
       return false;
    }
    
    if($("#pwd").val() == ""){
        alert("비밀번호를 입력해주세요.");
        $("#pwd").focus();
        return false;
    }
   
    return true;
};

 </script>
</head>
<body>
   <div id="login" class="wrap">
      <div class="titlebar" id="head">
                <div class="titlelogo"><a href ="/SalmonBooks/">Salmon Books</a></div>
      </div>
      <div class="content loginform" id="content1">
         <form action="login.do" method="post" onsubmit="return checkForm();">
            <div class="form-group">
               <div id="loginID">
                  <!-- <label for="email">아이디 :</label> -->
                  <input type="text" class="form-control" id="id"
                     placeholder="아이디를 입력해주세요" name="id" value="<%if(saveId.length()>1) { out.println(saveId); } %>">
               </div>
            </div>
            <div class="form-group">
               <div id="loginID">
                  <input type="password" class="form-control" id="pwd"
                     placeholder="비밀번호를 입력해주세요" name="password">
                  <!-- <label for="pwd">비밀번호:</label> -->
               </div>
            </div>
            <div class="form-group form-check">
               <div class="row">
                  <div class="col" style="margin-left:30px;">
                     <label class="form-check-label"> <input
                        class="form-check-input" type="checkbox" name="saveId"<% if(saveId.length()>1) { out.println("checked"); } %> ><small>아이디
                           저장</small>
                     </label>
                  </div>
                  <!-- 
                  <div class="col-sm-4">
                     <label> <input class="form-check-input" type="checkbox"
                        name="autoLogin" <% if(id.length()>1&&pwd.length()>1) { out.println("checked"); } %> ><small>자동 로그인</small>
                     </label>
                  </div>
                   -->
               </div>
            </div>
            <button type="submit" class="btn btn-block "
               style="background-color: #FF6F61; color: #FFFFFF; border: #FF6F61">로그인</button>
         </form>
         <br>
         <div class="row">
            <div class="col-sm-1"></div>
            <div class="col" style="text-align: center">
               <a href="signin.do"
                  style="font-size: 80%; color: rgb(118, 118, 118)">회원가입</a>
            </div>
            <span class="txt_bar" style="color: rgb(230, 230, 230)">|</span>
            <div class="col" style="text-align: center">
               <a href="idSearch.do"
                  style="font-size: 80%; color: rgb(118, 118, 118)">아이디/비밀번호 찾기</a>
            </div>
            <div class="col-sm-1"></div>
         </div>
      </div>
      <div class="foot row">
         <div class="col" style="text-align: right">
            <a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">©SalmonisDelicious</a>
         </div>
         <span style="color: rgb(230, 230, 230)">|</span>
         <div class="col" style="text-align: left;">
            <a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">고객센터</a>
         </div>
      </div>
   </div>
</body>
</html>