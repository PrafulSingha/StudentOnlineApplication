<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Report</title>
</head>
<body>
<h3 style="color:blue;" align="center">${searchSuccess}</h3>  
<form:form action="searchJsonFile" method="post" >  
<p align="center"><label for="idsearch">Type id to search</label></p> 
<p align="center"><input type="text" name="id"/></p>  
<p align="center"><input type="submit" value="Search File"/></p>  
</form:form>
</body>
</html>