<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
   <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>

<body>
  <div class="header">
    <h1>Codecooler menu</h1>
    <p>"${codecooler.email}"</p>
  </div>
  <div class="topnav">
    <a class="active">Options</a>
    <a href="../ccprofile">My profile</a>
    <a href="../artifactshop">Artifact shop</a>
    <a href="../login">Login page</a>
  </div>

  <div class="row">
    <div class="column">
      <div class="card">
      <table border="1" cellpadding="5">
        <caption><h2>List of Artifacts</h2></caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Credit</th>
                <th>Action</th>
            </tr>
            <c:forEach var="artifact" items="${listArtifacts}">
                <tr>
                    <td><c:out value="${artifact.id}" /></td>
                    <td><c:out value="${artifact.title}" /></td>
                    <td><c:out value="${artifact.description}" /></td>
                    <td><c:out value="${artifact.credit}" /></td>
                    <td>
                       <a href="/addCCArtifact?id=<c:out value='${artifact.id}' />">Add</a>
                    </td>
                </tr>
            </c:forEach>
       </table>


      </table>
      <br><br>
      </div>
    </div>
    <div class="column">
      <div class="card">

      </div>
    </div>
    <div class="column">
      <div class="card">

      </div>
    </div>

  </div>
  <script src="codecooler.js"></script>

  <div class="footer">
    <h2>Footer</h2>
  </div>
</body>

</html>