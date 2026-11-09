package br.com.FelipeS_GabrielC.pw3_achados_perdidos.entity;

import br.com.FelipeS_GabrielC.pw3_achados_perdidos.enums.CategoriaEnum;
import br.com.FelipeS_GabrielC.pw3_achados_perdidos.enums.StatusItemEnum;
import br.com.FelipeS_GabrielC.pw3_achados_perdidos.enums.TipoItemEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Conditional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = "itens")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private CategoriaEnum categoriaEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoItemEnum tipoItemEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusItemEnum statusItemEnum = StatusItemEnum.ABERTO;

    @Column(name = "local_ocorrencia")
    private String localOcorrencia;

    @Column(name = "data_ocorrencia")
    private LocalDate dataOcorrencia;

    @Column(name = "nome_contato")
    private String nomeContato;

    @Column(name = "contato")
    private String contato;

    @Column(name = "data_registro")
    private LocalDateTime dataRegistro;

    @Column(name = "data_devolucao")
    private LocalDateTime dataDevolucao;

    @Column(name = "nome_retirante")
    private String nomeRetirante;

    @PrePersist
    void aoCriar() {
        dataRegistro = LocalDateTime.now();
        if (statusItemEnum == null) statusItemEnum = StatusItemEnum.ABERTO;
    }
}
