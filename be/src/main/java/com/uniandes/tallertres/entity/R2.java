package com.uniandes.tallertres.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("r2")
public class R2 {
    @PrimaryKey("id")
    private int id;
    @Column("movieid")
    private int movieid;
    @Column("readyid")
    private int readyid;

    public R2() {
    }

    public R2(int id, int movieid, int readyid) {
        this.id = id;
        this.movieid = movieid;
        this.readyid = readyid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
