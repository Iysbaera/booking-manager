<%--
  Created by IntelliJ IDEA.
  User: expres
  Date: 12/18/2015
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"      "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
        <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
        <script>
            jQuery(document).ready(function ($) {
                $("#datepicker").datepicker();
            });
        </script>
        <title>Test</title>
    </head>
    <body>
        <tr>
        <form:label path="checkIn">Ceck In</form:label>
        <input type="text" id="datepicker" />
        </tr>
        
        <tr>
        <form:label path="checkOut">Check Out</form:label>
        <input type="text" id="datepicker" />
        </tr>
    
    </body>
</html>

<%@ page contentType="text/html;charset=UTF-8"  trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

<tr>
<select name="customerId" >
    <c:forEach var="customer" items="${customers}">
    <option value="${customer.id}">${customer.forename}</option>
        <%--<c:out value="${customer.forename}"/> - <c:out value="${customer.surname}"/>--%>
</c:forEach>
</select>
</tr>

<tr>
<select name="roomId" >
    <c:forEach var="room" items="${rooms}">       
        <option value="${room.id}">${room.number}</option>
            <%--<c:out value="${room.hotelId}"/> - <c:out value="${room.number}"/>--%>
    </c:forEach>
</select>
</tr>


