package com.james.api.enums;
import com.james.api.article.ArticleView;
import com.james.api.crawler.CrawlerView;
import com.james.api.user.UserView;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum NavigationOfPredicate {

    Exit("x", scanner ->  {
        System.out.println("EXIT");
        return false;
    }),
    User("u", scanner -> {
        try {
            UserView.main(scanner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Board("b", scanner -> {
        System.out.println("Borad");
        return true;
    }),

    Account("m", scanner -> {
        System.out.println("Account");
        return true;
    }),
    Crawler("c", scanner-> {
        try {
            CrawlerView.main(scanner);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),

    Articles("a", scanner -> {
        try {
            ArticleView.main(scanner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),

    ERROR("error", scanner-> {
        System.out.println("ERROR 유효하지 않는 문자입니다.");
        return true;
    });
    // 1번 필드 생성
    private final String name;
    //0번 Main Navigation0fPredicate.navigate(sc);
    //1번 필드 생성 // 2번 상수 객체니까 final을 붙여준다.
    //3번 2개 생성자 생성하고 this name, scanner로 받아준다. (서비스 임플리먼트로 생성자 생성 또는 add 추가)
    //4번 스위치문 없애기 -> enum 활용  exit~ articles까지 적어주기
    // 4-1 기능을 구현해라 (람다식 4개중에 뭘 쓸지 결정)
    //5번 외부 호출 메서드 만들기 public static boolean navigate(Scanner sc) {} , 리턴은 모름

    private final Predicate<Scanner> predicate; //1번 생성

    //pricate String name

    NavigationOfPredicate(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static boolean navigate(Scanner sc) { //외부 호출
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

