package br.com.FelipeS_GabrielC.pw3_achados_perdidos.service;

import br.com.FelipeS_GabrielC.pw3_achados_perdidos.entity.Item;
import br.com.FelipeS_GabrielC.pw3_achados_perdidos.enums.StatusItemEnum;
import br.com.FelipeS_GabrielC.pw3_achados_perdidos.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<Item> listar() { return itemRepository.findAll(); }

    public Item buscar(Long id) {
        return itemRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado"));
    }

    public Item salvar(Item item) {
        item.setId(null);
        item.setStatusItemEnum(StatusItemEnum.ABERTO);
        return itemRepository.save(item);
    }

    public Item atualizar(Long id, Item novo) {
        Item item = buscar(id);
        if (item.getStatusItemEnum() == StatusItemEnum.DEVOLVIDO)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item já devolvido não pode ser editado");
        item.setTitulo(novo.getTitulo());
        item.setDescricao(novo.getDescricao());
        item.setCategoriaEnum(novo.getCategoriaEnum());
        item.setTipoItemEnum(novo.getTipoItemEnum());
        item.setLocalOcorrencia(novo.getLocalOcorrencia());
        item.setDataOcorrencia(novo.getDataOcorrencia());
        item.setNomeContato(novo.getNomeContato());
        item.setContato(novo.getContato());
        return itemRepository.save(item);
    }

    public void deletar(Long id) { itemRepository.delete(buscar(id)); }

    // Regra 1: marcar como devolvido
    public Item devolver(Long id, String nomeRetirante) {
        Item item = buscar(id);
        if (item.getStatus() == StatusItemEnum.DEVOLVIDO)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item já foi devolvido");
        if (nomeRetirante == null || nomeRetirante.isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Informe quem retirou o item");
        item.setStatus(StatusItem.DEVOLVIDO);
        item.setNomeRetirante(nomeRetirante);
        item.setDataDevolucao(LocalDateTime.now());
        return repository.save(item);
    }

    // Regra 2: sugerir correspondências (perdido <-> achado, mesma categoria, ainda aberto)
    public List<Item> correspondencias(Long id) {
        Item item = buscar(id);
        if (item.getStatus() == StatusItem.DEVOLVIDO)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item já foi devolvido");
        TipoItem oposto = item.getTipo() == TipoItem.PERDIDO ? TipoItem.ACHADO : TipoItem.PERDIDO;
        return repository
                .findByTipoAndCategoriaAndStatus(oposto, item.getCategoria(), StatusItem.ABERTO)
                .stream()
                .sorted(Comparator.comparingLong(i ->
                        Math.abs(ChronoUnit.DAYS.between(i.getDataOcorrencia(), item.getDataOcorrencia()))))
                .toList();
    }

    // Regra 3: busca por texto
    public List<Item> pesquisar(String termo) {
        return repository
                .findByTituloContainingIgnoreCaseOrDescricaoContainingIgnoreCase(termo, termo);
    }

    public List<Item> porStatus(StatusItem status) { return repository.findByStatus(status); }
    public List<Item> porTipo(TipoItem tipo) { return repository.findByTipo(tipo); }
}
