import board.BoardView;
import crawler.CrawlerView;
import account.AccountView;
import article.ArticleView;
import jinPractice.JinView;
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
            System.out.println("\n === x-Exit +" +
                    "u-User " +
                    "b-Board " +
                    "m-Account " +
                    "c-Crawler " +
                    "a-Articles" +
                    "===");

            System.out.println("목록중에 원하시는걸 선택하세요");
            switch (sc.next()) {
                case "x": return;
                case "u": UserView.main(sc);  break;
                case "b": BoardView.main(sc); break;
                case "m": AccountView.main(sc); break;
                case "c": CrawlerView.main(sc); break;
                case "a": ArticleView.main(sc); break;
                case "j": JinView.main(sc); break;
            }
        }
    }
}