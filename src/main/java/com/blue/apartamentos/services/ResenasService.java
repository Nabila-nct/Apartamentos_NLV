package com.blue.apartamentos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blue.apartamentos.models.ResenasModel;
import com.blue.apartamentos.repositories.IResenasRepository;

@Service
public class ResenasService {

    @Autowired
    private IResenasRepository resenasRepository;

    public List<ResenasModel> getAllResenas() {
        return resenasRepository.findAll();
    }

    public Optional<ResenasModel> getResenaById(Long id) {
        return resenasRepository.findById(id);
    }

    public ResenasModel saveResena(ResenasModel r) {
        return resenasRepository.save(r);
    }

    public void deleteResena(Long id) {
        resenasRepository.deleteById(id);
    }
}
