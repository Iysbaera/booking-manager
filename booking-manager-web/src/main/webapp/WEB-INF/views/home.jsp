<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
    <title>Booking</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
</head>
<body>
    <h1>Welcome to booking</h1>

    <a href="<c:url value="/bookings" />">Bookings</a> |
    <a href="<c:url value="/booking/register" />">Bookings</a>
</body>
</html>
