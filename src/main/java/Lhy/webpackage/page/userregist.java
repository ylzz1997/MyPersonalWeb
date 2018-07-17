package Lhy.webpackage.page;

import Lhy.webpackage.POJO.HashUtil;
import Lhy.webpackage.bean.User;
import Lhy.webpackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lhy on 2018/7/10.
 */
@Controller
public class userregist {
    @Autowired
    UserService userService;
    @Autowired
    HashUtil hashUtil;
    @RequestMapping(value = "/userregist",method = RequestMethod.POST)
    public String regist(@RequestParam("username")String username , @RequestParam("password")String password,@RequestParam("email")String email, Model model){
        User user = new User();
        user.setUsername(username);
        user.setIndexname(username);
        user.setEmail(email);
        user.setPassword(hashUtil.getMD5(password));
        user.setFaceimg("/img/user/userNoFace.png");
        if(userService.saveUser(user)!=null){
            model.addAttribute("notice","注册成功");
            model.addAttribute("contence","注册成功,请登录后完善个人信息");
            model.addAttribute("atext","登录界面");
            model.addAttribute("href","/userupdown");
        };
        return "userReturn.html";
    }
}
