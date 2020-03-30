package demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistUserInfoToXML;

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String name;
		String pwd;
		name = req.getParameter("username");
		pwd = req.getParameter("pwd");

		RegistUserInfoToXML re = new RegistUserInfoToXML();
		re.registuserinfo(name, pwd);
		PrintWriter pw = resp.getWriter();
		pw.print("×¢²á³É¹¦");
		pw.flush();
	}

}
