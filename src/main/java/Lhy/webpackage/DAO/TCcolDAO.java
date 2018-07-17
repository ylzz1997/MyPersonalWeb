package Lhy.webpackage.DAO;

import Lhy.webpackage.bean.TCItem;
import Lhy.webpackage.bean.TCcol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by lhy on 2018/6/26.
 */
public interface TCcolDAO extends CrudRepository<TCcol,Integer> {
    @Query(value = "select * from tecnocolunm order by `order` ASC",nativeQuery = true)
    List<TCcol> findAllSortByOrder();
}
