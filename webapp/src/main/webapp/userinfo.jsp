<%@ page import="org.example.dto.UserDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация о пользователе</title>
</head>
<body>
<div>
    <br>Имя: ${sessionScope.userDto.getName()}
    <br>Номер: телефона ${sessionScope.userDto.getNumber()}
    <br>Адрес: ${sessionScope.userDto.getAddress()}
    <br>Email: ${sessionScope.userDto.getEmail()}
    <br>Дата рождения: ${sessionScope.userDto.getBirthsDate()}
    <br> <a href="/biochemicalfinder">Найти все биохимические анализы</a>
    <br> <a href="/oakfinder">Найти все Общие анализы крови</a>
</div>
</body>
</html>
