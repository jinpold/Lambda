package com.james.api.enums;

import com.james.api.article.ArticleController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ArticleRouter {

    Exit("x", scanner ->  {
        System.out.println("EXIT");
        return false;
    }),

    List("l", scanner-> {
        try {
           ArticleController.getInstance().findAll().forEach(i -> System.out.println(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),

    ERROR("error", scanner-> {
        System.out.println("ERROR 유효하지 않는 문자입니다.");
        return true;
    });

    private final String name;

    private final Predicate<Scanner> predicate;


    ArticleRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }
    public static boolean munu(Scanner sc ) {
        System.out.println("[메뉴]\n" + "x-Exit\n" + "l-List\n");
        String str = sc.next();
        return Stream.of(values())
                .filter(i -> i.name.equals(str))
                .findAny().orElse(ERROR).predicate.test(sc);
    }
}
