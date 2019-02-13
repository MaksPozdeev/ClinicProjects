package app.model;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/model/EditClient")
public class EditClient extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        //Количество обновлённых записей
        int rows=0;

                //Инфа для отслеживания в консоли
                System.out.println("EditClient_servlet: START");

        //Сохранение отредактированных данных клиента
        if (req.getParameter("editClient") != null) {
            Integer id = Integer.parseInt(req.getParameter("client_id"));
            String name = req.getParameter("name");
            String phone = req.getParameter("phone");
            String city = req.getParameter("city");
            System.out.println("New client data: " + name +" " + phone +" "+ city);

            try {
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://localhost:5432/petclinic";
                String login = "postgres";
                String password = "passgres";

                Connection connection = DriverManager.getConnection(url, login, password);
                try {
                    PreparedStatement preparedStatement;
                    preparedStatement = connection.prepareStatement("UPDATE clients SET name =?,  phone=?, city=? WHERE client_id=?");
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, phone);
                    preparedStatement.setString(3, city);
                    preparedStatement.setInt(4, id);

                    rows = preparedStatement.executeUpdate();
                    preparedStatement.close();
                } finally {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

//            Переделать!!!!!!!
//            Код ниже добавляет фон, кнопку перехода на главную стр и количество добавленных записей

            PrintWriter out = resp.getWriter();
            out.print("<style type=\"text/css\">\n" +
                    "        body {\n" +
                    "            background-image : url('/resources/images/fabric001.jpg');\n" +
                    "            background-repeat: repeat;            \n" +
                    "        }        \n" +
                    "    </style>");
            if (rows != 0) {
                out.print("Добавлено записей: " + rows);
                out.print("<br>");
            }
            out.print(" <button onclick=\"location.href='/'\">На главную</button>" + "<br>");
            out.close();
        }

//        Инфа для отслеживания в консоли
        System.out.println("AddClient_servlet: STOP");

    }
}

