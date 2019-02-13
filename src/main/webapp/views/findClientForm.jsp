<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Клиника</title>
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
                <td>Id:</td>
                <td><input type="text" name="client_id"/></td>
            </tr>
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

            <tr>
                <td></td>
                <td align="right"> <input type="submit" name="findClient" value="Найти" ></td>
            </tr>
        </table>
    </form>

</div>

</body>
</html>
