package Lhy.webpackage.service.tecnology.render;

import Lhy.webpackage.bean.Item;
import Lhy.webpackage.service.strategy.ArticleItemContext;
import Lhy.webpackage.service.interfaces.ItemRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lhy on 2018/7/2.
 */
@Service
public class TCItemRender implements ItemRender {
    @Autowired
    private ArticleItemContext articleItemContext;
    private String pathname = "technology";
    @Override
    public Item rendItem(Item item) {
        if(item.isItem()){
            return articleItemContext.excuse(item,pathname);
        }else {
            return item;
        }
    }
}
