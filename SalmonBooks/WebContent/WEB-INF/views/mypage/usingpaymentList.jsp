<%@page import="usingpayment.model.vo.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mypage.command.MyPageTab2Handler"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% ArrayList<UsingPayment> usingpaymentlist = (ArrayList<UsingPayment>)request.getSession().getAttribute("usingpaymentlist"); %>

<div class="outer" style="height:300px; margin-top:10px">
	<br>
	<h2 align="center">소설구매내역</h2>
	<br>
	<div class="tableArea">
		<table align="center" id="listArea">
			<tr>
				<th width="200px">구매일</th>
				<th width="200px">제목</th>
				<th width="200px">회차</th>
				<th width="200px">금액</th>

			</tr>
			<% for(UsingPayment up: usingpaymentlist){ %>
			<tr>
				<td><%= up.getuDate() %></td>
				<td><%= up.getTitle() %></td>
				<td><%= up.getDno() %> 화</td>
				<td><%= up.getPay() %></td>

			</tr>
			<% } %>


		</table>
	</div>

</div>




