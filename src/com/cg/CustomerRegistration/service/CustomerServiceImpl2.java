package com.cg.CustomerRegistration.service;

import java.util.List;
import java.util.Map;

import com.cg.CustomerRegistration.DAL.CustomerDAO;
import com.cg.CustomerRegistration.DAL.CustomerDAOImpl;
import com.cg.CustomerRegistration.DAL.CustomerDAOimpljdbc;
import com.cg.CustomerRegistration.DTO.CustomerDTO;

import ExceptionPackage.CustomException;

public class CustomerServiceImpl2 implements CustomerService {
CustomerDAO cd;
public CustomerServiceImpl2() throws CustomException{
	cd=new CustomerDAOimpljdbc();
}
Validation valid=new Validation();
	@Override
	public String addCustomer(CustomerDTO c) {
		if(valid.isValidCustomer(c))
		return cd.addCustomer(c);
		else
			return "null";
	}

	@Override
	public String deleteAllCustomer() {
		
		return cd.deleteAllCustomer();
	}

	@Override
	public String modifyCustomerDetails(int id, String name) {
		// TODO Auto-generated method stub
		String msg="";
		if(valid.isValidId(id)&&valid.isValidName(name))
		{
			msg =cd.modifyCustomerDetails(id, name);
		}
			//throw new CustomException("Data is not valid")
				
		return msg;
		}

	@Override
	public List<CustomerDTO> fetchAllCustomer() {
		// TODO Auto-generated method stub
		return cd.fetchAllCustomer();
	}

	@Override
	public CustomerDTO fetchCustomerDetailsOnName(String name) {
		if(valid.isValidName(name))
		{
		return cd.fetchCustomerDetailsOnName(name);
		}
		else
			return null;
	}

	@Override
	public String deleteCustomerBasedOnId(int id) {
		// TODO Auto-generated method stub
		if(valid.isValidId(id))
		return cd.deleteCustomerBasedOnId(id);
		else
			return "null";
	}

}
