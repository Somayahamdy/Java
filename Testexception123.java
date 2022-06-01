class Exceptionss extends Exception{
	public Exceptionss (String str){
		super(str);
	}
}

public class Exception11{

	//method to check gender
	static void validate1 (String gender) throws Exceptionss{
		if(gender=="Female"){
			throw new Exceptionss ("not vaild");
		}
		else
		{
			System.out.println("welcom to vote");
		}
	}
	// method to check age
	static void validate2 (int age) throws Exceptionss{
		if(age<=10){
			throw new Exceptionss ("age is not valid to vote ");
		}
		else
		{
			System.out.println("welcom to vote");
		}
	}
	// method to check salary
	static void validate3 (int salary) throws Exceptionss{
		if(salary <=10000){
			throw new Exceptionss ("salary not in rang");
		}
		else
		{
			System.out.println("welcom to vote");
		}
	}
}
public class Exception22{
	public static void main(String[] args) {
	//Exception11 ex2 = new 	
try{
	validate1("Female");
	validate2("3");
	validate3("188");
}	
catch (Exceptionss ex)
{
	System.out.println("cought the exception");
	System.out.println(" exception ocured"+ex);
}
finally{
     System.out.println("the code is perfect by this way");
}
}
}



/*

public class Testexception123{	
public static void main(String[] args) {
Exceptionss.Exception22 ex2 = new Exceptionss.Exception22();
ex2.validate1("Female");
ex2.validate2("3");
ex2.validate3("188");
}
	
}	
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


