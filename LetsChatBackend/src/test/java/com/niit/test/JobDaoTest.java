package com.niit.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.JobDao;
import com.niit.model.ApplyJob;
import com.niit.model.Job;

public class JobDaoTest {

	private static AnnotationConfigApplicationContext context;
	private static JobDao jobDao;
	private Job job;
	private ApplyJob applyjob;

	// @SuppressWarnings("resource")
	
	@BeforeClass
	public static void initialize() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		jobDao = (JobDao) context.getBean("jobDao");
	}

		@Ignore
		@Test
		public void testAddJob() throws ParseException {
			SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
		    job =new Job();
			job.setCompany("abc");
			job.setJobDescription("software engr");
			job.setPostedDate(textFormat.parse("2016-08-18"));
			job.setSalary("8.5lpa");
			job.setDesgination("engineer1");
			job.setLocation("pune");
			Assert.assertEquals("Successfully added job into the table", true, jobDao.addJob(job));
			
			System.out.println("Successfully inserted into job");
		}
		
	@Ignore
	@Test
	public void testDeleteJob() {
		job = jobDao.getJob(62);
		Assert.assertEquals("Successfully deleted job details from the table", true, jobDao.deleteJob(job));
		System.out.println("Successfully deleted job");
	}
	
	@Ignore
	@Test
	public void updateJobTest() throws ParseException {
	    job=jobDao.getJob(61);
		job.setSalary("5lpa");
		Assert.assertEquals("Successfully updated job into the table", true, jobDao.updateJob(job));
		System.out.println("Successfully updated job");
	}
	
	@Ignore
	@Test
	public void getJob(){
		job = jobDao.getJob(63);
		Assert.assertEquals("Successfully fetched a job details from the table", "engineer1", job.getDesgination());
		System.out.println("Successfully fetched job");
		
		
	}
	
	@Ignore
	@Test
	public void testGetAllJob() {
		List<Job> listJob = jobDao.listJob();
		Assert.assertEquals("List job Failed", 2, listJob.size());

		System.out.println("Successfully retrieved list of job");
	}
	
	    @Ignore
		@Test
		public void testApplyJob() {
			applyjob = new ApplyJob();
			job=jobDao.getJob(61);
			applyjob.setAppliedDate(new Date());
			applyjob.setLoginName("saroj");
			applyjob.setJobId(job.getJobId());
			Assert.assertEquals("Successfully applied for job", true, jobDao.applyJob(applyjob));
			System.out.println("Successfully applied for job");
		}
	
	    //@Ignore
		@Test
		public void listAllAppliedJobs()
		{
			List<ApplyJob> listAppliedJobs = jobDao.getAllAppliedJobDetails();
		Assert.assertTrue("Successfully fetched all applied jobs from the table", jobDao.getAllAppliedJobDetails().size() > 0);
			for (ApplyJob appliedJobs : listAppliedJobs) {
			System.out.println("ApplicationID :" +appliedJobs.getApplicationId());
			System.out.println("JobID :" + appliedJobs.getJobId());
			System.out.println("LoginName :" + appliedJobs.getLoginName());
			System.out.println("Applied Date :" + appliedJobs.getAppliedDate());
		}
		System.out.println("Successfully retrieved list of applied jobs");
		}
}

