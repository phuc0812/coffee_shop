package com.blueeye.coffee_shop.util;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public Time stringToTime(String str){
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mmaa");
        long t = 0;
        try {
            t = dateFormat.parse(str).getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Time time = new Time(t);
        return time;
    }

    public String timeToString(Time time){
        return time.toString();
    }

    public Date stringToDate(String str){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            return dateFormat.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String dateToString(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }
}
