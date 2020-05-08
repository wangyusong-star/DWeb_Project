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
 * Servlet implementation class ViewProfitServlet
 */
@WebServlet("/ViewProfitServlet")
public class ViewProfitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		String offer;
		String profit;
		offer = req.getParameter("businessman");
		GoodsMethods c = new GoodsMethods();
		profit = c.Profit(offer);	
		req.setAttribute("profit",profit); 
        req.getRequestDispatcher("/view2.jsp").forward(req,resp); 
	}

}
