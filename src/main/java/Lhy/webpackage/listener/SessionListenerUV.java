package Lhy.webpackage.listener;

import Lhy.webpackage.bean.pv;
import Lhy.webpackage.bean.uv;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import Lhy.webpackage.service.uvService;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by lhy on 2018/6/26.
 */


@WebListener
public class SessionListenerUV implements HttpSessionListener {
    @Autowired
    uvService uvService;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        Date date = new Date();
        uv uvObj = uvService.findUv(date);
        if(uvObj!=null){
            uvObj.setCount(uvObj.getCount()+1);
            uvService.Update(uvObj);
        }else {
            uvService.save(new uv(1,date));
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
