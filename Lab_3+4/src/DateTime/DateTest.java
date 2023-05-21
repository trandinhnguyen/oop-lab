package DateTime;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class DateTest {
    public static void main(String[] args) throws ParseException {

        System.out.println("No parameter");
        MyDate myDate1 = new MyDate();
        myDate1.print();

        System.out.println("\n3 int parameters");
        MyDate myDate2 = new MyDate(1, 1, 2000);
        myDate2.print();

        System.out.println("\nString parameter");
        MyDate myDate3 = new MyDate("February 18th 2023");
        myDate3.print();

        System.out.println("\nNo parameter then set attributes");
        MyDate myDate4 = new MyDate();
        myDate4.setDay(10);
        myDate4.setMonth(10);
        myDate4.setYear(10);
        myDate4.print();

        System.out.println("\nInput from keyboard (eg. February 18th 2023)");
        MyDate myDate5 = new MyDate();
        myDate5.accept();
        myDate5.print();

        // String version
        System.out.println("\nSring version");
        MyDate myDate6 = new MyDate();
        myDate6.setDay("First");
        myDate6.setMonth("December");
        myDate6.setYear("Twenty Twenty Three");
        myDate6.printStr();

        // Specified format
        System.out.println("\nSpecified format version");
        System.out.println("Enter the format: ");
        Scanner input = new Scanner(System.in);
        String format = input.nextLine();
        MyDate myDate7 = new MyDate();
        myDate7.print(format);

        System.out.println("\nCompare two dates");
        myDate5.print("M-dd-yyyy");
        DateUtils.compare(myDate5, myDate1);
        myDate1.print("M-dd-yyyy");

        System.out.println("\nSort date");
        System.out.println(DateUtils.sortDate(myDate1, myDate2, myDate3));
    }
}
