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
@Table(name="ForumComment")
@SequenceGenerator(name = "forumcommidseq", sequenceName="forumCommentidseq", allocationSize = 1)
public class ForumComment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forumcommidseq")
	@Column(name="commId")
	int commId;
	
	@Column(name="commtex")
	private String commtext;
	
	@Column(name="username")
	private String username;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-mm-yyyy")
	@Column(name="commDate")
	Date commDate;

	@Column(name="forumId")
	private int forumId;

	public int getCommId() {
		return commId;
	}

	public void setCommId(int commId) {
		this.commId = commId;
	}

	public String getCommtext() {
		return commtext;
	}

	public void setCommtext(String commtext) {
		this.commtext = commtext;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCommDate() {
		return commDate;
	}

	public void setCommDate(Date commDate) {
		this.commDate = commDate;
	}

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	
}
