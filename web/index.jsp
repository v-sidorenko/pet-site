<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
    <head>
        <title>Index</title>
    </head>
    <body>
        <h1>Работа с БД SQLite</h1>
        <form action = "users"  method="get">
            <input type="submit" value="Список пользователей">
        </form>
    </body>
</html>
