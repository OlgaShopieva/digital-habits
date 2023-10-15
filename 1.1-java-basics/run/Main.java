package run;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        final Date date1 = new Date(1, 2, 3); //Date является mutable типом.
//        final Date date2 = new Date(1, 2, 4);
//
//        Set<Date> set = new HashSet();
//        set.add(date1);
//        set.add(date2);
//
//
//        date2.setDate(3); //т.к хэш-код добавляется только при добавлении объекта,
//        //то в дальнейшем мы можем менять состояние объекта, что может привести к нежелательным последствиям
//
//        System.out.println(set);

        //ситуация с LocalDate другая, так как он immutable.
        final LocalDate date1 = LocalDate.of(1,2,3);
        final LocalDate date2 = LocalDate.of(1,2,4);

        Set<LocalDate> set = new HashSet<>();
        set.add(date1);
        set.add(date2);

        final LocalDate date3 = date2.minusDays(1);
        set.add(date3);

        System.out.println(set);
    }
}
