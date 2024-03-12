package com.james.api.product;
import com.james.api.common.UtilService;
import com.james.api.common.UtilServiceImpl;

import java.util.Scanner;

public class ProductView {
    public static void main(Scanner sc) {

        UtilService util = UtilServiceImpl.getInstance();
        Product product = Product.builder()
                .pno(util.createRandomInteger(1, 8))
                .name(util.createRandomWriter())
                .company(util.createRandomCompany())
                .price(util.createRandomInteger(0,100))
                .build();
        System.out.println(product.toString());
    }
}


