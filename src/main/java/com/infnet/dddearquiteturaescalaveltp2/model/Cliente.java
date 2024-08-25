package com.infnet.dddearquiteturaescalaveltp2.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Embedded
    private Endereco enderecoEntrega;
    @Embedded
    private DadosPagamento dadosPagamento;

}
