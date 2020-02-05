package com.cg.CustomerRegistration.service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.cg.CustomerRegistration.DTO.CustomerDTO;

import ExceptionPackage.CustomException;

public class ValidationTest {
	static Validation obj;
	@BeforeClass
	public static void start()
	{obj=new Validation();
		
	}

	@Test
	public void testIsValidCustomer() {
		CustomerDTO custDTO=new CustomerDTO(10,"Sudhanshu",8222857576l,"vishnu","sudhanhu@gmail.vom");
		assertTrue(obj.isValidCustomer(custDTO));
	}

	@Test
	public void testIsValidId() {
	assertTrue(obj.isValidId(10));
	}

	@Test
	public void testIsValidName() {
		assertTrue(obj.isValidName("Sudhanshu"));
	}

	@Test
	public void testIsValidPhonenumber() {
		assertTrue(obj.isValidPhonenumber(8222842456L));
	}

	@Test
	public  void testIsValidemail() {
		assertTrue(obj.isValidemail("sudhanhsurajpal9841@gmail.com"));
	}
	@AfterClass
	public static void stop()
	{obj=null;
		
	}

}
