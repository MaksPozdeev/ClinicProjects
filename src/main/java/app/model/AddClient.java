package app.model;

//import app.entities.Theater;
//import app.model.dbAddUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/model/AddClient")
public class AddClient extends HttpServlet {

//    Theater theater = new Theater();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        int rows=0;

        System.out.println("AddClient_servlet: START");
        //Добавление клиента
        if (req.getParameter("addClient") != null) {
            String name = req.getParameter("name");
            String phone = req.getParameter("phone");
            String city = req.getParameter("city");
            System.out.println("Client: " + name +" " + phone +" "+ city);

            try {
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://localhost:5432/petclinic";
                String login = "postgres";
                String password = "passgres";

                Connection con = DriverManager.getConnection(url, login, password);
//            String sqlQuery = "INSERT INTO users VALUES (6,'Denis', 'pass6');";
                try {
                    Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery(sqlQuery);

                    PreparedStatement pstm = con.prepareStatement("INSERT INTO clients (name,  phone, city) values (?,?,?)");
                    pstm.setString(1, name);
                    pstm.setString(2, phone);
                    pstm.setString(3, city);

                    rows = pstm.executeUpdate();
//                rs.close();
                    stmt.close();
                } finally {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

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

//
//           out.print(req.getParameter("name") + "<br>");
//            out.print(req.getParameter("city") + "<br>");
//            out.print(req.getParameter("address") + "<br>");
//            out.print(req.getParameter("phone") + "<br>");
//            out.print(req.getParameter("website") + "<br>");
            out.close();

        }

        //Добавление User'a
       /* else if (req.getParameter("addNewUser") != null) {
            String name = req.getParameter("name");
            String pass = req.getParameter("pass");
            System.out.println("User: " + name +" " + pass);
            dbAddUser.testAddUser(name, pass);*/

//            Сюда бы вставить проверочку о том, что запись реально добавилась
//            И уже писать результат: "Запись добавилась" или что-то типа "Возник сбой, повторите попытку"

            /*PrintWriter out = resp.getWriter();
            out.print(" <button onclick=\"location.href='/'\">На главную</button>" + "<br>");
            out.print("Запись добавлена");
            out.close();*/


        //Добавление ЧЯВО-ТО
        System.out.println("AddClient_servlet: STOP");

    }
}

/*
    public static void testAddUser(String name, String pass) {

//        String name, city, address, phone, website;

        System.out.println("Users_from_dbAddUser: " + name + " " + pass);



    }
}*/

