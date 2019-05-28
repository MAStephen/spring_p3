<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 03/12/2018
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
${lib}
totot
${test}
${works}

<c:forEach var="work" items="${ test }">
    <p><c:out value="${work}"/> fonctionne </p>
</c:forEach>
</body>
</html>
