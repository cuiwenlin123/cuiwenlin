package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

/*
 * ������
 */
public class NewsFilter implements Filter {
	private final Logger log = Logger.getLogger(NewsFilter.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// ʹ��log4j��¼ִ�й���
		log.info("����NewsFilter��doFilter()����");
		// �����ַ���
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// ��������������
		chain.doFilter(request, response);
		// ʹ��log4j��¼ִ�й���
		log.info("�˳�NewsFilter��doFilter()����");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
