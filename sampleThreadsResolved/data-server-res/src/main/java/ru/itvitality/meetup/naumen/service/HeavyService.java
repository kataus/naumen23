package ru.itvitality.meetup.naumen.service;

import ru.itvitality.meetup.naumen.model.AnyTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public interface HeavyService {
    CompletableFuture<Integer> recalcData( AtomicInteger semafore );

    Integer anyAction( AnyTask task );

}
