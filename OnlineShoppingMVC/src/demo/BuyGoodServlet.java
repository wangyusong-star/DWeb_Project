package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daodb.GoodsMethods;

/**
 * Servlet implementation class BuyGoodServlet
 */
@WebServlet("/BuyGoodServlet")
public class BuyGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		String name;
		String goodname;
		String num;
		name = req.getParameter("customername");
		goodname = req.getParameter("goodname");
		num = req.getParameter("num");
		GoodsMethods c = new GoodsMethods();
		c.Buy(name,goodname,num);
		pw.print("add success");
		req.getRequestDispatcher("/customercenter.jsp").forward(req,resp);
	}

}
