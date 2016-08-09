<%--
  Created by IntelliJ IDEA.
  User: azburatura
  Date: 8/4/2016
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload Multiple File Request Page</title>
</head>
<body>
<form method="POST" action="uploadMultipleFile" enctype="multipart/form-data">
    File1 to upload: <input type="file" name="file" multiple id="fileUpload" onchange="setName()">
    <br/>

    <input type="submit" value="Upload"> Press here to upload the file!
</form>


</body>
</html>
