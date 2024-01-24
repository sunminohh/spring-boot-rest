package com.example.rest.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.service.JobService;
import com.example.rest.vo.Job;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@RestController
@Slf4j
public class JobController {

	@Autowired
	private JobService jobService;
	
	// RestApi 에서는 반환타입이 String(뷰 이름)이 아닌 데이터다.
	@GetMapping("/jobs")
	public ResponseEntity<List<Job>> getAllJobs() {
		List<Job> jobs = jobService.getAllJobs();
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}
	
	@GetMapping("/jobs/{jobId}")
	public ResponseEntity<Job> getJob(@PathVariable("jobId") String jobId) {
		log.info("jobId -> {}", jobId); 
		Job job = jobService.getJob(jobId);
		return ResponseEntity.ok(job);
	}
	
	@PostMapping("/jobs")
	public ResponseEntity<Job> createJob(@RequestBody Job job) {
		log.info("요청데이터 -> {}", job);
		jobService.insertNewJob(job);
		
		return ResponseEntity.ok().body(job);
	}
	
	@DeleteMapping("/jobs/{jobId}")
	public ResponseEntity<Void> deleteJob(@PathVariable("jobId") String jobId) {
		log.info("삭제할 직종아이디 - {}", jobId);
		jobService.deleteJob(jobId);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/jobs/{jobId}")
	public ResponseEntity<Job> updateJob(@PathVariable("jobId") String jobId,
			@RequestBody Job job) {
		Job updatedJob = jobService.updateJob(jobId, job);
		
		return ResponseEntity.ok().body(updatedJob);
	}
}










