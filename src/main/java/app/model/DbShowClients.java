package app.model;

import app.entities.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbShowClients {

    public static List qweryDatabase() {
        List<Client> clientsList = new ArrayList<>();
        Integer client_id;
        String name;
        String phone;
        String city;

        String url = "jdbc:postgresql://localhost:5432/petclinic";
        String login = "postgres";
        String password = "passgres";

        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(url, login, password);
            try {
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM clients");

                while (resultSet.next()) {
                    client_id = resultSet.getInt("client_id");
                    name = resultSet.getString("name");
                    phone = resultSet.getString("phone");
                    city = resultSet.getString("city");

                    Client client = new Client(client_id, name, phone, city);

                    clientsList.add(client);

//                    System.out.println(client);
                }
                resultSet.close();
                statement.close();
            } finally {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientsList;
    }
}
