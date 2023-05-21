package DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DateUtils {
    public static void compare(MyDate myDate1, MyDate myDate2) throws ParseException {
        Date date1 = format(myDate1);
        Date date2 = format(myDate2);
        if (date1.compareTo(date2) > 0) {

            System.out.println("Comes after");
        } else if (date1.compareTo(date2) < 0) {
            System.out.println("Comes before");
        } else if (date1.compareTo(date2) == 0) {
            System.out.println("Both dates are equal");
        }
    }

    public static ArrayList<Date> sortDate(MyDate... myDates) throws ParseException {
        ArrayList<Date> dateArrayList = new ArrayList<Date>(myDates.length);
        for (MyDate mydate : myDates) {
            dateArrayList.add(format(mydate));
        }
        dateArrayList.sort(((o1, o2) -> o1.compareTo(o2)));
        return dateArrayList;
    }

    private static Date format(MyDate myDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = myDate.getYear() + "-" + myDate.getMonth() + "-" + myDate.getDay();
        Date date = sdf.parse(dateStr);
        return date;
    }
}




