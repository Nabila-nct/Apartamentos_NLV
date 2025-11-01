package com.blue.apartamentos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blue.apartamentos.models.ReservacionesModel;
import com.blue.apartamentos.repositories.IReservacionesRepository;

@Service
public class ReservacionesService {

    @Autowired
    private IReservacionesRepository reservacionesRepository;

    public List<ReservacionesModel> getAllReservaciones() {
        return reservacionesRepository.findAll();
    }

    public Optional<ReservacionesModel> getReservacionById(Long id) {
        return reservacionesRepository.findById(id);
    }

    public ReservacionesModel saveReservacion(ReservacionesModel r) {
        return reservacionesRepository.save(r);
    }

    public void deleteReservacion(Long id) {
        reservacionesRepository.deleteById(id);
    }
}
