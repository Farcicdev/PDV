package farcic.dev.pdv.java.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "forma", nullable = false, length = 30)
    private FormaPagamentoEnum forma;

    @NotNull
    @DecimalMin("0.00")
    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;
}
