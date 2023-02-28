import org.springframework.lang.NonNull;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Optional;
import java.util.TimeZone;

/**
 * @author pangxiong
 * @title: TestMain
 * @projectName c_channel
 * @description: TODO
 * @date 2023/1/2814:08
 */
public class TestMain {
    public static void main(String[] args) {
        LocalDateTime now= LocalDateTime.now();
        System.out.println(Integer.parseInt(now.format(DateTimeFormatter.ofPattern("yyyyMM"))));
        Duration duration = Duration.between(LocalDateTime.now(),LocalDateTime.now().plusMinutes(1));
        System.out.println(duration.toMillis());
        Duration duration2 = Duration.between(LocalDateTime.now().plusMinutes(1),LocalDateTime.now());
        System.out.println(Math.toIntExact(duration2.toMillis()));
        long aa=10L;
        int b=(int)aa;
        System.out.println(b);
        System.out.println(LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println(LocalDateTime.now().with(LocalTime.MAX));
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX));
        TimeZone timeZone=TimeZone.getTimeZone("UTC");
        LocalDateTime now2 = LocalDateTime.now(timeZone.toZoneId());
        System.out.println(now2);
        System.out.println(now2.atZone(TimeZone.getTimeZone("UTC-8:00").toZoneId()).toLocalDateTime());
        LocalDateTime now3= LocalDateTime.ofInstant(LocalDateTime.now().toInstant(ZoneOffset.UTC),TimeZone.getTimeZone("GMT+8:00").toZoneId());
        System.out.println(now3);


        ZonedDateTime zonedUTC =LocalDateTime.now().atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("GMT+8"));
        System.out.println(zonedUTC.toLocalDateTime());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM.dd.yyyy HH:mm:ss");

        System.out.println(LocalDateTime.now().format(dateTimeFormatter));
        System.out.println(LocalDateTime.now().format(dateTimeFormatter));
        System.out.println(LocalDateTime.now().format(dateTimeFormatter));


        System.out.println(LocalDateTime.now().atZone(ZoneId.of("GMT+1")).withZoneSameInstant(ZoneId.of("GMT+7")).toLocalDateTime()
                .with(LocalTime.MIN));

        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());


    }

}
