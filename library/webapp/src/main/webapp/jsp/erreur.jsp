<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 10/12/2018
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="_include/header.jsp" %>


<!-- Error Page -->
<div class="error">
    <div class="container-floud">
        <div class="col-xs-12 ground-color text-center">
            <div class="container-error-404">
                <div class="clip"><div class="shadow"><span class="digit thirdDigit"></span></div></div>
                <div class="clip"><div class="shadow"><span class="digit secondDigit"></span></div></div>
                <div class="clip"><div class="shadow"><span class="digit firstDigit"></span></div></div>
                <div class="msg">OH!<span class="triangle"></span></div>
            </div>
            <h2 class="h1">Sorry! Page not found</h2>
        </div>
    </div>
</div>
<!-- Error Page -->

<script src="../js/error404.js"></script>

<%@include file="_include/footer.jsp" %>
