package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daodb.CustomerMethods;

/**
 * Servlet implementation class ChangeBusinessmanInfo
 */
@WebServlet("/ChangeBusinessmanInfo")
public class ChangeBusinessmanInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		String name;
		String pwd;

		name = req.getParameter("businessname");
		pwd = req.getParameter("pwd");
		CustomerMethods c = new CustomerMethods();
		c.UpdatePassword(name,pwd);
		pw.print("add success");
		req.getRequestDispatcher("/businesscenter.jsp").forward(req,resp);
	}


}
