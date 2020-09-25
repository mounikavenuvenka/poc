package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Job {
	@Id
	@GeneratedValue
	private Integer id;

	@NotBlank(message = "job title canot be null or empty")
	private String jobTitle;

	@NotBlank(message = "jd cannot be null or empty")
	private String jobDescription;

	@NotBlank(message = "Country name cannot be empty")
	private String country;

	@NotBlank(message = "state name cannot be empty")
	private String state;

	@NotBlank(message = "avaliability name cannot be empty")
	private String availability;

	@NotNull(message = "reply rate name cannot be empty")
	private Integer replyRate;

	@NotNull(message = "payrate name cannot be empty")
	private Integer payRate;

	@NotNull(message = "Experience name cannot be empty")
	private Integer experience;
	@NotBlank(message = "skills not empty")
	private String skills;
	@NotBlank(message = "Language name cannot be empty")
	private String language;
	@NotBlank(message = "JobType name cannot be empty")
	private String jobType;
	@OneToOne
	private User userName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Integer getReplyRate() {
		return replyRate;
	}

	public void setReplyRate(Integer replyRate) {
		this.replyRate = replyRate;
	}

	public Integer getPayRate() {
		return payRate;
	}

	public void setPayRate(Integer payRate) {
		this.payRate = payRate;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public User getUserName() {
		return userName;
	}

	public void setUserName(User userName) {
		this.userName = userName;
	}

	public Job() {
		super();
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", jobTitle=" + jobTitle + "]";
	}

}
