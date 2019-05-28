<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 07/12/2018
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="_include/header.jsp" %>
<%--contenu du body--%>
<div class="container" style="margin-top: 25px;">
    <div class="col-lg-3 col-lg-offset-1">
    </div>
    <div class="col-lg-12 col-lg-offset-6">
<form name="search" action="/acceuil/search" method="post">
<div class="input-group mb-3">
    <div class="input-group-prepend">
        <span class="input-group-text" id="inputTitle">Titre</span>
    </div>
    <input type="text" name="title" class="form-control" aria-label="Text input with checkbox" value="${titleSearched}">
</div>

<div class="input-group">
    <div class="input-group-prepend">
        <span class="input-group-text" id="inputAuthor">Auteur</span>
    </div>
    <input type="text" name="author" class="form-control" aria-label="Text input with radio button" value="${authorSearched}">
</div>
<button type="submit" class="btn btn-primary float-right" style="margin-top: 5px; margin-bottom: 5px;">Rechercher</button>
</form>

<c:if test="${ works != null }" >
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Title</th>
        <th scope="col">Author</th>
        <th scope="col">Description</th>
        <th scope="col">Emprunt</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="work" items="${works}">
        <tr>
            <th scope="row">${work.id}</th>
            <td>${work.title}</td>
            <td>${work.author}</td>
            <td>${work.description}</td>
            <td>
                <c:choose>
                    <c:when test="${sessionScope.connected}">
                        <c:choose>
                            <c:when test="${work.isAvailable()}">

                                <a href="/borrowing/${work.id}" class="btn btn-success btn-lg active" >emprunter</a>
                            </c:when>
                            <c:otherwise>

                                <a href="#" class="btn btn-warning btn-lg active" >Non disponible</a>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <a href="/connexion" class="btn btn-success btn-lg active" >emprunter</a>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</c:if>
    </div>
    <div class="col-lg-3 col-lg-offset-1"></div>
</div>

<%@include file="_include/footer.jsp" %>