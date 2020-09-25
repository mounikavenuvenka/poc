package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Job;
import com.example.demo.service.JobService;
import com.example.demo.util.ExcelHelper;
import com.example.demo.util.Response;

@RestController
@RequestMapping("/job")
public class JobController {
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private JobService service;

	@PostMapping(value = "/postjob", produces = { "application/json", "application/xml" }, consumes = {
			"application/xml", "application/json" })

	public Response save(@Valid @RequestBody Job job) {
		log.debug("from save method of job");
		Response job2 = service.saveJob(job);
		return job2;
	}

	@GetMapping(value = "/getJob/{id}", produces = { "application/json", "application/xml" })

	public Response getJobById(@PathVariable("id") int id) {
		log.debug("from get job by id ");
		Response jobById = service.getJobById(id);
		Response res = new Response();
		res.setResult(jobById);
		return res;
	}

	@GetMapping(value = "/getByJobType/{jobType}", produces = { "application/json", "application/xml" })
	public List<Job> getJobByJobType(@PathVariable("jobType") String jobType) {

		log.debug("from get job by job tytpe");
		return service.findJobByJobType(jobType);

	}

	@GetMapping(value = "/getByExp/{exp}", produces = { "application/json", "application/xml" })
	public List<Job> findJobByExperience(@PathVariable("exp") int exp) {
		log.debug("from get job by experience");
		return service.findJobByExperience(exp);

	}

	@GetMapping(value = "/getByCountry/{country}", produces = { "application/xml", "application/json" })

	public List<Job> findJobByCountry(@PathVariable("country") String country) {
		log.debug("from get job by country");
		return service.findJobByCountry(country);

	}

	@GetMapping(value = "/getByAvailability/{availability}", produces = { "application/xml", "application/json" })
	public List<Job> findByAvailability(@PathVariable("availability") String availability) {
		log.debug("from get job by availability");
		String[] avl = availability.split(",");
		return service.findByAvailability(Arrays.asList(avl));
	}

	@GetMapping(value = "/getalljobs", produces = { "application/xml", "application/json" })
	public List<Job> findAll() {
		log.debug("from get all jobs");
		return service.findAll();
	}

	@GetMapping(value = "/getBySkills/{skills}", produces = { "application/xml", "application/json" })
	public List<Job> findBySkillsContaining(@PathVariable String skills) {
		log.debug("from get job by skills");
		return service.findBySkillsContaining(skills);
	}

	@PostMapping("/processexcel")
	public List<Job> uploadFile(@RequestParam("file") MultipartFile file) {

		if (ExcelHelper.hasExcelFormat(file)) {

			try {
				List<Job> list = service.saveAll(file);
				return list;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ArrayList<Job>();

			}
		} else {
			System.out.println("not excel format");
			return new ArrayList<>();
		}

	}

	@GetMapping(value = "/getByPayRate/{low}/{high}", produces = { "application/json", "application/xml" })
	public List<Job> getByPayRate(@PathVariable Integer low, @PathVariable Integer high) {
		List<Job> job = service.findByPayRateBetween(low, high);
		return job;
	}

}
