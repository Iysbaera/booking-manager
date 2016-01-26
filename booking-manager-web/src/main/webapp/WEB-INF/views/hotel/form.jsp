<%--
  User: Michal
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:label path="name">Hotel Name</form:label>
<form:input path="name" id="name"/>
<form:errors path="name" cssClass="error"/>


<%--	    <form:label path="email">Email</form:label>
            <form:input path="email" id="email"/>
            <form:errors path="email" cssClass="error"/>
--%>