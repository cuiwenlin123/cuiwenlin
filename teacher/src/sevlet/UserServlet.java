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
		// ��ȡ����
		String name = req.getParameter("name");
		// ��ȡ����
		String pwd = req.getParameter("pwd");
		// ʵ��������
		UserDao userDao = new UserDaoImple();
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		// ��ע������ݱ��浽���ݿ���
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
