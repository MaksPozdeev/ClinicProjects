package app.model;

import app.entities.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbShowClients {

    public static ArrayList testDatabase() {
        List<Client> clientsList = new ArrayList<>();
        Integer client_id;
        String name, phone, city;

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/petclinic";
            String login = "postgres";
            String password = "passgres";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM clients");
                while (rs.next()) {
                    client_id = rs.getInt("client_id");
                    name = rs.getString("name");
                    phone = rs.getString("phone");
                    city = rs.getString("city");
                    Client client = new Client(client_id, name, phone, city);
//                        genre.setId(id);
//                        genre.setName(name);
                    clientsList.add(client);
                    System.out.println("Клиент:" + client);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (ArrayList) clientsList;
    }
}
