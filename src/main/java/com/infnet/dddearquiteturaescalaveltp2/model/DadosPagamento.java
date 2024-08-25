package com.infnet.dddearquiteturaescalaveltp2.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
class DadosPagamento {

    private String numeroCartao;
    private String validade;
    private String cvv;
}
