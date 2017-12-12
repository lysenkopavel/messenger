<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Chat</title>
</head>
<body>

<jsp:include page="includejsp/_header.jsp"/>
<jsp:include page="includejsp/_menu.jsp"/>

<form method="POST" action="createChat">
    <table border="0">
        <tr>
            <td>Chat title</td>
            <td><input type="text" name="title" value="${chats.title}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit" />
                <a href="chats">Cancel</a>
            </td>
        </tr>
    </table>
</form>

<jsp:include page="includejsp/_footer.jsp"/>

</body>
</html>
