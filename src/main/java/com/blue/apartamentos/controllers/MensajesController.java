package com.blue.apartamentos.controllers;

import com.blue.apartamentos.models.MensajesModel;
import com.blue.apartamentos.services.MensajesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
public class MensajesController {

    private final MensajesService service;

    public MensajesController(MensajesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MensajesModel>> getAll() {
        return ResponseEntity.ok(service.getAllMensajes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MensajesModel> getById(@PathVariable Long id) {
        return service.getMensajeById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MensajesModel> create(@RequestBody MensajesModel m) {
        return ResponseEntity.ok(service.saveMensaje(m));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MensajesModel> update(@PathVariable Long id, @RequestBody MensajesModel m) {
        m.setId(id);
        return ResponseEntity.ok(service.saveMensaje(m));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteMensaje(id);
        return ResponseEntity.noContent().build();
    }
}
