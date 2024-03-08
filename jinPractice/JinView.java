package jinPractice;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class JinView {

    public static void main(Scanner sc) throws SQLException {

        JinController controller = new JinController();
        while (true) {
            System.out.println("[메뉴]" + "0-종료" + "1-글 목록");
            switch (sc.next()){
                case "0" :
                    System.out.println();
                    return;
                case "1" :
                    System.out.println();
                    List<?> ls = controller.findJin();
                    break;
            }
        }
    }
}
