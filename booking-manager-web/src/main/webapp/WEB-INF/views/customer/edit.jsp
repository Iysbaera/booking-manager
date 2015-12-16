<%-- 
    Document   : form
    Created on : Dec 16, 2015, 6:03:45 PM
    Author     : Jana Cechackova
--%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <table>
        <tr>
            <th><form:label path="firstname">First name</form:label></th>
            <td><form:input path="firstname"/></td>
            <td><form:errors path="firstname" cssClass="error"/></td>
        </tr>
        <tr>
            <th><form:label path="surname">Surname</form:label></th>
            <td><form:input path="surname"/></td>
            <td><form:errors path="surname" cssClass="error"/></td>
        </tr>
    </table>
