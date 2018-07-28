package Lhy.webpackage.AOP;

import Lhy.webpackage.bean.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by lhy on 2018/7/28.
 */
@Aspect
@Component
public class UserPermitAspect {
    @Pointcut("execution(* Lhy.webpackage.Json.UserPermit..*.*(..))")
    public void userAspect(){}

    @Around("userAspect()")
    public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null){
            return joinPoint.proceed();
        }else {
            ModelAndView model = new ModelAndView("userReturn.html");

            model.addObject("notice","403");
            model.addObject("contence","非法访问");
            model.addObject("atext","回到上一页");
            model.addObject("href","javascript:void(0)");
            model.addObject("onclick","history.back(-1)");
            return model;
        }
    }
}
