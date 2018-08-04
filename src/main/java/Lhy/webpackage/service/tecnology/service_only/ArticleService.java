package Lhy.webpackage.service.tecnology.service_only;

import Lhy.webpackage.DAO.ArticleDAO;
import Lhy.webpackage.bean.Article;
import Lhy.webpackage.bean.Item;
import Lhy.webpackage.bean.TCItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by lhy on 2018/7/2.
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleDAO articleDAO;

    public List<Article> getBreifArByItem(TCItem item){
        return articleDAO.findByItemBreif(item);
    }

    public List<Article> getBreifArByItemAtPage(TCItem item, int page, int size){
        Pageable pg = PageRequest.of(page,size);
        return articleDAO.findByItemBreif(item,pg);
    }

    public List<Article> getBreifArByItemAtPagedDESC(TCItem item, int page, int size){
        Pageable pg = PageRequest.of(page,size);
        return articleDAO.findByItemBreifDESC(item,pg);
    }

    public Article getArticle(int id){
        Optional<Article> articleOp = articleDAO.findById(id);
        if(articleOp.isPresent()){
            return articleOp.get();
        }else {
            return null;
        }
    }

    public long getCount(){
        return articleDAO.count();
    }

    public long getPage(int page){
        return (long)Math.ceil((double)articleDAO.count()/(double)page);
    }

    public long[] getStartToEnd(long sumPage,long thisPage,long step){
        long start,end;
        long halfStepCeil = (long)Math.ceil((double) step/2.00);
        long halfStepDown = (long)Math.floor((double) step/2.00);
        if((thisPage>halfStepDown)&&thisPage+halfStepCeil-1<sumPage){
            start = thisPage - halfStepCeil;
            end = thisPage+sumPage+halfStepDown-1;
        }else {
            if(thisPage<=halfStepDown){
                start = 1;
                end = step>=sumPage?sumPage:step;
            }else {
                start = thisPage-step+1>0?(thisPage-step+1):1;
                end = sumPage;
            }
        }

        return new long[]{start,end};
    }

    public int updateVinum(int num,int id){
       return articleDAO.UpdateVisById(num,id);
    }
}
