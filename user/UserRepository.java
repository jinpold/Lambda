package user;
import java.sql.*;
import java.util.*;

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
        List<User> ls= new ArrayList<>();
        String sql = "select * from users";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                ls.add(User.builder()
                        .id(rs.getLong("id"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .name(rs.getString("name"))
                        .phone(rs.getString("phone"))
                        .job(rs.getString("job"))
                        .height(rs.getDouble("height"))
                        .weight(rs.getDouble("weight"))
                        .build());
            } while (rs.next());
        }else{
            System.out.println("데이터가 없습니다.");
        }
        rs.close();
        pstmt.close();
        return ls;
    }

    public String createTable() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS users (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    username VARCHAR(20),\n" +
                "    password VARCHAR(20),\n" +
                "    name VARCHAR(20),\n" +
                "    phone VARCHAR(20),\n" +
                "    job VARCHAR(20),\n" +
                "    height VARCHAR(20),\n" +
                "    weight VARCHAR(20)\n" +
                ");";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        int result = pstmt.executeUpdate();
        System.out.println("쿼리의 반환값은 : " + result);
//        String msg = "";
//        if(result==0){
//            msg = "테이블 생성 성공";
//        }else{
//            msg = "테이블 생성 실패";
//        }
        pstmt.close();
        return (result==0) ? "테이블 생성 성공":"테이블 생성 실패" ; // 삼항연산자

    }
    public String deleteTable() throws SQLException {

        String sql = "DROP TABLE IF EXISTS users";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        int result = pstmt.executeUpdate();
        System.out.println("쿼리의 반환값은 : " + result);
        String msg = "";
        if(result==0){
            msg = "테이블 삭제 성공";
        }else{
            msg = "테이블 삭제 실패";
        }
        pstmt.close();
        return msg;
    }

    public String insertData(User user) throws SQLException {
        String sql = "insert into users(id, username, password, name, phone, job, height, weight) \n" +
                "values (id,?,?,?,?,?,?,?);";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getName());
        pstmt.setString(4, user.getPhone());
        pstmt.setString(5, user.getJob());
        pstmt.setDouble(6, user.getHeight());
        pstmt.setDouble(7, user.getWeight());
        int result = pstmt.executeUpdate();
        System.out.println("쿼리의 반환값은 : " + result);
        String msg = "";
        if(result==1){
            msg = "데이터 추가 성공";
        }else{
            msg = "데이터 추가 실패";
        }

        pstmt.close();
        return msg;
    }
    public void sqlClose() throws SQLException {
        connection.close();
    }
}
