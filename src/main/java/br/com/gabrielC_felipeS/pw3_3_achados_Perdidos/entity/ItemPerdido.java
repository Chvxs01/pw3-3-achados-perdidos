package br.com.gabrielC_felipeS.pw3_3_achados_Perdidos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity

@Getter
@Setter
@Table(name = "item_perdido")

public class ItemPerdido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeItem;

    private String localEncontrado;

    private LocalDate dataAchado;

    private String status;

    private String descricaoDevolucao;
}