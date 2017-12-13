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
<body style="background-color: gray;"> 
<form:form action="savefile" method="post" enctype="multipart/form-data">  
<p align="center"><label for="fileChoose">Choose File To Upload</label></p> 
<p align="center"><input type="file" name="file"/></p>  
<p align="center"><input type="submit" value="Upload File"/></p>  
</form:form>
<br>
<br>
<p align="center"><a href="index">Go To Home</a></p>
</body>
</html>