package com.hdfc.capstone.employee.client.dto;

import java.time.LocalDate;

public class EmployeeDTOEncrypted {
	private long employeeId;
	private String employeeName;
	private byte[] dateOfBirth;
	
	
	
	public EmployeeDTOEncrypted() {
		super();
	}
	
	public EmployeeDTOEncrypted(long employeeId, String employeeName, byte[] dateOfBirth) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.dateOfBirth = dateOfBirth;
	}

	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public byte[] getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(byte[] dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	

}
