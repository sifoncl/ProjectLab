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
            <td  style="border: 1px solid black;">Дата получение материала</td>
            <td  style="border: 1px solid black;">Дата получения результата</td>
            <td  style="border: 1px solid black;">АЛТ</td>
            <td  style="border: 1px solid black;">АСТ</td>
            <td  style="border: 1px solid black;">Креатинин</td>
            <td  style="border: 1px solid black;">Мочевина</td>
            <td  style="border: 1px solid black;">Билирубин общий</td>
            <td  style="border: 1px solid black;">Билирубин прямой</td>
            <td  style="border: 1px solid black;">Биоирубин не прямой</td>
            <td  style="border: 1px solid black;">Холестерин</td>
            <td  style="border: 1px solid black;">Глюкоза</td>
            <c:forEach var="bc" items="${allBc}">
        <tr>
            <td  style="border: 1px solid black;">${bc.getGetMatirial()}</td>
            <td  style="border: 1px solid black;">${bc.getAddedResult()}</td>
            <td  style="border: 1px solid black;">${bc.getAlt()}</td>
            <td  style="border: 1px solid black;">${bc.getAst()}</td>
            <td  style="border: 1px solid black;">${bc.getCreatinin()}</td>
            <td  style="border: 1px solid black;">${bc.getMochevina()}</td>
            <td  style="border: 1px solid black;">${bc.getBilirubinObsh()}</td>
            <td  style="border: 1px solid black;">${bc.getBilirubinPriamoi()}</td>
            <td  style="border: 1px solid black;">${bc.getBilirubinNepriamoi()}</td>
            <td  style="border: 1px solid black;">${bc.getCholesterin()}</td>
            <td  style="border: 1px solid black;">${bc.getGlucose()}</td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
