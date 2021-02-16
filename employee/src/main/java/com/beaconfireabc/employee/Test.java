package com.beaconfireabc.employee;

import com.beaconfireabc.employee.domain.Day;
import com.beaconfireabc.employee.domain.TimeSheet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        TimeSheet ts = new TimeSheet();
        List<Day> days = new ArrayList<>();
        for (int i=0;i<7;i++){
            days.add(new Day());
        }
        ts.setDays(days);
        addDateInDefaultTimeSheet(ts, "02/14/2021");
        System.out.println(ts);
    }

    static void addDateInDefaultTimeSheet(TimeSheet timeSheet, String weekend){
        timeSheet.setWeekending(weekend);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate weekendingDate = LocalDate.parse(weekend, dateFormatter);
        for (int i=0;i<7;i++){
            LocalDate then = weekendingDate.minusDays(7-1-i);
            timeSheet.getDays().get(i).setDate(then.format(dateFormatter));
        }
    }
}
