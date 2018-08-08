package Lhy.webpackage.POJO;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lhy on 2018/7/10.
 */
@Component
public class HashUtil {
    public String getMD5(String str) {
        return getStringHash("MD5",str);
    }

    public String getSHA1(String str) {
        return getStringHash("SHA1",str);
    }

    private String getStringHash(String type,String str){
        try {
            MessageDigest md = MessageDigest.getInstance(type);
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
