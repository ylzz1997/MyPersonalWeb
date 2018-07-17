package Lhy.webpackage.bean;

import javax.persistence.*;

/**
 * Created by lhy on 2018/6/25.
 */

@Entity
@Table(name="tecnoitem")
public class TCItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;
    @Column(name = "name")
    private String name;
    @Column(name = "ico")
    private String ico;
    @Column(name = "img")
    private String img;

    public TCItem(String name, String ico, String img) {
        this.name = name;
        this.ico = ico;
        this.img = img;
    }

    public TCItem() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public String getImg() {
        return img;
    }
}
