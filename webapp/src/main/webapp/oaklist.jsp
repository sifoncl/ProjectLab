<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Биохимические анализы</title>
</head>
<body>
<div>
    <br>Биохимические анализы: ${sessionScope.userDto.getName()}
    <table style="border-collapse: collapse;">
        <tr>
            <td style="border: 1px solid black;">Дата получение материала</td>
            <td style="border: 1px solid black;">Дата получения результата</td>
            <td style="border: 1px solid black;">Эритроциты</td>
            <td style="border: 1px solid black;">Лимфоциты</td>
            <td style="border: 1px solid black;">Тромбоциты</td>
            <td style="border: 1px solid black;">Гемаглобин</td>
            <td style="border: 1px solid black;">Гематокрит</td>
            <td style="border: 1px solid black;">Цветовой покзатель</td>
            <td style="border: 1px solid black;">Ретикулоциты</td>
            <td style="border: 1px solid black;">СОЕ</td>
            <td style="border: 1px solid black;">Палочкоядерные гранулоциты</td>
            <td style="border: 1px solid black;">Сегментоядерные гранулоциты</td>
            <td style="border: 1px solid black;">Эозинофилы</td>
            <td style="border: 1px solid black;">Базофилы</td>
            <td style="border: 1px solid black;">Лимфоциты</td>
            <td style="border: 1px solid black;">Моноциты</td>
            <td style="border: 1px solid black;">Метомиелоциты</td>
            <td style="border: 1px solid black;">Миелоциты</td>
            <c:forEach var="oak" items="${allOAK}">
        <tr>
            <td style="border: 1px solid black;">${oak.getGetMatirial()}</td>
            <td style="border: 1px solid black;">${oak.getAddedResult()}</td>
            <td style="border: 1px solid black;">${oak.getRbc()}</td>
            <td style="border: 1px solid black;">${oak.getWbc()}</td>
            <td style="border: 1px solid black;">${oak.getTrombocitis()}</td>
            <td style="border: 1px solid black;">${oak.getHb()}</td>
            <td style="border: 1px solid black;">${oak.getHematocritis()}</td>
            <td style="border: 1px solid black;">${oak.getCp()}</td>
            <td style="border: 1px solid black;">${oak.getReticulocitis()}</td>
            <td style="border: 1px solid black;">${oak.getSoe()}</td>
            <td style="border: 1px solid black;">${oak.getPalochkoydernieGranulociti()}</td>
            <td style="border: 1px solid black;">${oak.getSegmentoydernieGranulociti()}</td>
            <td style="border: 1px solid black;">${oak.getEosinofiles()}</td>
            <td style="border: 1px solid black;">${oak.getBasofiles()}</td>
            <td style="border: 1px solid black;">${oak.getLimfocities()}</td>
            <td style="border: 1px solid black;">${oak.getMonocities()}</td>
            <td style="border: 1px solid black;">${oak.getMetolmielocites()}</td>
            <td style="border: 1px solid black;">${oak.getMielocities()}</td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>