package com.cg.CustomerApp.presentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.cg.CustomerRegistration.DAL.*;
import com.cg.CustomerRegistration.DTO.*;
import com.cg.CustomerRegistration.service.*;

import ExceptionPackage.CustomException;
public class DesignUI {

	public static void main(String[] args) {
		CustomerService  cs=null;
		Logger log=Logger.getLogger("DesignUI.class");
		log.setLevel(Level.ERROR);
		Scanner sc=new Scanner(System.in);
		int choice=0;
		try {
		cs=new CustomerServiceImpl2();
		}
		catch(CustomException ce) {
			ce.printStackTrace();
		}
	
		boolean y=false;
	Task:
	while(true)
	{	try
	{
		System.out.println("************Welcome to Customer Registration****************");
		System.out.println("Press 1: to Add a Customer");
		System.out.println("Press 2: to Display all Customer");
		System.out.println("Press 3: to Delete Customer based on id");
		System.out.println("Press 4: to delete all customer");
		System.out.println("Press 5: to fetch customer details based on name");
		System.out.println("Press 6: to update the name based on id");
		System.out.println("Press 7: for Exit");
		System.out.println("Enter your Choice");
		if(y==true)
		sc.nextLine();
		choice=sc.nextInt();		
		switch(choice)
		{
		case 1:
		{  
			CustomerDTO cust=new CustomerDTO();
			try
			{
			
			System.out.println("Enter Customer Id");
			cust.setCustId(Integer.parseInt(sc.next("[0-9]*")));
			}
			catch(CustomException exp) {
				System.err.println(exp.getMessage());
			}
			catch(InputMismatchException e)
			{
				System.err.println("Invalid Input");
			}
	
			try
			{
			System.out.println("Enter the Customer name");
			cust.setName(sc.next("[A-Z][a-z]{1,26}"));
			}
			catch(CustomException exp) {
				System.err.println(exp.getMessage());
			}
			
			try
			{
			System.out.println("Enter the Phone Number");
			cust.setPhoneNo(Long.parseLong(sc.next("[1-9][0-9]{9}")));
			}
			catch(CustomException exp) {
				System.err.println(exp.getMessage());
			}
		
			try
			{
			System.out.println("Enter the address");
			cust.setAddress(sc.next());
			sc.nextLine();
			}
			catch(CustomException exp) {
				System.err.println(exp.getMessage());
			}
			try
			{
			System.out.println("Enter the email");
			cust.setEmail(sc.next());
			}
			catch(CustomException exp) {
				System.err.println(exp.getMessage());
			}
			
			cs.addCustomer(cust);
			System.out.println("Customer is added");
			log.error("customer is added");
			
			
			break;
			
		}
		
		case 2:
		{
			try
			{
			List<CustomerDTO> list=new ArrayList<CustomerDTO>();
			list=cs.fetchAllCustomer();
			/*for(Map.Entry<Integer, CustomerDTO> entry:map.entrySet())
			{
			System.out.println(entry.getKey()+" "+entry.getValue());
			}*/
			list.stream().filter(x->x.getName().length()>5).forEach(System.out::println);
			
			}
			catch(CustomException exp) {
				System.err.println(exp.getMessage());
			}
			break;
		}
		
		case 3:
		{
			try
			{
			System.out.println("Enter the id of the customer which is to be removed");
			int id=sc.nextInt();
			String msg=cs.deleteCustomerBasedOnId(id);
			System.out.println(msg+"is deleted");
			}
			catch(CustomException exp) {
				System.err.println(exp.getMessage());
			}
			break;
			
		}
		case 4:
		{
			try
			{
			String name=cs.deleteAllCustomer(); 
			System.out.println(name);
			}
			catch(CustomException exp) {
				System.err.println(exp.getMessage());
			}
			break;
		}
		case 5:
		{
			try
			{
			System.out.println("Enter the name");
			String name=sc.next();
			System.out.println(cs.fetchCustomerDetailsOnName(name));
			}
			catch(CustomException exp)
			{
				System.err.println(exp.getMessage());
				
			}
			break;
		}
		case 6:
		{
			try{
				System.out.println("Enter the Id");
			
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the new name");
			String name=sc.next();
			
			String msg=cs.modifyCustomerDetails(id,name);
			System.out.println(msg);
			}
			catch(CustomException exp) {
				System.err.println(exp.getMessage());
			}
			break;
			
		}
		case 7:
		{
			System.exit(0);
			break;
		}
		
		}
		
	}
	catch(InputMismatchException e)
	{
		System.out.println("Enter valid choice");
		y=true;
		continue Task;
	}
	}
	

	}

}
