<%--
  Created by IntelliJ IDEA.
  User: pasha
  Date: 12/4/17
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<jsp:include page="includejsp/_header.jsp"/>
<jsp:include page="includejsp/_menu.jsp"/>

<h3>Users Page</h3>


<h3>Users List</h3>


<table border="1" cellpadding="3" cellspacing="1" >
    <tr>
        <th>ID</th>
        <th>nickname</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${listUsers}" var="users" >
        <tr>
            <td>${users.userID}</td>
            <td>${users.nickname}</td>
            <td>
                <a href="editUsers?code=${users.userID}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="createUser" >Create User</a>


<jsp:include page="includejsp/_footer.jsp"/>

</body>
</html>
