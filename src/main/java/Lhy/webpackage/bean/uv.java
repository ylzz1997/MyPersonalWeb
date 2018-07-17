package Lhy.webpackage.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lhy on 2018/6/26.
 */
@Entity
@Table(name="uv")
public class uv {
    @Column(name="count")
    private int count;

    @Id
    @GeneratedValue(generator = "id_date")
    @GenericGenerator(name="id_date",strategy="assigned")
    @Temporal(TemporalType.DATE)
    @Column(name="date")
    private Date date;

    public uv(int count, Date date) {
        this.count = count;
        this.date = date;
    }

    public uv() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
