package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Job;

public interface JobRepo extends JpaRepository<Job, Integer> {
	public List<Job> findJobByJobType(String jobType);

	public List<Job> findJobByExperience(int exp);

	public List<Job> findJobByCountry(String country);

	public List<Job> findByAvailabilityIn(List<String> availability);

	public List<Job> findBySkillsContaining(String skill);

	public List<Job> findByPayRateBetween(Integer low, Integer high);

}
