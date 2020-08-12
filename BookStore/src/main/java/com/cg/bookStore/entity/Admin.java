package com.cg.bookStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


/********************************************************************************************************
 *          @author          Ranjith Reddy B N
 *          Description      It is an Entity class of Admin that is mapped with the Oracle DataBase
 *                                       of table bookstore_admin.
 *          @version         1.0
 *          Created Date     04-08-2020
 ********************************************************************************************************/

@Entity
@Table(name="bookstore_admin")
@DynamicUpdate
@DynamicInsert
public class Admin {

	@Column(name="admin_id")
	private long adminId;
	
	@Id
	@Column(name="email")
	@Size(min=10, max=64)
	private String email;
	
	@Column(name="full_name")
	@Size(min=1, max= 16)
	private String fullName;
	
	@Column(name="password")
	@Size(min=8, max= 16)
	private String password;

	
	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
