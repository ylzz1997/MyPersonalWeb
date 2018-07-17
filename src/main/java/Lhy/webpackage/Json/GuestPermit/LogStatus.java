package Lhy.webpackage.Json.GuestPermit;

import Lhy.webpackage.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lhy on 2018/7/10.
 */
@RestController
public class LogStatus {
    @RequestMapping("/getlogStatus")
    public Map<String,Object> getlogStatus(HttpSession session){
        Map<String,Object> rt = new HashMap<String,Object>();
        User user = (User)session.getAttribute("user");
        if(user==null){
            rt.put("status",0);
        }else {
            rt.put("status",1);
            user.setPassword(null);
            rt.put("user",user);
        }
        return  rt;
    }
}
