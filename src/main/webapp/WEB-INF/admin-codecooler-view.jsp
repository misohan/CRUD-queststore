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
    <a href="../login">Login page</a>
  </div>

  <div class="row">
    <div class="column">
      <div class="card">
        <h2>Create codecooler item</h2>


        <div id="codecooler" class="vis">
          <div class="form">
            <form action="/addCodecooler" method="post">
                <label>Id:</label><br>
                <input value="" name="id"><br><br>
                <label>First name:</label><br>
                <input value="" name="firstName"><br><br>
                <label>Last name:</label><br>
                <input value="" name="lastName"><br><br>
                <label>Age:</label><br>
                <input value="" name="age"><br><br>
                <label>Email:</label><br>
                <input value="" name="email"><br><br>
                <button class="button button2" type="submit">Send</button>
            </form>
          </div>
        </div>
      </div>
    </div>

    <div class="column">
      <div class="card">

        <table border="1" cellpadding="5">
          <caption><h2>List of codecoolers</h2></caption>
          <tr>
              <th>ID</th>
              <th>Title</th>
              <th>Description</th>
              <th>Credit</th>
              <th>Action</th>
          </tr>
          <c:forEach var="codecooler" items="${listCodecoolers}">
              <tr>
                  <td><c:out value="${codecooler.id}" /></td>
                  <td><c:out value="${codecooler.firstName}" /></td>
                  <td><c:out value="${codecooler.lastName}" /></td>
                  <td><c:out value="${codecooler.age}" /></td>
                  <td><c:out value="${codecooler.email}" /></td>
                  <td>
                      <a href="/edit?id=<c:out value='${codecooler.id}' />">Edit</a>
                      <a href="/deleteCodecooler?id=<c:out value='${codecooler.id}' />">Delete</a>
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