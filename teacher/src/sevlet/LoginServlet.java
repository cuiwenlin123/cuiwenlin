package sevlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.imple.UserDaoImple;
import entity.User;

public class LoginServlet extends HttpServlet {

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
		User u = new User();
		u.setName(name);
		u.setPwd(pwd);
		// ��ѯ���ݿ�
		List<User> i = userDao.getAll(u);
		if (!i.isEmpty()) {
			req.getRequestDispatcher("update.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("show1.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
