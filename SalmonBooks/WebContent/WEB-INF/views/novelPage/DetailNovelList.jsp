<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="novel.vo.NovelInfo"%>
<%@page import="novel.vo.PageInfo"%>
<%@page import="novel.vo.DetailNovel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<%	
 	NovelInfo ni = (NovelInfo)request.getAttribute("DetailNovel");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int nno = (int)request.getAttribute("nno");
	int listCount   = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage     = pi.getMaxPage();
	int startPage   = pi.getStartPage();
	int endPage     = pi.getEndPage();
	
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SalmonBooks</title>
<link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/DetailNovelPage.css" />
<link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/salmonbooks.css" />


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

.pagingArea button{
            background-color: white;
            border: 2px solid #FF6F61;
            color: #FF6F61;
            font-size:15px;
			width: 30px;
        	height: 25px;
        	margin-bottom: 20px;
        }		
		
</style>
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
    <input type="hidden" name="listCount" value=<%=listCount%> />
    <div class="novelContainer">
        <div id="infNovel" style="background: white; margin: 30px 0 0 0; color: black;">
            <table id = "detailInfNovel">
                <tr>
                    <td rowspan="3" style="width: 400px"><div style = "height: 100%"><img class="novelImage"  style="width: 400px; height: auto;" src=${DetailNovel.img}></div></td>
                    <td class="novelSubject">
                        <h1 style="font-family : 'Malgun Gothic';">${DetailNovel.ntitle}<br><br></h1>
                        <h2><p style="font-size:15px; font-family : 'Malgun Gothic'; width: 490px"> ${DetailNovel.nSimpContent}</p></h2>
                    </td>
                </tr>
                <tr>
                    <td class="novelFont" ><h2 style="color: gray">조회수 ${DetailNovel.nView}&nbsp|&nbsp${DetailNovel.genre}&nbsp|&nbsp${DetailNovel.nWriter}</h2></td>
                </tr>
                <tr>
                    <td><button onclick="location.href='<%= request.getContextPath() %>/ViewNovel.do?nno=<%=nno%>&dno=1&listcount=<%=listCount%>&free=<%=ni.getFree() %>'" style="border: 2px solid #FF6F61; color: #FF6F61; width: 20%; margin: auto; background: white;">첫화보기</button></td>
                </tr>
                <tr></tr>
            </table>
        </div>
     </div>
     <div class="novelContainer">
        <div style="background: white; margin: 30px 0 0 0;">        
            <ul class="novelList">
            	<c:forEach var="item" items="${dList}" varStatus="status">
	                <li>
	                	<a href = 'ViewNovel.do?nno=${item.nno}&dno=${item.dno}&listcount=<%=listCount%>&free=<%=ni.getFree() %>'>
	                    <table style="height: 150px; width: 100%;">
	                        <tr style="margin-top: 35px;">
	                            <td rowspan="3" style="width: 20%"><img src="${item.img}" style="width: 200px; height:auto;"></td>
	                        </tr>
	                        <tr>
	                        	<td style="height: 100px;">
	                                    <h3 style="font-family : 'Malgun Gothic'; padding-left: 15px ; color: gray">${item.dTitle}</h3>
	                            </td>
	                            <td style="text-align: right;">
	                                	<%-- <span style="color: #FF6F61">평점 ★  ${item.rate}</span> --%>&nbsp&nbsp&nbsp<span style="color: gray">${item.nDate}&nbsp</span>
	                            </td>
	                        </tr>
	                    </table>
	                	</a>
	                </li>              
    			</c:forEach>
            </ul>
       		<div class="pbtnlist">
            <%-- 페이지 처리 --%>
			<div class="pagingArea" align="center">
			<button  onclick="location.href='<%= request.getContextPath() %>/selectOne.do?nno=<%=request.getParameter("nno")%>&currentPage=1'"><<</button>
			<%  if(currentPage <= 1){  %>
			<button disabled><</button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/selectOne.do?nno=<%=request.getParameter("nno")%>&currentPage=<%=currentPage - 1 %>'"><</button>
			<%  } %>
			
			<% for(int p = startPage; p <= endPage; p++){
					if(p == currentPage){	
			%>
				<button disabled><%= p %></button>
			<%      }else{ %>
				<button onclick="location.href='<%= request.getContextPath() %>/selectOne.do?nno=<%=request.getParameter("nno")%>&currentPage=<%= p %>'"><%= p %></button>
			<%      } %>
			<% } %>
				
			<%  if(currentPage >= maxPage){  %>
			<button disabled>></button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/selectOne.do?nno=<%=request.getParameter("nno")%>&currentPage=<%=currentPage + 1 %>'">></button>
			<%  } %>
			<button onclick="location.href='<%= request.getContextPath() %>/selectOne.do?nno=<%=request.getParameter("nno")%>&currentPage=<%= maxPage %>'">>></button>
		
			</div>
        	</div>
        
        </div>
        
      
     </div>

	
</body>
</html>