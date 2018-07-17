package Lhy.webpackage.DAO;

import Lhy.webpackage.bean.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by lhy on 2018/7/8.
 */
public interface UserDAO extends CrudRepository<User,Integer> {
    @Query(value = "select u from User u where u.username = ?1 and u.password = ?2")
    User findUserByPassword(String username,String password);

    @Query(value = "select u from User u where u.username = ?1")
    User findUserByName(String username);
}
