/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.util;

/**
 *
 * @author depek
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

@WebFilter(filterName = "authenticationFilter", urlPatterns = {"/*"})

public class AuthenticationFilter implements Filter {

    @Autowired
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) resp;
            HttpSession session = request.getSession(false);

            String requestURI = request.getRequestURI();

            if (requestURI.indexOf("/admin") >= 0) {
                if (session != null && session.getAttribute("loggedInAdmin") != null) {
                    chain.doFilter(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/404");
                }
            } else if (requestURI.indexOf("/pacjent") >= 0) {
                if (session != null && session.getAttribute("loggedInPacjent") != null) {
                    chain.doFilter(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/404");
                }
            } else {
                chain.doFilter(request, response);
            }

        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
    }

    @Override
    public void destroy() {
    }
}
