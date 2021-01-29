<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Редактировать пользователя</title>
</head>
<body>
<div align="center">
    <h2>Редактировать пользователя</h2>
    <form:form action="save" method="post" modelAttribute="user">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td>${user.id}
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>Имя: </td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Имя: </td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td>Возраст: </td>
                <td><form:input path="age" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Сохранить"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
