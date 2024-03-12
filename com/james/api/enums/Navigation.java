package com.james.api.enums;

import com.james.api.article.ArticleView;
import com.james.api.crawler.CrawlerView;
import com.james.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Navigation {

    Exit("x", i ->  {
        System.out.println("EXIT");
        return false;
    }),
    User("u", i -> {
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Board("b", i -> {
        System.out.println("Borad");
        return true;
    }),

    Account("m", i -> {
        System.out.println("Account");
        return true;
    }),
    Crawler("c", i-> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),

    Articles("a", i -> {
        try {
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),

    ERROR("error", i-> {
        System.out.println("ERROR 유효하지 않는 문자입니다.");
        return true;
    });

    private final String name;
    private final Predicate<Scanner> predicate;

    Navigation(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }
    public static boolean navigate(Scanner sc) {
        System.out.println("\n === x-Exit +" +
                "u-User " +
                "b-Board " +
                "m-Account " +
                "c-Crawler " +
                "a-Articles" +
                "===");
        String str = sc.next();
        return Stream.of(values())
                .filter(i -> i.name.equals(str))
                .findAny().orElse(ERROR).predicate.test(sc);
    }
}

