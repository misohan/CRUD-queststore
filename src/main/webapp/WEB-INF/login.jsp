<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<head>
    <meta charset="utf-8">
    <title>Bookshop Website</title>
    <link rel="stylesheet" href="loginStyle.css">
</head>
<body>

<div style="text-align: center">
    <form action="/login" method="post">
        <label for="email">Email:</label>
        <input name="email" size="30"/>
        <br><br>
        <label for="password">Password:</label>
        <input type="password" name="password" size="30"/>

        <%
            String message = null;
            if(message==null){

        %>

        <%
            }else{
        %>
        <p>${message}</p>
        <br><br>
        <%
            }
        %>
        <button type="submit">Login</button>
    </form>
</div>
</body>
