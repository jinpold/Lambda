import com.james.api.enums.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);

        //List<?> ls = MenuController.getInstance().selectTable();
        // 리턴타입 3개 (3개밖에 존재하지 않음 / return 대신 현업에선 get 사용함
        //Messenger msg = MenuController.getInstance().returnMessenger();
        //Menu oneMenu = MenuController.getInstance().returnOneMenu();
        //List<?> allMenu = MenuController.getInstance().returnAllMenus();

        // 테이블 관련 코드
        //MenuController.getInstance().deleteMenuTable(); 개발자가 편하게 하려고 해놓음.
        //MenuController.getInstance().createMenuTable();
        //MenuController.getInstance().insertMenus();

        //기존 코드
        while(Navigation.navigate(sc));

//        //펑션
//        String stringFlag2 = NavigationOfFunction.navigate(sc);
//        while (!stringFlag2.equals("x"));

        //프리디킷
        //boolean booleanFlag = NavigationOfPredicate.select(sc);
        //while (booleanFlag);

        //컨슈머
        //NavigationOfConsumer.select(sc);
        // while();

        //서플라이어
        //String stringFlag = NavigationOfSupplier.select(sc);
        //while (stringFlag.equals("x"));
    }
}
