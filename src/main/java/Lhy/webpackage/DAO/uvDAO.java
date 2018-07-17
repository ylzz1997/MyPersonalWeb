package Lhy.webpackage.DAO;

import Lhy.webpackage.bean.pv;
import Lhy.webpackage.bean.uv;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by lhy on 2018/6/26.
 */
public interface uvDAO extends CrudRepository<uv,Date> {
    @Transactional
    @Modifying
    @Query("update uv u set u.count = ?1 where u.date = ?2")
    int UpdateById(int count,Date date);

    @Query(value = "select * from uv where date = ?1",nativeQuery = true)
    uv findByDate(String date);
}
