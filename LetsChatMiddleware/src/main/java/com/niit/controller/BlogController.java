package com.niit.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.BlogDao;
import com.niit.model.Blog;
import com.niit.model.BlogComment;

@RestController
public class BlogController {
	
	@Autowired
	BlogDao blogDao;
	
	@GetMapping(value="/listBlogs")
	public ResponseEntity<List<Blog>> getBlogs()
	{
		List<Blog> listblogs=blogDao.listBlog("Prati");
		if(listblogs.size()>0)
		{
		return  new  ResponseEntity<List<Blog>>(listblogs,HttpStatus.OK);
		}
		else
		{
			return  new  ResponseEntity<List<Blog>>(listblogs,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/addBlog")
	public ResponseEntity<String> addBlog(@RequestBody Blog blog)
	{
		//blog.setCreateDate();
		/*blog.setCreateDate(new Date());
		blog.setLikes(0);
		blog.setStatus("NA");
		blog.setUserName("Prasar");
		//blog.setBlogContent("gtfytfyug");
		//blog.setBlogId(88);*/
		if(blogDao.addBlog(blog))
		{
			return  new  ResponseEntity<String>("success",HttpStatus.OK);
		}
		else
		{
			return  new  ResponseEntity<String>("failure",HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/updateBlog/{blogId}")
	public ResponseEntity<String> updateBlog(@PathVariable("blogId") int blogId, @RequestBody Blog blog) {
		System.out.println("Updating Blog " + blogId);
		Blog Blog1 = blogDao.getBlog(blogId);
		if (Blog1 == null) {
			System.out.println("Blog with blogId " + blogId + " Not Found");
			return new ResponseEntity<String>("Update Blog Failue", HttpStatus.NOT_FOUND);
		}
		
		Blog1.setBlogContent(blog.getBlogContent());
		Blog1.setBlogname(blog.getBlogname());
		Blog1.setCreateDate(new Date());
		Blog1.setStatus(blog.getStatus());
		//Blog1.setLoginname(blog.getLoginname());
		
		blogDao.updateBlog(Blog1);
		return new ResponseEntity<String>("Update Blog Success", HttpStatus.OK);
	}

	@GetMapping(value="/deleteBlog/{blogId}")
	public ResponseEntity<String> deleteBlog(@PathVariable("blogId") int blogId) {
		System.out.println("Delete blog with blog Id: " + blogId);
		Blog blog = blogDao.getBlog(blogId);
		if (blog == null) {
			System.out.println("No blog " + blogId + " found to delete");
			return new ResponseEntity<String>("No blog with blog Id: " + blogId + " found to delete",
					HttpStatus.NOT_FOUND);
		} else {
			blogDao.deleteBlog(blog);
			return new ResponseEntity<String>("Blog with Blog Id " + blogId + " deleted successfully", HttpStatus.OK);
		}

	}
	
	@GetMapping(value = "/getBlog/{blogId}")
	public ResponseEntity<Blog> getBlog(@PathVariable("blogId") int blogId) {
		System.out.println("Get Blog " + blogId);
		Blog blog = blogDao.getBlog(blogId);
		if (blog == null) {
			return new ResponseEntity<Blog>(blog, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		}
	}

	
	@PutMapping(value = "/approveBlog/{blogId}")
	public ResponseEntity<String> approveBlog(@PathVariable("blogId") int blogId) {
		System.out.println("Approve Blog " + blogId);
		Blog blog = blogDao.getBlog(blogId);
		if (blog == null) {
			System.out.println( blogId + " Not found for Approval");
			return new ResponseEntity<String>("No Blog found for Approval", HttpStatus.NOT_FOUND);
		} else {
			blog.setStatus("A");
			blogDao.approveBlog(blog);
			return new ResponseEntity<String>("Blog " + blogId + " Approved Successfully", HttpStatus.OK);
		}
	}

	@PutMapping(value = "/rejectBlog/{blogId}")
	public ResponseEntity<String> rejectBlog(@PathVariable("blogId") int blogId) {
		System.out.println("Disapprove Blog with Blog ID: " + blogId);
		Blog blog = blogDao.getBlog(blogId);
		if (blog == null) {
			System.out.println(blogId + " not found for Approval");
			return new ResponseEntity<String>("No Blog with Blog Id " + blogId + " found for Disapproval",
					HttpStatus.NOT_FOUND);
		} else {
			blog.setStatus("NA");
			blogDao.rejectBlog(blog);
			return new ResponseEntity<String>("Blog " + blogId + " Disapproved Successfully", HttpStatus.OK);
		}
	}
	
	
	@PostMapping(value = "/addBlogComment")
	public ResponseEntity<String> addBlogComments(@RequestBody BlogComment blogComment) {
		System.out.println("In AddBlogComments() method");
		blogComment.setCommDate(new Date());
		blogComment.setBlogId(blogComment.getBlogId());
		blogComment.setCommDate(new Date());
		blogComment.setCommText(blogComment.getCommText());
		blogComment.setUsername(blogComment.getUsername());
		
		if (blogDao.addBlogComment(blogComment)) {
			return new ResponseEntity<String>("BlogComment Added- Success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("BlodComment insert failed", HttpStatus.NOT_FOUND);
		}
	}

		@DeleteMapping(value = "/deleteBlogComment/{commentId}")
	public ResponseEntity<String> deleteBlogComment(@PathVariable("commentId") int commentId) {
		System.out.println("Delete blogComment with comment Id: " + commentId);
		BlogComment blogComment = blogDao.getBlogComment(commentId);
		if (blogComment == null) {
			System.out.println("No blog " + commentId + " found to delete");
			return new ResponseEntity<String>("No blogcomment with comment Id: " + commentId + " found to delete",
					HttpStatus.NOT_FOUND);
		} else {
			blogDao.deleteBlogComment(blogComment);
			return new ResponseEntity<String>("BlogComment with comment Id " + commentId + " deleted successfully", HttpStatus.OK);
		}

	}
	@GetMapping(value = "/getBlogComment/{commentId}")
	public ResponseEntity<String> getBlogComment(@PathVariable("commentId") int commentId) {
		System.out.println("Get BlogComment " + commentId);
		BlogComment blogComment = blogDao.getBlogComment(commentId);
		if (blogComment == null) {
			return new ResponseEntity<String>("Get blogComment failure", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<String>("Get blogComment Success", HttpStatus.OK);
		}
	}

	
	@GetMapping(value = "/listBlogComments/{blogId}")
	public ResponseEntity<List<BlogComment>> listBlogComments(@PathVariable("blogId")int blogId) {
		System.out.println("In listBlogcomments() method");
		List<BlogComment> listBlogComments = blogDao.listBlogComments(blogId);
		if (listBlogComments.size() != 0) {
			return new ResponseEntity<List<BlogComment>>(listBlogComments, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<BlogComment>>(listBlogComments, HttpStatus.NOT_FOUND);
		}
	}
	
	
			@PostMapping(value = "/incrementLikes/{blogID}")
			public ResponseEntity<String> incrementLikes(@PathVariable("blogID")int blogId) {
				System.out.println("Increment likes for BlogId " + blogId);
				Blog blog = blogDao.getBlog(blogId);
				if (blogDao.incrementLikes(blog)) {
					return new ResponseEntity<String>("Successfully incremented..", HttpStatus.OK);
				} else {
					return new ResponseEntity<String>("Failed incremeneting likes..", HttpStatus.NOT_FOUND);
				}
			}


	}

