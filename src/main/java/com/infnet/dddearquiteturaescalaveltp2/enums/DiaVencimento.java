package com.infnet.dddearquiteturaescalaveltp2.enums;

import lombok.Getter;

@Getter
public enum DiaVencimento {
    CINCO(5),
    DEZ(10),
    DOZE(12);

    private final int value;

    DiaVencimento(int value) {
        this.value = value;
    }

}
