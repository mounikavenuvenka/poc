package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Job;
import com.example.demo.repo.JobRepo;
import com.example.demo.util.ExcelHelper;
import com.example.demo.util.Response;

@Service
public class JobService {
	@Autowired
	private JobRepo repo;

	public Response saveJob(Job job) {
		Job save = repo.save(job);
		Response response = new Response();

		if (save.getId() != null) {
			response.setMessage("User saved with username" + save.getUserName());
			response.setResult(save);
			response.setStatus(HttpStatus.CREATED);
		} else {
			response.setMessage("user not saved");
			response.setStatus(HttpStatus.BAD_REQUEST);
		}
		return response;

	}

	public Response getJobById(Integer id) {
		Optional<Job> findById = repo.findById(id);
		Response response = new Response();

		if (findById != null) {
			response.setMessage("user found");
			response.setResult(findById);
			response.setStatus(HttpStatus.FOUND);

			return response;
		} else {
			response.setMessage("Object Not Found");
			response.setStatus(HttpStatus.NOT_FOUND);
		}
		return response;
	}

	public List<Job> findJobByJobType(String jobType) {
		return repo.findJobByJobType(jobType);
	}

	public List<Job> findJobByExperience(int exp) {
		return repo.findJobByExperience(exp);
	}

	public List<Job> findJobByCountry(String country) {
		return repo.findJobByCountry(country);

	}

	public List<Job> findByAvailability(List<String> availability) {
		return repo.findByAvailabilityIn(availability);

	}

	public List<Job> findAll() {
		return repo.findAll();
	}

	public List<Job> findBySkillsContaining(String skill)

	{
		return repo.findBySkillsContaining(skill);
	}

	public List<Job> saveAll(MultipartFile file) {
		try {
			List<Job> jobs = ExcelHelper.excelToTutorials(file.getInputStream());
			List<Job> saveAll = repo.saveAll(jobs);
			System.out.println(saveAll);
			return saveAll;
		} catch (IOException e) {
			System.out.println("from exception");
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

	public List<Job> findByPayRateBetween(Integer low, Integer high) {

		return repo.findByPayRateBetween(low, high);
	}
	
	
}
