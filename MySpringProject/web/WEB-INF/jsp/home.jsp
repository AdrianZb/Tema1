<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: azburatura
  Date: 8/2/2016
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Home page
<br/>
<br/>

<form method="POST" action="<c:url value="/"/>">
    <table>
        <tr>
            <td>
                <labe>Nume:</labe>
            </td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td><label> Parola:</label></td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Creaza nou user"></td>
        </tr>
    </table>
</form>

<form method="POST" action="<c:url value="/delete"/>">
    <table>
        <tr>
            <td>
                <labe>Id:</labe>
            </td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Sterge un user"></td>
        </tr>
    </table>
</form>

<button type="button" onclick="window.location='/users'">All users rest</button>
<br/>
<button type="button" onclick="window.location='/uploadFile'">Upload 1 file page</button>
<br/>
<button type="button" onclick="window.location='/uploadMultipleFile'">Upload multiple files page</button>
<br/>
<br/>
<button type="button" onclick="window.location='/documents'">All documents</button>

</body>
</html>
