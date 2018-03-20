package com.niit.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDao;
import com.niit.model.User;

@Service
@Repository("userDao")

public class UserDaoImpl implements UserDao{

	@Autowired
	SessionFactory sessionfactory;
	
	@Autowired
	public UserDaoImpl(SessionFactory sf) {
		super();
		this.sessionfactory = sf;
	}
	
	@Transactional
	@Override
	public boolean addUser(User user) {
		try{
			sessionfactory.getCurrentSession().save(user);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean updateUser(User user) {
		try{
			sessionfactory.getCurrentSession().update(user);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteUser(User user) {
		try{
			sessionfactory.getCurrentSession().delete(user);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public User getUser(int userId) {
		User user = sessionfactory.getCurrentSession().get(User.class, userId);
		return user;
	}

	@Transactional
	@Override
	public List<User> listUsers() {
		@SuppressWarnings("unchecked")
		List<User> listUser = sessionfactory.openSession().createQuery("FROM User").list();
		return listUser;
	}

	
	
}
