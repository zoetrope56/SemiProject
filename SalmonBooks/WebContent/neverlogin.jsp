1. naverlogin.jsp
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>네이버로그인</title>
  </head>
  <body>
  <%
    String clientId = "plOTolnnJ8nLVxRDzvck";
    String redirectURI = URLEncoder.encode("http://localhost:9923/SalmonBooks/callback.jsp", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 %>
  <a href="<%=apiURL%>"><img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
  <script src="https://nsp.pay.naver.com/sdk/js/naverpay.min.js"
    data-client-id="u86j4ripEt8LRfPGzQ8"
    data-mode="production"
    data-merchant-user-key="aaa"
    data-merchant-pay-key="bbb"
    data-product-name="ccc"
    data-total-pay-amount="1000"
    data-tax-scope-amount="1000" 
    data-tax-ex-scope-amount="0"
    data-return-url="사용자 결제 완료 후 결제 결과를 받을 URL">
</script>
  </body>
</html>