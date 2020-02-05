package com.cg.CustomerRegistration.DAL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.CustomerRegistration.DTO.*;

import ExceptionPackage.CustomException;

public class CustomerDAOImpl implements CustomerDAO{
	
static Map<Integer,CustomerDTO> empMap=new HashMap<Integer,CustomerDTO>();

public CustomerDAOImpl() throws CustomException
{
	PropertyConfigurator.configure("resource/customerlog.properties");	
}
Logger log=Logger.getRootLogger();



@Override
public String addCustomer(CustomerDTO c) {
	Staticdbmap.getMap().put(c.getCustId(), c);
	log.setLevel(Level.INFO);
	log.info("customer is added");
	
	
	
	return "customer is added";
}



@Override
public String deleteAllCustomer() {
	if(Staticdbmap.getMap().size()!=0)
	{
		Staticdbmap.getMap().clear();
		log.warn("all customer deleted");
		return "all customer deleted";
	}
	else
		throw new CustomException("Already Empty");
	
}



@Override
public String modifyCustomerDetails(int id, String name) {
	if(Staticdbmap.getMap().containsKey(id)) {
	Staticdbmap.getMap().get(id).setName(name);
	log.fatal("Customer modified");
	return "Customer modified";
	}
	else
		throw new CustomException("Id not Found");
}



@Override
public List<CustomerDTO> fetchAllCustomer() {
	List<CustomerDTO> list=new ArrayList<>();
	if(Staticdbmap.getMap().size()!=0)
	{
	log.error("return all customer detail");
	for(Map.Entry<Integer, CustomerDTO> entry:Staticdbmap.getMap().entrySet())
	{
		list.add(entry.getValue());
	}
	return list;
	}
	else
		 throw new CustomException("list is emptied");
}



@Override
public CustomerDTO fetchCustomerDetailsOnName(String name) {
	for(Map.Entry<Integer, CustomerDTO> entry:Staticdbmap.getMap().entrySet())
	{
		if(entry.getValue().getName().equals(name))
		{
			return entry.getValue();
		}
		else
			throw new CustomException("Name not found");
	}
	log.debug("fetch customer based on name");
	return null;
}



@Override
public String deleteCustomerBasedOnId(int id) {
	if(Staticdbmap.getMap().containsKey(id))
	{
	Staticdbmap.getMap().remove(id);
	log.warn("customer deleted");
	return "customer deleted";
	}
	else
		throw new CustomException("id not found");
}






	/*@Override
	public String addCustomer(CustomerDTO c) {
	StaticDb.getList().add(c);
	log.info("added correctly");
	return "you added successfully";
	
		
	}

	
	@Override
	public String deleteAllCustomer() {
		StaticDb.getList().clear();
		return "all Customers are deleted";
		
	}

	
	@Override
	public String modifyCustomerDetails(int id,String name) {
		Iterator<CustomerDTO> itr=StaticDb.getList().iterator();
		while(itr.hasNext())
		{
			CustomerDTO obj=itr.next();
			if((obj.getCustId())==id)
			{
			 obj.setName(name);
			}
		}
		
		
		return "details are modified";
	}

	
	@Override
	public List<CustomerDTO> fetchAllCustomer() {
	
		return  StaticDb.getList();
		
	}

	@Override
	public CustomerDTO fetchCustomerDetailsOnName(String name) {
		Iterator<CustomerDTO> itr=StaticDb.getList().iterator();
		while(itr.hasNext())
		{CustomerDTO obj=itr.next();
		
			if(obj.getName().equals(name))
			{
				return obj;
			}
		}
		return null;
		
	}

	@Override
	public String deleteCustomerBasedOnId(int id) {
		Iterator<CustomerDTO> itr=StaticDb.getList().iterator();
		String sname=new String();
		while(itr.hasNext())
		{
			CustomerDTO obj=itr.next();
			if((obj.getCustId())==id)
				{
				 sname=obj.getName();
				itr.remove();
				}
		}
		return sname;
		
	}
	*/

}
