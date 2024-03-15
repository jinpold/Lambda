package com.james.api.account;


import com.james.api.enums.AccountRouter;

import java.util.Scanner;

public class AccountView {
    public static void main(Scanner sc) {

        AccountController accountController = new AccountController();
        AccountRouter.account(sc);
    }
}

