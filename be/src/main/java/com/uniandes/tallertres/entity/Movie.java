package com.uniandes.tallertres.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table(value = "movies")
public class Movie{

    @PrimaryKey("movieid")
    private int movieId;
    @Column("title")
    private String title;
    @Column("genre1")
    private String genre1;
    @Column("genre2")
    private String genre2;
    @Column("genre3")
    private String genre3;
    @Column("genre4")
    private String genre4;
    @Column("genre5")
    private String genre5;
    @Column("genre6")
    private String genre6;
    @Column("genre7")
    private String genre7;
    @Column("genre8")
    private String genre8;
    @Column("abstract")
    private String abstractmovie;
    @Column("director")
    private String director;
    @Column("distributor")
    private String distributor;

    public Movie(){
    }

    public Movie(int movieId, String title, String genre1, String genre2, String genre3, String genre4, String genre5, String genre6, String genre7, String genre8, String abstractmovie, String director, String distributor) {
        this.movieId = movieId;
        this.title = title;
        this.genre1 = genre1;
        this.genre2 = genre2;
        this.genre3 = genre3;
        this.genre4 = genre4;
        this.genre5 = genre5;
        this.genre6 = genre6;
        this.genre7 = genre7;
        this.genre8 = genre8;
        this.abstractmovie = abstractmovie;
        this.director = director;
        this.distributor = distributor;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre1() {
        return genre1;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    public String getGenre2() {
        return genre2;
    }

    public void setGenre2(String genre2) {
        this.genre2 = genre2;
    }

    public String getGenre3() {
        return genre3;
    }

    public void setGenre3(String genre3) {
        this.genre3 = genre3;
    }

    public String getGenre4() {
        return genre4;
    }

    public void setGenre4(String genre4) {
        this.genre4 = genre4;
    }

    public String getGenre5() {
        return genre5;
    }

    public void setGenre5(String genre5) {
        this.genre5 = genre5;
    }

    public String getGenre6() {
        return genre6;
    }

    public void setGenre6(String genre6) {
        this.genre6 = genre6;
    }

    public String getGenre7() {
        return genre7;
    }

    public void setGenre7(String genre7) {
        this.genre7 = genre7;
    }

    public String getGenre8() {
        return genre8;
    }

    public void setGenre8(String genre8) {
        this.genre8 = genre8;
    }

    public String getAbstractmovie() {
        return abstractmovie;
    }

    public void setAbstractmovie(String abstractmovie) {
        this.abstractmovie = abstractmovie;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }
}