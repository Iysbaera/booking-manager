<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:layout title="Hotel">
<jsp:attribute name="body">
    <form:form method="post" action="${pageContext.request.contextPath}/hotel/create" modelAttribute="createHotel" cssClass="form-horizontal">
                <form:label path="name">Name</form:label>
                    <form:input path="name" id="name"  />
                    <form:errors path="name"  />

        <button class="btn btn-primary" type="submit">Add Hotel</button>
    </form:form>
          <c:if test="${not empty alert_failure}">
              <div class="alert alert-danger" role="alert"><c:out value="${alert_failure}"/></div>
          </c:if>
</jsp:attribute>
</my:layout>
