package ru.polovinko.springmvc.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Log4j2
@Component
@Order(1)
@Profile("filters")
public class SecurityFilter implements Filter {

    public static final String NAME_HEADER = "name";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter from SecurityFilter");
        Optional<String> nameHeader = Optional.ofNullable(((HttpServletRequest) servletRequest).getHeader(NAME_HEADER));
        if (nameHeader.filter("Leo"::equals).isPresent()) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
