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
		String name;
		String pwd;
		String againpwd;
		name = req.getParameter("username");
		pwd = req.getParameter("pwd");
		againpwd = req.getParameter("again_pwd");
		
		if(pwd!=againpwd) {
			//MyDefaultHandle de = new MyDefaultHandle();
		}
		
		try {
			XMLOperateUser.AddClinetLoginUser(name, pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		PrintWriter pw = resp.getWriter();
		pw.print("×¢²á³É¹¦");
		pw.flush();
	}

}
