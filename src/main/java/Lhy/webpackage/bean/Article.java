package Lhy.webpackage.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lhy on 2018/7/2.
 */
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="author")
    private String author;
    @Column(name="content")
    private String content;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item")
    private TCItem item;
    @Column(name = "visitnum")
    private int visitnum;
    @Column(name = "date")
    private Date date;
    @Column(name = "tap")
    private String tap;
    @Transient
    private String[] taps;

    public Article(String title, String author, String content, TCItem item, int visitnum, Date date, String tap) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.item = item;
        this.visitnum = visitnum;
        this.date = date;
        this.tap = tap;
    }

    public Article(int id,String title, String author, TCItem item, int visitnum, Date date, String tap) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.item = item;
        this.visitnum = visitnum;
        this.date = date;
        this.tap = tap;
    }

    public Article() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TCItem getItem() {
        return item;
    }

    public void setItem(TCItem item) {
        this.item = item;
    }

    public int getVisitnum() {
        return visitnum;
    }

    public void setVisitnum(int visitnum) {
        this.visitnum = visitnum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTap() {
        return tap;
    }

    public void setTap(String tap) {
        this.tap = tap;
    }

    public String[] getTaps() {
        if(this.taps==null){
            if(!tap.equals(""))
                this.taps = tap.split(",");
            else
                this.taps = new String[]{};
        }
        return taps;
    }

    public String getHotCubeColor(){
        int R,G,B = 225;
        if(visitnum<=10000){
           R = (int)(255 - visitnum*0.0255);
           B = (int)(255 - visitnum*0.0255);
           G = 255;
        }else if(visitnum>10000&&visitnum<=20000){
            R = (int)((visitnum-10000)*0.0255);
            B = 0;
            G= (int)(255 - (visitnum-10000)*0.0255);
        }else {
            R = 255;
            G = 0;
            B = 0;
        }

        return ""+R+","+G+","+B;
    }
}
