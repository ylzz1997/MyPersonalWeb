package Lhy.webpackage.page.technology;

import Lhy.webpackage.DAO.TCItemDAO;
import Lhy.webpackage.bean.Article;
import Lhy.webpackage.bean.TCItem;
import Lhy.webpackage.bean.TCcol;
import Lhy.webpackage.service.ArticleService;
import Lhy.webpackage.service.ItemService;
import Lhy.webpackage.service.TCItemHandle;
import Lhy.webpackage.service.TCcolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by lhy on 2018/6/25.
 */
@Controller
@RequestMapping("/technology")
public class technology {
    @Resource
    private ItemService TCItemService;
    @Autowired
    private TCItemHandle tcItemHandle;
    @Autowired
    private TCcolService tCcolService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping({"","/","/index","/index.html","/index.do","/index.jsp","/index.asp","/index.php"})
    public String index(Model model){
        List<TCItem> list = TCItemService.findAll();
        List<TCcol> listCol = tCcolService.findAllByOrder();
        listCol = tcItemHandle.renderAll(listCol);
        model.addAttribute("itemList",list);
        model.addAttribute("colList",listCol);
        return "teconology/Technology_index.html";
    }

    @RequestMapping("/{list}")
    public String articleList(@PathVariable(value = "list") String listName, @RequestParam(value = "page",defaultValue = "1")int page,Model model){
        int size = 10;
        long step = 10;
        TCItem item = TCItemService.findByName(listName);
        if(item==null){
            model.addAttribute("status",404);
            return "forward:/error.html";
        }
        model.addAttribute("item",item);
        List<Article> articleList = articleService.getBreifArByItemAtPage(item, page-1, size);
        long sumpage = articleService.getPage(size);
        model.addAttribute("sum",sumpage);
        model.addAttribute("articleList",articleList);
        model.addAttribute("page",page);
        long[] index = articleService.getStartToEnd(sumpage,page,step);
        model.addAttribute("index",index);
        return "teconology/Technology_list.html";
    }

    @RequestMapping("/{list}/{articleId}")
    public String article(@PathVariable(value = "list") String listName,@PathVariable(value = "articleId") int articleId, @RequestParam(value = "page",defaultValue = "1")int page,Model model){
        Article article = articleService.getArticle(articleId);
        if(article==null){
            model.addAttribute("status",404);
            return "forward:/error.html";
        }
        if(!article.getItem().getName().equals(listName)){
            model.addAttribute("status",404);
            return "forward:/error.html";
        }

        articleService.updateVinum(article.getVisitnum()+1,article.getId());
        model.addAttribute("article",article);
        return "teconology/Technology_article.html";
    }
}
