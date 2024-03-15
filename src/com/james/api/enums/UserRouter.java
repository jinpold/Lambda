package com.james.api.enums;
import com.james.api.user.UserController;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum UserRouter {
    EXIT("x", (scanner) ->{
        System.out.println("종료");
        return false;
    }),
    JOIN("j", (scanner) -> {
        try {
            UserController.getInstance().save(scanner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    LOGIN("l", (scanner) ->{
        UserController.getInstance().login(scanner);
        return true;
    }),
    ID("id", (scanner) ->{
        UserController.getInstance().findById(scanner);
        return true;
    }),
    PASSWORD("cp", (scanner) ->{
        UserController.getInstance().updatePassword(scanner);
        return true;
    }),
    DELETE("d", (scanner) ->{
        UserController.getInstance().deleteUser(scanner);
        return true;
    }),
    LIST("ls", (scanner) ->{
        try {
            UserController.getInstance().findUsers().forEach(i-> System.out.println(i));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    NAME("name", (scanner) ->{
        UserController.getInstance().findUsersByName(scanner);
        return true;
    }),
    JOB("job", (scanner) ->{
        UserController.getInstance().findUsersByJob(scanner);
        return true;
    }),
    COUNT("count", (scanner)->{
        System.out.println(scanner);
        return true;
    }),
    TOUCH("touch", (scanner) -> {
        try {
            System.out.println(UserController.getInstance().createTable());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    REMOVE("rm", (scanner) -> {
        try {
            System.out.println(UserController.getInstance().deleteTable());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    INSERT ("in", (scanner) -> {
        try {
            System.out.println(UserController.getInstance().insertData(scanner));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),

    ERROR("error", (scanner) -> {
        System.out.println("ERROR 유효하지 않는 문자입니다.");
        return true;
    });

    private final String name;
    private final Predicate<Scanner> predicate;

    UserRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }
    public static boolean router(Scanner sc)  {
        System.out.println("[메뉴] x-Exit\n" +
                " j-회원가입\n" +
                " l-로그인\n" +
                " id-ID검색\n" +
                " cp-비번변경\n" +
                " d-탈퇴\n" +
                " ls-회원목록\n" +
                " name-이름검색\n" +
                " job-직업검색\n" +
                " count-회원수\n" +
                " touch - 테이블생성\n" +
                " rm - 테이블삭제\n"+
                " in - 데이터추가");
        String str = sc.next();
        return Stream.of(values())
                .filter(i -> i.name.equals(str))
                .findAny().orElse(ERROR).predicate.test(sc);
    }
}