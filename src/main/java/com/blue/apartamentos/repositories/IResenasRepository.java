package com.blue.apartamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blue.apartamentos.models.ResenasModel;

@Repository
public interface IResenasRepository extends JpaRepository<ResenasModel, Long> {
}
