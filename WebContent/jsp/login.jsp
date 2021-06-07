

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../header.html" %>

<% 
String login_id = request.getParameter("login_id");
String message = "IDもしくはパスワードが違います。";
if (login_id == null) {
	login_id = "";
	message = "";
}
%>

<form action="../jp.co.aforce.servlet/Login.action" method="post"> 
	<p>ログイン</p>
	<p>ID<input type="text" name="login_id" value="<%=login_id %>"></p>	
	<p>パスワード<input type="password" name="password"></p>
	<p><input type="submit" value="ログイン"></p>
	<p><%=message %></p>
	
</form>

<p>会員登録は<a href="../jsp/register.jsp">こちら</a></p>

<%@ include file="../footer.html" %>

<!-- .actionファイルが開けない現象が多発していたが、いつの間にか何事もなく開けるようになった。 -->
<!-- 他のプロジェクトでは、まだうまくいかない。 -->
<!-- なぜできなかったのか、なぜできるようになったのかが謎なまま。 -->