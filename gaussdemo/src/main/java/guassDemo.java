import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class guassDemo {

    public static void main(String[] args) {
        String driver = "com.huawei.gauss.jdbc.ZenithDriver";
        String url = "jdbc:zenith:@121.36.96.161:1888";
        String user = "lxk";
        String password = "liuxiaokun@123";
        String sql = "select * from users";
        Connection conn = null;
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, user, password);
//            System.out.println(conn);
            Statement stmt = conn.createStatement();
            int rc = stmt.executeUpdate(sql);

            System.out.println(rc);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
