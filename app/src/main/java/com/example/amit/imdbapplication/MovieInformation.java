package com.example.amit.imdbapplication;

/**
 * Created by Amit on 8/3/2017.
 */

public class MovieInformation {
    String title,releasedate;
    int votecount;
    String img;
    double voteavg,popularity,popularity1;
    public MovieInformation(String title, String releasedate, int votecount, double voteavg, double popularity,String img,double popularity1) {
        this.setTitle(title);
        this.setReleasedate(releasedate);
        this.setVotecount(votecount);
        this.setVoteavg(voteavg);
        this.setPopularity(popularity);
        this.setImg(img);
        this.setPopularity1(popularity1);
    }

    public double getPopularity1() {
        return popularity1;
    }

    public void setPopularity1(double popularity1) {
        this.popularity1 = popularity1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public int getVotecount() {
        return votecount;
    }

    public void setVotecount(int votecount) {
        this.votecount = votecount;
    }

    public double getVoteavg() {
        return voteavg;
    }

    public void setVoteavg(double voteavg) {
        this.voteavg = voteavg;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
