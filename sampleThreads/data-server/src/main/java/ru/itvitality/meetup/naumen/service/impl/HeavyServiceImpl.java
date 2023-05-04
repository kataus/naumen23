package ru.itvitality.meetup.naumen.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.itvitality.meetup.naumen.model.AnyTask;
import ru.itvitality.meetup.naumen.rest.DataService;
import ru.itvitality.meetup.naumen.service.HeavyCalculator;
import ru.itvitality.meetup.naumen.service.HeavyService;

import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class HeavyServiceImpl implements HeavyService {
    private final DataService dataService;
    private final HeavyCalculator calculator;

    @Override
    public Integer recalcData() {
        log.error( "=== recalc starting ===" );
        return IntStream.range( 1, 10 )
                .map( i -> this.anyAction( new AnyTask( i, "request" + i ) ) )
                .reduce( 0, ( ( left, right ) -> left + right ) );
    }

    @Override
    public Integer anyAction( AnyTask task ) {
        var data = dataService.getData( task.getKey() );

        return calculator.heavyMethod( data );
    }
}
