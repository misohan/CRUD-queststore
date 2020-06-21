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
    <a href="../codecooler/codecooler.html">Codecooler</a>
    <a href="../mentor/mentor.html">Mentor</a>
    <a href="../loginPage/loginPage.html">Login page</a>
  </div>

  <div class="row">
    <div class="column">
      <div class="card">
        <h2>Create</h2>
        <label  for="options">Create</label>
        <select class="custom-select" id="create">
          <option value="mentor">mentor account</option>
          <option value="class">class</option>
          <option value="experience">levels of experience</option>
        <select>



        <div id="mentor" class="vis">
          <div class="form">
                <form  action="/add" method="post">
                  <label>Id:</label>
                  <input value="" name="id">
                  <label>First name:</label>
                  <input value="" name="firstName">
                  <label>Last name:</label>
                  <input value="" name="lastName">
                  <label>Age:</label>
                  <input value="" name="age">
                  <button type="submit">Send</button>
                </form>
              <form  action="/delete" method="delete">
                  <label>Id:</label>
                  <input value="" name="id">
                  <button type="submit">Send</button>
              </form>

          </div>
        </div>
        <div id="class" class="inv">
          <div class="form">
            <form>
              <label for="fname">Class name:</label><br>
              <input type="text" id="fname" name="fname"><br><br>
              <label for="lname">Number of students:</label><br>
              <input type="text" id="lname" name="fname"><br><br>
              <input class="button button2" type="submit" value="Create">
            </form>
          </div>
        </div>
        <div id="experience" class="inv">
          <div class="form">
            <form>
              <label for="fname">Experience name:</label><br>
              <input type="text" id="fname" name="fname"><br><br>
              <label for="lname">Credits required:</label><br>
              <input type="text" id="fname" name="fname"><br><br>
              <label for="lname">Date:</label><br>
              <input type="text" id="fname" name="fname"><br><br>
              <input class="button button2" type="submit" value="Create">
            </form>
          </div>
        </div>
      </div>
    </div>
    <div class="column">
      <div class="card">
        <h2>Edit Mentor's profile</h2>
        <select class="custom-select" name="options" id="options">
          <option value="Pampy">Pampy</option>
          <option value="Lampy">Lampy</option>
          <option value="Gampy">Gampy</option>
          <option value="Jumpy">Jumpy</option>
        </select>
        <div class="form">
          <form action="/action_page.php">
            <label for="fname">First name:</label><br>
            <input type="text" id="fname" name="fname"><br><br>
            <label for="lname">Last name:</label><br>
            <input type="text" id="fname" name="fname"><br><br>
            <input class="button button2" type="submit" value="Submit changes">
          </form>
        </div>
      </div>
    </div>
    <div class="column">
      <div class="card">
        <h2>View mentor's profile</h2>

        <center>

          <h2>
              <a href="/add">Add mentor</a>
          </h2>
      </center>
      <div align="center">
          <table border="1" cellpadding="5">
              <caption><h2>List of mentors</h2></caption>
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
                          <a href="/delete?id=<c:out value='${mentor.id}' />">Delete</a>
                      </td>
                  </tr>
              </c:forEach>
          </table>
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