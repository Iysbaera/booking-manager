<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="booking" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<booking:layout title="hotel">
<jsp:attribute name="body">
    <c:if test="${empty hotels}">
        <div class="row">
            <div class="col-md-2 col-md-offset-5">
                <h1>There are not any hotels in our offer.</h1>
            </div>
        </div>
    </c:if>
    <c:if test="${not empty hotels}">
        <h1 class="text-center">Our Hotels</h1>

        <div class="container">
            <ul class="list-group">
                <c:forEach items="${hotels}" var="hotel">
                    <li class="list-group-item">
                        <span class="badge">${fn:length(hotel.rooms)}</span>
                        <a href="${pageContext.request.contextPath}/hotel/${hotel.id}/show">${hotel.name}</a>
                           <span class="button">
                            <td>
                                <c:forEach var="item" items="${toDelete}">
                                <c:if test="${item eq hotel.id}">
                                <form method="post" action="${pageContext.request.contextPath}/hotel/delete/${hotel.id}">
                                    <input type="submit" value="Delete">
                                </form
                               </c:if>

                               </c:forEach>
                           </span>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <a class="btn btn-info" href="${pageContext.request.contextPath}/hotel/create">Create</a>
</jsp:attribute>
</booking:layout>