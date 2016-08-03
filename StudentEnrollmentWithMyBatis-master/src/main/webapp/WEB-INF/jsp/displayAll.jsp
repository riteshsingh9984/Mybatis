<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="assets/css/bootstrap-united.css" rel="stylesheet" />

<style>
.error {
	color: #ff0000;
	font-size: 0.9em;
	font-weight: bold;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<title>Student Enrollment Login</title>
</head>
<body>
	<script src="jquery-1.8.3.js">
		
	</script>

	<script src="bootstrap/js/bootstrap.js">
		
	</script>

	<div class="navbar navbar-default">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search">
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/StudentEnrollmentWithMyBatis">Home</a></li>
				<li><a href="signup.html">Signup</a></li>
				<li class="active"><a href="login.html">Login</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Explore<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">Contact us</a></li>
						<li class="divider"></li>
						<li><a href="#">Further Actions</a></li>
						<li><a href="displayAll.html">Display All</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>

	<div class="container">
		<div class="jumbotron">
			<div>
				<h1>Welcome to Online Student Enrollment Login</h1>
				<p>Login to explore the complete features!</p>
			</div>
		</div>

		<div></div>
	</div>

	<div class="col-lg-8 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-8">
						<table class="table">
    <thead>
      <tr>
        <th>Id</th>
        <th>Date Of Birth</th>
        <th>Email Address</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>password</th>
        <th>User Name</th>
        <th>Update</th>
        
      </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${studentList}">
      <tr>
        <td> <a href='deleteStudent.html?id=<c:out value="${student.id}"/>'><c:out value="${student.id}"/></a> </td>
        <td> <c:out value="${student.dateOfBirth}"/> </td>
        <td> <c:out value="${student.emailAddress}"/> </td>
        <td> <c:out value="${student.firstName}"/> </td>
        <td> <c:out value="${student.lastName}"/> </td>
        <td> <c:out value="${student.password}"/> </td>
        <td> <c:out value="${student.userName}"/> </td>
        <td> <a href='updateStudent.html?id=<c:out value="${student.id}"/>'><c:out value="${student.id}"/></a> </td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>