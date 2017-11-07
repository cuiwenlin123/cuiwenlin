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
 * 过滤器
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
		// 使用log4j记录执行过程
		log.info("进入NewsFilter的doFilter()方法");
		// 设置字符集
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 继续请求处理流程
		chain.doFilter(request, response);
		// 使用log4j记录执行过程
		log.info("退出NewsFilter的doFilter()方法");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
