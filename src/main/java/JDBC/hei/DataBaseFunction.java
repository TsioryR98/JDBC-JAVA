package JDBC.hei;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static java.sql.DriverManager.getConnection;

public class DataBaseFunction {
    private static final String URL = "jdbc:postgresql://localhost:5432/jdbc_datatest";
    private static final String User = "postgres";
    private static final String Password = "tsiory98";//for test for connect easily

    static {
        //initialize and save postgres Driver
        try{
            Driver driver = new org.postgresql.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // connect to database
    public static Connection getConnection(){
        Connection conn = null;
        //Driver postgresql loading
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        try {
            conn = DriverManager.getConnection(URL,User,Password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
    //INSERT QUERY
    public void insertCustomer(Connection conn,int id_client, String nom_client,
                               String prenom_client, String adresse,
                               String telephone, String email){
        String query = "INSERT INTO client (id_client,nom_client,prenom_client,adresse,telephone,email)\n" +
                       "VALUES(?,?,?,?,?,?)";
        try (PreparedStatement statement = conn.prepareStatement(query);){
                statement.setInt(1,id_client);
                statement.setString(2,nom_client);
                statement.setString(3,prenom_client);
                statement.setString(4,adresse);
                statement.setString(5,telephone);
                statement.setString(6,email);
                System.out.println("INSERT VALIDATED");                             
                statement.executeUpdate();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteCustomer(Connection conn,String table_name, String target, int id){
        String query = "DELETE FROM "+table_name+" WHERE "+target+" =?";                ;
        try (PreparedStatement statement = conn.prepareStatement(query);){
                statement.setInt(1,id);
                System.out.println("DELETE VALIDATED");
                statement.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void showCustomerOrder(Connection conn){
        String query =
                "SELECT c.nom_client, c.prenom_client, g.nom_gateau, g.categorie, contenir.quantite, commande.date_commande FROM commande\n" +
                        "LEFT JOIN client c ON commande.id_commande=c.id_client\n" +
                        "LEFT JOIN contenir ON commande.id_commande=contenir.id_commande\n" +
                        "LEFT JOIN gateau g ON contenir.id_gateau=g.id_gateau;";
        //statement for queries not update
        try (Statement statement1 = conn.createStatement()){
            ResultSet res1 = statement1.executeQuery(query);

            while(res1.next()){
                System.out.println(res1.getString("nom_client") + " "
                        + res1.getString("prenom_client") + " a commandé "
                        + res1.getString("categorie") + " pour "
                        + res1.getInt("quantite")+ " en date du "
                        + res1.getDate("date_commande"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
