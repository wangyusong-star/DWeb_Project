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

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		String name;
		String pwd;
		String againpwd;
		String choosecus;
		String choosebus;
		int flag = 0;
		
		name = req.getParameter("username");
		pwd = req.getParameter("pwd");
		againpwd = req.getParameter("again_pwd");
		choosecus = req.getParameter("customer");
		choosebus = req.getParameter("businessman");
		
		Cookie cookie = new Cookie(name,pwd);
		cookie.setMaxAge(-1);
		resp.addCookie(cookie);	
		
		if(!pwd.equals(againpwd)) {//确认密码出错
			flag = 1;
		}
		if(choosecus != null && choosebus == null) {//用户
			CustomerMethods c = new CustomerMethods();			
			boolean result = c.nameRepeat(name);
			if(result == true) {//用户名输入重复，不可注册
				flag = 2;
			}else {//注册
				c.addInfo(name, pwd);
			}
			
		}
		
		if(choosebus != null && choosecus == null) {//商家
			BusinessMethods b = new BusinessMethods();	
			boolean result2 = b.nameRepeat(name);
			if(result2 == true) {
				flag = 2;
			}else {//注册
				b.addInfo(name,pwd);
			}			
		}
		
		if(choosebus != null && choosecus != null) {//勾了两个，报错
			flag = 3;
		}
		if(choosebus == null && choosecus == null) {//两个没勾，报错
			flag = 4;
		}
		if(flag == 1) {
			pw.print("<html>"
			+"<head>"+"<title>RegistFailed</title>"+"</head>"
			+"<body>"
			+"<h1>"+"<a herf=\"javascript:;\" onClick=\"javascript:history.back(-1);\">The two passwords are inconsistent! Click to return to the registration interface</a>"+"</h1>"
			+"</body>"
			+"</html>");
		}
		if(flag == 2) {//如果用户名已经存在
			pw.print("<html>"
			+"<head>"+"<title>RegistFailed</title>"+"</head>"
			+"<body>"
			+"<h1>"+"<a herf=\"javascript:;\" onClick=\"javascript:history.back(-1);\">Username is already exists!</a>"+"</h1>"
			+"</body>"
			+"</html>");
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
		if(flag == 0){
				resp.sendRedirect("login.jsp");
			}

	}
	
}
