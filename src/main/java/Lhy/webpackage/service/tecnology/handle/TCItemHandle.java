package Lhy.webpackage.service.tecnology.handle;

import Lhy.webpackage.bean.TCcol;
import Lhy.webpackage.service.tecnology.render.TCItemRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lhy on 2018/7/2.
 */
@Service
public class TCItemHandle {
    @Autowired
    private TCItemRender tcItemRender;

    public List<TCcol> renderAll(List<TCcol> items){
        items.forEach(item -> {
            item = (TCcol)tcItemRender.rendItem(item);
        });
        return items;
    }
}
