package ru.itvitality.meetup.naumen.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AnyTask {
    private final Integer key;
    private final String value;
}
