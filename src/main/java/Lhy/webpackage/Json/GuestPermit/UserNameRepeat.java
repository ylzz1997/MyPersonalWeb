package Lhy.webpackage.Json.GuestPermit;

import Lhy.webpackage.bean.User;
import Lhy.webpackage.service.index.service_only.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lhy on 2018/7/10.
 */
@RestController
public class UserNameRepeat {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/checknamerepeat",method = RequestMethod.GET)
    public Map<String,String> check(@RequestParam("username") String userName){
        Map<String,String> status = new HashMap<String,String>();
        User user = new User();
        user.setUsername(userName);
        if(userService.findUserByName(user)==null){
            status.put("check","0");
        }else {
            status.put("check","1");
        }
        return status;
    }
}
