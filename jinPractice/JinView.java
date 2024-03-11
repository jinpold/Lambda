package jinPractice;

import java.util.List;
import java.util.Scanner;

public class JinView {
    public static void main(Scanner sc) {

        JinController controller = new JinController();

        while (true) {
            System.out.println("[메뉴] 0-종료\n + 1-글 목록\n");
            switch (sc.next()){
                case "0" :
                    System.out.println("종료");
                    return;
                case "1" :
                    System.out.println("글 목록");
                    List <?> ls = controller.findJin();
                    controller.findJin().forEach((i-> System.out.println(i)));
                    break;
            }
        }

    }
}
