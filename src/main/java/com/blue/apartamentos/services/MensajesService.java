package com.blue.apartamentos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blue.apartamentos.models.MensajesModel;
import com.blue.apartamentos.repositories.IMensajesRepository;

@Service
public class MensajesService {

    @Autowired
    private IMensajesRepository mensajesRepository;

    public List<MensajesModel> getAllMensajes() {
        return mensajesRepository.findAll();
    }

    public Optional<MensajesModel> getMensajeById(Long id) {
        return mensajesRepository.findById(id);
    }

    public MensajesModel saveMensaje(MensajesModel m) {
        return mensajesRepository.save(m);
    }

    public void deleteMensaje(Long id) {
        mensajesRepository.deleteById(id);
    }
}
