package com.glen.RestMVC.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "perdorues")
public class Perdorues {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "id")
	private int id;
		
		@Column(name = "name" ,nullable=false)
	private String name;
		
		@Column(name = "last_name", nullable=false)
	private String lastName;
		
		@Column(name = "username" , nullable=false )
	private String email;
		
		@Column(name = "password", nullable=false)
	private String pasword;
		
		
		/*
		 @ManyToMany(cascade=CascadeType.ALL)
		 @JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
		*/
		@Column(name = "role")
		private String role;
		
		@Column(name = "enabled")
	private short enabled;

	

	

		public Perdorues(int id, String name, String lastName, String email, String pasword, String role,
				short enabled) {
			super();
			this.id = id;
			this.name = name;
			this.lastName = lastName;
			this.email = email;
			this.pasword = pasword;
			this.role = role;
			this.enabled = enabled;
		}



		public Perdorues() {
			super();
		}
		
		

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPasword() {
			return pasword;
		}

		public void setPasword(String pasword) {
			this.pasword = pasword;
		}

		public short getEnabled() {
			return enabled;
		}

		public void setEnabled(short enabled) {
			this.enabled = enabled;
		}

		@Override
		public String toString() {
			return "Perdorues [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email
					+ ", pasword=" + pasword + ", role=" + role + ", enabled=" + enabled + "]";
		}


		

}
