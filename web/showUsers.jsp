<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список пользователей</title>
    </head>
    <body>
        <h1>Список пользователей</h1>
        <table border="2">
            <tr>
                <td>ID</td>
                <td>email</td>
                <td>name</td>
                <td>Действия</td>
            </tr>
            <c:forEach items="${users}" var = "user">
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getName()}</td>
                    <td>
                        <form action = "updateUser.jsp" method="post">
                            <input type="hidden" name="id" value="${user.getId()}">
                            <input type="hidden" name="email" value="${user.getEmail()}">
                            <input type="hidden" name="name" value="${user.getName()}">
                            <input type="submit" value="Изменить" style="float:left">
                        </form>
                        <form action="deleteUser.jsp" method="post">
                            <input type="hidden" name="id" value="${user.getId()}">
                            <input type="hidden" name="email" value="${user.getEmail()}">
                            <input type="hidden" name="name" value="${user.getName()}">
                            <input type="submit" value="Удалить" style="float:left">
                        </form></td>
                </tr>
            </c:forEach>
        </table>
        <a href="../">На главную</a>
        <a href="../addUser.jsp">Добавить пользователя</a>
    </body>
</html>
