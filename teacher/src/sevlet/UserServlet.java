package sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.imple.UserDaoImple;
import entity.User;

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 获取姓名
		String name = req.getParameter("name");
		// 获取密码
		String pwd = req.getParameter("pwd");
		// 实例化对象
		UserDao userDao = new UserDaoImple();
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		// 将注册的数据保存到数据库中
		int i = userDao.save(user);
		if (i > 0) {
			req.setAttribute("user", user);
			req.getRequestDispatcher("show.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}

}
