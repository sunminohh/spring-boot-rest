package com.example.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.mapper.JobMapper;
import com.example.rest.vo.Job;

@Service
public class JobService {

	@Autowired
	private JobMapper jobMapper;
	
	public List<Job> getAllJobs() {
		return jobMapper.getJobs();
	}
	
	public Job getJob(String jobId) {
		return jobMapper.getJobById(jobId);
	}
	
	public void insertNewJob(Job job) {
		jobMapper.insertJob(job);
	}
	
	public void deleteJob(String jobId) {
		jobMapper.deleteJobById(jobId);
	}
	
	public Job updateJob(String jobId, Job job) {
		Job savedJob = jobMapper.getJobById(jobId);
		if (job.getTitle() != null) {
			savedJob.setTitle(job.getTitle());
		} 
		if (job.getMinSalary() != 0) {
			savedJob.setMinSalary(job.getMinSalary());
		}
		if (job.getMaxSalary() != 0) {
			savedJob.setMaxSalary(job.getMaxSalary());
		}
		
		jobMapper.updateJob(savedJob);
		
		return savedJob;
		
	}
}










