package br.com.FelipeS_GabrielC.pw3_achados_perdidos;

public class ItemController {
    @RestController
    @RequestMapping("/api/itens")
    @RequiredArgsConstructor
    @CrossOrigin(origins = "http://localhost:4200")
    public class ItemController {
        private final ItemService service;

        @GetMapping
        public List<Item> listar() { return service.listar(); }

        @GetMapping("/{id}")
        public Item buscar(@PathVariable Long id) { return service.buscar(id); }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Item criar(@Valid @RequestBody Item item) { return service.salvar(item); }

        @PutMapping("/{id}")
        public Item atualizar(@PathVariable Long id, @Valid @RequestBody Item item) {
            return service.atualizar(id, item);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deletar(@PathVariable Long id) { service.deletar(id); }

        // Customizados
        @PatchMapping("/{id}/devolver")
        public Item devolver(@PathVariable Long id, @RequestParam String retirante) {
            return service.devolver(id, retirante);
        }

        @GetMapping("/{id}/correspondencias")
        public List<Item> correspondencias(@PathVariable Long id) { return service.correspondencias(id); }

        @GetMapping("/pesquisar")
        public List<Item> pesquisar(@RequestParam String termo) { return service.pesquisar(termo); }

        @GetMapping("/status/{status}")
        public List<Item> porStatus(@PathVariable StatusItem status) { return service.porStatus(status); }

        @GetMapping("/tipo/{tipo}")
        public List<Item> porTipo(@PathVariable TipoItem tipo) { return service.porTipo(tipo); }
    }
}
