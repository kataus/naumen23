package ru.itvitality.meetup.naumen.service;

import ru.itvitality.meetup.naumen.model.AnyTask;

import java.util.concurrent.CompletableFuture;

public interface HeavyService {
    CompletableFuture<Integer> recalcData();

    Integer anyAction( AnyTask task );

}
