package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.XMLOperateUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		String name;
		String pwd;

		name = req.getParameter("username");
		pwd = req.getParameter("pwd");
/*	
		if() {
			pw.print("<html>"
			+"<head>"+"<title>ע��ʧ��</title>"+"</head>"
			+"<body>"
			+"<h1>"+"<a herf=\"javascript:;\" onClick=\"javascript:history.back(-1);\">������������벻һ��!�������ע�����</a>"+"</h1>"
			+"</body>"
			+"</html>");
		}else {
			try {
				XMLOperateUser.AddClinetLoginUser(name, pwd);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			pw.print("ע��ɹ�");
			pw.flush();
		}

}
