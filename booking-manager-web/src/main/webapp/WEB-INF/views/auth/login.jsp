<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div>
        <h1><spring:message code="label.user.login.page.title"/></h1>
    </div>

    <sec:authorize access="isAnonymous()">
        <div>
            <div>
                <h2><spring:message code="label.login.form.title"/></h2>
            </div>
            <c:if test="${param.error eq 'bad_credentials'}">
                <div>
                    <button type="button" data-dismiss="alert" aria-hidden="true">&times</button>
                    <spring:message code="text.login.page.failed.error"/>
                </div>
            </c:if>
            <form action="${pageContext.request.contextPath}/login/authenticate" method="post" role="form">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <div class="row">
                    <div id="form-group-email" class="form-group col-lg-4">
                        <label class="control-label" for="user-email"><spring:message code="label.user.email"/>:</label>
                        <input id="user-email" name="username" type="text" class="form-control"/>
                    </div>
                </div>
                <div class="row">
                    <div id="form-group-password" class="form-group col-lg-4">
                        <label class="control-label" for="user-password"><spring:message code="label.user.password"/>:</label>
                        <input id="user-password" name="password" type="password" class="form-control"/>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-lg-4">
                        <button type="submit" class="btn btn-default"><spring:message code="label.user.login.submit.button"/></button>
                    </div>
                </div>
            </form>
            <div class="row">
                <div class="form-group col-lg-4">
                    <a href="${pageContext.request.contextPath}/user/register"><spring:message code="label.navigation.registration.link"/></a>
                </div>
            </div>
        </div>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <p><spring:message code="text.login.page.authenticated.user.help"/></p>
    </sec:authorize>
</body>
</html>
