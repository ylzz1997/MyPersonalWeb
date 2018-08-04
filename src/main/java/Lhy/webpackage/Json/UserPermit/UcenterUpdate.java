package Lhy.webpackage.Json.UserPermit;

import Lhy.webpackage.POJO.HashUtil;
import Lhy.webpackage.bean.User;
import Lhy.webpackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lhy on 2018/7/29.
 */
@RestController
@RequestMapping("/UcenterUpdate")
public class UcenterUpdate {
    @Autowired
    private UserService userService;
    @Autowired
    private HashUtil hashUtil;

    @RequestMapping(name = "/password",method = RequestMethod.POST)
    public Map updatePassword(@RequestParam("password")String password, HttpSession session){
        Map res = new HashMap<String,String>();
        User user = new User();
        user.setId(((User)session.getAttribute("user")).getId());
        user.setPassword(hashUtil.getMD5(password));
       if(userService.updateUserPassword(user)){
            res.put("result","1");
       }else {
           res.put("result","0");
       }
       return res;
    }


}
