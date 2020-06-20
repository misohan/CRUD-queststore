<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<style><%@include file="/WEB-INF/css/style.css"%></style>

<head>
<title>Add mentor</title>
</head>
<body>
    <form  action="add" method="post">
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
</body>
</html>