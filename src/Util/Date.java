package Util;

import Exceptions.DateNotRecognizedException;

public class Date {

    private int day, month, year;

    public Date(int day, int month, int year) {

        this.day = day;
        this.month = month;
        this.year = year;

    }

    public static Date readDate(String rawDate) throws DateNotRecognizedException {

        int day, month, year;

        char[] date = rawDate.toCharArray();

        if(!((date.length == 10 || date.length == 8 || date.length == 9) && date[2] == '/' && date[5] == '/'))
            throw new DateNotRecognizedException("Length or separators not valid");

        // Verifies the format of the date provided
        for(char c : date) {

            if(!(Character.isDigit(c) || c == '/'))
                throw new DateNotRecognizedException("Not all digits are valid");

        }

        day = Character.getNumericValue(date[0]) * 10 + Character.getNumericValue(date[1]);
        month = Character.getNumericValue(date[3]) * 10 + Character.getNumericValue(date[4]);
        year = Character.getNumericValue(date[6]) * 1000 + Character.getNumericValue(date[7]) * 100 + Character.getNumericValue(date[8]) * 10 + Character.getNumericValue(date[9]);

        if((!(day <= 31 && day > 0) || !(month <= 12 && month > 0) || !(year > 0)))
            throw new DateNotRecognizedException("Day, Month or Year Invalid");

        return new Date(day, month, year);

    }

    @Override
    public String toString() {

        if(day > 9 && month > 9)
           return String.format("%d/%d/%d", day, month, year);
        else if(day > 9 && month < 10)
            return String.format("%d/0%d/%d", day, month, year);
        else if(day < 10 && month > 9)
            return String.format("0%d/%d/%d", day, month, year);
        else if(day < 10 && month < 10)
            return String.format("0%d/0%d/%d", day, month, year);
        else
            return null;

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
