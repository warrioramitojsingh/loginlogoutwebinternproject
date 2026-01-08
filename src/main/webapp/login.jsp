<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 400px;
            margin: 80px auto;
        }
        .error {
            color: red;
            font-weight: bold;
        }
        form {
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 8px;
        }
        input[type=text], input[type=password] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            width: 100%;
        }
    </style>
</head>

<body>
<h2>Login</h2>

<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
    <p class="error"><%= error %></p>
<%
    }
%>

<form action="login" method="post">
    <label>Username:</label><br>
    <input type="text" name="username" required><br><br>

    <label>Password:</label><br>
    <input type="password" name="password" required><br><br>

    <button type="submit">Login</button>
</form>

</body>
</html>


