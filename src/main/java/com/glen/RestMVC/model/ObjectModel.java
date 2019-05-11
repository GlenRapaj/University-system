package com.glen.RestMVC.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

//@XmlRootElement
@Entity
@Table(name="Student")
public class ObjectModel {

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="last_name",nullable=false)
	private String lastName;
	
	@Column(name="grup",nullable=false)
	private String grupi;
	
	@Column(name="marks_math")
	private int marksMath;
	
	@Column(name="marks_calcus")
	private int marksCalcus;
	
	@Column(name="marks_programing")
	private int marksPrograming;
	
	@Column(name="marks_statistics")
	private int marksStatistics;
	
	//@OneToOne(cascade=CascadeType.PERSIST),fetch = FetchType.LAZY    ,nullable=false
	@ManyToOne(cascade=CascadeType.PERSIST )
	@JoinColumn(name="department_id")
	private UniversityModel  depID;

	//
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="date_of_starting")
	private Date doj;
	
	@Column(name="payment")
	private double payment;

	
	
	
	
	
	

	public ObjectModel(String name, String lastName, String grupi, int marksMath, int marksCalcus, int marksPrograming,
			int marksStatistics, UniversityModel depID, Date doj, double payment) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.grupi = grupi;
		this.marksMath = marksMath;
		this.marksCalcus = marksCalcus;
		this.marksPrograming = marksPrograming;
		this.marksStatistics = marksStatistics;
		this.depID = depID;
		this.doj = doj;
		this.payment = payment;
	}




	public ObjectModel() {
		super();
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UniversityModel getDepID() {
		return depID;
	}




	public void setDepID(UniversityModel depID) {
		this.depID = depID;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGrupi() {
		return grupi;
	}

	public void setGrupi(String grupi) {
		this.grupi = grupi;
	}

	public int getMarksMath() {
		return marksMath;
	}

	public void setMarksMath(int marksMath) {
		this.marksMath = marksMath;
	}

	public int getMarksCalcus() {
		return marksCalcus;
	}

	public void setMarksCalcus(int marksCalcus) {
		this.marksCalcus = marksCalcus;
	}

	public int getMarksPrograming() {
		return marksPrograming;
	}

	public void setMarksPrograming(int marksPrograming) {
		this.marksPrograming = marksPrograming;
	}

	public int getMarksStatistics() {
		return marksStatistics;
	}

	public void setMarksStatistics(int marksStatistics) {
		this.marksStatistics = marksStatistics;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}




	@Override
	public String toString()
	{
		return "ObjectModel [id=" + id + ", name=" + name + ", lastName=" + lastName + ", grupi=" + grupi
				+ ", marksMath=" + marksMath + ", marksCalcus=" + marksCalcus + ", marksPrograming=" + marksPrograming
				+ ", marksStatistics=" + marksStatistics + ", depID=" + depID + ", doj=" + doj + ", payment=" + payment
				+ ", getId()=" + getId() + ", getDepID()=" + getDepID() + ", getName()=" + getName()
				+ ", getLastName()=" + getLastName() + ", getGrupi()=" + getGrupi() + ", getMarksMath()="
				+ getMarksMath() + ", getMarksCalcus()=" + getMarksCalcus() + ", getMarksPrograming()="
				+ getMarksPrograming() + ", getMarksStatistics()=" + getMarksStatistics() + ", getDoj()=" + getDoj()
				+ ", getPayment()=" + getPayment() + "]";
	}


	

	

	
	
}
