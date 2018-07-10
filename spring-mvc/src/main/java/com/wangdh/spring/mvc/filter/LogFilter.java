package com.wangdh.spring.mvc.filter;

import org.slf4j.MDC;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/7/10 15:31
 * @Description:
 */
public class LogFilter implements Filter {
    private static String logKey = "";
    public void init(FilterConfig filterConfig) throws ServletException {
        logKey = filterConfig.getInitParameter("logKey");
        if(logKey == null || logKey==""){
            logKey = "defaultKey";
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MDC.put(logKey, UUID.randomUUID().toString().replace("-","").substring(0,10));

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
