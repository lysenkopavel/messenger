<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new User</title>
</head>
<body>

<jsp:include page="includejsp/_header.jsp"/>
<jsp:include page="includejsp/_menu.jsp"/>

<form method="POST" action="createUser">
    <table border="0">
        <tr>
            <td>Nickname</td>
            <td><input type="text" name="nickname" value="${users.nickname}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit" />
                <a href="users">Cancel</a>
            </td>
        </tr>
    </table>
</form>

<jsp:include page="includejsp/_footer.jsp"/>

</body>
</html>
