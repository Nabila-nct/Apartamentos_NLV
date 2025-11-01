package com.blue.apartamentos.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blue.apartamentos.models.ClienteModel;
import com.blue.apartamentos.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> getAll() {
        return ResponseEntity.ok(service.getAllClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> getById(@PathVariable Long id) {
        return service.getClienteById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClienteModel> create(@RequestBody ClienteModel c) {
        return ResponseEntity.ok(service.saveCliente(c));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> update(@PathVariable Long id, @RequestBody ClienteModel c) {
        c.setId(id);
        return ResponseEntity.ok(service.saveCliente(c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}
