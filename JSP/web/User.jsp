<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: azburatura
  Date: 7/29/2016
  Time: 12:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<c:set var="userVar" scope="session" value="${requestScope.user}"/>

<form action="${pageContext.request.contextPath}/user" method="post">
    <table>
        <tr>
            <td>Id:<td/>
            <td><input type="text" name="userId" value="${userVar.id}" readonly></td>
        </tr>
        <tr>
            <td>User:<td/>
            <td><input type="text" name="userName" value="${userVar.nume}"></td>
        </tr>
        <tr>
            <td>Password:<td/>
            <td><input type="text" name="userPass" value="${userVar.parola}"></td>
        </tr>
        <tr>
            <td>Varsta:<td/>
            <td><input type="text" name="userVarsta" value="${userVar.varsta}" pattern="^[0-9]{1,45}$" title="Trebuie sa introduceti un numar!"></td>
        </tr>
    </table>
    <br/>
    <input type="submit" value="Update user">
</form>

<button type="button" onclick="window.location='/home';">Home page</button>

</body>
</html>
