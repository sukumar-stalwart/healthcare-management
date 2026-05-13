package com.sukumar.bank_account.accountmanagement.util;

public class GenerateAccountNumber {

    public static String generateUniqueAccNum(){

        String name = "SBI";
        long accnum =  (long) (1000000000L + Math.random()*9000000000L);
        return  name + accnum ;
    }
}
