package demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistUserInfoToXML;
import dao.XMLOperateUser;

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		String name;
		String pwd;
		String againpwd;
		name = req.getParameter("username");
		pwd = req.getParameter("pwd");
		againpwd = req.getParameter("again_pwd");
		
		if(pwd!=againpwd) {
			pw.print("<html>"
			+"<head>"+"<title>注册失败</title>"+"</head>"
			+"<body>"
			+"<h1>"+"<a herf=\"javascript:;\" onClick=\"javascript:history.back(-1);\">两次输入的密码不一致!点击返回注册界面</a>"+"</h1>"
			+"</body>"
			+"</html>");
		}else {
			try {
				XMLOperateUser.AddClinetLoginUser(name, pwd);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.print("注册成功");
			pw.flush();
		}
	}
}
