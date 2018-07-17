package Lhy.webpackage.service;

import Lhy.webpackage.DAO.UserDAO;
import Lhy.webpackage.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lhy on 2018/7/8.
 */
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public User findUserPassword(User user){
        return userDAO.findUserByPassword(user.getUsername(),user.getPassword());
    }

    public User findUserByName(User user){
        return userDAO.findUserByName(user.getUsername());
    }

    public User saveUser(User user){
        return userDAO.save(user);
    }
}
