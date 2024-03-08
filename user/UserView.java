package user;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserView {

    public static void main(Scanner sc) throws SQLException {

        UserController userController = new UserController();
        String msg = userController.addUsers();
        System.out.println("addUsers의 결과: " + msg);

        while (true) {
            System.out.println("[관리자메뉴] 0-종료\n " +
                    "1-회원가입\n " +
                    "2-로그인\n " +
                    "3-re연결\n " +
                    "4-비번변경\n" +
                    "5-탈퇴\n" +
                    "ls-회원목록\n" +
                    "7-이름검색\n" +
                    "8-직업검색\n" +
                    "9-회원수\n" +
                    "touch-테이블생성\n" +
                    "rm-테이블삭제\n" +
                    "is-데이터추가");

            switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    userController.sqlClose();
                    return;
                case "1":
                    System.out.println("1-회원가입");
                    System.out.println(userController.save(sc));
                    break;
                case "2":
                    System.out.println("2-로그인");
                    System.out.println(userController.login(sc));
                    break;
                case "3":
                    System.out.println("3-ID검색");
                    User user = userController.findByUser(sc);
                    System.out.println(user);
                    break;
                case "4":
                    System.out.println("4-비번변경");
                    System.out.println(userController.updatePassword(sc));
                    break;
                case "5":
                    System.out.println("5-탈퇴");
                    System.out.println(userController.deleteUser(sc));
                    break;
                case "ls":
                    System.out.println("6-회원목록");
                    List<?> users = userController.findUsers();
                    users.forEach(i -> System.out.println(i));
                    break;
                case "7":
                    System.out.println("7-이름검색");
                    userController.findUsersByName(sc).forEach((i) -> {
                        System.out.println(i);
                    });
                    break;
                case "8":
                    System.out.println("8-직업검색");
                    userController.findUsersByJob(sc).forEach((i) -> {
                        System.out.println(i);
                    });
                    break;
                case "9":
                    System.out.println("9-회원수");
                    String numberOfUsers = userController.count();
                    System.out.println("회원수" + userController.count());
                    break;
                case "touch":
                    System.out.println("테이블 생성");
                    System.out.println(userController.createTable());
                    break;
                case "rm":
                    System.out.println("테이블 삭제");
                    System.out.println(userController.deleteTable());
                    break;
                case  "is":
                    System.out.println("데이터 추가");
                    System.out.println(userController.insertData(sc));
            }
        }
    }
}



