import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class Tests {
    public static void main(String[] args) {
        Date date = new Date();
        LocalDateTime d = LocalDateTime.now();

      SimpleDateFormat formatter = new SimpleDateFormat(" E dd/MM/yyyy : HH mm ss");
        System.out.println(formatter.format(date));
        System.out.println(d);

        ZonedDateTime de  = d.atZone(ZoneId.of("Europe/Paris"));
        System.out.println("hahahhah  " + de);

        LocalDate ld = LocalDate.now();

        LocalDate tomorrow = ld.plusDays(1);
        System.out.println("Tomorrow is: " + tomorrow);

        LocalDate lastMonth = ld.minus(1, ChronoUnit.MONTHS);
        System.out.println("Last month: " + lastMonth);

        LocalDate lastMonth2 = ld.minusMonths(4);
        System.out.println("last Month again is: " + lastMonth2);
        System.out.println( " " + ld.toString());


        int i = 0;
        boolean flag = true;
        while(i<5){
            System.out.println(i);
            i++;
        }

        String [] array= {"cat", "Dog", "Lion"};
        for(String a:array){
            if(a.matches("...")){
                System.out.println(a.toUpperCase(Locale.ROOT));
            }
        }

    }
}
