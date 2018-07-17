package Lhy.webpackage.AOP;

import Lhy.webpackage.POJO.IPUtil;
import Lhy.webpackage.bean.Guest;
import Lhy.webpackage.service.GuestStatisticService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by lhy on 2018/7/4.
 */
@Aspect
@Component
public class IndexUserInformationAspect {
    @Autowired
   private GuestStatisticService guestStatisticService;
    @Autowired
    private IPUtil ipUtil;

    @Pointcut("execution(* Lhy.webpackage.page.index.index(..)) || execution(* Lhy.webpackage.page.technology.technology.index(..))")
    public void indexPage(){}

    @Before("indexPage()")
    public void Before(JoinPoint joinPoint) throws Throwable {
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Guest guest = new Guest();
        String ua = ipUtil.getUA(request);
        guest.setUa(ua);
        guest.setDate(new Date());
        String ip = ipUtil.getIpAddr(request);
        guest.setIp(ip);
        guest.setBrowser(ipUtil.getRequestBrowserInfo(ua));
        String system = ipUtil.getRequestSystemInfo(ua);
        guest.setSystem(system);
        guest.setProtocol(ipUtil.getProtocol(request));
        guest.setHostname(ipUtil.getHostName(request));
        guest.setServername(ipUtil.getServerName(request));
        guest.setDevice(ipUtil.getMobileOrPc(system));
        guest.setDevicename(ipUtil.getDeviceName(ua));
        new Thread(()->{
            guestStatisticService.save(guest);
        }).start();

    }
}
