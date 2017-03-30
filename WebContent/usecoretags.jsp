<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Using Core Tags</title>
</head>
<body>

   <c:out value="Hello!" />
   <p/>
   <c:forEach  var="c"  begin="1"   end="10" step="2">
          ${c} <p/>
    </c:forEach>
	 

</body>
</html>