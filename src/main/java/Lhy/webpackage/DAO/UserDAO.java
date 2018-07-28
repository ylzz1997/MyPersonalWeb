package Lhy.webpackage.DAO;

import Lhy.webpackage.bean.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lhy on 2018/7/8.
 */
public interface UserDAO extends CrudRepository<User,Integer> {
    @Query(value = "select u from User u where u.username = ?1 and u.password = ?2")
    User findUserByPassword(String username,String password);

    @Query(value = "select u from User u where u.username = ?1")
    User findUserByName(String username);

    @Transactional
    @Modifying
    @Query(value = "update User u set u.password = ?1 where u.id = ?2")
    User UpdateUserPassword(String password,int id);

    @Transactional
    @Modifying
    @Query(value = "update User u set u.email = ?1 where u.id = ?2")
    User UpdateUserEmail(String email,int id);

    @Transactional
    @Modifying
    @Query(value = "update User u set u.indexname = ?1 where u.id = ?2")
    User UpdateUserIndexname(String indexname,int id);
}
