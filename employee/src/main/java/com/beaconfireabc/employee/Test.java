package com.beaconfireabc.employee;

import com.beaconfireabc.employee.domain.Day;
import com.beaconfireabc.employee.domain.TimeSheet;
import io.jsonwebtoken.Jwts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

//        TimeSheet ts = new TimeSheet();
//        List<Day> days = new ArrayList<>();
//        for (int i=0;i<7;i++){
//            days.add(new Day());
//        }
//        ts.setDays(days);
//        System.out.println(addDateInDefaultTimeSheet("2020-01-16"));
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIzIiwiaWF0IjoxNjEzNTE0MDUyfQ.XlAzGCi-dy2XCnLH9lQ64I4GdDJqyubNGYOqb6_Yuc4";
        System.out.println(Jwts.parser().setSigningKey("signingKey").parseClaimsJws(token).getBody().getSubject());

    }

    static String addDateInDefaultTimeSheet(String weekend){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(weekend, dateFormatter);
        int dayDiff = 6 - date.getDayOfWeek().getValue();
        LocalDate weekendingDay = date.plusDays(dayDiff>=0?dayDiff:6);
        return weekendingDay.format(dateFormatter);
    }
}
