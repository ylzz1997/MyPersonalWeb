package Lhy.webpackage.page;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;

/**
 * Created by lhy on 2018/6/21.
 */
@Controller
@RequestMapping("/error")
public class error implements ErrorController {

    @RequestMapping
    public String error(HttpServletRequest request,Model model){
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        model.addAttribute("status",statusCode);
        return getErrorPath();
    }

    @Override
    public String getErrorPath() {
        return "error.html";
    }
}
