package com.niit.dao;

import java.util.List;

import com.niit.model.ApplyJob;
import com.niit.model.Job;

public interface JobDao {

	
	public boolean addJob(Job job);
	public boolean deleteJob(Job job);
	public boolean updateJob(Job job);
	public Job getJob(int jobId);
	public List<Job> listJob();
	public boolean applyJob(ApplyJob applyJob);
	public List<ApplyJob> getAllAppliedJobDetails();
}
