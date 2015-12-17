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
          <th>Room</th>
          <th>Check in</th>
          <th>Check out</th>
          <th>Price</th>
        </tr>
        <c:forEach items="${bookings}" var="booking">
          <tr>
            <td><c:out value="${booking.customer.forename}"/>
              <c:out value="${booking.customer.surname}"/></td>
            <td><c:out value="${booking.room.number}"/></td>
            <td><c:out value="${booking.checkIn}"/></td>
            <td><c:out value="${booking.checkOut}"/></td>
            <td><c:out value="${booking.price}"/></td>
          </tr>
        </c:forEach>
      </table>

    <a class ="btn btn-info" href="${pageContext.request.contextPath}/booking/create">Create</a>
</jsp:attribute>
</my:layout>

