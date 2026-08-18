package com.bank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequestDTO {

	@NotBlank(message ="Username Required")
    private String username;

	@NotBlank(message ="Password Required")
	@Size(min = 8,max = 20,message ="Password must be 8-20 chars")
    private String password;

	@NotBlank(message ="First Name Required")
    private String firstName;

	@NotBlank(message ="Last Name Required")
    private String lastName;

    @Email(message ="Invalid Email")
    private String email;

    @NotBlank(message ="Phone Required")
    private String phone;

    private String address;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

    
}