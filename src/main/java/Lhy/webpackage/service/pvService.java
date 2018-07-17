package Lhy.webpackage.service;

import Lhy.webpackage.DAO.pvDAO;
import Lhy.webpackage.bean.TCItem;
import Lhy.webpackage.bean.pv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by lhy on 2018/6/26.
 */

@Service
public class pvService {
    @Autowired
    private pvDAO pvDao;

    public pv findPv(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        pv Obj= pvDao.findByDate(sdf.format(date));
        if(Obj!=null){
            return Obj;
        }else{
            return null;
        }
    }

    public boolean save(pv Obj){
        if(pvDao.save(Obj)!=null){
            return true;
        }else {
            return false;
        }
    }

    public boolean Update(pv Obj){
        if(pvDao.UpdateById(Obj.getCount(),Obj.getDate())==1)
            return true;
        else
            return false;
    }

    public List<pv> getAll(){
        Iterable<pv> all = pvDao.findAll();
        List<pv> list = new ArrayList<pv>();
        all.forEach(single->{list.add(single);});
        return list;
    }
}
