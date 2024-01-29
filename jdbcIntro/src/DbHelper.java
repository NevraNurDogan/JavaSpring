import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private String userName="root";
    private String password="1234abcd";
    private String dblUrl="jdbc:mysql://localhost:3306/world";
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dblUrl,userName,password);

    }
    public void showErrorMessage(SQLException e){
        System.out.println("Eror:"+e.getMessage());
        System.out.println("Eror Code:"+e.getErrorCode());
    }

}
