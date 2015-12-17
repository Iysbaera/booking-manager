<%-- Author: Ivo Hradek --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" action="${pageContext.request.contextPath}/hotel/create"
           modelAttribute="hotelCreate" cssClass="form-horizontal">
    <div class="form-group ${name_error ? 'has-error' : ''}">
                                                        <form:label path="name" cssClass="col-sm-2 control-label">Name</form:label>
                                                        <div class="col-sm-10">
                                                        <form:input path="name" cssClass="form-control" />
                                                        <form:errors path="name" cssClass="help-block" />
                                                        </div>
                                                        </div>
    <button class="btn btn-primary" type="submit">${submit-name}</button>
</form:form>
