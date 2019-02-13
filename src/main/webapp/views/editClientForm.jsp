<%@ page import="app.entities.Client" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<h2>Редактирование клиента:</h2>

<div>

    <form method="post" action="/MainControllerServlet">
        <table>
        <%
            Client client = (Client) request.getAttribute("client");
        %>
            <tr>
                <td>Имя:</td>
                <td><input type="text" name="name" value="<%=client.getName()%>"></td>
            </tr>

            <tr>
                <td>Тел:</td>
                <td> <input type="text" name="phone" value="<%=client.getPhone()%>" ></td>
            </tr>

            <tr>
                <td>Город:</td>
                <td> <input type="text" name="city" value="<%=client.getCity()%>" ></td>
            </tr>

            <tr>
                <td></td>
                <input type="hidden" name="client_id" value="<%=client.getId()%>" >
                <td align="right"> <input type="submit" name="editClient" value="Сохранить" ></td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
