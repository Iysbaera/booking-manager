<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <c:if test="${empty hotels}">
        <p>There are no hotels</p>
    </c:if>
    <c:if test="${not empty hotels}">
        <ul>
            <c:forEach items="${hotels}" var="hotel">
                <li>
                    <c:out value="${hotel.id}" />
                </li>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>
