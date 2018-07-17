package Lhy.webpackage.service;

import Lhy.webpackage.bean.TCItem;
import Lhy.webpackage.bean.pv;
import Lhy.webpackage.bean.uv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lhy on 2018/6/27.
 */

@Service
public class WebStatisticCount {
    @Autowired
    private pvService pvService;
    @Autowired
    private uvService uvService;

    public int dailyPv(){
        pv dpv = pvService.findPv(new Date());
        return dpv.getCount();
    }

    public int dailyUv(){
        uv duv = uvService.findUv(new Date());
        return duv.getCount();
    }

    public int sumPv(){
        List<pv> pvList = pvService.getAll();
        final int[] sum = {0};
        pvList.forEach(pv -> {
            sum[0] += pv.getCount();});

        return sum[0];
    }

    public int sumUv(){
        List<uv> uvList = uvService.getAll();
        final int[] sum = {0};
        uvList.forEach(uv -> {
            sum[0] += uv.getCount();});

        return sum[0];
    }
}
