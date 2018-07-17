package Lhy.webpackage.page;

import Lhy.webpackage.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by lhy on 2018/7/17.
 */
@Controller
public class usercenter {
    @RequestMapping("/usercenter")
    public String center(HttpSession session,Model model){
        User user = (User)session.getAttribute("user");
        if(user==null){
            model.addAttribute("notice","请登录！");
            model.addAttribute("contence","若要使用用户中心请先登录!");
            model.addAttribute("atext","登陆界面");
            model.addAttribute("href","/userupdown");
            return "userReturn.html";
        }
        return "usercenter.html";
    }
}
