<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Users</title>
</head>
<body>

<jsp:include page="includejsp/_header.jsp"/>
<jsp:include page="includejsp/_menu.jsp"/>

<h3>Users Page</h3>

Listing all registered users

<table border="1" cellpadding="3" cellspacing="1" >
    <tr>
        <th>ID</th>
        <th>nickname</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${listUsers}" var="users" >
        <tr>
            <td>${users.userID}</td>
            <td>${users.nickname}</td>
            <td>
                <a href="deleteUser?userID=${users.userID}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="createUser" >Create User</a>


<jsp:include page="includejsp/_footer.jsp"/>

</body>
</html>
