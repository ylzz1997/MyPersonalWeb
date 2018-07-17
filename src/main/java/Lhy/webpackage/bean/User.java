package Lhy.webpackage.bean;

import javax.persistence.*;

/**
 * Created by lhy on 2018/7/8.
 */
@Entity
@Table(name="user")
public class User{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "indexname")
    private String indexname;
    @Column(name = "email")
    private String email;
    @Column(name = "faceimg")
    private String faceimg;
    @Column(name = "ban")
    private boolean ban;

    public User(String username, String password, String indexname, String email, String faceimg, boolean ban) {
        this.username = username;
        this.password = password;
        this.indexname = indexname;
        this.email = email;
        this.faceimg = faceimg;
        this.ban = ban;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIndexname() {
        return indexname;
    }

    public void setIndexname(String indexname) {
        this.indexname = indexname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaceimg() {
        return faceimg;
    }

    public void setFaceimg(String faceimg) {
        this.faceimg = faceimg;
    }

    public boolean isBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }
}
