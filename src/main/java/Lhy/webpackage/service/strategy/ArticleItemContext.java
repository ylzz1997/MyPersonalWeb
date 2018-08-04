package Lhy.webpackage.service.strategy;

import Lhy.webpackage.bean.Article;
import Lhy.webpackage.bean.Item;
import Lhy.webpackage.service.tecnology.service_only.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by lhy on 2018/7/2.
 */
@Service
public class ArticleItemContext {
    @Autowired
    private ArticleService articleService;

    public Item excuse(Item item){
        String rtnHTML;
        List<Article> arList = articleService.getBreifArByItemAtPagedDESC(item.getItem(),0,10);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(arList.size()!=0){
            rtnHTML ="<ul>";
            for(Article article : arList){
                rtnHTML +="<li><div class='col-lg-7 col-md-7 text-left'><a href='"+"/"+item.getItem().getName()+"/"+article.getId()+"'>"+ StringUtils.abbreviate(article.getTitle(),15)+"</a></div><div class='col-lg-5 col-md-5 hidden-sm hidden-xs text-right'"+ sdf.format(article.getDate())+"</div></li>";
            }
            rtnHTML +="</ul>";
        }else {
            rtnHTML ="<div class='text-center' style='font-size:40px'>暂无文章</div>";
        }
        item.setContain(rtnHTML);
        return item;
    }

    public Item excuse(Item item,String path){
        String rtnHTML;
        List<Article> arList = articleService.getBreifArByItemAtPagedDESC(item.getItem(),0,10);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(arList.size()!=0){
            rtnHTML ="<ul>";
            for(Article article : arList){
                rtnHTML +="<li><div class='col-lg-7 col-md-12 col-sm-12 col-xs-12 text-left'><a href='/"+path+"/"+item.getItem().getName()+"/"+article.getId()+"'>"+StringUtils.abbreviate(article.getTitle(),15)+"</a></div><div class='col-lg-5 hidden-md hidden-sm hidden-xs text-right'>"+ sdf.format(article.getDate())+"</div></li>";
            }
            rtnHTML +="</ul>";
        }else {
            rtnHTML ="<div class='text-center' style='font-size:40px'>暂无文章</div>";
        }
        item.setContain(rtnHTML);
        return item;
    }
}
