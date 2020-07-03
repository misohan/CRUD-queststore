<%--
  Created by IntelliJ IDEA.
  User: Konrad
  Date: 29.06.2020
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<div id="mentor" class="vis">
<c:forEach var="mentor" items="${update}">
    <div class="form">
        <form action="/update" method="post">
            <label>Id:</label><br>
            <input value="" name="id"><br><br>
            <label>First name:</label><br>
            <input value="" name="firstName"><br><br>
            <label>Last name:</label><br>
            <input value="" name="lastName"><br><br>
            <label>Age:</label><br>
            <input value="" name="age"><br><br>
            <button class="button button2" type="submit">Send</button>
        </form>
    </div>
</c:forEach>
</div>
</body>
</html>
