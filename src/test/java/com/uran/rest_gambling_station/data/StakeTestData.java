package com.uran.rest_gambling_station.data;

import com.uran.rest_gambling_station.domain.Stake;

import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDateTime.of;

public class StakeTestData {
    public static final Stake STAKE_1 =
            new Stake(1L, UserTestData.USER_1, HorseTestData.HORSE_4, 100.25, of(2016, Month.MAY, 30, 10, 0).truncatedTo(ChronoUnit.SECONDS), true, 10.0, false);
    
    public static final Stake STAKE_2 =
            new Stake(2L, UserTestData.USER_2, HorseTestData.HORSE_5, 100.25, of(2016, Month.JUNE, 12, 13, 30).truncatedTo(ChronoUnit.SECONDS), false, 0.0, false);
    
    public static final Stake STAKE_3 =
            new Stake(3L, UserTestData.USER_1, HorseTestData.HORSE_6, 100.25, of(2016, Month.JUNE, 13, 19, 45).truncatedTo(ChronoUnit.SECONDS), false, 0.0, false);
    
    public static final Stake STAKE_4 =
            new Stake(4L, UserTestData.USER_2, HorseTestData.HORSE_4, 100.25, of(2016, Month.AUGUST, 5, 10, 9).truncatedTo(ChronoUnit.SECONDS), false, 0.0, false);
    
    public static final Stake STAKE_5 =
            new Stake(5L, UserTestData.USER_1, HorseTestData.HORSE_4, 100.25, of(2016, Month.AUGUST, 5, 10, 10).truncatedTo(ChronoUnit.SECONDS), false, 0.0, false);
    
    //public static final Stake STAKE_6 =
     //       new Stake(null, USER_1, HORSE_7, RACE_4, 10.0, of(2016, Month.AUGUST, 5, 10, 25).truncatedTo(ChronoUnit.SECONDS), false, 0.0, false);
    
    public static final List<Stake> STAKES = Arrays.asList(STAKE_1, STAKE_2, STAKE_3, STAKE_4, STAKE_5);
    
    public static Stake getCreated() {
        return new Stake(null, UserTestData.USER_1, HorseTestData.HORSE_1, RaceTestData.RACE_4, 5.25, of(2016, Month.OCTOBER, 3, 10, 35).truncatedTo(ChronoUnit.SECONDS), false, 0.0, true);
    }
    
    public static Stake getCreatedMore() {
        return new Stake(null, UserTestData.USER_1, HorseTestData.HORSE_9, RaceTestData.RACE_4, 5.25, of(2016, Month.OCTOBER, 3, 10, 39).truncatedTo(ChronoUnit.SECONDS), false, 0.0, true);
    }
}
