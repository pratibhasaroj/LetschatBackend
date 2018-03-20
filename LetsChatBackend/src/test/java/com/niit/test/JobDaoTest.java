package com.niit.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.JobDao;
import com.niit.model.Job;

public class JobDaoTest {

	private static AnnotationConfigApplicationContext context;
	private static JobDao jobDao;
	private Job job;

	// @SuppressWarnings("resource")
	
	@BeforeClass
	public static void initialize() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		jobDao = (JobDao) context.getBean("jobDao");
	}

		@Test
		public void testAddJob() throws ParseException {
			SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
		    job =new Job();
			job.setJobTitle("Engineer");
			job.setJobDescription("tester");
			job.setPostedDate(textFormat.parse("2017-06-08"));
			job.setSalary("4.5lpa");
			job.setDesgination("Automated testing");
			Assert.assertEquals("Successfully added job into the table", true, jobDao.addJob(job));
			
			System.out.println("Successfully inserted into job");
		}
		/*
	/*
	@Test
	public void testDeleteJob() {
		job = jobDao.getJob(2);
		Assert.assertEquals("Successfully deleted job details from the table", true, jobDao.deleteJob(job));
		System.out.println("Successfully deleted job");
	}
	
	@Test
	public void updateJobTest() throws ParseException {
	    job=jobDao.getJob(1);
		job.setSalary("5lpa");
		Assert.assertEquals("Successfully updated job into the table", true, jobDao.updateJob(job));
		System.out.println("Successfully updated job");
	}
	
	@Test
	public void getJob(){
		job = jobDao.getJob(1);
		Assert.assertEquals("Successfully fetched a job details from the table", "Trainer", job.getJobTitle());
		System.out.println("Successfully fetched job");
		
		
	}
	@Test
	public void testGetAllJob() {
		List<Job> listJob = jobDao.listJob();
		Assert.assertEquals("List job Failed", 8, listJob.size());

		System.out.println("Successfully retrieved list of job");
	}*/
}

