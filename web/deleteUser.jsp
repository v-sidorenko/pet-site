<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<html>
    <head>
        <title>Удаление пользователя</title>
    </head>
    <body>
        <h1>Вы действительно хотите удалить пользователя?</h1>
        id = ${param.id}<br>
        email = ${param.email}<br>
        name = ${param.name}<br>
        <table cellpadding="5">
            <tr>
                <form action = "users" method="post">
                    <input type="hidden" name="id" value="${param.id}">
                    <input type="hidden" name="method" value="delete">
                    <input type="submit" value="Ок" style="float:left">
                </form>
            </tr>
            <tr>
                <form action="users" method="get">
                    <input type="submit" value="Отмена" style="float:left">
                </form>
            </tr>
        </table>
</body>
</html>
