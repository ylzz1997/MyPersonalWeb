package Lhy.webpackage.DAO;

import Lhy.webpackage.bean.Guest;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lhy on 2018/7/4.
 */
public interface GuestDAO extends CrudRepository<Guest,Integer> {
}
