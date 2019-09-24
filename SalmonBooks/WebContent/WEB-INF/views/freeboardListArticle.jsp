<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="/SalmonBooks/resource/css/salmonbooks.css" />
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

    <style>
        /* .titleMenuIcon:hover{
        animation-duration: 2s;
        animation-name: slidein;  
    } */
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
        .pbtnlist a{
        	color : #FF6F61;
        }
        
        .pbutton{
            background-color: white;
            border: 2px solid #FF6F61;
            color: #FF6F61;
            font-size:30px;

        }
        
        .pbtnlist{
            position:relative;
            margin-bottom: 20px;
            text-align: center;
            
        }

        .pbtnlist span{
            width:20%;
            padding:0 5px 0 0;
        }
        .w_btn{
    	margin-left:80%;
		}    		
		
		
    </style>
</head>

<body>
    <div class="titlebar">
        <div style="float: right;">
        
        <u:isLogin>
        <div class="dropdown">
                <a href="../logout.do" style="text-decoration: none; color : white">Logout</a>
                <div class="dropdown-content">
                    <a href="../myPage.do">마이페이지</a>
                    <a href="../payment.do">결제샵</a>
                </div>
            </div>
        </u:isLogin>
        <u:notLogin>
        	<a href="../login.do" style="text-decoration: none; color : white">Login</a>
        </u:notLogin>
        </div>
                <div class="titlelogo"><a href ="/SalmonBooks/">Salmon Books</a></div>
        <div class="titleMenu">
            <div class="titleMenuIcon"><a href="../">홈</a>
            </div>
            <div class="titleMenuIcon"><a href="../FreeNovelList.do?FREE=TRUE&COMPLATE=FALSE">무료</a></div>
            <div class="titleMenuIcon"><a href="../PayNovelList.do?FREE=FALSE&COMPLATE=FALSE">유료</a></div>
            <div class="titleMenuIcon"><a style="border-bottom: 5px solid bisque;" href = "list.do">커뮤니티</a>
                <div class="a"><a href="./list.do">자유게시판</a></div>                
                <div class="a"><a href="../reviewboard/list.do">감상평</a></div>
            </div>
        </div>
    </div>
    <div class="novelContainer">
        <div class="novelPanel" style="margin-top: 0px;">
        <c:if test ="${articlePage.hasNoArticles()}">
        	게시글이 없어!
        </c:if><br><br>
    
            <ul class="novelList" style="margin-top: 0px;">
            <c:forEach var="article" items="${articlePage.content }">
            	 <li class="novelListItem">
            	 <a href="read.do?no=${article.number }&page=${articlePage.currentPage}" style="color : black;">
            	   
            	   <table>
                        <tr>
                            <td rowspan="3"><img class="novelImage" src="/SalmonBooks/resource/image/lovebook2.png" style="width : 100px">
                            </td>
                            <td class="novelSubject"> 
                               <h4>&nbsp;[<c:out value =   "${article.category}"/>]<c:out value ="${article.title}"/><br><br></h4>
                                <p class="novelFont"></p>
                            </td>
                        </tr>
                        <tr>
                            <td class="novelFont"> &nbsp; ${article.writer.name } | 추천 0 | 조회 ${article.readCount } | ${article.regDate } </td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                        <tr></tr>
                    </table>
            	 </a>
                </li>
            </c:forEach>
            </ul>
            <br>
                <button type="button" class="w_btn" onclick="location.href = 'write.do'">글쓰기</button>
            <br>
         <div class="pbtnlist">
		<c:if test="${articlePage.hasArticles() }">
			<c:if test="${articlePage.startPage > 5 }">
			<a style = "color : black" href= "list.do?pageNo=${articlePage.startPage -5 }">이전</a>
			</c:if>
			<c:forEach var = "pNo" begin ="${articlePage.startPage }" end ="${articlePage.endPage }">
			<span><a class="pbutton" href="list.do?pageNo=${pNo }" >${pNo }</a></span>
			<c:if test="${articlePage.endPage < articlePage.totalPages }">
				<a href="list.do?pageNo=${articlePage.startPage +5 }"></a>
			</c:if>
			</c:forEach>
		</c:if>
        </div>  
            <div
                style="border-top: 1px solid gray; height : 10%; width : 50%; padding :5% 0% 5% 40%; margin-left: auto; margin-right : auto; background: white;">
                <div style="text-align: center; display: inline;">
                    <a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">©SalmonisDelicious</a></div>
                <span style="color: rgb(230, 230, 230); display: inline;">|</span>
                <div style="text-align: left; text-align: center;  display : inline;">
                    <a href="#" style="font-size: 60%; color: rgb(118, 118, 118)">고객센터</a></div>
            </div>
        </div>
        <div>
        </div>
    </div>
</body>

</html>