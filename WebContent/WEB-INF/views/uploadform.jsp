<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Form</title>
</head>
<body>
<h3 style="color:red">${filesuccess}</h3>  
<form:form action="savefile" method="post" enctype="multipart/form-data">  
<p><label for="fileChoose">Choose File</label></p> 
<p><input type="file" name="file"/></p>  
<p><input type="submit" value="Upload File"/></p>  
</form:form>

</body>
</html>