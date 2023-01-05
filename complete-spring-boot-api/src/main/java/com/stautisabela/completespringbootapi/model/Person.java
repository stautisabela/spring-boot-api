package com.stautisabela.completespringbootapi.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String firstName;
	private String LastName;
	private String Address;
	private Date birthdate;
	
	public Person() {
		
	}

	public Person(String firstName, String lastName, String address, String birthdate) {
		UUID uuid = UUID.randomUUID();
		this.id = uuid.toString();
		this.firstName = firstName;
		LastName = lastName;
		Address = address;
		this.birthdate = formatDate(birthdate);
	}

	public String getId() {
		return id;
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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
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
		Person other = (Person) obj;
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
