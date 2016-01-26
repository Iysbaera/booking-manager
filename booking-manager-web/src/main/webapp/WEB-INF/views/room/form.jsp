<%--
  Created by IntelliJ IDEA.
  User: expres
  Date: 12/17/2015
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tr>
<form:label path="number">Number</form:label>
<form:input path="number" type="number" min="1" value="1" id="number"/>
<form:errors path="number" cssClass="error"/>
</tr>
<tr>
<form:label path="price">Price</form:label>
<form:input path="price" type="number" min="1" value="1" id="price"/>
<form:errors path="price" cssClass="error"/>
</tr>
<tr>
  <select name="hotelId" >
    <c:forEach var="hotel" items="${hotels}">
      <option value="${hotel.id}">${hotel.name}</option>
    </c:forEach>
  </select>
</tr>
<tr>
  <select name="roomType" >
    <c:forEach var="roomType" items="${roomTypes}">
      <option value="${roomType}">${roomType}</option>
    </c:forEach>
  </select>
</tr>