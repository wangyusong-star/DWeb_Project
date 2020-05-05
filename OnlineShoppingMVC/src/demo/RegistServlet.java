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
		
		if(!pwd.equals(againpwd)) {//ȷ���������
			flag = 1;
		}
		if(choosecus != null && choosebus == null) {//�û�
			CustomerMethods c = new CustomerMethods();			
			boolean result = c.nameRepeat(name);
			if(result == true) {//�û��������ظ�������ע��
				flag = 2;
			}else {//ע��
				c.addInfo(name, pwd);
			}
			
		}
		
		if(choosebus != null && choosecus == null) {//�̼�
			BusinessMethods b = new BusinessMethods();	
			boolean result2 = b.nameRepeat(name);
			if(result2 == true) {
				flag = 2;
			}else {//ע��
				b.addInfo(name,pwd);
			}			
		}
		
		if(choosebus != null && choosecus != null) {//��������������
			flag = 3;
		}
		if(choosebus == null && choosecus == null) {//����û��������
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
		if(flag == 2) {//����û����Ѿ�����
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
