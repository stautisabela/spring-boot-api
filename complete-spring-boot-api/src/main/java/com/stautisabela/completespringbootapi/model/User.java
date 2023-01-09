package com.stautisabela.completespringbootapi.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column
	private String address;
	
	@Column(name = "birth_date")
	private String birthDate;
	
	public User() {
		
	}

	public User(String firstName, String lastName, String address, String birthDate) {
		UUID uuid = UUID.randomUUID();
		this.id = uuid.toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.birthDate = birthDate;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthdate() {
		return birthDate;
	}

	public void setBirthdate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lastName, birthDate, id);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(lastName, other.lastName) && Objects.equals(birthDate, other.birthDate)
				&& Objects.equals(id, other.id);
	}
	
	public Date formatDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat ("dd-MM-yyyy");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
}
