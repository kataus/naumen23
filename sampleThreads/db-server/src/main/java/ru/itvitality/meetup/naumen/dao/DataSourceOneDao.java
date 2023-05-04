package ru.itvitality.meetup.naumen.dao;

import ru.itvitality.meetup.naumen.model.AnyData;

public interface DataSourceOneDao {
    AnyData get(Integer key);
}
