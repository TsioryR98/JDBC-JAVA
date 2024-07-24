package JDBC.hei;

import java.sql.Connection;

public class MainDataBaseExe {
    public static void main(String[] args) {
        DataBaseFunction app = new DataBaseFunction();
        Connection conn = app.getConnection();
        app.insertCustomer(conn,11,"rakoto","tojoniana","Ankadifotsy","0321456789","azerty@gmail.com");
        app.insertCustomer(conn,12,"rasoa       ","tojoniana","Ankadifotsy","0321456789","azerty@gmail.com");

        app.deleteCustomer(conn,"client","id_client",12);
        app.showCustomerOrder(conn);
    }
}
