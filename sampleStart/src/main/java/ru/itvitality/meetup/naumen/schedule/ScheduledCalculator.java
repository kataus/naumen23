package ru.itvitality.meetup.naumen.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.itvitality.meetup.naumen.model.AnyTask;
import ru.itvitality.meetup.naumen.service.HeavyService;

import java.util.Date;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScheduledCalculator {
    private final HeavyService heavyService;

    @Scheduled(fixedRate = 1000)
    public void recalcData() {
        log.error( "Data calculator starting..." );
        var startDate = new Date();
        var result = IntStream.range( 1, 10 )
                .map( i -> heavyService.anyAction( new AnyTask( i, "request" + i ) ) )
                .reduce( 0, ( ( left, right ) -> left + right ) );
        var endDate = new Date();
        log.error( "Data calculated, summ = {}, duration = {}", result, ( endDate.getTime() - startDate.getTime() ) );
    }
}
