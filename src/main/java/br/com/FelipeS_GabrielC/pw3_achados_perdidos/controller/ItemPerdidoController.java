package br.com.FelipeS_GabrielC.pw3_achados_perdidos.controller;

import br.com.FelipeS_GabrielC.pw3_achados_perdidos.entity.ItemPerdido;
import br.com.FelipeS_GabrielC.pw3_achados_perdidos.enums.StatusItemEnum;
import br.com.FelipeS_GabrielC.pw3_achados_perdidos.service.ItemPerdidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ItemPerdidoController {
    private final ItemPerdidoService service;

    public record StatusRequest(StatusItemEnum status) {}

    @GetMapping
    public List<ItemPerdido> listar(@RequestParam(required = false) StatusItemEnum status) {
        return service.listar(status);
    }

    @GetMapping("/{id}")
    public ItemPerdido buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemPerdido cadastrar(@RequestBody ItemPerdido item) {
        return service.cadastrar(item);
    }

    @PutMapping("/{id}")
    public ItemPerdido atualizar(@PathVariable Long id, @RequestBody ItemPerdido item) {
        return service.atualizar(id, item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) { service.excluir(id); }

    @PatchMapping("/{id}/status")
    public ItemPerdido atualizarStatus(@PathVariable Long id, @RequestBody StatusRequest req) {
        return service.atualizarStatus(id, req.status());
    }
}