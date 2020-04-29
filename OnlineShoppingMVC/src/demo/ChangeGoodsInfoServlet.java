package demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeGoodsInfoServlet
 */
public class ChangeGoodsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();

		String goodname;
		String price;
		String stock;
		String state;
		String describe;
		
		goodname = req.getParameter("goodname");
		price = req.getParameter("price");
		stock = req.getParameter("stock");
		state = req.getParameter("state");
		describe = req.getParameter("describe");

		
		int num = 0;
		int flag = 0;
		try {
			num = XMLOperateGoods.GoodsNum();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Goods good = new Goods();
		for(int i = 1;i < num;i ++) {
			try {
				good = XMLOperateGoods.QueryGoodById(i);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(good.getGoodname().equals(goodname)) {	//判断用户是否存在，若存在则修改
					try {
						XMLOperateGoods.AddGoods(goodname, price, stock, state, describe);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				pw.print("Update Success!");
				flag = 1;
				break;
				}
		}



		if(flag == 0) {
			pw.print("<html>"
			+"<head>"+"<title>Failed</title>"+"</head>"
			+"<body>"
			+"<h1>"+"<a herf=\"javascript:;\" onClick=\"javascript:history.back(-1);\">Goodname do not exist or other Unexception</a>"+"</h1>"
			+"</body>"
			+"</html>");
		}
	}
}
