package DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class MyDate {
    private int day;
    private int month;
    private int year;
    private String dayStr;
    private String monthStr;
    private String yearStr;

    public MyDate() {
        Calendar cal = Calendar.getInstance();
        this.day = cal.get(Calendar.DATE);
        this.month = (cal.get(Calendar.MONTH) + 1);
        this.year = cal.get(Calendar.YEAR);
    }

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d'th' yyyy", Locale.ENGLISH);
        LocalDate dateTime = LocalDate.parse(date, formatter);

        this.day = dateTime.getDayOfMonth();
        this.month = dateTime.getMonth().getValue();
        this.year = dateTime.getYear();
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (1 <= day && day <= 31) {
            this.day = day;
        } else {
            System.out.println("Not a valid day");
        }
    }

    public void setDay(String day) {
        this.dayStr = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (1 <= month && month <= 12) {
            this.month = month;
        } else {
            System.out.println("Not a valid month");
        }
    }

    public void setMonth(String month) {
        this.monthStr = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setYear(String year) {
        this.yearStr = year;
    }

    public void accept() {
        Scanner input = new Scanner(System.in);

        try {
            String dateStr = input.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d'th' yyyy", Locale.ENGLISH);
            LocalDate dateTime = LocalDate.parse(dateStr, formatter);

            this.day = dateTime.getDayOfMonth();
            this.month = dateTime.getMonth().getValue();
            this.year = dateTime.getYear();
        } catch (Exception e) {
            System.out.println("Invalid input");
        }

    }

    public void print() {
        System.out.println("Day: " + day);
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
    }

    public void printStr() {
        System.out.println(this.monthStr + ", " + this.dayStr + ", " + this.yearStr);
    }

    public void print(String format) {
        if (format == "string") {
            this.printStr();
        } else {
            String dateStr = this.day + "/" + this.month + "/" + this.year;
            TemporalAccessor ta = DateTimeFormatter.ofPattern("dd/M/yyyy", Locale.ENGLISH).parse(dateStr);
            String output = DateTimeFormatter.ofPattern(format, Locale.ENGLISH).format(ta);
            System.out.println(output);
        }
    }
}
