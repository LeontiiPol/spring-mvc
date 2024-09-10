package ru.polovinko.springmvc.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import ru.polovinko.springmvc.exception.InvalidNameHeaderException;

import static ru.polovinko.springmvc.filters.SecurityFilter.NAME_HEADER;

@Component
@Log4j2
public class PutDealInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle from PutDealInterceptor");
        if (!request.getHeader(NAME_HEADER).equalsIgnoreCase("Leo")) {
            throw new InvalidNameHeaderException("Name must be 'Leo'");
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle from PutDealInterceptor");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
