package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daodb.CustomerMethods;
import daodb.GoodsMethods;

/**
 * Servlet implementation class AddShoppingCarServlet
 */
@WebServlet("/AddShoppingCarServlet")
public class AddShoppingCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter pw = resp.getWriter();
			String name;
			String goodname;
			String goodnum;

			name = req.getParameter("customername");
			goodname = req.getParameter("money");
			goodnum = req.getParameter("num");
			GoodsMethods c = new GoodsMethods();
			c.addtoShoppingCar(name,goodname,goodnum);
			pw.print("add success");
			req.getRequestDispatcher("/customercenter.jsp").forward(req,resp);
		}

}
