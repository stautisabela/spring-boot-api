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
	private String LastName;
	
	@Column
	private String Address;
	
	@Column(name = "birth_date")
	private String birthdate;
	
	public User() {
		
	}

	public User(String firstName, String lastName, String address, String birthdate) {
		UUID uuid = UUID.randomUUID();
		this.id = uuid.toString();
		this.firstName = firstName;
		LastName = lastName;
		Address = address;
		this.birthdate = birthdate;
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
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(LastName, birthdate, id);
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
		return Objects.equals(LastName, other.LastName) && Objects.equals(birthdate, other.birthdate)
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
