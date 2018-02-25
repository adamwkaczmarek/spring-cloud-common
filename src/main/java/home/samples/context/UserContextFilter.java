package home.samples.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UserContextFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserContextFilter.class);
    @Value("${spring.application.name}")
    String appName;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
        FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        UserContextHolder.getContext().setCorrelationId(  httpServletRequest.getHeader(UserContext.CORRELATION_ID) );
        LOGGER.debug("Incoming to {} Correlation id: {}",appName ,UserContextHolder.getContext().getCorrelationId());
        UserContextHolder.getContext().setAuthToken(httpServletRequest.getHeader(UserContext.AUTH_TOKEN));
        UserContextHolder.getContext().setUserId(httpServletRequest.getHeader(UserContext.USER_ID));

        filterChain.doFilter(httpServletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}