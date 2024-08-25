package com.infnet.dddearquiteturaescalaveltp2.model;

import com.infnet.dddearquiteturaescalaveltp2.enums.DiaVencimento;
import com.infnet.dddearquiteturaescalaveltp2.enums.StatusPagamento;
import com.infnet.dddearquiteturaescalaveltp2.enums.TipoAssinatura;
import com.infnet.dddearquiteturaescalaveltp2.events.DomainEvent;
import com.infnet.dddearquiteturaescalaveltp2.events.StatusChangedEvent;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.domain.DomainEvents;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Assinatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private LocalDateTime dataCriacao;
    @Column(name = "cliente_id", nullable = false)
    private Long clienteId; //Faz referência ao agregado Cliente, pertencente a outro domínio
    @ElementCollection
    @CollectionTable(name = "assinatura_produtos", joinColumns = @JoinColumn(name = "assinatura_id"))
    private List<Produto> produtosAssinados;
    private TipoAssinatura tipoAssinatura;
    private DiaVencimento diaVencimento;
    private StatusPagamento statusPagamento;
    @Transient
    private boolean mudancaDeStatusEmitida = false;
    private double valorTotal;

    private double calcularValorTotal(){
        //Lógica de cálculo de valor total a ser implementada
        return 0.0;
    }

    private void emitirMudancaDeStatus(){
        if(this.statusPagamento != StatusPagamento.PAGAMENTO_PENDENTE && LocalDateTime.now().getDayOfMonth() - diaVencimento.getValue()  <= 10 && !mudancaDeStatusEmitida){
            this.statusPagamento = StatusPagamento.PAGAMENTO_PENDENTE;
            //DomainEvents.publish(new StatusChangedEvent(this.id, this.statusPagamento, this.valorTotal, Instant.now()))
            //Publica um evento de mudança no status de pagamento a ser consumido pela classe/serviço responsável por gerar e enviar a fatura
            mudancaDeStatusEmitida = true; //Evita que a mudança de status seja enviada novamente dentro dos 10 dias se a fatura já foi paga
        } else if (this.statusPagamento == StatusPagamento.REGULAR){
            mudancaDeStatusEmitida = false;
        }
    }

    
}
