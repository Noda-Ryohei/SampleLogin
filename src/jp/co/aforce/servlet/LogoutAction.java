package jp.co.aforce.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.tool.Action;

public class LogoutAction  extends Action {

	public String execute (HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("customer") != null) {
			session.removeAttribute("customer");
			return "/jsp/logout-out.jsp";
		}
		
		return "/jsp/logout-error.jsp";
	}
}
