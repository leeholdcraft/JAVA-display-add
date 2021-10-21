<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
          <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>
    
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Dojo Page</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous"> -->
		
	</head>
	<body>
	   <div class="dashboardContiner">
	   	<header>
	   	<h1>${dojos.name} Location Ninjas</h1>
	   	</header>
			<table class="table table-striped table-bordered">
		    	<thead>
				    <tr>
				      <th scope="col">First Name</th>
				      <th scope="col">Last Name</th>
				      <th scope="col">Age</th>
				   </tr>
				 </thead>
				 <tbody>
					 <c:forEach items="${dojos.ninjas}" var="nin">
					    <tr>
						     <td><c:out value="${nin.firstName}"/></td>
						     <td><c:out value="${nin.lastName}"/></td>
						     <td><c:out value="${nin.age}"/></td>
					    </tr>
				     </c:forEach> 
				 </tbody>
			</table>
		</div>
	</body>
</html>