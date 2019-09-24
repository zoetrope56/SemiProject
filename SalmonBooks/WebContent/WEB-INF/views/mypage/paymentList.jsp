<%@page import="payment.model.vo.Payment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mypage.command.MyPageTab2Handler" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<% ArrayList<Payment> list = (ArrayList<Payment>)request.getSession().getAttribute("list"); %>
<div class="outer" style="height:300px; margin-top:10px">
   <br>
   <h2 align="center">결제내역</h2>
   <br>
   <div class="tableArea">
      <table align="center" id="listArea">
         <tr>
            <th width="200px">구매일</th>
            <th width="100px">구분</th>
            <th width="200px">금액</th>
            <th width="200px">현재포인트</th>
            
         </tr>
         <% for(Payment p: list){ %>
         <tr>
            <td><%= p.getpDate() %></td>
            <td><%= p.getStatus() %></td>
            <td><%= p.getPoint() %></td>
            <td><%= p.getUserPoint() %></td>
            
         </tr>
         <% } %>
      </table>
   </div>
</div>