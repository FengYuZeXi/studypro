package com.example.testfilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    /**
     * 专门用来拦截请求。可以做权限检查
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if(user == null){
            servletRequest.getRequestDispatcher("/admin/login.jsp").forward(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
