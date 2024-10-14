package vn.iostar.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable{
	
	private int id;
	private String fullName;
	private String username;
	private String password; 
	private String email;
	private String avatar;
	private String phoneNumber;
	private Date createdDate;
	private int roleId;
	
	public UserModel() {
		super();
	}

	public UserModel(String fullName, String username, String password, String email,
			String phoneNumber, int roleId) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.roleId = roleId;
	}
	
	public UserModel(int id, String fullName, String username, String password, String email, String avatar,
			String phoneNumber, Date createdDate, int roleId) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.avatar = avatar;
		this.phoneNumber = phoneNumber;
		this.createdDate = createdDate;
		this.roleId = roleId;
	}

	public UserModel(String username, String fullName, String password) {
		super();
		this.username = username;
		this.fullName = fullName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", fullName=" + fullName + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", avatar=" + avatar + ", phoneNumber=" + phoneNumber + ", createdDate="
				+ createdDate + ", roleId=" + roleId + "]";
	}
	
	
	
}
