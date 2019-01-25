<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Афиша</title>
    <style type="text/css">
        body {
            background-image : url('/resources/images/fabric001.jpg');
            background-repeat: repeat;
        }
    </style>
</head>

<body>

<button onclick="location.href='/'">На главную</button>

<h2>Добавление нового клиента:</h2>

<div>

    <%--Обратить внимание на нижеследующий код!!!! Там описан процесс получения агрументов--%>

    <%--<%
    if (request.getAttribute("userName") != null) {
    out.println("<p>User '" + request.getAttribute("userName") + "' added!</p>");
    }
    %>--%>

    <form method="post" action="/MainControllerServlet">
        <table>
            <tr>
                <td>Имя:</td>
                <td><input type="text" name="name"/></td>
            </tr>

            <tr>
                <td>Тел:</td>
                <td> <input type="text" name="phone" /></td>
            </tr>

            <tr>
                <td>Город:</td>
                <td> <input type="text" name="city" /></td>
            </tr>

            <%--<tr>
                <td>Адресс:</td>
                <td> <input type="text" name="address" /></td>
            </tr>
            <tr>
                <td>Web-сайт:</td>
                <td> <input type="text" name="website" /></td>
            </tr>--%>

            <tr>
                <td></td>
                <td align="right"> <input type="submit" name="addClient" value="Добавить" ></td>
                <%--<td align="right"> <input type="submit" name="showGenres" value="Показать жанры" ></td>--%>
            </tr>
        </table>
    </form>

</div>

</body>
</html>
