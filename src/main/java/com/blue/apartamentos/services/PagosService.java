package com.blue.apartamentos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blue.apartamentos.models.PagosModel;
import com.blue.apartamentos.repositories.IPagosRepository;

@Service
public class PagosService {

    @Autowired
    private IPagosRepository pagosRepository;

    public List<PagosModel> getAllPagos() {
        return pagosRepository.findAll();
    }

    public Optional<PagosModel> getPagoById(Long id) {
        return pagosRepository.findById(id);
    }

    public PagosModel savePago(PagosModel pago) {
        return pagosRepository.save(pago);
    }

    public void deletePago(Long id) {
        pagosRepository.deleteById(id);
    }

}
