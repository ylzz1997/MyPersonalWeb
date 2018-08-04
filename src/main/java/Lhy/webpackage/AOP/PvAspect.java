package Lhy.webpackage.AOP;

import Lhy.webpackage.bean.pv;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import Lhy.webpackage.service.index.service_only.pvService;

import java.util.Date;

/**
 * Created by lhy on 2018/6/26.
 */
@Aspect
@Component
public class PvAspect {
    @Autowired
    private pvService pvService;

    @Pointcut("execution(* Lhy.webpackage.page..*.*(..))")
    public void allPage(){}

    @Before("allPage()")
    public void Before(JoinPoint joinPoint) throws Throwable {
        Date date = new Date();
        pv pvObj = pvService.findPv(date);
        if(pvObj!=null){
            pvObj.setCount(pvObj.getCount()+1);
            pvService.Update(pvObj);
        }else {
            pvService.save(new pv(1,date));
        }
    }
    }
