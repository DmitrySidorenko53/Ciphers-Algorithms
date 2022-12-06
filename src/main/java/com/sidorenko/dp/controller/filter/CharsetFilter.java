package com.sidorenko.dp.controller.filter;

import javax.servlet.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.LogRecord;

public class CharsetFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("requestEncoding");
        if (encoding == null) {
            encoding = String.valueOf(StandardCharsets.UTF_8);
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest, servletResponse);
        servletResponse.setContentType("text/html;charset=UTF-8");
    }

    @Override
    public void destroy() {

    }
}
