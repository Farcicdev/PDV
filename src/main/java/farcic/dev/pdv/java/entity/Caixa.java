package farcic.dev.pdv.java.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "caixa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Caixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "aberto_em", nullable = false)
    private LocalDateTime abertoEm;

    @Column(name = "fechado_em")
    private LocalDateTime fechadoEm;

    @Column(name = "valor_abertura", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorAbertura;

    @Column(name = "valor_fechamento", precision = 10, scale = 2)
    private BigDecimal valorFechamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private StatusCaixaEnum status;

    @ManyToOne
    @JoinColumn(name = "operador_id", nullable = false)
    private Usuario operador;
}
