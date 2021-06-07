package jp.co.aforce.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.CustomerBean;
import jp.co.aforce.dao.CustomerDAO;
import jp.co.aforce.tool.Action;

public class RegisterAction extends Action {

	public String execute (HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
//		HttpSession session = request.getSession();
		
		CustomerBean customer = new CustomerBean();
		customer.setLogin_id(request.getParameter("login_id"));
		customer.setPassword(request.getParameter("password"));
		
		CustomerDAO dao = new CustomerDAO();
		
		int line = dao.register(customer);
		
		if (line == 1) {
			return "/jsp/register-out.jsp";
		}
		
		return "/jsp/register-error.jsp";
	
		} catch (Exception e) {
			return "/jsp/register-error.jsp";
		}
	}
}
