package com.uran.rest_gambling_station.data;

import com.uran.rest_gambling_station.domain.Race;

import java.time.Month;

import static java.time.LocalDateTime.of;

public class RaceTestData {
    private static final String HORSES_LIST_1 = "Alien:Чужой,Black Ghost:Черный призрак,White Ghost:Белый призрак,Enisei:Енисей,Thunderbird:Гром,Ruby Rose:Рубироуз";
    private static final String HORSES_LIST_2 = "Predator:Хищник,Gulfstream:Гольфстрим,Rabindranate:Рабиндранат,Ruby Rose:Рубироуз,White Ghost:Белый призрак,Angelfire:Энджелфае";
    
    public static final Race RACE_1 = new Race(1L, of(2016, Month.MAY, 30, 10, 0), of(2016, Month.MAY, 30, 10, 45), HORSES_LIST_1, "Ghost:Черный призрак");
    public static final Race RACE_2 = new Race(2L, of(2016, Month.JUNE, 12, 13, 0), of(2016, Month.JUNE, 12, 13, 45), HORSES_LIST_1, "Thunderbird:Гром");
    public static final Race RACE_3 = new Race(3L, of(2016, Month.JUNE, 13, 19, 0), of(2016, Month.JUNE, 13, 19, 45), HORSES_LIST_2, "Predator:Хищник");
    public static final Race RACE_4 = new Race(4L, of(2016, Month.AUGUST, 5, 10, 0), of(2016, Month.AUGUST, 5, 10, 45), HORSES_LIST_2, "Ruby Rose:Рубироуз");
}
