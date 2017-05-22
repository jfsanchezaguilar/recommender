package com.uniandes.tallertres.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("r1")
public class R1 {
    @PrimaryKey("id")
    private int id;
    @Column("userid")
    private int userid;
    @Column("movieid")
    private int movieid;
    @Column("readyid")
    private int readyid;

    public R1() {
    }

    public R1(int userid, int movieid, int readyid) {
        this.userid = userid;
        this.movieid = movieid;
        this.readyid = readyid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public int getReadyid() {
        return readyid;
    }

    public void setReadyid(int readyid) {
        this.readyid = readyid;
    }
}
