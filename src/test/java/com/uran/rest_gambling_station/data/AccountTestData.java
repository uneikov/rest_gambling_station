package com.uran.rest_gambling_station.data;

import com.uran.rest_gambling_station.domain.Account;

import java.util.Arrays;
import java.util.List;

public class AccountTestData {
    
    public static Account ACC_USER_1 = new Account("1234432156788765", 10.0, UserTestData.USER_1);
    public static Account ACC_USER_2 = new Account("1234432589028765", 15.0, UserTestData.USER_2);
    public static Account ACC_USER_ADMIN = new Account("1234433478588765", 0.0, UserTestData.ADMIN);
    public static Account ACC_USER_STATION = new Account("9076632156788765", 100.0, UserTestData.STATION);
    
    public static List<Account> ACCOUNTS = Arrays.asList(ACC_USER_1, ACC_USER_2, ACC_USER_ADMIN, ACC_USER_STATION);
}
