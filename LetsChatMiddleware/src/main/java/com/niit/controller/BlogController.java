package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.BlogDao;
import com.niit.model.Blog;

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

}
