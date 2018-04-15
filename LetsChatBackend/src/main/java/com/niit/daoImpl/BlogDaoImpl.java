package com.niit.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.BlogDao;
import com.niit.model.Blog;
import com.niit.model.BlogComment;


@SuppressWarnings("deprecation")
@Service
@Repository("blogDao")
public class BlogDaoImpl implements BlogDao {

	@Autowired
	SessionFactory sessionFactory;
	
	   @Autowired
		public BlogDaoImpl(SessionFactory sessionfactory) {
			
	        super();
			this.sessionFactory = sessionfactory;}
		
 
	@Transactional
	@Override
	public boolean addBlog(Blog blog) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteBlog(Blog blog) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public Blog getBlog(int blogId) {
		// TODO Auto-generated method stub
		try{
		Session session=sessionFactory.openSession();
		Blog blog=session.get(Blog.class,blogId);
		session.close();
		return blog;
	}
		catch(Exception e){
			return null;
		}
	}

	@Transactional
	@Override
	public boolean approveBlog(Blog blog) {
		// TODO Auto-generated method stub
		try{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e){
			return false;
		}
		
	}

	@Transactional
	@Override
	public boolean rejectBlog(Blog blog) {
		// TODO Auto-generated method stub
		try{
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e){
			return false;
		}
}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Blog> listBlog(String username) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<Blog> blogList = new ArrayList<Blog>();
	     	Query query = session.createQuery("FROM Blog where username=:username").setString("username",username);
			blogList = query.list();
			return blogList;
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	@Transactional
	public boolean incrementLikes(Blog blog) {
		 try{
			 int likes=blog.getLikes();
			 likes++;
			 blog.setLikes(likes);
			 sessionFactory.getCurrentSession().update(blog);
			 return true;
		 }catch(Exception e)
		 {
			 return false;
		 }
	}


	@Override
	@Transactional
	public boolean addBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blogComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	@Override
	@Transactional
	public boolean deleteBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	@Override
	@Transactional
	public BlogComment getBlogComment(int commentId) {
		try {
			Session session = sessionFactory.openSession();
			BlogComment blogComment = session.get(BlogComment.class,commentId);
			return blogComment;
		} catch (Exception e) {
			return null;
		}	
	}


	@Override
	@Transactional
	public List<BlogComment> listBlogComments(int blogId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogComment where blogId=:blogId");
		query.setParameter("blogId", new Integer(blogId));
		@SuppressWarnings("unchecked")
		List<BlogComment> listBlogComments=query.list();
		return listBlogComments;
	}

}
