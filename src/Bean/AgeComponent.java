package Bean;

import ExceptionPackage.CustomException;

public class AgeComponent {
	int age;
	public boolean isValidAge(int age)
	{
		if(age<0)
		throw new CustomException("this is exception");
	else if(age>=18)
			return true;
		
		else
			return false;
	}
	public String isString(String str)
	{
		return str;
	}

}
