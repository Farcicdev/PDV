package farcic.dev.pdv.java.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 120)
    @Column(name = "nome", nullable = false, length = 120)
    private String nome;

    @Size(max = 60)
    @Column(name = "codigo_barras", unique = true, length = 60)
    private String codigoBarras;

    @NotNull
    @DecimalMin("0.00")
    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @NotNull
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;

}
