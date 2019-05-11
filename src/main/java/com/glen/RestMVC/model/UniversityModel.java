package com.glen.RestMVC.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Univesiteti")
public class UniversityModel {

	
	
	
	
	@Id()
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dep_id")
	private int id;
	
	@Column(name="faculty_name",nullable=false)
	private String facultyName;
	
	@Column(name="departament_name",nullable=false)
	private String departamentName;
	
	@Column(name="adres")
	private String adr;

	
	//
	
	/*
	
	@OneToOne(mappedBy="depID")
	private ObjectModel  std ;
	
	
	
	
	public UniversityModel( String facultyName, String departamentName, String adr, ObjectModel std) {
		super();
		
		this.facultyName = facultyName;
		this.departamentName = departamentName;
		this.adr = adr;
		this.std = std;
	}
	
	*/
	

	//
	
	
	
	// kjo nuk ishte e komentuar
	 

	public UniversityModel() {
		super();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getDepartamentName() {
		return departamentName;
	}

	public void setDepartamentName(String departamentName) {
		this.departamentName = departamentName;
	}

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}
	
	
	
	//

	/*
	
	public ObjectModel getStd() {
		return std;
	}

	public void setStd(ObjectModel std) {
		this.std = std;
	}



	@Override
	public String toString() 
	{
		return "UniversityModel [id=" + id + ", facultyName=" + facultyName + ", departamentName=" + departamentName
				+ ", adr=" + adr + ", std=" + std + ", getStd()=" + getStd() + ", getId()=" + getId()
				+ ", getFacultyName()=" + getFacultyName() + ", getDepartamentName()=" + getDepartamentName()
				+ ", getAdr()=" + getAdr() + "]";
	
	}

	*/

	
}
