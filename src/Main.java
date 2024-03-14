import com.james.api.enums.NavigationOfPredicate;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        //기존 코드
        while(NavigationOfPredicate.navigate(sc));

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
