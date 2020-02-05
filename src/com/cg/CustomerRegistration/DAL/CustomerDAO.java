package com.cg.CustomerRegistration.DAL;

import java.util.List;
import java.util.Map;

import com.cg.CustomerRegistration.DTO.*;

public interface CustomerDAO {
	public String addCustomer(CustomerDTO c);
	public String deleteAllCustomer();
	public String modifyCustomerDetails(int id,String name);
	public List<CustomerDTO> fetchAllCustomer();
	//public List<CustomerDTO> fetchAllCustomer();
	public CustomerDTO fetchCustomerDetailsOnName(String name);
	public String deleteCustomerBasedOnId(int id);

}
