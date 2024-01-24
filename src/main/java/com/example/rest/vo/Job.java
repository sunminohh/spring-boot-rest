package com.example.rest.vo;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Alias("Job")
public class Job {

	private String id;
	private String title;
	private int minSalary;
	private int maxSalary;
}
