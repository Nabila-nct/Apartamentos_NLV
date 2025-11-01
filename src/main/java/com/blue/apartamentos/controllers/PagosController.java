package com.blue.apartamentos.controllers;

import com.blue.apartamentos.models.PagosModel;
import com.blue.apartamentos.services.PagosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagosController {

    private final PagosService service;

    public PagosController(PagosService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PagosModel>> getAll() {
        return ResponseEntity.ok(service.getAllPagos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagosModel> getById(@PathVariable Long id) {
        return service.getPagoById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PagosModel> create(@RequestBody PagosModel pago) {
        PagosModel created = service.savePago(pago);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagosModel> update(@PathVariable Long id, @RequestBody PagosModel pago) {
        pago.setId(id);
        PagosModel updated = service.savePago(pago);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletePago(id);
        return ResponseEntity.noContent().build();
    }
}
