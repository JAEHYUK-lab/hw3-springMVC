<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" 
	href="${pageContext.request.contextPath}/resources/css/main.css">

</head>
<body>

	<sf:form method="post" action="${pageContext.request.contextPath}/dosubject" modelAttribute="subject">
		<table class="formtable">
			<tr> <td class="label"> Year:</td> 
				<td> <sf:input class="control" type="text" path="year" /> <br/>
				<sf:errors path="year" class="error"/> </td> </tr>
			<tr> <td class="label"> Semester:</td> 
				<td> <sf:input class="control" type="text" path="semester"/> <br/>
				<sf:errors path="semester" class="error"/> </td> </tr>
			<tr> <td class="label"> Subject:</td>
				<td> <sf:input class="control" path="subject"/> <br/>
				<sf:errors path="subject" class="error"/> </td> </tr>
			<tr> <td class="label"> Classification:</td>
				<td> <sf:input class="control" path="classification"/> <br/>
				<sf:errors path="classification" class="error"/> </td> </tr>
			<tr> <td class="label"> Professor:</td> 
				<td> <sf:input class="control" path="professor"/> <br/>
				<sf:errors path="professor" class="error"/> </td> </tr>
			<tr> <td class="label"> Credit:</td>
				<td> <sf:input class="control" path="credit" /> <br/>
				<sf:errors path="credit" class="error"/> </td> </tr>
			<tr> <td> </td> <td> <input type="submit" value="수강 신청"/> </td> </tr>
		</table>
	</sf:form>
	

</body>
</html>