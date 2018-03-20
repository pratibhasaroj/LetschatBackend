package com.niit.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.model.User;

public class UserDaoTest {

	@Autowired
	private static SessionFactory sessionFactory;
	private static UserDao userDao;
	private static AnnotationConfigApplicationContext context;
    private User user;
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		userDao = (UserDao) context.getBean("userDao");
		sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	}
/*	
	@Test
	public void testaddUser() {
		User user = new User();
		user.setUserName("prat");
		user.setPassword("123456");
		user.setEmail("prat@gmail.com");
		user.setPhone("98776865");
		user.setAddress("andheri");
		user.setRole("admin");
		user.setEnabled(true);
		user.setAccountOpeningDate(new Date());

		Assert.assertEquals("Insert User success", true, userDao.addUser(user));
		
	}
	@Test
	public void testDeleteUser() {
	user  = userDao.getUser(28);
	//	Assert.assertEquals("Successfully deleted user details from the table", true, userDao.deleteUser(user));
	//	User user = sessionFactory.openSession().get(User.class, 2);
		Assert.assertEquals("Delete User success", true, userDao.deleteUser(user));
		System.out.println("Successfully deleted users");
	}
	@Test
	public void testUpdateUser() {
		
		user=userDao.getUser(29);
		//User user = sessionFactory.openSession().get(User.class, 1);
		user.setUserName("saroj");

		Assert.assertEquals("Successfully updated user", true, userDao.updateUser(user));
	}
	@Test
	public void testgetUser(){
		user=userDao.getUser(29);
		Assert.assertEquals("Successfully fetched a user details from the table", "saroj", user.getUserName());
		System.out.println("Successfully fetched job");
		
		
	}

	@Test
	public void testGetAllUser() {
		List<User> listUser = userDao.listUsers();
		Assert.assertEquals("List user success", 2, listUser.size());

		System.out.println("Successfully retrieved list of user");
	
}*/
}
