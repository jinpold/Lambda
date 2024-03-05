import Auth.AuthView;
import CrawlerService.CrawlerView;
import account.AccountView;
import board.BoardView;
import product.Product;
import product.ProductView;
import user.UserView;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //파사드 패턴 - 진입로를 하나로 들어가는 것
    public static void main(String[] args) {
        // 메인 메서드 static (변하지 않는 객체) 프로젝트에 단 하나 the one
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n === 0-Exit +" +
                    "1-User " +
                    "2-Board " +
                    "3-Account " +
                    "4-Crawler ===");

            // 이 프로젝트에는 현재 4개의 기능이 구현이 되어 있다.
            System.out.println("목록중에 원하시는걸 선택하세요");
            switch (sc.next()) {
                case "0": return; // 종료는 리턴!!
                case "1": UserView.main(sc);  break;
                case "2": BoardView.main(sc); break;
                case "3": AccountView.main(sc); break;
                case "4": CrawlerView.main(sc); break;
            }
        }
    }
}