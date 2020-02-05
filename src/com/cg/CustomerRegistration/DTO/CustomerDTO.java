package com.cg.CustomerRegistration.DTO;

public class CustomerDTO {
	private int custId;
	private String name;
	private Long phoneNo;
	private String address;
	private String email;
	public CustomerDTO()
	{
		
	}
	public CustomerDTO(int custId, String name, Long phoneNo, String address, String email) {
		super();
		this.custId = custId;
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		this.email = email;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "CustomerDetails [custId=" + custId + ", name=" + name + ", phoneNo=" + phoneNo + ", address=" + address
				+ ", email=" + email + "]\n";
	}
	
	

}
