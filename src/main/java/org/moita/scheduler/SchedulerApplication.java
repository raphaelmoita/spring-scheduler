package org.moita.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@SpringBootApplication
@EnableScheduling
public class SchedulerApplication {

    /**
     * <second> <minute> <hour> <day-of-month> <month> <day-of-week>
     * every 5 seconds, every minute, from 10 to 17, every day, every month, from Monday to Friday
     */
    @Scheduled(cron = "0/5 * 10-17 * * MON,TUE,WED,THU,FRI *", zone = "America/Sao_Paulo")
    public void run() {

        ZoneId americasSaoPaulo = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime nowBrazil = ZonedDateTime.ofInstant(Instant.now(), americasSaoPaulo);

        System.out.println("Data & Time in Brazil now is: "+ nowBrazil);
    }

    public static void main(String[] args) {
        SpringApplication.run(SchedulerApplication.class, args);
    }
}
