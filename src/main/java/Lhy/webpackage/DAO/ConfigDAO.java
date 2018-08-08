package Lhy.webpackage.DAO;

import Lhy.webpackage.bean.Config;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by lhy on 2018/8/8.
 */
public interface ConfigDAO extends CrudRepository<Config,Integer> {
    @Transactional
    @Modifying
    @Query("update Config t set t.value = ?2 where t.key = ?1")
    int UpdateByKey(String key,String value);

}
