<%-- 
    Document   : form
    Created on : Dec 16, 2015, 6:03:45 PM
    Author     : Jana Cechackova
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
            <form:label path="forename">Forename</form:label>
            <form:input path="forename" id="forename"/>
            <form:errors path="forename" cssClass="error"/>

<form:label path="surname">Surname</form:label>
<form:input path="surname" id="surname"/>
<form:errors path="surname" cssClass="error"/>

<form:label path="email">email</form:label>
<form:input path="email" id="email"/>
<form:errors path="email" cssClass="error"/>

<form:label path="password">password</form:label>
<form:input path="password" id="password" type="password"/>
<form:errors path="password" cssClass="error"/>

<%--	    <form:label path="email">Email</form:label>
            <form:input path="email" id="email"/>
            <form:errors path="email" cssClass="error"/>
--%>   