<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login and Registration From Designe</title>
        <script defer src="script.js"></script>
        <style><%@include file="/WEB-INF/css/loginStyle.css"%></style>
    </head>
    <body>

        <div class="backgroundlogo"></div>
        <div class="login-page">
            <div class="form">
                <from class="register-form">
                    <input type="text" placeholder="user name">
                    <input type="text" placeholder="password">
                    <input type="text" placeholder="email">
                    <input type="text" placeholder="name">
                    <button>Create</button>
                    <p class="message">Already Registered <a href="#">Login</a> </p>
                </from>
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
        </div>
    </body>