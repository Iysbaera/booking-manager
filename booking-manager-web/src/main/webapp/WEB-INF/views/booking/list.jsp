
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:layout title="Booking">
<jsp:attribute name="body">

    <h1> Bookings </h1>
      <table class="table">
        <tr>
          <th>Customer</th>
          <th>Hotel</th>
          <th>Room</th>
          <th>Check in</th>
          <th>Check out</th>
          <th>Price</th>
        </tr>
        <c:forEach items="${bookings}" var="booking">
          <tr>
            <td><c:out value="${booking.customer.forename}"/>
              <c:out value="${booking.customer.surname}"/></td>
            <td><c:out value="${booking.room.hotel.name}"/></td>
            <td><c:out value="${booking.room.number}"/></td>
            <td><c:out value="${booking.checkIn}"/></td>
            <td><c:out value="${booking.checkOut}"/></td>
            <td><c:out value="${booking.price}"/></td>
            <td>
                <form method="post" action="${pageContext.request.contextPath}/booking/cancel/${booking.id}">
                    <input type="submit" value="Cancel">
                </form>
            </td>
          </tr>
        </c:forEach>
      </table>
    
    <c:if test="${not empty alert_success}">
	<div class="alert alert-success" role="alert"><c:out value="${alert_success}"/></div>
    </c:if>
	
    <c:if test="${not empty alert_failure}">
	<div class="alert alert-danger" role="alert"><c:out value="${alert_failure}"/></div>
    </c:if>

    <a class ="btn btn-info" href="${pageContext.request.contextPath}/booking/create">Create</a>
</jsp:attribute>
</my:layout>

