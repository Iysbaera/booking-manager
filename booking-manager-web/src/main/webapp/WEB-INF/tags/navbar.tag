<%-- Author: Ivo Hradek --%>
<%@ tag pageEncoding="utf-8" dynamic-attributes="dynattrs" trimDirectiveWhitespaces="true" %>

<!-- Top navigation bar -->
<nav class="navbar navbar-default navbar-inverse navbar-static-top main" role="navigation">
    <div class="container">
        <!-- Logo and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <buton type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </buton>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Hotels</a>
        </div>
        <!-- Navigation -->
        <div class="collapse navbar-collapse navbar-ex1-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/hotel/list" role="button">Hotels</a></li>
                <li><a href="${pageContext.request.contextPath}/about" role="button">About</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Sign In<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Profile</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Log out</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
