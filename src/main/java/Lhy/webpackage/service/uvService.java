package Lhy.webpackage.service;

import Lhy.webpackage.DAO.uvDAO;
import Lhy.webpackage.bean.uv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lhy on 2018/6/26.
 */

@Service
public class uvService {
    @Autowired
    private uvDAO uvDao;

    public uv findUv(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        uv Obj= uvDao.findByDate(sdf.format(date));
        if(Obj!=null){
            return Obj;
        }else{
            return null;
        }
    }

    public boolean save(uv Obj){
        if(uvDao.save(Obj)!=null){
            return true;
        }else {
            return false;
        }
    }

    public boolean Update(uv Obj){
        if(uvDao.UpdateById(Obj.getCount(),Obj.getDate())==1)
            return true;
        else
            return false;
    }

    public List<uv> getAll(){
        Iterable<uv> all = uvDao.findAll();
        List<uv> list = new ArrayList<uv>();
        all.forEach(single->{list.add(single);});
        return list;
    }
}
