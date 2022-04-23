package com.example.demo;

import java.util.Date;

public class ClassAndReview {
	public String name;
	public long classID;
	public Date date;
	public String location;
	public int reviewRating;
	
	public void setName(String n) {
		this.name = n;
	}
		
	public void setClassID(long c) {
		this.classID = c;
	}
	
	public void setDate(Date d) {
		this.date = d;
	}
	
	public void setLocation(String l) {
		this.location = l;
	}
	
	public void setReviewRating(int r) {
		this.reviewRating = r;
	}
	
	public String getName() {
		return name;
	}
	
	public long getClassID() {
		return classID;
	}
	
	public String getLocation() {
		return location;
	}
	
	public Date getDate() {
		return date;
	}
	
	public int getReviewRating() {
		return reviewRating;
	}
}
