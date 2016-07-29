<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<table border="2">
    <c:forEach items="${requestScope.userList}" var="user">
        <tr>
            <td>Id: <c:out value="${user.id}"></c:out></td>
            <td>Nume: <c:out value="${user.nume}"></c:out></td>
            <td>Varsta: <c:out value="${user.varsta}"></c:out></td>
            <td><a href="user?id=${user.id}">Details</a></td>
            <td>
                <form action="${pageContext.request.contextPath}/delete" method="post">
                    <input type="submit" name="deleteUser" value="Sterge">
                    <input type="hidden" name="hiddenUser" value="${user.id}">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
<button type="button" onclick="window.location='/home';">Home page</button>

</body>
</html>
