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
 * Servlet implementation class UpdateGoodsInfoServlet
 */
@WebServlet("/UpdateGoodsInfoServlet")
public class UpdateGoodsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		String name;
		String price;
		String stock;
		String state;
		String describe;
		

		name = req.getParameter("name");
		price = req.getParameter("price");
		stock = req.getParameter("stock");
		state = req.getParameter("state");
		describe = req.getParameter("describe");
		GoodsMethods c = new GoodsMethods();		
		c.UpdateGoods(name,price,stock,state,describe);
		pw.print("add success");
		req.getRequestDispatcher("/businesscenter.jsp").forward(req,resp);
	}

}
