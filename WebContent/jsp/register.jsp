<!-- 会員登録ページ -->

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../header.html" %>

<form action="../jp.co.aforce.servlet/Register.action" method="post"> 
	
	<p>新規会員登録</p>
	<p>ID<input type="text" name="login_id"></p>
	<p>パスワード<input type="password" name="password"></p><!-- 再入力も実装したい -->
	<p><input type="submit" value="登録"></p>
	
</form>

<%@ include file="../footer.html" %>