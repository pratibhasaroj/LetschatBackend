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

import com.niit.dao.JobDao;
import com.niit.model.ApplyJob;
import com.niit.model.Job;


@Service
@Repository("jobDao")
public class JobDaoImpl implements JobDao{

	@Autowired
	SessionFactory sessionFactory;


	   @Autowired
		public JobDaoImpl(SessionFactory sf) {
			super();
			this.sessionFactory = sf;
		}

	@Transactional
	public boolean addJob(Job job) {
		try {
			sessionFactory.getCurrentSession().save (job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean deleteJob(Job job) {
		try {
			sessionFactory.getCurrentSession().delete(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean updateJob(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public Job getJob(int jobId) {
		try {
			Session session = sessionFactory.openSession();
			Job job = session.get(Job.class, jobId);
			return job;
		} catch (Exception e) {
			return null;
		}
	}

	

	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Job> listJob() {
		List<Job> listJob = null;
		try {
			listJob = sessionFactory.openSession().createQuery("FROM Job").list();

		} catch (Exception e) {
			System.err.println(e);
		}
		return listJob;
	}

	@Transactional
	@Override
	public boolean applyJob(ApplyJob applyJob) {
		try {
			sessionFactory.getCurrentSession().save(applyJob);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public List<ApplyJob> getAllAppliedJobDetails() {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<ApplyJob> appliedjobList = new ArrayList<ApplyJob>();
			Query query = session.createQuery("FROM ApplyJob");
			appliedjobList = query.list();
			return appliedjobList;
		} catch (Exception e) {
			return null;
		}
	}
}