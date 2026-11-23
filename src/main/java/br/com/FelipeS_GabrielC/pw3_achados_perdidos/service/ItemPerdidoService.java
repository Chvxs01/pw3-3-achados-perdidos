package br.com.FelipeS_GabrielC.pw3_achados_perdidos.service;

import br.com.FelipeS_GabrielC.pw3_achados_perdidos.entity.ItemPerdido;
import br.com.FelipeS_GabrielC.pw3_achados_perdidos.enums.StatusItemEnum;
import br.com.FelipeS_GabrielC.pw3_achados_perdidos.repository.ItemPerdidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemPerdidoService {
    private final ItemPerdidoRepository repository;

    public List<ItemPerdido> listar(StatusItemEnum status) {
        return status == null ? repository.findAll() : repository.findByStatus(status);
    }

    public ItemPerdido buscar(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado."));
    }

    public ItemPerdido cadastrar(ItemPerdido item) {
        item.setId(null);
        item.setStatus(StatusItemEnum.PERDIDO);
        return repository.save(item);
    }

    public ItemPerdido atualizar(Long id, ItemPerdido novo) {
        ItemPerdido item = buscar(id);
        item.setNomeItem(novo.getNomeItem());
        item.setLocalEncontrado(novo.getLocalEncontrado());
        item.setDataAchado(novo.getDataAchado());
        item.setDescricaoDevolucao(novo.getDescricaoDevolucao());
        return repository.save(item);
    }

    public void excluir(Long id) { repository.delete(buscar(id)); }

    // Regra de negócio: transição de status
    public ItemPerdido atualizarStatus(Long id, StatusItemEnum novoStatus) {
        ItemPerdido item = buscar(id);
        if (item.getStatus() == StatusItemEnum.DEVOLVIDO && novoStatus != StatusItemEnum.DEVOLVIDO) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Item já devolvido ao dono não pode ter o status alterado.");
        }
        item.setStatus(novoStatus);
        return repository.save(item);
    }
}