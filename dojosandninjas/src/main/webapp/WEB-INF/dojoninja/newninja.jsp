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
		<title>New Ninja</title>
	</head>
	<body>
		<form:form action="/ninjas" method="post" modelAttribute="ninjas">
			<p>
				<form:label path="dojo" for="formGroupExampleInput" class="col-sm-4 form-label">Dojo:</form:label>
				<form:errors path="dojo"/>
				<form:select path="dojo" class="form-select" id="specificSizeSelect">
					<c:forEach items = "${dojos}" var="dojo">
						<form:option value="${dojo.id }" >
							<c:out value="${dojo.name}"/>
						</form:option>
					</c:forEach>
				</form:select>
			</p>
		    <p>
		        <form:label path="firstName">First Name</form:label>
		        <form:errors path="firstName"/>
		        <form:input path="firstName"/>
		    </p>
		    <p>
		        <form:label path="lastName">Last Name</form:label>
		        <form:errors path="lastName"/>
		        <form:input path="lastName"/>
		    </p>
		    <p>
		        <form:label path="age">Age</form:label>
		        <form:errors path="age"/>
		        <form:input path="age"/>
		    </p>     
		    <input type="submit" value="Submit"/>
		</form:form> 
	</body>
</html>