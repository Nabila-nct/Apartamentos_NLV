package com.blue.apartamentos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blue.apartamentos.models.DisponibilidadModel;
import com.blue.apartamentos.repositories.IDisponibilidadRepository;

@Service
public class DisponibilidadService {

    @Autowired
    private IDisponibilidadRepository disponibilidadRepository;

    public List<DisponibilidadModel> getAllDisponibilidad() {
        return disponibilidadRepository.findAll();
    }

    public Optional<DisponibilidadModel> getDisponibilidadById(Long id) {
        return disponibilidadRepository.findById(id);
    }

    public DisponibilidadModel saveDisponibilidad(DisponibilidadModel d) {
        return disponibilidadRepository.save(d);
    }

    public void deleteDisponibilidad(Long id) {
        disponibilidadRepository.deleteById(id);
    }

}
