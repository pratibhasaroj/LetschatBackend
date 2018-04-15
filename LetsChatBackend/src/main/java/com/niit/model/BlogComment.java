package com.niit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
@Table(name="BlogComment")
@SequenceGenerator(name = "blogcommidseq", sequenceName="blogCommentidseq", allocationSize = 1)
public class BlogComment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blogcommidseq")
	@Column(name="commId")
	int commId;
	
	@Column(name="commText")
	private String commText;
	
	@Column(name="username")
	private String username;
	
	@Column(name=" blogId")
	 private int blogId;
	 
	 public int getCommId() {
		return commId;
	}

	public void setCommId(int commId) {
		this.commId = commId;
	}

	public String getCommText() {
		return commText;
	}

	public void setCommText(String commText) {
		this.commText = commText;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public Date getCommDate() {
		return CommDate;
	}

	public void setCommDate(Date commDate) {
		CommDate = commDate;
	}

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	 @Column(name="CommDate")
	 Date CommDate;
	 
	 
	
	
}
