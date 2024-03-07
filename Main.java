import article.ArticleService;
import board.BoardView;
import crawler.CrawlerView;
import account.AccountView;
import article.ArticleView;
import user.UserView;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n === 0-Exit +" +
                    "1-User " +
                    "2-Board " +
                    "3-Account " +
                    "4-Crawler " +
                    "5-Articles" +
                    "===");

            System.out.println("목록중에 원하시는걸 선택하세요");
            switch (sc.next()) {
                case "0": return;
                case "1": UserView.main(sc);  break;
                case "2": BoardView.main(sc); break;
                case "3": AccountView.main(sc); break;
                case "4": CrawlerView.main(sc); break;
                case "5": ArticleView.main(sc); break;
            }
        }
    }
}