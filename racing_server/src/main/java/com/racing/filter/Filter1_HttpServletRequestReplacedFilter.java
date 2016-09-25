package com.racing.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.racing.filter.base.BodyReaderHttpServletRequestWrapper;


/**
 * 转换HttpServlet 的过滤器
 * 
 * @author Leon
 * 
 */
@Component
@WebFilter(filterName = "httpServletRequestReplacedFilter", urlPatterns = "/*")
public class Filter1_HttpServletRequestReplacedFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    // 替换request对象，进行保留body内容，方便进行验签操作
    ServletRequest requestWrapper = null;
    if (request instanceof HttpServletRequest) {
      requestWrapper = new BodyReaderHttpServletRequestWrapper((HttpServletRequest) request);
    }
    if (null == requestWrapper) {
      chain.doFilter(request, response);
    } else {
      chain.doFilter(requestWrapper, response);
    }

  }

  @Override
  public void destroy() {

  }

}
