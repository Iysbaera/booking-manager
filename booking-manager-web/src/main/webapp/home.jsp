<%-- 
    Document   : home
    Created on : Dec 16, 2015, 3:32:03 PM
    Author     : Jana Cechackova
--%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<my:layout title="Home">
<jsp:attribute name="body">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking Manager</title>
    </head>
    <body>
        <h1 align="center">Booking manager</h1>
        <h4 align="center">This web application serves as a database of hotels, rooms, customers and their bookings.</h4>
        <h1 align="center">Things to do in this application:</h1>
        <ul align="center">
            <li> create, edit, delete hotels </li>
            <li> choose your own room comfort standart (basic and deluxe rooms) </li>
            <li> manage your and other customer`s personal accounts </li>
            <li> make bookings and find a place to stay </li>
            </ul>
        
    </body>
    
    
</html>
</jsp:attribute>
</my:layout>