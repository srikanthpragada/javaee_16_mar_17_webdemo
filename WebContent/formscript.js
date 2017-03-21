  function validate()
   {
	   var uname = document.getElementById("uname");
	   var userError = document.getElementById("userError");
	   
	   if (uname.value == "")
	   {
		   userError.innerHTML = "Please enter username!";
		   return false;  // validation failed 
   	   }   
	   
	   return true; // valid 
  }