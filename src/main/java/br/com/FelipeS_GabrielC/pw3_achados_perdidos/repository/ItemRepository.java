package br.com.FelipeS_GabrielC.pw3_achados_perdidos.repository;

import br.com.FelipeS_GabrielC.pw3_achados_perdidos.entity.Item;
import br.com.FelipeS_GabrielC.pw3_achados_perdidos.enums.CategoriaEnum;
import br.com.FelipeS_GabrielC.pw3_achados_perdidos.enums.StatusItemEnum;
import br.com.FelipeS_GabrielC.pw3_achados_perdidos.enums.TipoItemEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByStatusItemEnum(StatusItemEnum statusItemEnum);
    List<Item> findByTipoItemEnum(TipoItemEnum tipoItemEnum);

    List<Item> findByTituloContainingIgnoreCaseOrDescricaoContainingIgnoreCase(String t, String d);

    List<Item> findByTipoItemEnumAndCategoriaEnumAndStatusItemEnum(
            TipoItemEnum tipoItemEnum,
            CategoriaEnum categoriaEnum,
            StatusItemEnum statusItemEnum
    );
}