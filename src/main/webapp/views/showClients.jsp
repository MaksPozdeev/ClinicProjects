<%@ page import="java.util.*" %>
<%@ page import="app.entities.Client" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Клиника</title>
    <style>
        <%@include file="/resources/CSS/table_style.css"%>
    </style>

</head>
<body>
    <button onclick="location.href='/'">На главную</button>

    <form method="Post" action="/MainControllerServlet">
        <table class="bordered">
            <caption><h3>Список клиентов</h3></caption>
            <tr>
                <th>ID</th>
                <th>Имя</th>
                <th>Телефон</th>
                <th>Город</th>
                <th>Редактировать</th>
                <th>Удалить</th>

            </tr>

            <%--Выводим инфу из БД--%>
            <%
                List <Client> arr = (ArrayList)request.getAttribute("clients");
                for (Client client : arr) {
                    out.println("<tr>");
                    out.println("<td>" + client.getId() + "</td>");
                    out.println("<td>" + client.getName() + "</td>");
                    out.println("<td>" + client.getPhone() + "</td>");
                    out.println("<td>" + client.getCity() + "</td>");
                    out.println("<td><a href=\"/MainControllerServlet?edit_id=" + client.getId() + "\" align=\"center\"> Edit </a></td>");
                    out.println("<td><a href=\"/MainControllerServlet?delete_id=" + client.getId() + "\"> Delete </a></td>");


                    out.println("</tr>");
                }
            %>
        </table>
    </form>
</body>

</html>
