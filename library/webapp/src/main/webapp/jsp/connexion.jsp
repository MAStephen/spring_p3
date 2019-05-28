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
<form method="post" action="/connexion">
    <div class="form-row">
        <div class="col">
            <%--<label for="inputUserName">Pseudo</label>--%>
            <input type="text" class="form-control" name="username" placeholder="Pseudo">
        </div>
        <div class="form-group col-md-6">
            <input type="password" class="form-control" name="password" id="password" placeholder="Password">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

    </div>
    <div class="col-lg-3 col-lg-offset-1"></div>
</div>


<%@include file="_include/footer.jsp"%>