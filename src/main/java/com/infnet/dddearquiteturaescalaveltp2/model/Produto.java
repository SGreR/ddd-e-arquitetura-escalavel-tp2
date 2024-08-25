package com.infnet.dddearquiteturaescalaveltp2.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Produto {

    private String descricaoProduto;
    private int quantidade;
    private double precoUnitario;
}
