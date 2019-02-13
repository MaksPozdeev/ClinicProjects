package app.model;

import app.entities.Client;
import java.sql.*;

public class DbShowClient {

    public static Client qweryDatabase(int record_id) {
        Client client = null;
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
            try{
                PreparedStatement preparedStatement = null;

                preparedStatement = connection.prepareStatement("select * from clients where client_id=?");
                preparedStatement.setInt(1, record_id);

                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){
                    client_id = resultSet.getInt("client_id");
                    name = resultSet.getString("name");
                    phone = resultSet.getString("phone");
                    city = resultSet.getString("city");

                    client = new Client(client_id, name, phone, city);
                }

                resultSet.close();
                preparedStatement.close();
            } finally {
                connection.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return client;
    }
}