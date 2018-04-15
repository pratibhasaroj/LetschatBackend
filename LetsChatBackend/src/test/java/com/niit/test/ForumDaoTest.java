package com.niit.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.Forumdao;
import com.niit.model.Forum;
import com.niit.model.ForumComment;



public class ForumDaoTest {
	private static AnnotationConfigApplicationContext context;
	private static Forumdao forumDao;
	private Forum forum;
	private ForumComment forumcomm;

	// @SuppressWarnings("resource")
	
	@BeforeClass
	public static void initialize() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumDao = (Forumdao) context.getBean("forumDao");

	}
	
	@Ignore
	@Test
	public void testAddForum() {
		// fail("not yet implemented");
		forum = new Forum();
		//forum.setBlogId(1);
		forum.setForumname("forumTwo");
		forum.setForumContent("welcome to forum two");
		forum.setUserName("psaroj");
		forum.setCreateDate(new Date());
		forum.setStatus("A");
		Assert.assertEquals("Successfully added a bloginto the table", true,forumDao.addForum(forum));
		System.out.println("Successfully added forum");
	}
	
	@Ignore
	@Test
	public void testDeleteForum() {
		forum = forumDao.getForum(22);
		Assert.assertEquals("Successfully deleted a forum into the table", true,forumDao.deleteForum(forum));
		System.out.println("Successfully deleted forum");

	}
	
    @Ignore
	@Test
	public void testUpdateForum(){
		forum=forumDao.getForum(23);
		forum.setForumContent("welcome everyone");
		Assert.assertEquals("Successfully updated a bloginto the table", true,forumDao.updateForum(forum));
		System.out.println("Successfully updated forum");
	}
	
	@Ignore
	@Test
	public void testGetForum(){
		forum=forumDao.getForum(23);
		Assert.assertEquals("Successfully fetched a blog details from the table","forumTwo", forum.getForumname());
		System.out.println("Successfully fetched forum");
	}

	@Ignore
	@Test
	public void testListForum(){
		Assert.assertEquals("Successfully fetched all blogs from the table", 1,
			forumDao.listForum("Alex").size());

		System.out.println("Successfully retrieved list of forum");
	}
	
	@Ignore
	@Test
	public void testApproveForum() {
		forum = forumDao.getForum(23);
		String sts = forum.getStatus();
		if (sts.equals("NA")) {
			Assert.assertEquals("Successfully approved forum int the table", true, forumDao.approveForum(forum));
			System.out.println("Successfully approved forum");
		} else {
			System.out.println("not approved");
		}
	}

	@Ignore
	@Test
	public void testRejectForum() {
		forum = forumDao.getForum(3);
		String sts = forum.getStatus();
		if (sts.equals("A")) {
			Assert.assertEquals("Successfully approved forum int the table", true, forumDao.rejectForum(forum));
			System.out.println("Successfully rejected forum");
		} else {
			System.out.println("not approved");
		}
	}

	@Ignore
	@Test
	public void testAddForumComment() {
		forumcomm = new ForumComment();
		forum = forumDao.getForum(24);
		String username = forum.getUserName();
		int forumId = forum.getForumId();
		forumcomm.setForumId(forumId);
		forumcomm.setUsername(username);
		forumcomm.setCommDate(new Date());
		forumcomm.setCommtext("Destiny forum");
		Assert.assertEquals("Successfully added the forumComment...", true, forumDao.addForumComment(forumcomm));
		System.out.println("Successfully added forumCommment");
	}

//	@Ignore
	@Test
	public void testGetForumCommment() {
		forumcomm = forumDao.getForumComment(1);
		Assert.assertEquals("Successfully fetched a forumComments from the table", "psaroj",
				forumcomm.getUsername());
		System.out.println("ForumComment");
		System.out.println("forumID :" + forumcomm.getForumId());
		System.out.println("Username :" + forumcomm.getUsername());
		System.out.println("Status :" + forumcomm.getCommDate());
		System.out.println("Likes :" + forumcomm.getCommtext());
		System.out.println("Created Date :" + forumcomm.getCommDate());
		System.out.println("Successfully fetched forumComment");
	}

	@Ignore
	@Test
	public void testDeleteForumComment() {
		forumcomm = forumDao.getForumComment(4);
		Assert.assertEquals("Successfully deleted forum details from the table", true,
				forumDao.deleteForumComment(forumcomm));
		System.out.println("Successfully deleted forumComment");
	}

	@Ignore
	@Test
	public void testListForumComments() {
		List<ForumComment> listForumComments = forumDao.listForumComments(1);
		Assert.assertTrue("Successfully fetched all forums from the table", forumDao.listForumComments(1).size() > 0);
		System.out.println("ForumComments fetched");
		for (ForumComment forumComment : listForumComments) {
			System.out.println("forumID :" + forumComment.getForumId());
			System.out.println("CommentID :" + forumComment.getCommDate());
			System.out.println("Comment Text :" + forumComment.getCommtext());
			System.out.println("Username :" + forumComment.getUsername());
			System.out.println("Comment Date : " + forumComment.getCommDate());
		}
		System.out.println("Successfully retrieved list of forumComments");
	}

	
	}
	

