package com.blue.apartamentos.controllers;

import com.blue.apartamentos.models.ResenasModel;
import com.blue.apartamentos.services.ResenasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resenas")
public class ResenasController {

    private final ResenasService service;

    public ResenasController(ResenasService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ResenasModel>> getAll() {
        return ResponseEntity.ok(service.getAllResenas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResenasModel> getById(@PathVariable Long id) {
        return service.getResenaById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ResenasModel> create(@RequestBody ResenasModel r) {
        return ResponseEntity.ok(service.saveResena(r));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResenasModel> update(@PathVariable Long id, @RequestBody ResenasModel r) {
        r.setId(id);
        return ResponseEntity.ok(service.saveResena(r));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteResena(id);
        return ResponseEntity.noContent().build();
    }
}
