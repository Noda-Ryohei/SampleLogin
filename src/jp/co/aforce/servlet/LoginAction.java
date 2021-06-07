// p.384 list 24-07
package jp.co.aforce.servlet;  //ただし多分これはサーブレットではない

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CustomerBean;
import jp.co.aforce.dao.CustomerDAO;
import jp.co.aforce.tool.Action;

public class LoginAction extends Action {

	public String execute (HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		String login_id = request.getParameter("login_id");
		String password = request.getParameter("password");
		CustomerDAO dao = new CustomerDAO();
		CustomerBean customer = dao.search(login_id, password);
		
		if (customer != null) {
			session.setAttribute("customer", customer);
			return "/jsp/login-out.jsp"; //ログイン成功ページへ(コンテキストルートからのパス)
		}
		
		session.setAttribute("login_id", login_id);
		return "/jsp/login.jsp"; //ログインエラーページへ
	}
}
