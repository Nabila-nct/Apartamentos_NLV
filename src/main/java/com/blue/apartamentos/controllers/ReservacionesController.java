package com.blue.apartamentos.controllers;

import com.blue.apartamentos.models.ReservacionesModel;
import com.blue.apartamentos.services.ReservacionesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservaciones")
public class ReservacionesController {

    private final ReservacionesService service;

    public ReservacionesController(ReservacionesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ReservacionesModel>> getAll() {
        return ResponseEntity.ok(service.getAllReservaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservacionesModel> getById(@PathVariable Long id) {
        return service.getReservacionById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReservacionesModel> create(@RequestBody ReservacionesModel r) {
        return ResponseEntity.ok(service.saveReservacion(r));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservacionesModel> update(@PathVariable Long id, @RequestBody ReservacionesModel r) {
        r.setId(id);
        return ResponseEntity.ok(service.saveReservacion(r));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteReservacion(id);
        return ResponseEntity.noContent().build();
    }
}
