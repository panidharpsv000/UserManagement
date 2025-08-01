<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.saitama.UserManagementSystem.bean.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
    <center>
        <h1>User Management</h1>
        <h2>
            <% User user = (User) request.getAttribute("user"); %>
            <% if (user != null) { %>
                Edit User
            <% } else { %>
                Add New User
            <% } %>
        </h2>
    </center>
    <div align="center">
        <form action="<%= (user != null) ? "update" : "insert" %>" method="post">
            <% if (user != null) { %>
                <input type="hidden" name="id" value="<%= user.getId() %>" />
            <% } %>
            <table>
                <tr>
                    <th>Name: </th>
                    <td><input type="text" name="name" size="45"
                            value="<%= (user != null) ? user.getName() : "" %>"
                        /></td>
                </tr>
                <tr>
                    <th>Email: </th>
                    <td><input type="text" name="email" size="45"
                            value="<%= (user != null) ? user.getEmail() : "" %>"
                        /></td>
                </tr>
                <tr>
                    <th>Country: </th>
                    <td><input type="text" name="country" size="15"
                            value="<%= (user != null) ? user.getCountry() : "" %>"
                        /></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align:center;">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>