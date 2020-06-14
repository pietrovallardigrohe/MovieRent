package Util;

import Exceptions.DateNotRecognizedException;

import java.util.Date;

public class DateReader {


    public static Date readDate(String rawDate) throws DateNotRecognizedException {

        int day, month, year;

        char[] date = rawDate.toCharArray();

        if(!(date.length == 10 && date[2] == '/' && date[5] == '/'))
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

        return new Date(year, month, day);

    }

}
