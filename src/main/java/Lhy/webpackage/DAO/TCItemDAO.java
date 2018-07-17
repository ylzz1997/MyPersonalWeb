package Lhy.webpackage.DAO;

import Lhy.webpackage.bean.TCItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by lhy on 2018/6/25.
 */
public interface TCItemDAO extends CrudRepository<TCItem,Integer> {
    @Query("select a from TCItem a where a.name = ?1")
    TCItem findByName(String name);
}
