<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 11/12/2018
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_include/header.jsp"%>

<div class="container" style="margin-top: 25px;">
    <div class="col-lg-3 col-lg-offset-1">
    </div>
    <div class="col-lg-12 col-lg-offset-6">
<form method="post" action="/user/update">
    <div class="form-row">
        <div class="col">
            <label for="firstName">Prénom</label>
            <input type="text" class="form-control" name="firstName" id="firstName" placeholder="Prénom" value="${userinfo.firstName}">
        </div>
        <div class="col">
            <label for="lastName">Nom</label>
            <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Nom" value="${userinfo.lastName}">
        </div>
        <div class="col">
            <label for="userName">Pseudo</label>
            <input type="text" class="form-control" name="userName" id="userName" placeholder="Pseudo" value="${userinfo.username}">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="${userinfo.email}">
        </div>
        <div class="form-group col-md-6">
            <label for="password">Mot de passe</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="Password" value="${userinfo.password}">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-12">
            <label for="inputAddress">Adresse</label>
            <input type="text" class="form-control" name="inputAddress1" id="inputAddress" value="${userinfo.address}">
        </div>
    </div>
    <button type="submit" class="btn btn-primary float-right">Editer son profil</button>
</form>

    </div>
    <div class="col-lg-3 col-lg-offset-1"></div>
</div>


<%@include file="_include/footer.jsp"%>