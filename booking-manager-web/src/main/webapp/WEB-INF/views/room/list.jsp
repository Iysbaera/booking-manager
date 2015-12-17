<%--
  Created by IntelliJ IDEA.
  User: expres
  Date: 12/17/2015
  Time: 12:30 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:layout title="Room">
<jsp:attribute name="body">

    <h1> Rooms </h1>
      <table class="table">
          <tr>
              <th>Hotel</th>
              <th>Room type</th>
              <th>Number</th>
              <th>Price</th>
          </tr>
          <c:forEach items="${rooms}" var="room">
              <tr>
                  <td><c:out value="${room.hotel.name}"/></td>
                  <td><c:out value="${room.type}"/></td>
                  <td><c:out value="${room.number}"/></td>
                  <td><c:out value="${room.price}"/></td>
                  <td>
                      <form method="get" action="${pageContext.request.contextPath}/room/update/${room.id}">
                          <input type="submit" value="Change price">
                      </form>
                  </td>

              </tr>
          </c:forEach>
      </table>

    <%--    <form:form method="post" action="${pageContext.request.contextPath}/customer/create">
    <%-- <%@include file="form.jsp"%>
    <input type="submit" value="New Customer">
    </form:form>--%>

    <a class="btn btn-info" href="${pageContext.request.contextPath}/room/create">Create</a>
</jsp:attribute>
</my:layout>

