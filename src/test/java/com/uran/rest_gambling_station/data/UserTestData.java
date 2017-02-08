package com.uran.rest_gambling_station.data;

import com.uran.rest_gambling_station.domain.Role;
import com.uran.rest_gambling_station.domain.User;

import java.util.Arrays;
import java.util.List;

public class UserTestData {
    public static final User USER_1 =
            new User(1L,"User1", "user1@yandex.ru", "$2a$10$Gk4kXU24ryWq66oKA0f8AeaguhyMNx7.pR2x/euooqK0NG.IyK1jC", AccountTestData.ACC_USER_1, Role.ROLE_USER);
    public static final User USER_2 =
            new User(2L, "User2", "user2@yandex.ru", "$2a$10$3Om1jqFdbcLtir5XsQbS2uiBG/7kv2twth/3BGg1jPTjbqgaqplw.", AccountTestData.ACC_USER_2, Role.ROLE_USER);
    public static final User ADMIN =
            new User(3L, "Admin", "admin@gmail.com", "$2a$10$WejOLxVuXRpOgr4IlzQJ.eT4UcukNqHlAiOVZj1P/nmc8WbpMkiju", AccountTestData.ACC_USER_ADMIN, Role.ROLE_ADMIN);
    public static final User STATION =
            new User(4L, "Station", "station@gamblingstation.com", "$2a$10$4BB/oW0v.c54SFiRB47gue22MjbPnG88iSRSo//uESs1T1NMrnpUK", AccountTestData.ACC_USER_STATION, Role.ROLE_STATION);
    
    public static final List<User> USERS = Arrays.asList(USER_1, USER_2, ADMIN, STATION);
    public static final List<User> USERS_SORTED_ASC = Arrays.asList(ADMIN, STATION, USER_1, USER_2);
    
    //public static final Iterable<User> USERS_SORTED = new ArrayList<>(USERS_S);
}
