<%--
  Created by IntelliJ IDEA.
  User: expres
  Date: 12/17/2015
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:label path="number">Number</form:label>
<form:input path="number" id="number"/>
<form:errors path="number" cssClass="error"/>


<form:label path="price">Price</form:label>
<form:input path="price" id="price"/>
<form:errors path="price" cssClass="error"/>