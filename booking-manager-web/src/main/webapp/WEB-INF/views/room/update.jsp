<%--
  Created by IntelliJ IDEA.
  User: expres
  Date: 12/17/2015
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>

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

<my:layout title="Room">
<jsp:attribute name="body">

<form:form method="post" action="${pageContext.request.contextPath}/room/update/${room.id}" modelAttribute="room">

  <h1> Customers </h1>
  <table class="table">
    <tr>
      <th>Hotel name</th>
      <th>Room type</th>
      <th>Number</th>
      <th>Price</th>
      <th>New price</th>
    </tr>

    <tr>
    <td><c:out value="${room.hotel.name}"/></td>
      <td><c:out value="${room.type}"/></td>
      <td><c:out value="${room.number}"/></td>
      <td><c:out value="${room.price}"/></td>
    <td>
     <form:input path="price" id="price"/>
     <form:errors path="price" cssClass="error"/>
    </td>
        <td>
            <input type="submit" value="Save"></td>
    </tr>
  </table>
</form:form>
</jsp:attribute>
</my:layout>