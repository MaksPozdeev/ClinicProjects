package app.model;

import app.entities.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbDeleteClient {
    public static void qweryDatabase(int record_id) {

        String url = "jdbc:postgresql://localhost:5432/petclinic";
        String login = "postgres";
        String password = "passgres";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, login, password);
            try{
                PreparedStatement preparedStatement = null;
                preparedStatement = connection.prepareStatement("DELETE FROM clients where client_id=?");
                preparedStatement.setInt(1, record_id);
                preparedStatement.executeQuery();
                preparedStatement.close();
            } finally {
                connection.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
