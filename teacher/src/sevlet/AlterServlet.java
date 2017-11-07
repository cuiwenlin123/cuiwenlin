package sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.imple.UserDaoImple;
import entity.User;

public class AlterServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 获取姓名
		String name = req.getParameter("name");
		// 获取新密码
		String pwd = req.getParameter("pwd");
		// 实例化对象
		UserDao user = new UserDaoImple();
		User u = new User();
		u.setName(name);
		u.setPwd(pwd);
		// 修改数据
		int i = user.updade(u);
		if (i > 0) {
			req.getRequestDispatcher("alter1.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("alter2.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
