package ru.itvitality.meetup.naumen.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itvitality.meetup.naumen.dao.DataSourceOneDao;
import ru.itvitality.meetup.naumen.model.AnyTask;
import ru.itvitality.meetup.naumen.service.HeavyCalculator;
import ru.itvitality.meetup.naumen.service.HeavyService;

@Service
@RequiredArgsConstructor
public class HeavyServiceImpl implements HeavyService {
    private final DataSourceOneDao dao;
    private final HeavyCalculator calculator;

    @Override
    public Integer anyAction( AnyTask task ) {
        var data = dao.get( task.getKey() );

        return calculator.heavyMethod( data );
    }
}
