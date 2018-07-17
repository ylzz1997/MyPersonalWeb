package Lhy.webpackage.bean;

import javax.persistence.*;

/**
 * Created by lhy on 2018/6/26.
 */
@Entity
@Table(name="tecnocolunm")
public class TCcol implements Item{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int Id;
    @Column(name="title")
    private String title;
    @Column(name="order")
    private int order;
    @Column(name="contain")
    private String contain;
    @Column(name="isItem")
    private boolean isItem;
    @Column(name="isEnable")
    private boolean isEnable;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "toItem")
    private TCItem Item;


    public TCcol(String title, int order, String contain, boolean isItem, TCItem item) {
        this.title = title;
        this.order = order;
        this.contain = contain;
        this.isItem = isItem;
        Item = item;
        this.isEnable=true;
    }

    public TCcol() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain = contain;
    }

    public boolean isItem() {
        return isItem;
    }

    public void setItem(boolean item) {
        isItem = item;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public TCItem getItem() {
        return Item;
    }

    public void setItem(TCItem item) {
        Item = item;
    }
}
