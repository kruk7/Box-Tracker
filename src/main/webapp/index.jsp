<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Box Tracker - Welcome page</title>
    <link rel="stylesheet" href="resources/css/styles.css">
</head>
<body>
<div class="topnav">
    <a class="active" href="#home">Home</a>
    <a href="#about">About</a>
    <a href="#contact">Contact</a>
    <a href="sign-up.jsp">Signup</a>
    <div class="login-container">
        <form action="login" method="post">
            <input type="text" placeholder="Username" name="username">
            <input type="password" placeholder="Password" name="password">
            <button type="submit">Login</button>
        </form>
    </div>
</div>
<div class="main-container">
    <h2>Box Tracker</h2>
    <h3>Welcome page</h3>
    <img src="resources/images/box-tracker-logo.jpg" alt="Box Tracker Logo" width="400" height="400">
</div>

</body>
</html>