package Bean;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class NameValidationTest {
	static NameValidation obj;
	@BeforeClass
	public static void start()
	{
		 obj=new NameValidation();
		 System.out.println("helo");
	}
	

	@Test
	public void testIsValidName() {
		boolean pattern=Pattern.matches("[A-Z][a-z]{8}",obj.isValidName("Sudhanshu"));
		assertTrue(pattern);
		
		
		
	}
	@AfterClass
	public static void stop()
	{
		 obj=null;
		 System.out.println("end");
	}


}
