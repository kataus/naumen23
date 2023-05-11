package ru.itvitality.meetup.naumen.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.itvitality.meetup.naumen.model.AnyData;
import ru.itvitality.meetup.naumen.service.HeavyCalculator;

import java.util.Random;

@Service
@Slf4j
public class HeavyCalculatorImpl implements HeavyCalculator {
    @Override
    public Integer heavyMethod( AnyData data ) {
        var random = new Random();
        try {
            Thread.sleep( 1000L + random.nextInt( 1000 ) );
        } catch ( InterruptedException e ) {
            log.error( "HeavyCalculator thread interrupted" );
        }
        return data.getKey();
    }
}
