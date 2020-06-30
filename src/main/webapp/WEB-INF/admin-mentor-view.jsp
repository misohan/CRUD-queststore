<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
   <style><%@include file="/WEB-INF/css/style.css"%></style>

</head>

<body>
  <div class="header">
    <h1>Admin menu</h1>
    <p>Your personal dashboard</p>
  </div>
  <div class="topnav">
    <a class="active">Options</a>
    <a href="../codecoolers">Codecoolers</a>
    <a href="../mentors">Mentors</a>
    <a href="../artifacts">Artifacts</a>
    <a href="../quests">Quest</a>
    <a href="../loginPage/loginPage.html">Login page</a>
  </div>

  <div class="row">
    <div class="column">
      <div class="card">
        <h2>Create mentor account</h2>


        <div id="mentor" class="vis">
          <div class="form">
            <form action="/addMentor" method="post">
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
        </div>
      </div>
    </div>

    <div class="column">
      <div class="card">

        <table border="1" cellpadding="5">
          <caption><h2>List of mentors</h2></caption>
          <tr>
              <th>ID</th>
              <th>First name</th>
              <th>Last name</th>
              <th>Age</th>
              <th>Action</th>
          </tr>
          <c:forEach var="mentor" items="${listMentors}">
              <tr>
                  <td><c:out value="${mentor.id}" /></td>
                  <td><c:out value="${mentor.firstName}" /></td>
                  <td><c:out value="${mentor.lastName}" /></td>
                  <td><c:out value="${mentor.age}" /></td>
                  <td>
                      <a href="/editMentor?id=<c:out value='${mentor.id}' />">Edit</a>
                      <a href="/delete?id=<c:out value='${mentor.id}' />">Delete</a>
                  </td>
              </tr>
          </c:forEach>
      </table>

      </div>
    </div>
  </div>
  <script src="admin.js"></script>

  <div class="footer">
    <h2>Footer</h2>
  </div>
</body>


</html>