package Lhy.webpackage.service.index.service_only;

import Lhy.webpackage.DAO.GuestDAO;
import Lhy.webpackage.bean.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lhy on 2018/7/4.
 */
@Service
public class GuestStatisticService {
    @Autowired
    private GuestDAO guestDAO;

    public boolean save(Guest guest){
        if(guestDAO.save(guest)!=null)
            return true;
        else
            return false;
    }
}
