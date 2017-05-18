package com.uniandes.tallertres.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * Created by jfsan on 17/05/2017.
 */
@Table(value = "ratings")
public class Rating {
    @PrimaryKey("id")
    private int id;
    @Column("timestamp")
    private int timestamp;
    @Column("movieid")
    private int movieid;
    @Column("rating")
    private double rating;
    @Column("userid")
    private int userid;

    public Rating() {
    }

    public Rating(int id, int timestamp, int movieid, double rating, int userid) {
        this.id = id;
        this.timestamp = timestamp;
        this.movieid = movieid;
        this.rating = rating;
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
