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

import com.niit.dao.Forumdao;
import com.niit.model.Forum;
import com.niit.model.ForumComment;

@SuppressWarnings("deprecation")
@Service
@Repository("forumDao")
public class ForumDaoImpl implements Forumdao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	public ForumDaoImpl(SessionFactory sessionfactory) {

		super();
		this.sessionFactory = sessionfactory;
	}

	@Transactional
	@Override
	public boolean addForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().save(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean updateForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public Forum getForum(int forumId) {
		try {
			Session session = sessionFactory.openSession();
			Forum forum = session.get(Forum.class, forumId);
			session.close();
			return forum;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
		@Override
	public List<Forum> listForum(String username) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<Forum> forumList = new ArrayList<Forum>();
			Query<Forum> query = session.createQuery("FROM Forum where username=:username").setString("username", username);
			forumList = query.list();
			return forumList;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	@Override
	public boolean approveForum(Forum forum) {
		try {
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean rejectForum(Forum forum) {
		try {
			forum.setStatus("NA");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Transactional
	@Override
	public boolean addForumComment(ForumComment forumComment) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forumComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteForumComment(ForumComment forumComment) {
		try {
			sessionFactory.getCurrentSession().delete(forumComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public ForumComment getForumComment(int commentId) {
		try {
			Session session = sessionFactory.openSession();
			ForumComment forumComment = session.get(ForumComment.class, commentId);
			return forumComment;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	@Override
	public List<ForumComment> listForumComments(int forumId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from ForumComment where forumId=:forumId");
		query.setParameter("forumId", new Integer(forumId));
		@SuppressWarnings("unchecked")
		List<ForumComment> listForumComments = query.list();
		return listForumComments;
	}


}
