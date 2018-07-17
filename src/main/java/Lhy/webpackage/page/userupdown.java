package Lhy.webpackage.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lhy on 2018/7/10.
 */

@Controller
public class userupdown {

    @RequestMapping("/userupdown")
    public String userupdown(){
        return "userupdown.html";
    }
}
