package com.niit.test;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDao;
import com.niit.model.Blog;

public class BlogDaoTest {

	private static AnnotationConfigApplicationContext context;
	private static BlogDao blogDao;
	private Blog blog;

	// @SuppressWarnings("resource")
	
	@BeforeClass
	public static void initialize() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blogDao = (BlogDao) context.getBean("blogDao");

	}

	@Test
	public void testAddBlog() {
		// fail("not yet implemented");
		blog = new Blog();
		//blog.setBlogId(1);
		blog.setBlogname("Profit");
		blog.setBlogContent("name of the blog is Profit");
		blog.setUserName("Prati");
		blog.setStatus("A");
		blog.setCreateDate();
		Assert.assertEquals("Successfully added a bloginto the table", true,blogDao.addBlog(blog));
		System.out.println("Successfully added blog");
	}
	/*
	@Test
	public void testDeleteBlog() {
		blog = blogDao.getBlog(44);
		Assert.assertEquals("Successfully deleted a bloginto the table", true,blogDao.deleteBlog(blog));
		System.out.println("Successfully deleted blog");

	}
	
	@Test
	public void testUpdateBlog(){
		blog=blogDao.getBlog(43);
		blog.setBlogContent("DtProject 2");
		Assert.assertEquals("Successfully updated a bloginto the table", true,blogDao.updateBlog(blog));
		System.out.println("Successfully updated blog");
	}
	
	@Test
	public void testGetBlog(){
	blog=blogDao.getBlog(43);
		Assert.assertEquals("Successfully fetched a blog details from the table","Profit", blog.getBlogname());
		System.out.println("Successfully fetched blog");
	}
	
	@Test
	public void testApprovedBlog(){
		blog =blogDao.getBlog(43);
		String s=blog.getStatus();
		if(s.equals("A"))
		{
			Assert.assertEquals("Successfully approved blog int the table", true, blogDao.approveBlog(blog));
			System.out.println("Successfully approved blog");
		} else {
			System.out.println("not approved");
		}
		}
		
		
	@Test
	public void testRejecteBlog(){
		blog =blogDao.getBlog(43);
		String s=blog.getStatus();
		if(s.equals("NA"))
		{
			Assert.assertEquals("Successfully approved blog int the table", true, blogDao.approveBlog(blog));
			System.out.println("Successfully rejecteded blog");
		} else {
			System.out.println(" approved");
		}
		}
	
	@Test
	public void testListBlog(){
		Assert.assertEquals("Successfully fetched all blogs from the table", 1,
				blogDao.listBlog("Prati").size());

		System.out.println("Successfully retrieved list of blog");
	}*/
	
	
	}
	

