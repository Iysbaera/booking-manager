<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <ul>
        <c:forEach items="${hotelDtoCollection}" var="hotel">
            <li>
                <c:out value="${hotel.id}" />
            </li>
        </c:forEach>
    </ul>
</body>
</html>
