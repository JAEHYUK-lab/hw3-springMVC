<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home</title>
</head>
<body>

	<%-- <p>
		<a href="${pageContext.request.contextPath }/subjects"> Show current subjects </a>
	</p> --%>
	<p>
		<a href="${pageContext.request.contextPath }/subjectslist"> 학년/학기별
			이수 총 학점 </a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath }/createsubject"> 수강
			신청하기 </a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath }/newsubjectslist"> 수강
			신청 조회 메뉴</a>
	</p>

	<%-- <c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>

	<form id="logout" action="<c:url value="/logout" />" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form> --%>

	<c:if test="${pageContext.request.userPrincipal.name != null}">

		<c:url var="logoutUrl" value="/logout" />

		<form class="form-inline" action="${logoutUrl}" method="post">
			<input type="submit" value="Log out" /> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>

	</c:if>


</body>
</html>
