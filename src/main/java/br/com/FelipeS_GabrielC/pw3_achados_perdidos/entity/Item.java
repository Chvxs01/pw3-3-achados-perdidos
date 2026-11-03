package br.com.FelipeS_GabrielC.pw3_achados_perdidos.entity;

@Entity
@Table(name = "itens")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(max = 120)
    private String titulo;

    @Size(max = 500)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private TipoItem tipo;

    @Enumerated(EnumType.STRING)
    private StatusItem status = StatusItem.ABERTO;

    @NotBlank
    private String localOcorrencia;

    @NotNull @PastOrPresent
    private LocalDate dataOcorrencia;

    @NotBlank
    private String nomeContato;

    @NotBlank
    private String contato;

    private LocalDateTime dataRegistro;
    private LocalDateTime dataDevolucao;
    private String nomeRetirante;

    @PrePersist
    void aoCriar() {
        dataRegistro = LocalDateTime.now();
        if (status == null) status = StatusItem.ABERTO;
    }
}
