package ru.itvitality.meetup.naumen.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import ru.itvitality.meetup.naumen.dao.DataSourceOneDao;
import ru.itvitality.meetup.naumen.model.AnyData;

@RequiredArgsConstructor
@RestController
public class AnyDataController {
    private final DataSourceOneDao dao;

    @GetMapping("/data/{key}")
    public AnyData getData( @RequestPart("key") Integer key ) {
        return dao.get( key );
    }
}
