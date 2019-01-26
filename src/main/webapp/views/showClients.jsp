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

    <table class="bordered">
        <caption><h3>Список клиентов</h3></caption>
        <tr>
            <th>ID</th>
            <th>Имя</th>
            <th>Телефон</th>
            <th>Город</th>
        </tr>

        <%--Выводим инфу из БД--%>
        <%
            ArrayList arr = (ArrayList) request.getAttribute("clients");
            Iterator<Client> iter  = arr.iterator();
            while (iter.hasNext()){
                Client client = iter.next();
                out.println("<tr>");
                out.println("<td>" + client.getId() + "</td>");
                out.println("<td>" + client.getName() + "</td>");
                out.println("<td>" + client.getPhone() + "</td>");
                out.println("<td>" + client.getCity() + "</td>");
                out.println("</tr>");
            }
        %>
    </table>
</body>

</html>
