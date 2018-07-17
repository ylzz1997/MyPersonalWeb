package Lhy.webpackage.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lhy on 2018/7/4.
 */
@Entity
@Table(name = "gueststatistic")
public class Guest {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ip")
    private String ip;
    @Column(name = "browser")
    private String browser;
    @Column(name = "date")
    private Date date;
    @Column(name = "protocol")
    private String protocol;
    @Column(name = "system")
    private String system;
    @Column(name = "hostname")
    private String hostname;
    @Column(name = "servername")
    private String servername;
    @Column(name = "device")
    private String device;
    @Column(name = "devicename")
    private String devicename;
    @Column(name = "ua")
    private String ua;
    public Guest() {
    }

    public Guest(String ip, String browser, Date date, String protocol, String system, String hostname, String servername, String device,String devicename,String ua) {
        this.ip = ip;
        this.browser = browser;
        this.date = date;
        this.protocol = protocol;
        this.system = system;
        this.hostname = hostname;
        this.servername = servername;
        this.device = device;
        this.devicename = devicename;
        this.ua = ua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getServername() {
        return servername;
    }

    public void setServername(String servername) {
        this.servername = servername;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }
}
