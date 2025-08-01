<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.saitama.UserManagementSystem.bean.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
    <center>
        <h1>User Management</h1>
        <h2>
            <a href="new">Add New User</a>
               
            <a href="list">List All Users</a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            <%
                List<User> listUser = (List<User>) request.getAttribute("listUser");
                if (listUser != null) {
                    for (User user : listUser) {
            %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getName() %></td>
                <td><%= user.getEmail() %></td>
                <td><%= user.getCountry() %></td>
                <td>
                    <a href="edit?id=<%= user.getId() %>">Edit</a>
                        
                    <a href="delete?id=<%= user.getId() %>">Delete</a>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </div>
</body>
</html>