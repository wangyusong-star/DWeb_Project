package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daodb.CustomerMethods;
import javabean.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		String name;
		String pwd;

		int num = 0;
		int flag = 0;

		name = req.getParameter("username");
		pwd = req.getParameter("pwd");

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
			CustomerMethods c = new CustomerMethods();
		try {
			num = c.tableNum();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Customer cus = new Customer();
		for (int i = 1; i < num; i++) {
			try {
				user = XMLOperateUser.QueryClinetLoginUserById(i);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (user.getUsername().equals(name) && user.getPassword().equals(pwd)) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			pw.print("<html>" + "<head>" + "<title>LoginFailed</title>" + "</head>" + "<body>" + "<h1>"
					+ "<a herf=\"javascript:;\" onClick=\"javascript:history.back(-1);\">Username or Passsword is wrong!</a>"
					+ "</h1>" + "</body>" + "</html>");
		}
		if (flag == 1) {
			resp.sendRedirect("index.jsp");
		}
	}

}
