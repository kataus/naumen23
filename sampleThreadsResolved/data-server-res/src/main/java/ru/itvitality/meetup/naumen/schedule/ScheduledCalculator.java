package ru.itvitality.meetup.naumen.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.itvitality.meetup.naumen.service.HeavyService;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScheduledCalculator {
    private final HeavyService heavyService;

    @Scheduled(fixedRate = 1000)
    public void recalcData() {
        log.error( "Data calculator starting..." );
        var startDate = new Date();
        var result = - 1;
        var process = heavyService.recalcData();
        try {
            result = process.get( 10, TimeUnit.MINUTES );
        } catch ( TimeoutException e ){
            process.cancel( true );
        } catch ( Exception e ) {
            log.error( "=== SCHEDULLED PROCESS ALL HASN'T FINISHED IN TIME === ", e );
        }

        var endDate = new Date();
        log.error( "Data calculated, summ = {}, duration = {}", result, ( endDate.getTime() - startDate.getTime() ) );
    }
}
