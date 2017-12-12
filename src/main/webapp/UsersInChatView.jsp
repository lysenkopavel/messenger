<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Users in chat</title>
</head>
<body>

<jsp:include page="includejsp/_header.jsp"/>
<jsp:include page="includejsp/_menu.jsp"/>

<h3>Users in chat "${currentChat.chatTitle}" (ID=${currentChat.chatID})</h3>


<table border="1" cellpadding="3" cellspacing="1" >
    <tr>
        <th>ID</th>
        <th>nickname</th>
        <th>Delete from chat</th>
    </tr>
    <c:forEach items="${currentChat.usersInChat}" var="users" >
        <tr>
            <td>${users.userID}</td>
            <td>${users.nickname}</td>
            <td>
                <a href="deleteUserFromChat?userID=${users.userID}&chatID=${currentChat.chatID}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="nonChatUsers?chatID=${currentChat.chatID}" >Add User to chat "${currentChat.chatTitle}"</a>


<jsp:include page="includejsp/_footer.jsp"/>

</body>
</html>
