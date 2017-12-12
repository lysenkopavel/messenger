<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Chats</title>
</head>
<body>

<jsp:include page="includejsp/_header.jsp"/>
<jsp:include page="includejsp/_menu.jsp"/>

<h3>Chats Page</h3>

Listing all registered chats

<table border="1" cellpadding="3" cellspacing="1" >
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Users in Chat</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${listChats}" var="chats" >
        <tr>
            <td>${chats.chatID}</td>
            <td>
                <a href="openChat?chatID=${chats.chatID}">${chats.chatTitle}</a>
            </td>
            <td>
                <a href="usersInChat?chatID=${chats.chatID}">show/add users</a>
            </td>
            <td>
                <a href="deleteChat?chatID=${chats.chatID}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="createChat" >Create Chat</a>


<jsp:include page="includejsp/_footer.jsp"/>

</body>
</html>