package com.stautisabela.completespringbootapi.data.vo.v1;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class UserVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String firstName;
	private String lastName;
	private String address;
	private String birthDate;
	
	public UserVO() {
		
	}

	public UserVO(String id, String firstName, String lastName, String address, String birthDate) {
		this.id = id;
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
		UserVO other = (UserVO) obj;
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
