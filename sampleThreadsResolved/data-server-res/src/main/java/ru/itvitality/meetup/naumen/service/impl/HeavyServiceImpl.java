package ru.itvitality.meetup.naumen.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.itvitality.meetup.naumen.model.AnyTask;
import ru.itvitality.meetup.naumen.rest.DataService;
import ru.itvitality.meetup.naumen.service.HeavyCalculator;
import ru.itvitality.meetup.naumen.service.HeavyService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static ru.itvitality.meetup.naumen.utils.ThreadUtils.sleep;


@RequiredArgsConstructor
@Slf4j
@Service
public class HeavyServiceImpl implements HeavyService {
    private final DataService dataService;
    private final HeavyCalculator calculator;

    @Override
    @Async
    public CompletableFuture<Integer> recalcData( AtomicInteger semafore ) {
        log.error( "=== recalc starting ===" );
        List<Integer> result = new ArrayList<>();
        // Всякий полезный код
        var executors = Executors.newFixedThreadPool( 4 );
        IntStream.range( 1, 10 ).forEach( i ->
                executors.submit( () -> {
                    var itemResult = this.anyAction( new AnyTask( i, "request" + i ) );
                    result.add( itemResult );
                } )
        );
        executors.shutdown();
        while ( ! executors.isTerminated() ) {
            sleep( 1000L );
            if (semafore.get() > 0){
                executors.shutdownNow();
            }
        }
        log.error( "=== recalc finished ===" );
        var value = result.stream()
                .reduce( 0, ( ( left, right ) -> left + right ) );
        return CompletableFuture.completedFuture( value );
    }

    @Override
    public Integer anyAction( AnyTask task ) {
        var data = dataService.getData( task.getKey() );
        if (Thread.interrupted()){
            log.error( "Thread interrupted 1" );
        }
        return calculator.heavyMethod( data );
    }
}
