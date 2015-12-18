<%-- Author: Ivo Hradek --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="booking" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<booking:layout title="${hotel.name}">
<jsp:attribute name="body">
    <div class="container">
        <h1>${hotel.name}</h1>
        <h2>Rooms</h2>
        <ul class="list-group">
            <c:forEach items="${hotel.rooms}" var="room">
                <li class="list-group-item">
                    ${room.number}
                </li>
            </c:forEach>
        </ul>
    </div>
</jsp:attribute>
</booking:layout>
