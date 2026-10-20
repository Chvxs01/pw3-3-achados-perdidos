package br.com.gabrielC_felipeS.pw3_3_achados_Perdidos.repository;

import br.com.gabrielC_felipeS.pw3_3_achados_Perdidos.entity.ItemPerdido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPerdidoRepository extends JpaRepository<ItemPerdido, Long> {
}
