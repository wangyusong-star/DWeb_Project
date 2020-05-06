package demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daodb.GoodsMethods;
import javabean.Goods;

/**
 * Servlet implementation class SearchGoodsServlet
 */
@WebServlet("/SearchGoodsServlet")
public class SearchGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String search;
		search = req.getParameter("search");
		Goods good = new Goods();
		GoodsMethods gm = new GoodsMethods();
		good = gm.SearchGoodsInfo(search);
		req.setAttribute("searchgoods",good); 
        req.getRequestDispatcher("/searchresult.jsp").forward(req,resp); 
	}

}
