package br.com.FelipeS_GabrielC.pw3_achados_perdidos.entity;

import br.com.FelipeS_GabrielC.pw3_achados_perdidos.enums.StatusItemEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "itens_perdidos")
public class ItemPerdido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "O nome do item é obrigatório")
    @Column(name = "nome_item")
    private String nomeItem;

    @NotBlank(message = "O local é obrigatório")
    @Column(name = "local_encontrado")
    private String localEncontrado;

    @NotNull(message = "A data é obrigatória")
    @PastOrPresent(message = "A data não pode ser futura")
    @Column(name = "data_achado")
    private LocalDate dataAchado;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusItemEnum status = StatusItemEnum.PERDIDO;

    @Column(name = "descricao_devolucao")
    private String descricaoDevolucao;
}