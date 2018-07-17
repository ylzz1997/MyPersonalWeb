package Lhy.webpackage.service;

import Lhy.webpackage.DAO.TCItemDAO;
import Lhy.webpackage.bean.TCItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhy on 2018/6/25.
 */
@Service
public class TCItemService implements ItemService{
    @Autowired
    private TCItemDAO dao;

    public List<TCItem> findAll(){
        List<TCItem> list = new ArrayList<TCItem>();
        Iterable<TCItem> iterable = dao.findAll();
        iterable.forEach(single -> list.add(single));
        return list;
    }

    @Override
    public TCItem findByName(String name) {
        return dao.findByName(name);
    }

}
