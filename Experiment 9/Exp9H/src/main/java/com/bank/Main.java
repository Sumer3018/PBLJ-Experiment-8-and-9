package com.bank;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
            AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
        BankService bankService = context.getBean(BankService.class);
        try {
           // bankService.transferMoney(1, 2, 500); 
            bankService.transferMoney(2, 1, 400); 
            System.out.println("Money transfer successful!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        context.close();
    }
}
