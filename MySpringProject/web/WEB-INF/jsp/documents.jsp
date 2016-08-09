<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: azburatura
  Date: 8/4/2016
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All documents</title>
</head>
<body>
<table border="1">
    <th>Denumire</th>
    <c:forEach items="${documentList}" var="document">
        <tr>
            <td><c:out value="${document.denumire}"/></td>
            <td><form action="<c:url value="/download"/>" method="get">
                <input type="hidden" name="docId" value="${document.id}">
                <input type="submit" value="Download">
            </form></td>
            <td><form action="<c:url value="/deleteDoc"/>" method="post">
                <input type="hidden" name="id" value="${document.id}">
                <input type="submit" value="Delete">
            </form></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
