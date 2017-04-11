package jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean 
public class HelloBean {

	  // property message 
	  public String getMessage() {
		  return "Hello JSF";
	  }
}
