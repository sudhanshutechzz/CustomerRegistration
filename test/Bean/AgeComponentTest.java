package Bean;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ExceptionPackage.CustomException;

public class AgeComponentTest {
	static AgeComponent obj;
	@BeforeClass
	public static void start()
	{
		 obj=new AgeComponent();
		 System.out.println("helo");
	}
	
    //@Ignore
	@Test
	public void testIsValidAge()
	{//System.out.println("inside 1");
		boolean flag=obj.isValidAge(23);
		assertTrue(flag);
	}
	
	
	@Test(expected=CustomException.class)
	public void testIsValidAgeWith_veValue()
	{
		
		boolean flag=obj.isValidAge(-23);
		assertFalse(flag);
	}
	
	
	@Test
	public void testisString()
	{
		
		assertEquals("hello",obj.isString("hello"));
	}
	
	
	@AfterClass
	public static void stop()
	{
		 obj=null;
		 System.out.println("end");
	}

}
