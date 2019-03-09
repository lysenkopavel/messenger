<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Chats</title>
</head>
<body>

<jsp:include page="includejsp/_header.jsp"/>
<jsp:include page="includejsp/_menu.jsp"/>

<h3>Welcome to "${currentChat.chatTitle}" chat!</h3>


<form method="POST" action="openChat?chatID=${currentChat.chatID}">
    <table border="0">
        <tr>
            <select name="chooseUser" >
                <c:forEach items="${usersInChat}" var="user">
                    <option value="${user.userID}">${user.nickname}</option>
                </c:forEach>
            </select>
        </tr>
        <tr>
            <input type="text" name="newMessage" value="${message.message}"/>
        </tr>
        <tr>
            <input type="submit" value="send"/>
        </tr>
    </table>
</form>


<table border="1" cellpadding="3" cellspacing="1">
    <tr>
        <th>MessageID</th>
        <th>Nickname</th>
        <th>Text</th>
        <th>Time</th>
    </tr>
    <c:forEach items="${messagesInChat}" var="message">
        <tr>
            <td>${message.messageID}</td>
            <td>${message.messageFromUser.nickname}</td>
            <td>${message.message}</td>
            <td>${message.messageTime}</td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="includejsp/_footer.jsp"/>

</body>
</html>

