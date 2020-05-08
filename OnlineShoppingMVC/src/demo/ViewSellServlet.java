package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daodb.GoodsMethods;
import javabean.ShoppingRecord;

/**
 * Servlet implementation class ViewSellServlet
 */
@WebServlet("/ViewSellServlet")
public class ViewSellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		String offer;
		offer = req.getParameter("businessman");
		GoodsMethods c = new GoodsMethods();		
		List<ShoppingRecord> list = new ArrayList<ShoppingRecord>();
		list = c.SearchGoodsRecordForSpecificBusinessman(offer);
		pw.print("add success");
		req.setAttribute("goods",list); 
        req.getRequestDispatcher("/view.jsp").forward(req,resp); 
	}

}
