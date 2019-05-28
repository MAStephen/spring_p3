<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="_include/header.jsp" %>
<%--contenu du body--%>
<div class="container" style="margin-top: 25px;">
    <div class="col-lg-3 col-lg-offset-1">
    </div>
    <div class="col-lg-12 col-lg-offset-6">

<h1>Liste de mes emprunts</h1>
        <c:if test="${ sessionScope.connected }">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author</th>
                    <th scope="col">Description</th>
                    <th scope="col">Etat</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="borrow" items="${borrowingList}">

                    <c:choose>
                        <c:when test="${historic}">
                            <tr>
                                <th scope="row">${borrow.id}</th>
                                <td>${borrow.getTitle()}</td>
                                <td>${borrow.getAuthor()}</td>
                                <td>${borrow.getDescription()}</td>
                                <td>
                                    <c:if test="${borrow.extended}">
                                        <%--verifier que le livre est etendable--%>

                                        <a href="#" class="btn btn-warning btn-lg active" role="button"
                                           aria-pressed="true">fut prolongé</a>
                                    </c:if>
                                    <c:if test="${borrow.returnDate != null}">

                                        <a href="#" class="btn btn-success btn-lg active" role="button"
                                           aria-pressed="true">est rendu</a>
                                    </c:if>
                                    <c:if test="${borrow.returnDate == null}">

                                        <a href="#" class="btn btn-success btn-lg active" role="button"
                                           aria-pressed="true">en cours</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>

                            <c:if test="${borrow.status == 'ENCOURS'}">
                                <tr>
                                    <th scope="row">${borrow.id}</th>
                                    <td>${borrow.getTitle()}</td>
                                    <td>${borrow.getAuthor()}</td>
                                    <td>${borrow.getDescription()}</td>
                                    <td>
                                        <c:if test="${!borrow.extended}">
                                            <%--verifier que le livre est etendable--%>

                                            <a href="/extended/${borrow.id}" class="btn btn-warning btn-lg active" role="button"
                                               aria-pressed="true">prolonger</a>
                                        </c:if>
                                        <a href="/returnbook/${borrow.id}" class="btn btn-success btn-lg active" role="button"
                                           aria-pressed="true">rendre</a>
                                    </td>
                                </tr>
                            </c:if>

                        </c:otherwise>
                    </c:choose>

                </c:forEach>
                </tbody>
            </table>
        </c:if>

    </div>
    <div class="col-lg-3 col-lg-offset-1"></div>
</div>

<%@include file="_include/footer.jsp" %>