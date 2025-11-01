package com.blue.apartamentos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blue.apartamentos.models.PropiedadImagenModel;
import com.blue.apartamentos.repositories.IPropiedadImagenRepository;

@Service
public class PropiedadImagenService {

    @Autowired
    private IPropiedadImagenRepository propiedadImagenRepository;

    public List<PropiedadImagenModel> getAllImagenes() {
        return propiedadImagenRepository.findAll();
    }

    public Optional<PropiedadImagenModel> getImagenById(Long id) {
        return propiedadImagenRepository.findById(id);
    }

    public PropiedadImagenModel saveImagen(PropiedadImagenModel img) {
        return propiedadImagenRepository.save(img);
    }

    public void deleteImagen(Long id) {
        propiedadImagenRepository.deleteById(id);
    }
}
