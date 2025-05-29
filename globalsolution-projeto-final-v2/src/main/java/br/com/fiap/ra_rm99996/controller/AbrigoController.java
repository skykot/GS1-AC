package br.com.fiap.ra_rm99996.controller;

import br.com.fiap.ra_rm99996.dto.AbrigoDTO;
import br.com.fiap.ra_rm99996.entity.Abrigo;
import br.com.fiap.ra_rm99996.service.AbrigoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

    private final AbrigoService service;

    public AbrigoController(AbrigoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Abrigo> criar(@RequestBody AbrigoDTO dto) {
        return ResponseEntity.ok(service.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abrigo> atualizar(@PathVariable Long id, @RequestBody AbrigoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abrigo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Abrigo>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }
}
