package com.blue.apartamentos.controllers;

import com.blue.apartamentos.models.DisponibilidadModel;
import com.blue.apartamentos.services.DisponibilidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disponibilidad")
public class DisponibilidadController {

    private final DisponibilidadService service;

    public DisponibilidadController(DisponibilidadService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DisponibilidadModel>> getAll() {
        return ResponseEntity.ok(service.getAllDisponibilidad());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisponibilidadModel> getById(@PathVariable Long id) {
        return service.getDisponibilidadById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DisponibilidadModel> create(@RequestBody DisponibilidadModel d) {
        return ResponseEntity.ok(service.saveDisponibilidad(d));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisponibilidadModel> update(@PathVariable Long id, @RequestBody DisponibilidadModel d) {
        d.setId(id);
        return ResponseEntity.ok(service.saveDisponibilidad(d));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteDisponibilidad(id);
        return ResponseEntity.noContent().build();
    }
}
