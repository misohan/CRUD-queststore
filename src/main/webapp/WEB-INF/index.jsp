<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <center>
            <h1>Mentors CRUD</h1>
            <h2>
                <a href="/add">Add mentor</a>
                &nbsp;&nbsp;&nbsp;
                <a href="/mentors">List All mentors</a>

            </h2>
        </center>
        <div align="center">
            <table border="1" cellpadding="5">
                <caption><h2>List of students</h2></caption>
                <tr>
                    <th>ID</th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Age</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="mentor" items="${listMentor}">
                    <tr>
                        <td><c:out value="${mentor.id}" /></td>
                        <td><c:out value="${mentor.firstName}" /></td>
                        <td><c:out value="${mentor.lastName}" /></td>
                        <td><c:out value="${mentor.age}" /></td>

                        <td>
                            <a href="/edit?id=<c:out value='${mentor.id}' />">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="/delete?id=<c:out value='${mentor.id}' />">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
</body>
</html>