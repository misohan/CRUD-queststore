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
        <h2>Create mentor account</h2>


        <div id="mentor" class="vis">
          <div class="form">
            <form action="/editMentor" method="post">
                <label>Id:</label><br>
                <input value="${mentor.id}"/ name="id"><br><br>
                <label>First name:</label><br>
                <input value="${mentor.firstName}"/ name="firstName"><br><br>
                <label>Last name:</label><br>
                <input value="${mentor.lastName}" name="lastName"><br><br>
                <label>Age:</label><br>
                <input value="${mentor.age}" name="age"><br><br>
                <button class="button button2" type="submit">Send</button>
            </form>
          </div>
        </div>
      </div>
    </div>

    </div>
  </div>
  <script src="admin.js"></script>

  <div class="footer">
    <h2>Footer</h2>
  </div>
</body>


</html>