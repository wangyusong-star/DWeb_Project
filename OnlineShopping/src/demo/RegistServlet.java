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
			pw.print("<html>");pw.print("<head>");pw.print("<title>");pw.print("</head>");pw.print("<body>");pw.print("<h1>");pw.print("<a = herf>");
			pw.print("两次输入的密码不一致");
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
