package com.niit.test;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDao;
import com.niit.model.Blog;
import com.niit.model.BlogComment;

public class BlogDaoTest {

	private static AnnotationConfigApplicationContext context;
	private static BlogDao blogDao;
	private Blog blog;
	private BlogComment blogComment;

	// @SuppressWarnings("resource")
	
	@BeforeClass
	public static void initialize() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blogDao = (BlogDao) context.getBean("blogDao");

	}

	@Ignore
	@Test
	public void testAddBlog() {
		// fail("not yet implemented");
		blog = new Blog();
		//blog.setBlogId(1);
		blog.setBlogname("Angularjs");
		blog.setBlogContent("name of the blog is Angular");
		blog.setUserName("Pratibha");
		blog.setStatus("NA");
		blog.setCreateDate(new Date());
		blog.setLikes(0);
		Assert.assertEquals("Successfully added a bloginto the table", true,blogDao.addBlog(blog));
		System.out.println("Successfully added blog");
	}
	
	@Ignore
	@Test
	public void testDeleteBlog() {
		blog = blogDao.getBlog(44);
		Assert.assertEquals("Successfully deleted a bloginto the table", true,blogDao.deleteBlog(blog));
		System.out.println("Successfully deleted blog");

	}
	
	@Ignore
	@Test
	public void testUpdateBlog(){
		blog=blogDao.getBlog(43);
		blog.setBlogContent("DtProject 2");
		Assert.assertEquals("Successfully updated a bloginto the table", true,blogDao.updateBlog(blog));
		System.out.println("Successfully updated blog");
	}
	
	@Ignore
	@Test
	public void testGetBlog(){
	blog=blogDao.getBlog(43);
		Assert.assertEquals("Successfully fetched a blog details from the table","Profit", blog.getBlogname());
		System.out.println("Successfully fetched blog");
	}
	
	@Ignore
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
		
	@Ignore
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
	@Ignore
	@Test
	public void testListBlog(){
		Assert.assertEquals("Successfully fetched all blogs from the table", 1,
				blogDao.listBlog("Prati").size());

		System.out.println("Successfully retrieved list of blog");
	}
	
	@Ignore
	@Test
	public void testIncrementLikes() {
		blog = blogDao.getBlog(83);
		Assert.assertEquals("Successfully incremented likes to the table", true, blogDao.incrementLikes(blog));
		System.out.println("Likes After incrementing :" + blog.getLikes());
		System.out.println("Successfully incremented blog likes");
	}

	@Ignore
	@Test
	public void testAddBlogComment() {
		blogComment = new BlogComment();
		blog = blogDao.getBlog(83);
		String username = blog.getUserName();
		int blogId = blog.getBlogId();
		blogComment.setBlogId(blogId);
		blogComment.setUsername(username);
		blogComment.setCommDate(new Date());
		blogComment.setCommText("Hibernate blog");
		Assert.assertEquals("Successfully added the blogComment", true, blogDao.addBlogComment(blogComment));
		System.out.println("Successfully added blogCommment");
	}

	@Ignore
	@Test
	public void testGetBlogCommment() {
		blogComment = blogDao.getBlogComment(1);
		Assert.assertEquals("Successfully fetched a blogComments from the table", "Pratibha", blogComment.getUsername());
		System.out.println("BlogComment");
		System.out.println("blogID :" + blogComment.getBlogId());
		System.out.println("Username :" + blogComment.getUsername());
		System.out.println("Status :" + blogComment.getCommId());
		System.out.println("Likes :" + blogComment.getCommText());
		System.out.println("Created Date :" + blogComment.getCommDate());
		System.out.println("Successfully fetched blogComment");
	}

	@Ignore
	@Test
	public void testDeleteBlogComment() {
		blogComment = blogDao.getBlogComment(2);
		Assert.assertEquals("Successfully deleted blogcomment from the table", true, blogDao.deleteBlogComment(blogComment));
		System.out.println("Successfully deleted blogComment");
	}

	@Ignore
	@Test
	public void testListBlogComments() {
		List<BlogComment> listBlogComments = blogDao.listBlogComments(83);
		Assert.assertTrue("Successfully fetched all blogcomments from the table", blogDao.listBlogComments(83).size() > 0);
		System.out.println("BlogComments fetched");
		for (BlogComment blogComment : listBlogComments) {
			System.out.println("blogID :" + blogComment.getBlogId());
			System.out.println("CommentID :" + blogComment.getCommId());
			System.out.println("Comment Text :" + blogComment.getCommText());
			System.out.println("Username :" + blogComment.getUsername());
			System.out.println("Comment Date : " + blogComment.getCommDate());
		}
		System.out.println("Successfully retrieved list of blogComments");
	}

	
	}
	

