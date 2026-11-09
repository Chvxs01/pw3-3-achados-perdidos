package br.com.FelipeS_GabrielC.pw3_achados_perdidos.controller;

import br.com.FelipeS_GabrielC.pw3_achados_perdidos.entity.Item;
import br.com.FelipeS_GabrielC.pw3_achados_perdidos.enums.StatusItemEnum;
import br.com.FelipeS_GabrielC.pw3_achados_perdidos.enums.TipoItemEnum;
import br.com.FelipeS_GabrielC.pw3_achados_perdidos.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/itens")
    @RequiredArgsConstructor
    @CrossOrigin(origins = "http://localhost:8080")
    public class ItemController {
        private final ItemService itemService;

        @GetMapping
        public List<Item> listar() { return itemService.listar(); }

        @GetMapping("/{id}")
        public Item buscar(@PathVariable Long id) { return itemService.buscar(id); }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Item criar(@RequestBody Item item) { return itemService.salvar(item); }

        @PutMapping("/{id}")
        public Item atualizar(@PathVariable Long id,  @RequestBody Item item) {
            return itemService.atualizar(id, item);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deletar(@PathVariable Long id) { itemService.deletar(id); }

        // Customizados
        @PatchMapping("/{id}/devolver")
        public Item devolver(@PathVariable Long id, @RequestParam String retirante) {
            return itemService.devolver(id, retirante);
        }

        @GetMapping("/{id}/correspondencias")
        public List<Item> correspondencias(@PathVariable Long id) { return itemService.correspondencias(id); }

        @GetMapping("/pesquisar")
        public List<Item> pesquisar(@RequestParam String termo) { return itemService.pesquisar(termo); }

        @GetMapping("/status/{status}")
        public List<Item> porStatus(@PathVariable StatusItemEnum status) { return itemService.porStatus(status); }

        @GetMapping("/tipo/{tipo}")
        public List<Item> porTipo(@PathVariable TipoItemEnum tipo) { return itemService.porTipo(tipo); }
    }

