
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%-- 
    Document   : create
    Created on : Dec 16, 2015, 6:10:35 PM
    Author     : Jana Cechackova
--%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:layout title="Customer">
<jsp:attribute name="body">
    
<form:form method="post" action="${pageContext.request.contextPath}/customer/edit/${customer.id}" modelAttribute="customer">
    <fieldset><legend>New Customer</legend>
        <%@include file="form.jsp"%>
        <input type="submit" value="Save">
    </fieldset>
</form:form>
</jsp:attribute>
</my:layout>