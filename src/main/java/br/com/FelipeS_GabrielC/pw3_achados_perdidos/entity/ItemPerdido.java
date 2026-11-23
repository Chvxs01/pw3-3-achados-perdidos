package br.com.FelipeS_GabrielC.pw3_achados_perdidos.entity;

import br.com.FelipeS_GabrielC.pw3_achados_perdidos.enums.StatusItemEnum;
import br.com.FelipeS_GabrielC.pw3_achados_perdidos.enums.StatusItemEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
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

    @Column(name = "nome_item")
    private String nomeItem;

    @Column(name = "local_encontrado")
    private String localEncontrado;

    @Column(name = "data_achado")
    private LocalDate dataAchado;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusItemEnum status = StatusItemEnum.PERDIDO;

    @Column(name = "descricao_devolucao")
    private String descricaoDevolucao;
}