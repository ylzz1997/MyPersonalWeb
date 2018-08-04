package Lhy.webpackage.service.index.service_only;

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

    public boolean updateUserPassword(User user){
        if(userDAO.UpdateUserPassword(user.getPassword(),user.getId())!=0){
            return true;
        }else {
            return false;
        }
    }

    public boolean updateUserEmail(User user){
        if(userDAO.UpdateUserEmail(user.getEmail(),user.getId())!=0){
            return true;
        }else {
            return false;
        }
    }

    public boolean updateUserIndexname(User user){
        if(userDAO.UpdateUserIndexname(user.getIndexname(),user.getId())!=0){
            return true;
        }else {
            return false;
        }
    }
}
