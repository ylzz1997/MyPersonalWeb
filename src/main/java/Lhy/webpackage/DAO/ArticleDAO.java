package Lhy.webpackage.DAO;

import Lhy.webpackage.bean.Article;
import Lhy.webpackage.bean.TCItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lhy on 2018/7/2.
 */
public interface ArticleDAO extends CrudRepository<Article,Integer> {
    @Query("select new Article(a.id,a.title, a.author, a.item, a.visitnum, a.date, a.tap) from Article a where a.item = ?1")
    List<Article> findByItemBreif(TCItem item);

    @Query("select new Article(a.id,a.title, a.author, a.item, a.visitnum, a.date, a.tap) from Article a where a.item = ?1")
    List<Article> findByItemBreif(TCItem item,Pageable pageable);

    @Query("select new Article(a.id,a.title, a.author, a.item, a.visitnum, a.date, a.tap) from Article a where a.item = ?1 order by a.id DESC")
    List<Article> findByItemBreifDESC(TCItem item,Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Article u set u.visitnum = ?1 where u.id = ?2")
    int UpdateVisById(int num,int id);
}
