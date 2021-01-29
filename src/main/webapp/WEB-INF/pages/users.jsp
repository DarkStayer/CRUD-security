<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type">
    <title>Список сотрудников</title>
</head>
<body>
<div align="center">
    <h2>Список сотрудников</h2>
    <h3><a href="${pageContext.request.contextPath}/newUser">Добавить нового сотрудника</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Возраст</th>
            <th>Действие</th>
        </tr>
        <c:forEach items="${listUsers}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.lastName}</td>
                <td>${user.age}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/edit?id=${user.id}">Edit</a>

                    <a href="${pageContext.request.contextPath}/delete?id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>