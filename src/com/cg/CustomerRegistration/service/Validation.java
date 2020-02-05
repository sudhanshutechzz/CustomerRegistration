package com.cg.CustomerRegistration.service;
import java.util.regex.Pattern;

import com.cg.CustomerRegistration.DTO.*;

import ExceptionPackage.CustomException;

public class Validation {
	
	public boolean isValidCustomer(CustomerDTO c)
	{
		return (isValidId(c.getCustId())&&isValidName(c.getName())&&isValidPhonenumber(c.getPhoneNo())&&isValidemail(c.getEmail())); 
	}
	public boolean isValidId(int id)
	{
		if(Pattern.matches("[0-9]{1,}",String.valueOf(id)))
		{
			return true;
		}
		else
		 throw new CustomException("Please Enter valid String");
			
	}
	public boolean isValidName(String name)
	{
		if(Pattern.matches("[A-Z][a-z]{1,26}", name))
				{return true;
			
				}
		else
			throw new CustomException("Please Enter valid Name");
		
	}
	public boolean isValidPhonenumber(Long phnno)
	{
		if(Pattern.matches("[1-9][0-9]{9}",phnno.toString()))
			return true;
		else
			throw new CustomException("Please Enter valid Phone Number");
		
	}
	public boolean isValidemail(String email)
	{
		if(Pattern.matches("[a-zA-Z0-9._]+@+[a-zA-Z]+.+[a-z]{2,6}",email))
		{
			return true;
		}
		else
			throw new CustomException("Please Enter valid Email");
		
			
	}
	public boolean isValidAddress(String address)
	{
		if(Pattern.matches("[A-za-z0-9]*", address))
		{
			return true;
		}
		else
			throw new CustomException("Please Enter valid Address");
		
	}

}
