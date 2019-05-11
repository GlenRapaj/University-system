package com.glen.RestMVC.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Administrata")
public class Administrata {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="email",nullable=false)
	private String lastName;
	
	@Column(name="grup",nullable=false)
	private String grupi;

	public Administrata() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		
		this.id = id;
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

	@Override
	public String toString() {
		return "Administrata [id=" + id + ", name=" + name + ", lastName=" + lastName + ", grupi=" + grupi + "]";
	}
	
	
}
