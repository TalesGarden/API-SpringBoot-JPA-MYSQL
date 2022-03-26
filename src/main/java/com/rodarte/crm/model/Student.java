package com.rodarte.crm.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//JPA ANNOTATION, entity class  is mapped to DB) 

@Entity
public class Student{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = true)
	private int age;
	
	@Column(nullable = false)
	private double averageGrades;
	
	@Column(nullable = true)
	private double firstGrade;
	
	@Column(nullable = true)
	private double secondGrade;
	
	@Column(nullable = true)
	private double thirdGrade;
	
	@Column(nullable = true)
	private String gender;
	
	@Column(nullable = true)
	private Date birthday;
	
	

	
	public double getFirstGrade() {
		return firstGrade;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date date) {
		this.birthday = date;
	}

	public void setFirstGrade(double firstGrade) {
		this.firstGrade = firstGrade;
	}

	public double getSecondGrade() {
		return secondGrade;
	}

	public void setSecondGrade(double secondGrade) {
		this.secondGrade = secondGrade;
	}

	public double getThirdGrade() {
		return thirdGrade;
	}

	public void setThirdGrade(double thirdGrade) {
		this.thirdGrade = thirdGrade;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/*public SimpleDateFormat getSdf() {
		return sdfbirthday;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdfbirthday = sdf;
	}
	*/


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(id, other.id);
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getAverageGrades() {
		return averageGrades;
	}
	
	public void setAverageGrades(double averageGrades) {
		this.averageGrades = averageGrades;
	}


	 
}
