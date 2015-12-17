
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%-- 
    Document   : list
    Created on : Dec 16, 2015, 6:10:35 PM
    Author     : Jana Cechackova
--%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:layout title="Customer">
<jsp:attribute name="body">
    
    <h1> Customers </h1>
      <table class="table">
            <tr>
                <th>First name</th>
                <th>Surname</th>
            </tr>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td><c:out value="${customer.forename}"/></td>
                    <td><c:out value="${customer.surname}"/></td>
                    <td>
                        <form method="get" action="${pageContext.request.contextPath}/customer/edit/${customer.id}">
                            <input type="submit" value="Edit">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/customer/delete/${customer.id}">
                            <input type="submit" value="Delete">
                        </form>
                    </td>

                </tr>
            </c:forEach>
        </table>

    <%--    <form:form method="post" action="${pageContext.request.contextPath}/customer/create">
	<%-- <%@include file="form.jsp"%> 
	<input type="submit" value="New Customer">	
    </form:form>--%>
	
	<a class ="btn btn-info" href="${pageContext.request.contextPath}/customer/create">Create</a>
</jsp:attribute>
</my:layout>

