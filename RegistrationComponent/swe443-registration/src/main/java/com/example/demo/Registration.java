package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registrations")
public class Registration {

	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private long memberID;
	@Column(nullable = false)
	private long classID;
	
	public Registration() {
		
	}
	
	public Registration(int memberID, int classID) {
		this.memberID = memberID;
		this.classID = classID;
	}
	
	public long getMemberID() {
		return this.memberID;
	}
	
	public long getClassID() {
		return this.classID;
	}
	
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	
	public void setClassID(long classID) {
		this.classID = classID;
	}
}
