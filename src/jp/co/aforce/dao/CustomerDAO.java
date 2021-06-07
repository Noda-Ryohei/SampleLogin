// p.380 list 24-03

package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.CustomerBean;

public class CustomerDAO extends DAO {

	public CustomerBean search (String login_id, String password) throws Exception {
		
		CustomerBean customer = null;
		
		Connection con = getConnection();
		
		PreparedStatement st;
		st = con.prepareStatement("select * from customer where login_id = ? and password = ?");
		st.setString(1, login_id);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			customer = new CustomerBean();
			customer.setId(rs.getInt("id"));
			customer.setLogin_id(rs.getString("login_id"));
			customer.setPassword(rs.getString("password"));
		}
		
		st.close();
		con.close();
		return customer;
		
	}
	
	public int register (CustomerBean customer) throws Exception {
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		
		String login_id = customer.getLogin_id();
		String password = customer.getPassword();
		
		PreparedStatement st = con.prepareStatement("insert into customer values(null, ?, ?)");
		st.setString(1, login_id);
		st.setString(2, password);
		st.executeUpdate();
		
		st = con.prepareStatement("select * from customer where login_id = ?");
		st.setString(1, login_id);
		ResultSet rs = st.executeQuery();
		int line = 0;
		while (rs.next()) {
			line++;
		}
		
		if (line == 1) {
			con.commit();
		} else {
			con.rollback();
		}
		
		con.setAutoCommit(true);
		
		st.close();
		con.close();
		
		return line;
	}
	
}
