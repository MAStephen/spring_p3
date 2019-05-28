<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 27/11/2018
  Time: 01:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <link href='https://fonts.googleapis.com/css?family=Anton|Passion+One|PT+Sans+Caption' rel='stylesheet' type='text/css'>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link type="text/css" rel="stylesheet" href="../css/error404.css">
    <title>Library</title>
</head>
<body>

<c:if test="${ !sessionScope.connected }">
<div class="alert alert-warning alert-dismissible fade show" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
    <strong>Bonjour !</strong> Vous n'êtes pas connecté.
</div>
</c:if>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/acceuil">Accueil <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <c:choose>
                    <c:when test="${ sessionScope.connected }">
                    <a class="nav-link" href="/borrowing">
                    </c:when>
                    <c:otherwise>
                        <a class="nav-link" href="/connexion">
                    </c:otherwise>
                </c:choose>
                Liste de ses emprunts</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Informations complémentaires
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <c:choose>
                    <c:when test="${ sessionScope.connected }">
                        <a class="dropdown-item" href="/myaccount">
                        </c:when>
                        <c:otherwise>
                            <a class="dropdown-item" href="/connexion">
                            </c:otherwise>
                            </c:choose>
                    Son compte</a>
                    <a class="dropdown-item" href="/borrowinghistory">Historique des emprunts</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Contacter la librairie</a>
                </div>
            </li>
            <li class="nav-item">
                <c:choose>
                    <c:when test="${ sessionScope.connected }">
                        <a class="nav-link" href="/deconnexion">Déconnexion</a>
                    </c:when>
                    <c:otherwise>
                        <a class="nav-link" href="/connexion">Connexion</a>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="/acceuil/search" method="post">
            <input class="form-control mr-sm-2" type="search" placeholder="Recherche rapide par titre" aria-label="Search" name="title">
            <input class="d-none"  name="author">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Chercher</button>
        </form>
    </div>
</nav>

