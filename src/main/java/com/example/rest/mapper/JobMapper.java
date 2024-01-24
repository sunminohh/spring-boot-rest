package com.example.rest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.rest.vo.Job;

@Mapper
public interface JobMapper {

	// 기본적인 CRUD
	void insertJob(Job job);
	List<Job> getJobs();
	Job getJobById(String jobId);
	void updateJob(Job job);
	void deleteJobById(String jobId);
}
