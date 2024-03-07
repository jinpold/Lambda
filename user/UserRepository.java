package user;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    private static UserRepository instance;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Connection connection;
    private UserRepository() throws SQLException {

         connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/jamesdb",
            "james",
            "password");

    }
    public static UserRepository getInstance() {
        return instance;
    }

    public String test() {
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {

        String sql = "select * from board";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                System.out.printf("ID: %d\t Title: %s\t Content: %s\t Writer: %s\n",
                        rs.getInt("id"),
                        rs.getString("Title"),
                        rs.getString("Content"),
                        rs.getString("Writer"));

            } while (rs.next());

        }else{

            System.out.println("데이터가 없습니다.");
        }
        rs.close();
        pstmt.close();
        connection.close();
        return null;
    }
}