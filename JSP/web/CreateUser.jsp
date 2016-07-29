<%--
  Created by IntelliJ IDEA.
  User: azburatura
  Date: 7/28/2016
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>Useri</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    </head>
<body>
<h2>Hello, bine ati venit!</h2>

<form action="${pageContext.request.contextPath}/add-user" method="post">
    <table>
        <tr>
            <td><label>Nume utilizator: </label></td>
            <td><input type="text" value="" placeholder="nume utilizator" id="nume" name="numeUtilizator" required></td>
        </tr>
        <td><label>Parola utilizator:</label></td>
        <td><input type="password" value="" placeholder="parola" id="parola" name="parolaUtilizator" required></td>
        <tr>
            <td><label>Repeate password:</label></td>
            <td><input type="password" value="" placeholder="repeate password" id="parola2" onkeyup="check()" required></td>
            <td>
                <div id="atentionare"></div>
            </td>
        </tr>
        <tr>
            <td><label>Varsta:</label></td>
            <td><input type="text" placeholder="varsta" id="varsta" name="varstaUtilizator" pattern="^[0-9]{1,45}$" title="Trebuie sa introduceti un numar!" required></td>
        </tr>
    </table>
    <input type="submit" value="Create new user" id="submitId">
</form>

<button type="button" onclick="window.location='/home';">Home page</button>


<script>


    function check() {
        $("#parola2").keyup(verificaParole());
    }

    function verificaParole() {
        var parola = $("#parola").val();
        var parola2 = $("#parola2").val();

        if (parola == parola2) {
            $("#atentionare").text("Parolele coincid:)").css("color", "green");
            document.getElementById("submitId").disabled = false;
        } else {
            $("#atentionare").text("Parolele nu coincid!").css("color", "red");
            document.getElementById("submitId").disabled = true;
        }

    }
</script>

</body>
</html>
