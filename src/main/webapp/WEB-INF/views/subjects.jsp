<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  table {
    text-align: center;
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #444444;
    padding: 10px;
  }
</style>
</head>
<body>
	<!-- SubjectController에서 키 값을 받아 하나씩 꺼내 subject라는 변수에 저장하고 출력-->
	<!-- 객체 출력하게 되면 Subject의 ToString 함수가 불려서 subject에 들어가서 출력-->
	
		<table>
			<tr>
				<th>수강년도</th>
				<th>학기</th>
				<th>교과목명</th>
				<th>교과구분</th>
				<th>담당교수</th>
				<th>학점</th>
			</tr>
			<c:forEach var="subject" items="${subjects }">
			<tr>
				<td><c:out value="${subject.year }"></c:out></td>
				<td><c:out value="${subject.semester }"></c:out></td>
				<td><c:out value="${subject.subject }"></c:out></td>
				<td><c:out value="${subject.classification }"></c:out></td>
				<td><c:out value="${subject.professor }"></c:out></td>
				<td><c:out value="${subject.credit }"></c:out></td>
			</tr>
			</c:forEach>
		</table>
		<%-- <p> <c:out value="${subject }"></c:out> </p> --%>
	

</body>
</html>