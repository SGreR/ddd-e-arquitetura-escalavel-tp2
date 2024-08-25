package com.infnet.dddearquiteturaescalaveltp2.events;

import com.infnet.dddearquiteturaescalaveltp2.enums.StatusPagamento;
import lombok.Getter;
import lombok.NonNull;

import java.time.Instant;
import java.util.Objects;

@Getter
public class StatusChangedEvent implements DomainEvent {

    private final Long assinaturaId;
    private final StatusPagamento statusPagamento;
    private final double valorFinal;
    private final Instant occurredOn;

    public StatusChangedEvent(Long assinaturaId, StatusPagamento statusPagamento, double valorFinal, Instant occurredOn) {
        this.assinaturaId = Objects.requireNonNull(assinaturaId, "assinaturaId não pode ser null");
        this.valorFinal = valorFinal;
        this.statusPagamento = Objects.requireNonNull(statusPagamento, "statusPagamento não pode ser null");
        this.occurredOn = Objects.requireNonNull(occurredOn, "occurredOn não pode ser null");
    }

    @Override
    @NonNull
    public Instant occurredOn() {
        return occurredOn;
    }
}
