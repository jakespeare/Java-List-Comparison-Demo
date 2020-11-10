package service;

import dto.OpPowerlifterDto;
import dto.UsaplPowerlifterDto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PowerliftingService {

    //Keep in mind, due to O(n^2) for List Implementation, anything beyond 1000 records will take a LONG time.
    static final int RECORDS = 5_000_000;
    static final int LIST_RECORDS = 5_000_000; //Change LIST_RECORDS if you'd like to differ by list to create a time/record equivalency.


    public static List<UsaplPowerlifterDto> getUsaplPowerlifters() {
        List<UsaplPowerlifterDto> usaplPowerlifters = new ArrayList<>();
        for (int i = 0; i < RECORDS; i++) {
            usaplPowerlifters.add(getUsaplPowerlifter(String.valueOf(i)));
        }
        return usaplPowerlifters;
    }

    //By creating records this way, we make discrepancies equal to the number of records.
    public static List<OpPowerlifterDto> getOpPowerlifters() {
        List<OpPowerlifterDto> opPowerlifter = new ArrayList<>();

        for (int i = RECORDS; i < RECORDS + RECORDS; i++) {
            opPowerlifter.add(getOpPowerlifter(i));
        }
        return opPowerlifter;
    }

    /*
       These can be used to show equivalency in time spent.
     */
    public static List<UsaplPowerlifterDto> getUsaplPowerliftersForList() {
        List<UsaplPowerlifterDto> usaplPowerlifters = new ArrayList<>();
        for (int i = 0; i < LIST_RECORDS; i++) {
            usaplPowerlifters.add(getUsaplPowerlifter(String.valueOf(i)));
        }
        return usaplPowerlifters;
    }

    public static List<OpPowerlifterDto> getOpPowerliftersForList() {
        List<OpPowerlifterDto> usaplPowerlifters = new ArrayList<>();

        for (int i = LIST_RECORDS; i < LIST_RECORDS + LIST_RECORDS; i++) {
            usaplPowerlifters.add(getOpPowerlifter(i));
        }
        return usaplPowerlifters;
    }

    public static UsaplPowerlifterDto getUsaplPowerlifter(String weightClass) {
        UsaplPowerlifterDto usaplPowerlifterDto = new UsaplPowerlifterDto();
        usaplPowerlifterDto.setTotal(300.0);
        usaplPowerlifterDto.setHeaviestTotalDate(LocalDate.of(2020, 12, 20));
        usaplPowerlifterDto.setName("John Haack");
        usaplPowerlifterDto.setWeightClass(weightClass);
        usaplPowerlifterDto.setAge(26);
        return usaplPowerlifterDto;
    }

    public static OpPowerlifterDto getOpPowerlifter(Integer weightClass) {
        OpPowerlifterDto opPowerlifterDto = new OpPowerlifterDto();
        Stack<Double> totals = new Stack<>();
        totals.push(300.0);
        opPowerlifterDto.setTotals(totals);
        opPowerlifterDto.setHeaviestTotalDate(ZonedDateTime.of(2020, 12, 20, 0, 0, 0, 0, ZoneId.systemDefault()));
        opPowerlifterDto.setName("John Haack");
        opPowerlifterDto.setWeightClass(weightClass);
        opPowerlifterDto.setAge(26);
        return opPowerlifterDto;
    }

}
