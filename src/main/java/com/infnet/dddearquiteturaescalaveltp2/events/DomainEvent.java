package com.infnet.dddearquiteturaescalaveltp2.events;

import org.springframework.lang.NonNull;

import java.time.Instant;


public interface DomainEvent extends DomainObject {

    @NonNull
    Instant occurredOn();
}
