package com.james.api.enums;

import com.james.api.account.AccountController;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum AccountRouter {

    Exit("x", scanner -> {
        System.out.println("종료");
        return false;
    }),
    CreatAccount("cat",scanner -> {
        System.out.println("CreatAccount");
        AccountController.getInstance().createAccount(scanner);
        return true;
    }),
    Deposit("depo",scanner ->{
        System.out.println("Deposit");
        AccountController.getInstance().deposit(scanner);
        return true;
    }),

    Withdraw("with", scanner -> {
        System.out.println("Withdraw");
        AccountController.getInstance().withdraw(scanner);
        return true;
    }),

    Balance("bal", scanner -> {
        System.out.println("Balance");
        AccountController.getInstance().getBalance(scanner);
        return true;
    }),

    RemoveAccount("rm", scanner -> {
        System.out.println("RemoveAccount");
        AccountController.getInstance().deleteAccount(scanner);
        return true;
    }),

    GetAcoount("ls-a", scanner -> {
        System.out.println("AccountList");
        AccountController.getInstance().getAccount(scanner);
        return true;
    }),

    ERROR("error", scanner-> {
        System.out.println("ERROR 유효하지 않는 문자입니다.");
        return true;
    }),

    CreatTable("touch", scanner -> {
        System.out.println(scanner);
        return true;
    });

    private final String name;

    private final Predicate<Scanner> predicate;

    AccountRouter(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static boolean account(Scanner sc) {
        System.out.println("[Account] 0-Exit\n " +
                "1-create\n " +
                "2-Deposit\n " +
                "3-Withdraw\n " +
                "4-Balance\n" +
                "5-RemoveAccount\n ");
        String str = sc.next();
        return Stream.of(values())
                .filter(i -> i.name.equals(str))
                .findAny().orElse(ERROR).predicate.test(sc);
    }

}
