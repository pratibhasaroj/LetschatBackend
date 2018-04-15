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
	@Table(name="Forum")
	public class Forum {
		
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
		@SequenceGenerator(name = "generator", sequenceName="forum_seq", allocationSize = 1)
		
		
		@Column(name="forumId")
		private int forumId;
		
		@Column(name="forumname")
		private String forumname;
		
		@Column(name="forumContent")
		private String forumContent;
		
		@Column(name="userName")
		private String userName;
		
		@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-mm-yyyy")
		@Column(name = "createdDate")
		private Date createDate;

		@Column(name = "status")
		private String status;
	

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public int getForumId() {
			return forumId;
		}

		public void setForumId(int forumId) {
			this.forumId = forumId;
		}

		public String getForumname() {
			return forumname;
		}

		public void setForumname(String forumname) {
			this.forumname = forumname;
		}

		public String getForumContent() {
			return forumContent;
		}

		public void setForumContent(String forumContent) {
			this.forumContent = forumContent;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public Date getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Date createDate) {
		
			this.createDate = createDate;
		}
		
		
}
