package Lhy.webpackage.page;

import Lhy.webpackage.POJO.HashUtil;
import Lhy.webpackage.bean.User;
import Lhy.webpackage.service.index.service_only.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by lhy on 2018/7/10.
 */
@Controller
public class userlogin {
    @Autowired
    UserService userService;
    @Autowired
    HashUtil hashUtil;

    @RequestMapping(value = "/userlogin",method = RequestMethod.POST)
    public String login(@RequestParam("username")String username , @RequestParam("password")String password, HttpSession session, Model model){
        String passwordHash  = hashUtil.getMD5(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordHash);
        User getUser = userService.findUserPassword(user);
        if(getUser!=null){
            session.setAttribute("user",getUser);
            model.addAttribute("notice","登录成功");
            model.addAttribute("contence","点击下面返回首页");
            model.addAttribute("atext","回到首页");
            model.addAttribute("href","/");
        }else {
            model.addAttribute("notice","登录失败");
            model.addAttribute("contence","密码错误!");
            model.addAttribute("atext","重新登录");
            model.addAttribute("href","/userupdown");
        }
        return "userReturn.html";
    }
}
