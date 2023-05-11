package ru.itvitality.meetup.naumen.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.itvitality.meetup.naumen.dao.DataSourceOneDao;
import ru.itvitality.meetup.naumen.model.AnyData;

import java.util.Random;

@Service
@Slf4j
public class DataSourceOneDaoImpl implements DataSourceOneDao {
    @Override
    public AnyData get( Integer key ) {
        var random = new Random();
        try {
            Thread.sleep( 1000L + random.nextInt( 1000 ) );
        } catch ( InterruptedException e ) {
            log.error( "DataSourceOne thread interrupted" );
        }
        return new AnyData( key, "Value " + random.nextInt() );
    }
}
