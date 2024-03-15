package com.james.api.enums;
import com.james.api.account.AccountView;
import com.james.api.article.ArticleView;
import com.james.api.board.BoardView;
import com.james.api.crawler.CrawlerView;
import com.james.api.user.UserView;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum NavigationOfFunction {

    Exit("x", i -> "x" ),

    User("u", i -> {
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Board("b", i -> {
        System.out.println("Board Menu");
        BoardView.main(i);
        return "";
    }),

    Account("m",i -> {
        AccountView.main(i);
        return "";
    }),
    Crawler("c", i -> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Article("a",  i -> {
        try {
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    ERROR("error",  i -> "")
    ;

    // 1번 필드 생성
    private final String name;
    private final Function<Scanner, String> function;

    NavigationOfFunction(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String navigate(Scanner sc) { //외부 호출

        System.out.println("\n === x-Exit +" +
                "u-User " +
                "b-Board " +
                "m-Account " +
                "c-Crawler " +
                "a-Articles" +
                "===");
        String str = sc.next();
        System.out.println("선택한 메뉴:" + str);
        return Stream.of(values())
                .filter(i->i.name.equals(str))
                .findAny()
                .orElseGet(()->Exit)
                .function.apply(sc);
    }
}

