package com.uniandes.tallertres.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * Created by jfsan on 18/05/2017.
 */
@Table(value = "ready")
public class Ready {
    @PrimaryKey("id")
    private int id;
    @Column("timestampfrom")
    private int timestampfrom;
    @Column("timestampto")
    private int timestampto;
    @Column("movieid")
    private int movieid;
    @Column("userid")
    private int userid;
    @Column("ready")
    private Boolean ready;

    public Ready() {
    }

    public Ready(int id, int timestampfrom, int timestampto, int movieid, int userid, Boolean ready) {
        this.id = id;
        this.timestampfrom = timestampfrom;
        this.timestampto = timestampto;
        this.movieid = movieid;
        this.userid = userid;
        this.ready = ready;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimestampfrom() {
        return timestampfrom;
    }

    public void setTimestampfrom(int timestampfrom) {
        this.timestampfrom = timestampfrom;
    }

    public int getTimestampto() {
        return timestampto;
    }

    public void setTimestampto(int timestampto) {
        this.timestampto = timestampto;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }
}
