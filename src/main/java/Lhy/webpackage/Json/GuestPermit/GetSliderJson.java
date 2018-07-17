package Lhy.webpackage.Json.GuestPermit;

import Lhy.webpackage.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by lhy on 2018/7/2.
 */
@RestController
public class GetSliderJson {
    @Autowired
    SliderService sliderService;

    @RequestMapping("/sliderJson")
    public String sliderJson(){
        return sliderService.getSliderJson();
    }
}
