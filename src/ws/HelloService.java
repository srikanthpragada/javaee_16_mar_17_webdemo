package ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService 
public class HelloService {
	
	@WebMethod 
	public String hello()
	{
	  return "Hello from Soap Service";	
	}
	
	@WebMethod 
	public String greet(String name)
	{
	  return "Hello," + name;	
	}

}
