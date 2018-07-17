package Lhy.webpackage.Json.GuestPermit;

import Lhy.webpackage.service.WebStatisticCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lhy on 2018/6/27.
 */
@Controller
@RequestMapping("/guestStatistic")
public class GetGuestStatistic {
    @Autowired
    private WebStatisticCount webStatisticCount;

    @RequestMapping("/PvUv")
    public @ResponseBody Map<String,Integer> getPvAndUv(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        int dailyPv = webStatisticCount.dailyPv();
        int dailyUv = webStatisticCount.dailyUv();
        int sumUv = webStatisticCount.sumUv();
        int sumPv = webStatisticCount.sumPv();

        map.put("dailyPv",dailyPv);
        map.put("dailyUv",dailyUv);
        map.put("sumUv",sumUv);
        map.put("sumPv",sumPv);

        return map;
    }
}
