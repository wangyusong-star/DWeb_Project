package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daodb.BusinessMethods;
import daodb.CustomerMethods;
import javabean.Businessman;
import javabean.Customer;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		String name;
		String pwd;
		String choosecus;
		String choosebus;
		int flag = 0;

		name = req.getParameter("username");
		pwd = req.getParameter("pwd");
		choosecus = req.getParameter("customer");
		choosebus = req.getParameter("businessman");
		
		//Cookie[] cookies = req.getCookies();

		/*if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(name) && cookies[i].getValue().equals(pwd)) {
					// 如果cookie与保存的相等，即找到cookie
					flag = 1;
					break;
				}
			}
		}*/ 
		

		Cookie cookie = new Cookie(name, pwd);
		cookie.setMaxAge(-1);
		resp.addCookie(cookie);
			
		if(choosecus != null && choosebus == null) {	//用户
			CustomerMethods c = new CustomerMethods();
			Customer cus = new Customer();
			
			boolean result = c.nameRepeat(name);
			if(result == false) {//如果用户不存在
				flag = 2;
			}else {
				cus = c.searchAll(name);
				if(cus.getCustomer_password().equalsIgnoreCase(pwd)) { //检查密码
					flag = 0;
				}else {
					flag = 1;
				}
			}			
		}
		
		if(choosebus != null && choosecus == null) {	//商家
			BusinessMethods b = new BusinessMethods();
			Businessman bus = new Businessman();
			
			boolean result2 = b.nameRepeat(name);
			if(result2 == false) {//如果用户不存在
				flag = 2;
			}else {
				bus = b.searchAll(name);
				if(bus.getBusiness_password().equalsIgnoreCase(pwd)) { //检查密码
					flag = 0;
				}else {
					flag = 1;
				}
			}			
		}
		
		if(choosebus != null && choosecus != null) {//勾了两个，报错
			flag = 3;
		}
		if(choosebus == null && choosecus == null) {//两个没勾，报错
			flag = 4;
		}
			
		if (flag == 1) {
			pw.print("<html>" + "<head>" + "<title>LoginFailed</title>" + "</head>" + "<body>" + "<h1>"
					+ "<a herf=\"javascript:;\" onClick=\"javascript:history.back(-1);\">Username or Passsword is wrong!</a>"
					+ "</h1>" + "</body>" + "</html>");
		}
		if (flag == 2) {
			pw.print("<html>" + "<head>" + "<title>LoginFailed</title>" + "</head>" + "<body>" + "<h1>"
					+ "<a herf=\"javascript:;\" onClick=\"javascript:history.back(-1);\">User not exist!</a>"
					+ "</h1>" + "</body>" + "</html>");
		}
		if (flag == 3) {
			pw.print("<html>" + "<head>" + "<title>LoginFailed</title>" + "</head>" + "<body>" + "<h1>"
					+ "<a herf=\"javascript:;\" onClick=\"javascript:history.back(-1);\">You can't choose two character!</a>"
					+ "</h1>" + "</body>" + "</html>");
		}
		if (flag == 4) {
			pw.print("<html>" + "<head>" + "<title>LoginFailed</title>" + "</head>" + "<body>" + "<h1>"
					+ "<a herf=\"javascript:;\" onClick=\"javascript:history.back(-1);\">Please choose one character!</a>"
					+ "</h1>" + "</body>" + "</html>");
		}
		
		if (flag == 0) {
			resp.sendRedirect("index.jsp");//成功
		}
		
	}

}
