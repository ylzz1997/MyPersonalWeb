package Lhy.webpackage.page;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lhy on 2018/6/20.
 */

@Controller
@SpringBootApplication
public class index {

    @RequestMapping({"","/","/index","/index.html","/index.do","/index.jsp","/index.asp","/index.php"})
    public String index(){
        return "index.html";
    }

}
