package A0_Utils;


import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class Date {
    public static void main(String[] args) {
        LocalDate data1=LocalDate.of(2023,12,1);
        LocalDate data2=LocalDate.of(2024,1,1);
        //System.out.println(data1.get(ChronoField.DAY_OF_MONTH));
        Period periodo=Period.between(data1,data2);
        System.out.println(periodo);
        System.out.println(data1.lengthOfMonth());
    }


}
