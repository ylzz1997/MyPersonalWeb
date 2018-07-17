package Lhy.webpackage.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lhy on 2018/6/27.
 */

@Aspect
@Component
public class SessionAspect {
    @Pointcut("execution(* Lhy.webpackage.page..*.*(..))")
    public void allPage(){}

    @Before("allPage()")
    public void Before(JoinPoint joinPoint) throws Throwable {
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession();
    }
}
