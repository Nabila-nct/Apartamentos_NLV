package com.blue.apartamentos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blue.apartamentos.models.PropiedadesModel;
import com.blue.apartamentos.repositories.IPropiedadesRepository;

@Service
public class PropiedadesService {

    @Autowired
    private IPropiedadesRepository propiedadesRepository;

    public List<PropiedadesModel> getAllPropiedades() {
        return propiedadesRepository.findAll();
    }

    public Optional<PropiedadesModel> getPropiedadById(Long id) {
        return propiedadesRepository.findById(id);
    }

    public PropiedadesModel savePropiedad(PropiedadesModel p) {
        return propiedadesRepository.save(p);
    }

    public void deletePropiedad(Long id) {
        propiedadesRepository.deleteById(id);
    }
}
