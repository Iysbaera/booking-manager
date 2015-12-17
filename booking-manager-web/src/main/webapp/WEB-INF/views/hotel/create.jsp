<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="booking" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<booking:layout title="hotel">
<jsp:attribute name="body">
    <form:form method="post" action="${pageContext.request.contextPath}/hotel/create">
        modelAttribute="hotelCreate" cssClass="form-horizontal">
        <div class="form-group">
            <div class="col-sm-10">
            </div>
        </div>
        <button class="btn btn-primary" type="submit">${submit-name}</button>
    </form:form>
</jsp:attribute>
</booking:layout>
