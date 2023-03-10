package com.stautisabela.completespringbootapi.data.vo.v1;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "firstName", "lastName", "address", "birthDate"})
public class UserVO extends RepresentationModel<UserVO> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private String userId;
	private String firstName;
	private String lastName;
	private String address;
	private String birthDate;
	private Boolean active;
	
	public UserVO() {
	}

	public UserVO(String userId, String firstName, String lastName, String address, String birthDate, Boolean active) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.birthDate = birthDate;
		this.active = active;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String id) {
		this.userId = id;
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lastName, birthDate, userId);
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
				&& Objects.equals(userId, other.userId);
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
