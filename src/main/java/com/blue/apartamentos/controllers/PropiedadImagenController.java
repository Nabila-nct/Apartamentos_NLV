package com.blue.apartamentos.controllers;

import com.blue.apartamentos.models.PropiedadImagenModel;
import com.blue.apartamentos.services.PropiedadImagenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propiedades/imagenes")
public class PropiedadImagenController {

    private final PropiedadImagenService service;

    public PropiedadImagenController(PropiedadImagenService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PropiedadImagenModel>> getAll() {
        return ResponseEntity.ok(service.getAllImagenes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropiedadImagenModel> getById(@PathVariable Long id) {
        return service.getImagenById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PropiedadImagenModel> create(@RequestBody PropiedadImagenModel img) {
        return ResponseEntity.ok(service.saveImagen(img));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropiedadImagenModel> update(@PathVariable Long id, @RequestBody PropiedadImagenModel img) {
        img.setId(id);
        return ResponseEntity.ok(service.saveImagen(img));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteImagen(id);
        return ResponseEntity.noContent().build();
    }
}
