<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="booking" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<booking:layout title="Sign In">
<jsp:attribute name="body">
<div class="wrapper">
    <div class="top_wrapper">
        <div class="container">
            <div class="col-sm-12 header"><span class="icon-logo"></span></div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-12 login_content_wrapper">
            <div class="content_wrapper">
                <h1 class="title">Sign in to your account</h1>
                <form:form method="post" action="${pageContext.request.contextPath}/auth/login" modelAttribute="customer">
                    <div id="form-group-email" class="form-group col-lg-4">
                        <form:label path="email">Email:</form:label>
                        <form:input path="email" id="email" type="email" />
                        <form:errors path="email" cssClass="error"/>
                    </div>
                    <br>
                    <div id="form-group-password" class="form-group col-lg-4">
                        <form:label path="password" cssClass="control-label">Surname</form:label>
                        <form:input path="password" id="surname"/>
                        <form:errors path="password" cssClass="error"/>
                    </div>
                    <div class="col-xs-12 col-sm-6 text-right">
                        <button class="btn btn-default btn-success" type="submit">Sign In</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</jsp:attribute>
</booking:layout>

