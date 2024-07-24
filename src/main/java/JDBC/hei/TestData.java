package JDBC.hei;
import java.sql.*;
import static java.sql.DriverManager.getConnection;

public class TestData {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = getConnection("jdbc:postgresql://localhost:5432/jdbc_datatest",
                    "postgres","tsiory98"); // for test only for jdbc Postgres
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        try{
            Driver driver = new org.postgresql.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            ResultSet res = conn.createStatement().executeQuery("SELECT * FROM client");
            while(res.next()){
                System.out.println(res.getString("id_client") +" : "
                        + res.getString("nom_client")+" : "
                        +res.getString("prenom_client")
                        );
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println();

        try{
            String query =
                            "SELECT c.nom_client, c.prenom_client, g.nom_gateau, g.categorie, contenir.quantite, commande.date_commande FROM commande\n" +
                            "LEFT JOIN client c ON commande.id_commande=c.id_client\n" +
                            "LEFT JOIN contenir ON commande.id_commande=contenir.id_commande\n" +
                            "LEFT JOIN gateau g ON contenir.id_gateau=g.id_gateau;";
            Statement statement1 = conn.createStatement();
            ResultSet res1 = statement1.executeQuery(query);

            while(res1.next()){
                System.out.println(res1.getString("nom_client") + " "
                                    + res1.getString("prenom_client") + " a commandé "
                                    + res1.getString("categorie") + " pour "
                                    + res1.getInt("quantite")+ " en date du"
                                    + res1.getDate("date_commande"));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}


