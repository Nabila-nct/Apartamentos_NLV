package com.blue.apartamentos.controllers;

import com.blue.apartamentos.models.PropiedadesModel;
import com.blue.apartamentos.services.PropiedadesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propiedades")
public class PropiedadesController {

    private final PropiedadesService service;

    public PropiedadesController(PropiedadesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PropiedadesModel>> getAll() {
        return ResponseEntity.ok(service.getAllPropiedades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropiedadesModel> getById(@PathVariable Long id) {
        return service.getPropiedadById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PropiedadesModel> create(@RequestBody PropiedadesModel p) {
        return ResponseEntity.ok(service.savePropiedad(p));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropiedadesModel> update(@PathVariable Long id, @RequestBody PropiedadesModel p) {
        p.setId(id);
        return ResponseEntity.ok(service.savePropiedad(p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletePropiedad(id);
        return ResponseEntity.noContent().build();
    }
}
