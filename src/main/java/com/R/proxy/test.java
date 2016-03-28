package com.R.proxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * User: lijiaren
 * Date: 2016/3/25
 * Time: 11:52
 */
public class test {
    public static void main(String[] args) throws ParseException {
        String beginTime = "2016-3-21";
        String endTime = "2016-3-23";
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate =sdf.parse(beginTime);
        Date endDate = sdf.parse(endTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        int dayIndex = 1;
        int circleLength = 2;
        int compare = calendar.getTime().compareTo(endDate);
        while(calendar.getTime().compareTo(endDate) <= 0){
            dayIndex++;
            if(dayIndex > circleLength){
                dayIndex = 1;
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
    }
}
