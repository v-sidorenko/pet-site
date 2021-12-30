<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        Сюда добавится ваш текст:${param["out"]} ${param["in"]}
        <form action="index.jsp" method="post">
            <input hidden="true" name="out" value="${param["out"]} ${param["in"]}">
            Введите текст: <input type="text" name="in" value="" autofocus>
            <input type="submit">
        </form>
    </body>
</html>
