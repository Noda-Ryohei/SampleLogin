<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../header.html" %>

ようこそ、${customer.login_id}さん!  <!-- EL記法（テキスト第21章参照） -->
<p><a href="../jsp/logout.jsp">ログアウト画面へ</a></p>

<%@ include file="../footer.html" %>