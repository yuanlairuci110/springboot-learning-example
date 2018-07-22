package org.spring.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lichao
 * @date 2018年07月22 17:43 说明：自定义过滤器
 */
public class MyFilterService implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("=======初始化过滤器=========");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		long start = System.currentTimeMillis();

		filterChain.doFilter(request, response);

		System.out.println("filter 耗时：" + (System.currentTimeMillis() - start));

	}

	@Override
	public void destroy() {
		System.out.println("=======销毁过滤器=========");
	}
}
