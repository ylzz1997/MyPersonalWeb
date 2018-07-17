package Lhy.webpackage.DAO;

import Lhy.webpackage.bean.pv;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

/**
 * Created by lhy on 2018/6/26.
 */
public interface pvDAO extends CrudRepository<pv,Date> {
    @Transactional
    @Modifying
    @Query("update pv u set u.count = ?1 where u.date = ?2")
    int UpdateById(int count,Date date);

    @Query(value = "select * from pv where date = ?1",nativeQuery = true)
    pv findByDate(String date);
}
