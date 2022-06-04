<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Изменение пользователя</title>
    </head>
    <body>
        <h1>Вы можете изменить данные пользователя ${param.id}:</h1>
        <form action="users" method="POST">
            <input type="hidden" name="id" value=${param.id}>
            <input type="text" name="email" placeholder="Email" value=${param.email} required /><br><br>
            <input type="text" name="name"  placeholder="Имя" value=${param.name} required /><br><br>
            <input type="hidden" name="method" value="update">
            <input type="submit" value="ОК" />
        </form><br>
        <form action="users" method="GET">
            <input type="submit" value="Отмена" />
        </form>
    </body>
</html>
