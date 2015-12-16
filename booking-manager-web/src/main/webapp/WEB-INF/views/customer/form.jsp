<%-- 
    Document   : form
    Created on : Dec 16, 2015, 6:03:45 PM
    Author     : Jana Cechackova
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
            <form:label path="forename">Forename</form:label>
            <form:input path="forename"/>
            <form:errors path="forename" cssClass="error"/>
    
            <form:label path="surname">></form:label>
            <form:input path="surname"/>
            <form:errors path="surname" cssClass="error"/>
   