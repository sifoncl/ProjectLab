import org.example.dbconnecrion.DbConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class SomeTest {

    public static void main(String[] args) throws SQLException {

     Connection connection = DbConnectionManager.get();
        System.out.println(connection.getTransactionIsolation());
    }


}
