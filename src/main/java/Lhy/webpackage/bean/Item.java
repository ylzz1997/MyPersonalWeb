package Lhy.webpackage.bean;

/**
 * Created by lhy on 2018/7/2.
 */
public interface Item {
    int getId();
    void setId(int id);
    String getTitle();
    void setTitle(String title);
    String getContain();
    void setContain(String contain);
    boolean isItem();
    void setItem(boolean item);
    boolean isEnable();
    void setEnable(boolean enable);
    TCItem getItem();
    void setItem(TCItem item);
}
