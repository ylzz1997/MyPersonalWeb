package Lhy.webpackage.service;

import Lhy.webpackage.DAO.TCcolDAO;
import Lhy.webpackage.bean.TCcol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhy on 2018/7/2.
 */
@Service
public class TCcolService {
    @Autowired
    private TCcolDAO tCcolDAO;

    public List<TCcol> findAll(){
        Iterable<TCcol> all = tCcolDAO.findAll();
        List<TCcol> list = new ArrayList<TCcol>();
        all.forEach(single->{list.add(single);});
        return list;
    }

    public List<TCcol> findAllByOrder(){
        return tCcolDAO.findAllSortByOrder();
    }
}
