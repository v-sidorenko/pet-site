<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ошибка БД</title>
    </head>
    <body>
        <h1>Ошибка базы данных.</h1>
        Хотите выполнить начальную настройку БД?<br>
        Все данные будут удалены.<br>
        <br>
        <form action="db" method="POST">
            <input type="hidden" name="method" value="dbReset">
            <input type="submit" value="Cоздать пустую БД" />
        </form>
        <form action="db" method="POST">
            <input type="hidden" name="method" value="dbSample">
            <input type="submit" value="Cоздать БД с примерами" />
        </form>
    </body>
</html>
