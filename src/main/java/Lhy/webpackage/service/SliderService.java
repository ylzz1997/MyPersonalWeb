package Lhy.webpackage.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lhy on 2018/7/2.
 */
@Service
public class SliderService {
    private String filePath = "static/json/SliderConfig.json";

    public String getSliderJson()
    {
        Resource resource1 = new ClassPathResource(filePath);
        try {
            InputStream is = resource1.getInputStream();
            byte[] b = new byte[512];
            StringBuilder rts = new StringBuilder("");
            while (is.read(b)!=-1){
                rts.append(new String(b));
            }
            String rtb = rts.toString();
            rtb = rtb.replace("\u0001","");
            rtb = rtb.replace("\u0000","");
            return rtb;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
