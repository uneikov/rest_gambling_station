package com.uran.rest_gambling_station.data;

import com.uran.rest_gambling_station.domain.Horse;

public class HorseTestData {
    private static final long HORSE_1_ID = 1L;
    public static final Horse HORSE_1 = new Horse(HORSE_1_ID, "Black Ghost", "Черный призрак", 5, 0, true);
    public static final Horse HORSE_2 = new Horse(HORSE_1_ID + 1, "White Ghost", "Белый призрак", 5, 0, true);
    public static final Horse HORSE_3 = new Horse(HORSE_1_ID + 2, "Enisei", "Енисей", 3, 0);
    public static final Horse HORSE_4 = new Horse(HORSE_1_ID + 3, "Thunderbird", "Гром", 5, 0, true);
    public static final Horse HORSE_5 = new Horse(HORSE_1_ID + 4, "Ruby Rose", "Рубироуз", 4, 0, true);
    public static final Horse HORSE_6 = new Horse(HORSE_1_ID + 5, "Predator", "Хищник", 5, 0, true);
    public static final Horse HORSE_7 = new Horse(HORSE_1_ID + 6, "Alien", "Чужой", 6, 0, true);
    public static final Horse HORSE_8 = new Horse(HORSE_1_ID + 7, "Gulfstream", "Гольфстрим", 3, 0);
    public static final Horse HORSE_9 = new Horse(HORSE_1_ID + 8, "Rabindranate", "Рабиндранат", 5, 0);
    public static final Horse HORSE_10 = new Horse(HORSE_1_ID + 9, "Angelfire", "Энджелфае", 5, 0);
}
