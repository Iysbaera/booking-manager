<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="booking" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<booking:layout title="hotel">
<jsp:attribute name="body">
    <h1>Registration</h1>
    <sec:authorize access="isAnonymous()">
        <p>hovno</p>
    </sec:authorize>
    <form:form method="POST" action="${pageContext.request.contextPath}/auth/register" modelAttribute="customer">
        First name: <form:input path="forename" /><br />
        Last name: <form:input path="surname" /><br />
        <%-- Email : <form:input path="email" type="email" /><br />
        Password: <form:input path="password" /><br /> --%>
        <input type="submit" value="Register">
    </form:form>
</jsp:attribute>
</booking:layout>
