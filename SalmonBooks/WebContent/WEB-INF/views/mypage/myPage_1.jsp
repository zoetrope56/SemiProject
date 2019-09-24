<%@page import="auth.service.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ page import="mypage.command.MyPageHandler" %>
<%@ page import="member.model.Member" %>
<% Member member = (Member)request.getSession().getAttribute("member"); %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>myPage_userInfo</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/myPage.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="wrap">
    <form action="myPage_1.do" method="post">
        <div class="menu">
            <nav class="navbar navbar-expand-sm navbar-dark" style="background-color: #FF6F61;">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp" style="color: #fff">Salmon Books</a>
                    </li>
                </ul>
            </nav>
        </div><br>

        <div class="row" style="margin: 0px">
            <div class="col-sm-3" style="border: rgb(118, 118, 118)">
                <div class="container" style="font-size: 14px">
                    <div class="list-group-flush">
                        <a href="myPage.do" class="list-group-item list-group-item-action" id="tab1">마이페이지 홈</a>
                        <a href="myPage_1.do" class="list-group-item list-group-item-action" id="tab2">회원정보 관리</a>
                        <a href="myPage_2.do" class="list-group-item list-group-item-action" id="tab3">구매 내역</a>
                        <a href="myPage_3.do" class="list-group-item list-group-item-action" id="tab4">내 컨텐츠</a>
                    </div>
                </div>
            </div>

            <div class="col-sm-8" style="border: rgb(118, 118, 118)">
                <div class="content" id="userInfo" style="font-size: 14px">
                    <h4 style="margin-bottom: 23px">회원정보수정</h4>
                    
                    <table class="table table-borderless">
                        <tbody>
                            <tr>
                                <td style="text-align: right; width: 150px; background-color: rgb(250, 250, 250); border: rgb(240, 240, 240) 1px solid">이름</td>
                                <td style="border: rgb(240, 240, 240) 1px solid">
                                    <label><%=member.getName()%></label>
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: right; background-color: rgb(250, 250, 250); border: rgb(240, 240, 240) 1px solid">아이디</td>
                                <td style="border: rgb(240, 240, 240) 1px solid">
                                    <label><%=member.getUserId() %></label>
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: right; background-color: rgb(250, 250, 250); border: rgb(240, 240, 240) 1px solid">비밀번호 변경</td>
                                <td style="border: rgb(240, 240, 240) 1px solid">
                                    <input type="password" class="form-control" id="curPwd" name="curPwd" placeholder="현재 비밀번호를 입력해주세요" style="width: 250px; height: 30px; margin-bottom: 5px; font-size: 14px;">
                                    <input type="password" class="form-control" id="newPwd" name="newPwd" placeholder="새로운 비밀번호를 입력해주세요" style="width: 250px; height: 30px; margin-bottom: 5px; font-size: 14px;">
                                    <input type="password" class="form-control" id="newPwdConfirm" name="newPwdConfirm" placeholder="새로운 비밀번호를 확인" style="width: 250px; height: 30px; margin-bottom: 50px; font-size: 14px;">
                                    <!-- <button type="button" onclick="changePwd();" class="btn" style="width: 120px; height: 30px; padding: 0; font-size: 14px; background-color: #FF6F61; color: #FFFFFF; border: #FF6F61;">비밀번호 변경</button> -->
                                </td>
                                <script>
                                	function changePwd() {
                                		var curPwd = document.getElementById('curPwd');
                                		var newPwd = document.getElementById('newPwd');
                                		var newPwdConfirm = document.getElementById('newPwdConfirm');
                                		
                                		if(newPwd.value != newPwdConfirm.value){
                                			alert("비밀번호와 비밀번호 확인 값이 다릅니다.\n확인후 다시 입력해주세요.");
                                			$("#newPwd").focus();
                                			return false;   
                                		}
                                	}
                                </script>             
                            </tr>
                            <tr>
                                <td style="text-align: right; background-color: rgb(250, 250, 250); border: rgb(240, 240, 240) 1px solid">이메일</td>
                                <td style="border: rgb(240, 240, 240) 1px solid">
                                    <label id="userEmail" name="userEmail" style="width: 200px; height: 28px"><%=member.getEmail() %></label><br>
                                    <button id="emailBtn" name="emailBtn" type="button" onclick="changeEmail();" class="btn" style="width: 120px; height: 30px; padding: 0; font-size: 14px; background-color: #FF6F61; color: #FFFFFF; border: #FF6F61;">이메일 변경</button>
                                </td>
                                <script>
	                                function changeEmail(){
	                                    var userEmail = document.getElementById('userEmail');
	                                    var emailBtn = document.getElementById('emailBtn');
	                                    console.log(emailBtn);
	                                    
	                                    userEmail.innerHTML = '<input type="email" class="form-control" id="userEmail" name="userEmail" style="width: 250px; height: 30px; margin-bottom: 5px; font-size: 14px;">';
	                                    //emailBtn.innerHTML = '<button type="submit" onclick="alert("버튼바꿔달기성공");" class="btn" style="width: 120px; height: 30px; padding: 0; font-size: 14px; background-color: #FF6F61; color: #FFFFFF; border: #FF6F61;">이메일 변경</button>';
	                                    
	                                }
	                            </script>
                            </tr>                            
                            <tr>
                                <td style="text-align: right; background-color: rgb(250, 250, 250); border: rgb(240, 240, 240) 1px solid">전화번호</td>
                                <td style="border: rgb(240, 240, 240) 1px solid">
                                    <label id="userPhone" name="userPhone" style="width: 200px; height: 28px"><%=member.getTel()%></label><br>
                                    <button id="phoneBtn" name="phoneBtn" type="button" onclick="changePhone();" class="btn" style="width: 120px; height: 30px; padding: 0; font-size: 14px; background-color: #FF6F61; color: #FFFFFF; border: #FF6F61;">전화번호 변경</button>
                                </td>
                                <script>
                                    function changePhone(){
                                        var userPhone = document.getElementById('userPhone');
                                        var phoneBtn = document.getElementById('phoneBtn');
                                        
                                        userPhone.innerHTML = '<input type="text" class="form-control" id="userPhone" name="userPhone" style="width: 250px; height: 30px; font-size: 14px;">'
                                    }
                                </script>
                            </tr>
                        </tbody>
                    </table>
                    <button type="submit" class="btn" style="width: 120px; height: 30px; padding: 0; margin-left: 450px; font-size: 14px; background-color: #FF6F61; color: #FFFFFF; border: #FF6F61;">변경하기</button>         
                </div>
            </div>

        </div>

        <div class="foot row" style="margin-top: 15px;">
            <div class="col" style="text-align: right"><a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">©SalmonisDelicious</a></div>
            <span style="color: rgb(230, 230, 230)">|</span>
            <div class="col" style="text-align: left;"><a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">고객센터</a></div>
        </div>
    </form>
    </div>
</body>
</html>