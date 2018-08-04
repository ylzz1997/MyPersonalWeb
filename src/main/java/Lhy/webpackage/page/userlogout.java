package Lhy.webpackage.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by lhy on 2018/7/10.
 */
@Controller
public class userlogout {

    @RequestMapping(value = "/userlogout")
    public String login(HttpSession session, Model model){
        session.removeAttribute("user");
        model.addAttribute("notice","注销成功");
        model.addAttribute("contence","已注销成功，点击按钮回到首页!");
        model.addAttribute("atext","回到上一页");
        model.addAttribute("href","javascript:void(0)");
        model.addAttribute("onclick","history.back(-1)");
        return "userReturn.html";
    }
}
