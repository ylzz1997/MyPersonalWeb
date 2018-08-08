package Lhy.webpackage.POJO;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lhy on 2018/7/4.
 */
@Component
public final class IPUtil {
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (ip!= null && !"".equals(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (ip!= null && !"".equals(ip)  && !"unknown".equalsIgnoreCase(ip)) {
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

    public String getRequestBrowserInfo(HttpServletRequest request){
        String header = request.getHeader("user-agent");
        return getRequestBrowserInfo(header);
    }

    public String getRequestBrowserInfo(String header){
        String browserVersion = null;
        if(header == null || header.equals("")){
            return "未知内核的浏览器";
        }
        if(header.indexOf("baidubrowser")>0){
            browserVersion = "百度浏览器";
        }else if(header.indexOf("UBrowser")>0){
            browserVersion = "UC浏览器";
        }else if(header.indexOf("Maxthon")>0){
            browserVersion = "Maxthon";
        }else if(header.indexOf("MicroMessenger")>0){
            browserVersion = "微信";
        }else if(header.indexOf("MetaSr")>0){
            browserVersion = "搜狗浏览器";
        }else if(header.indexOf("masscan")>0){
            browserVersion = "Masscan端口探测";
        }else if(header.indexOf("WAP-Browser")>0){
            browserVersion = "WAP浏览器(功能机)";
        }else if(header.indexOf("python-requests")>0){
            browserVersion = "Python爬虫/自制浏览器";
        }else if(header.indexOf("Edge")>0){
            browserVersion = "MicrosoftEdge";
        }else if(header.indexOf("TaoBrowser")>0){
            browserVersion = "淘宝客户端";
        }else if(header.indexOf("LBBROWSER")>0){
            browserVersion = "猎豹浏览器";
        }else if(header.indexOf("QQ")>0 || header.indexOf("TIM")>0){
            if(header.indexOf("MQQBrowser")>0){
                browserVersion = "QQ内嵌的浏览器";
            }else if(header.indexOf("QQBrowser")>0){
                browserVersion = "QQ浏览器";
            }else{
                browserVersion = "QQ内嵌的浏览器";
            }
        }else if(header.indexOf("Opera")>0){
            browserVersion = "Opera";
        }else if(header.indexOf("Chrome")>0){
            browserVersion = "Chrome";
        }else if(header.indexOf("Firefox")>0){
            browserVersion = "Firefox";
        }else if(header.indexOf("Safari")>0){
            browserVersion = "Safari";
        }else if(header.indexOf("MSIE")>0){
            browserVersion = "IE6/7/8/9/10";
        }else if(header.indexOf("Camino")>0){
            browserVersion = "Camino";
        }else if(header.indexOf("rv:11.0")>0){
            browserVersion = "IE11";
        }else if(header.indexOf("Konqueror")>0){
            browserVersion = "Konqueror";
        }else if(header.indexOf("like Gecko")>0){
            browserVersion = "Like Gecko";
        }else {
            browserVersion = header;
        }
        return browserVersion;
    }

    public String getRequestSystemInfo(HttpServletRequest request){
        String header = request.getHeader("user-agent");
        return getRequestSystemInfo(header);
    }

    public String getRequestSystemInfo(String header){
        String systenInfo = null;
        if(header == null || header.equals("")){
            return "未知内核的系统";
        }
        //得到用户的操作系统
        if (header.indexOf("NT 6.0") > 0){
            systenInfo = "Windows Vista / Windows Server 2008";
        }else if (header.indexOf("Windows 3.1") > 0){
            systenInfo = "Windows 3.1";
        }else if (header.indexOf("NT 5.2") > 0){
            systenInfo = "Windows XP 64Bit / Windows Server 2003";
        } else if (header.indexOf("NT 5.1") > 0){
            systenInfo = "Windows XP    ";
        }else if (header.indexOf("NT 6.1") > 0){
            systenInfo = "Windows 7 / Windows Server 2008 R2";
        } else if (header.indexOf("NT 6.2") > 0){
            systenInfo = "Windows 8 / Windows Server 2012";
        } else if (header.indexOf("NT 6.3") > 0){
            systenInfo = "Windows 8.1 / Windows Server 2012 R2";
        } else if (header.indexOf("NT 5") > 0){
            systenInfo = "Windows 2000";
        } else if (header.indexOf("NT 4") > 0){
            systenInfo = "Windows NT4";
        } else if(header.indexOf("iPhone")>0){
            systenInfo = "IOS(iPhone)";
        } else if(header.indexOf("iPod")>0){
            systenInfo = "IOS(iPod)";
        } else if(header.indexOf("iPad")>0){
            systenInfo = "IOS(iPad)";
        }else if (header.indexOf("Mac") > 0){
            systenInfo = "MacOS";
        } else if (header.indexOf("Unix") > 0){
            systenInfo = "UNIX";
        } else if(header.indexOf("Android")>0){
            systenInfo = "Android";
        } else if (header.indexOf("Linux") > 0){
            systenInfo = "Linux";
        } else if (header.indexOf("SunOS") > 0){
            systenInfo = "SunOS";
        } else if(header.indexOf("FreeBSD") > 0){
            systenInfo = "FreeBSD";
        } else if(header.indexOf("NT 6.4") > 0){
            systenInfo = "Windows 10";
        } else if(header.indexOf("NT 10.0") > 0){
            systenInfo = "Windows 10";
        } else if (header.indexOf("Me") > 0){
            systenInfo = "Windows Me";
        } else if (header.indexOf("98") > 0){
            systenInfo = "Windows 98";
        } else if (header.indexOf("95") > 0){
            systenInfo = "Windows 95";
        }else {
            systenInfo = header;
        }
        return systenInfo;
    }

    public String getDeviceName(String header){
        String systenInfo = null;
        if(header == null || header.equals("")){
            return "未知设备";
        }
        if (header.indexOf("OPPO") > 0){
            systenInfo = "Oppo手机";
        } else if(header.indexOf("VIVO") > 0){
            systenInfo = "VIVO手机";
        }else if(header.indexOf("Lenovo") > 0){
            systenInfo = "联想手机";
        }else if(header.indexOf("SM-") > 0){
            systenInfo = "三星手机";
        }else if(header.indexOf("iPhone") > 0){
            systenInfo = "IPhone手机";
        }else if(header.indexOf("iPad") > 0){
            systenInfo = "IPad平板";
        }else if(header.indexOf("iPod") > 0){
            systenInfo = "IPod";
        }else {
            systenInfo = "桌面设备";
        }
        return systenInfo;
    }

    public String getMobileOrPc(String item){
        String rtn = "";
            if(item.indexOf("IOS")>-1 || item.equals("Android"))
                rtn = "移动设备";
            else
                rtn = "桌面设备";
        return rtn;
    }

    public String getHostName(String ip){
        InetAddress inet;
        try {
            inet = InetAddress.getByName(ip);
            return inet.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getHostName(HttpServletRequest request){
        return request.getRemoteHost()==null?"":request.getRemoteHost();
    }

    public String getProtocol(HttpServletRequest request){
        return request.getProtocol()==null?"": request.getProtocol();
    }

    public String getServerName(HttpServletRequest request){
        return request.getServerName()==null?"":request.getServerName();
    }

    public String getUA(HttpServletRequest request){
        return request.getHeader("user-agent")==null?"":request.getHeader("user-agent");
    }


    private String callCmd(String[] cmd) {
        String result = "";
        String line = "";
        try {
            Process proc = Runtime.getRuntime().exec(cmd);
            InputStreamReader is = new InputStreamReader(proc.getInputStream());
            BufferedReader br = new BufferedReader(is);
            while ((line = br.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    private String callCmd(String[] cmd,String[] another) {
        String result = "";
        String line = "";
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(cmd);
            proc.waitFor();
            proc = rt.exec(another);
            InputStreamReader is = new InputStreamReader(proc.getInputStream());
            BufferedReader br = new BufferedReader (is);
            while ((line = br.readLine ()) != null) {
                result += line;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private String filterMacAddress(final String ip, final String sourceString,final String macSeparator) {
        String result = "";
        String regExp = "((([0-9,A-F,a-f]{1,2}" + macSeparator + "){1,5})[0-9,A-F,a-f]{1,2})";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(sourceString);
        while(matcher.find()){
            result = matcher.group(1);
            if(sourceString.indexOf(ip) <= sourceString.lastIndexOf(matcher.group(1))) {
                break;
            }
        }
        return result;
    }

    private String getMacInWindows(final String ip){
        String result = "";
        String[] cmd = {"cmd","/c","ping " + ip + "-n 2 -w 500"};
        String[] another = {"cmd","/c","arp -a"};
        String cmdResult = callCmd(cmd,another);
        result = filterMacAddress(ip,cmdResult,"-");
        return result;
    }

    private String getMacInLinux(final String ip){
        String result = "";
        String[] cmd = {"/bin/sh","-c","ping " +  ip + " -c 2 -w 3 && arp -a" };
        String cmdResult = callCmd(cmd);
        result = filterMacAddress(ip,cmdResult,":");
        return result;
    }

    public String getMacAddress(String ip){
        String macAddress = "";
        if(System.getProperties().getProperty("os.name").indexOf("Windows")>-1){
            macAddress = getMacInWindows(ip).trim();
        }else {
            macAddress = getMacInLinux(ip).trim();
        }
        return macAddress;
    }

}
