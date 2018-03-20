package com.niit.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.Forumdao;
import com.niit.model.Forum;



public class ForumDaoTest {
	private static AnnotationConfigApplicationContext context;
	private static Forumdao forumDao;
	private Forum forum;

	// @SuppressWarnings("resource")
	
	@BeforeClass
	public static void initialize() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumDao = (Forumdao) context.getBean("forumDao");

	}
	/*
	@Test
	public void testAddForum() {
		// fail("not yet implemented");
		forum = new Forum();
		//forum.setBlogId(1);
		forum.setForumname("forumone");
		forum.setForumContent("welcome to forum one");
		forum.setUserName("saroj");
		forum.setCreateDate();
		Assert.assertEquals("Successfully added a bloginto the table", true,forumDao.addForum(forum));
		System.out.println("Successfully added forum");
	}
	/*
	@Test
	public void testDeleteForum() {
		forum = forumDao.getForum(1);
		Assert.assertEquals("Successfully deleted a bloginto the table", true,forumDao.deleteForum(forum));
		System.out.println("Successfully deleted forum");

	}
	
	@Test
	public void testUpdateForum(){
		forum=forumDao.getForum(2);
		forum.setForumContent("welcome everyone");
		Assert.assertEquals("Successfully updated a bloginto the table", true,forumDao.updateForum(forum));
		System.out.println("Successfully updated forum");
	}
	
	@Test
	public void testGetForum(){
		forum=forumDao.getForum(2);
		Assert.assertEquals("Successfully fetched a blog details from the table","forumone", forum.getForumname());
		System.out.println("Successfully fetched forum");
	}
	*/

	@Test
	public void testListForum(){
		Assert.assertEquals("Successfully fetched all blogs from the table", 1,
			forumDao.listForum("Alex").size());

		System.out.println("Successfully retrieved list of forum");
	}
	
	
	}
	

