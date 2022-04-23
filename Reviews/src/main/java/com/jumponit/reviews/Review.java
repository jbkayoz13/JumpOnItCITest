package com.jumponit.reviews;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue
    private long id;
    private double rating;
    private String comment;

    @Column(nullable = false)
    private int classID;

    @Column(nullable = false)
    private int commentorID;

    protected Review() { }

    public Review(double rating, String comment, int commentorID, int classID) {
        this.rating = rating;
        this.comment = comment;
        this.commentorID = commentorID;
        this.classID = classID;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCommentorID() {
        return commentorID;
    }

    public void setCommentorID(int commentorID) {
        this.commentorID = commentorID;
    }

    @Override
    public String toString() {
        return String.format("[%.1f/5] %s", rating, comment);
    }
}
