<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавление пользователя</title>
    </head>
    <body>
        <h1>Введите данные пользователя:</h1>
        <form action = "users" method="post">
            <input type="text" name="email" placeholder="Email" required><br><br>
            <input type="text" name="name" placeholder="Имя" required><br>
            <input type="hidden" name="method" value="add"><br>
            <input type="submit" value="Ок"><br>
        </form><br>
        <form action="users" method="get">
            <input type="submit" value="Отмена">
        </form>
    </body>
</html>
