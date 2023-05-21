package ru.itvitality.meetup.naumen.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.itvitality.meetup.naumen.model.AnyData;
import ru.itvitality.meetup.naumen.service.HeavyCalculator;
import ru.itvitality.meetup.naumen.utils.ThreadUtils;

import java.util.Random;

@Service
@Slf4j
public class HeavyCalculatorImpl implements HeavyCalculator {
    @Override
    public Integer heavyMethod( AnyData data ) {
        var random = new Random();
        ThreadUtils.sleep( 20000L + random.nextInt( 1000 )  );
        if (Thread.interrupted()){
            log.error( "Thread interrupted 2" );
        }
        return data.getKey();
    }
}
