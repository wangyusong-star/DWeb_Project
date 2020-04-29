package demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Goods;
import dao.XMLOperateGoods;

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
		int num = 0;
		List<Goods> list = new ArrayList<Goods>();
		try {
			num = XMLOperateGoods.GoodsNum();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Goods good = new Goods();
		for(int i=1;i<num;i++) {
			try {
				good = XMLOperateGoods.QueryGoodById(i);
				if(good.getGoodname().equals(search)){
					list.add(good);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		req.setAttribute("searchgoods",list); 
        req.getRequestDispatcher("/searchresult.jsp").forward(req,resp); 
        
	}

}
