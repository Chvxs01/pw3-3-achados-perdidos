package br.com.FelipeS_GabrielC.pw3_achados_perdidos.repository;

import br.com.FelipeS_GabrielC.pw3_achados_perdidos.entity.ItemPerdido;
import br.com.FelipeS_GabrielC.pw3_achados_perdidos.enums.StatusItemEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemPerdidoRepository extends JpaRepository<ItemPerdido, Long> {
    List<ItemPerdido> findByStatus(StatusItemEnum status);
}