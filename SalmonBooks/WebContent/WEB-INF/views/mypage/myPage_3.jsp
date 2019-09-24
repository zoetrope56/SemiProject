<%@page import="novel.vo.NovelInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int size = 0;
	ArrayList<NovelInfo> novelList = (ArrayList<NovelInfo>) request.getSession().getAttribute("novelList");
	if (novelList == null || novelList.isEmpty()) {
		System.out.println("myContents : failed");
	} else {
		size = novelList.size();
	}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>myPage_userInfo</title>
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
</head>
<body>
	<div class="wrap">
		<form action="myPage_3.do" method="post">
			<div class="menu">
				<nav class="navbar navbar-expand-sm navbar-dark"
					style="background-color: #FF6F61;">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="index.jsp"
							style="color: #fff">Salmon Books</a></li>
					</ul>
				</nav>
			</div>
			<br>

			<div class="row" style="margin: 0px">
				<div class="col-sm-3" style="border: rgb(118, 118, 118)">
					<div class="container" style="font-size: 14px">
						<div class="list-group-flush">
							<a href="myPage.do"
								class="list-group-item list-group-item-action"  id="tab1">마이페이지
								홈</a> <a href="myPage_1.do"
								class="list-group-item list-group-item-action" id="tab2">회원정보
								관리</a> <a href="myPage_2.do"
								class="list-group-item list-group-item-action" id="tab3">구매
								내역</a> <a href="myPage_3.do"
								class="list-group-item list-group-item-action" id="tab4">내
								컨텐츠</a>
						</div>
					</div>
				</div>

				<div class="col-sm-8" style="border: rgb(118, 118, 118)">
					<div class="content" id="myContents">
						<div class="container">
							<h4>내 컨텐츠</h4>
							<hr>
							<span style="font-size: 14px;">회원님이 등록한 소설입니다</span><br><br>
							<c:forEach var="loop" items="${novelList}">
								<!-- ${loop.nno } -->
								<table class="table table-borderless">
									<tbody>
										<tr>
											<td
												style="text-align: center; width: 400px; background-color: rgb(250, 250, 250); padding: 7px; border: rgb(240, 240, 240) 1px solid">
												<a
												href="<%=request.getContextPath()%>/selectOne.do?nno=${loop.nno }" style="text-decoration: none; color : black">${loop.ntitle }</a>
											</td>
											<td
												style="border: rgb(240, 240, 240) 1px solid; padding: 7px;">
												<div class="btn btn-block"
													style="width: 80px; height: 30px; padding: 0; margin: 1px; font-size: 14px; background-color: #FF6F61; color: #FFFFFF; border: #FF6F61;">
													<a
														href="<%=request.getContextPath()%>/novelUpload.do?nno=${loop.nno }" style="vertical-align:middle; text-decoration: none; color : white">업로드</a>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</c:forEach>
							<button type="submit" class="btn" id="enroll" name="enroll"
								style="width: 120px; margin: 30px 0px 0px 400px; font-size: 14px; background-color: #FF6F61; color: #FFFFFF; border: #FF6F61;">소설
								등록하기</button>
						</div>
					</div>
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
		</form>
	</div>

</body>
</html>