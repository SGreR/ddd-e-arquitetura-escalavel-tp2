package com.infnet.dddearquiteturaescalaveltp2.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
class Endereco {
    private String rua;
    private String cidade;
    private String estado;
    private String cep;

}
