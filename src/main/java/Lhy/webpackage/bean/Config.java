package Lhy.webpackage.bean;

import javax.persistence.*;

/**
 * Created by lhy on 2018/8/8.
 */
@Entity
@Table(name = "config")
public class Config {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    @Column(name="key")
    private String key;
    @Column(name="value")
    private String value;

    public Config() {
    }

    public Config(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
