package com.blue.apartamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blue.apartamentos.models.PropiedadImagenModel;

@Repository
public interface IPropiedadImagenRepository extends JpaRepository<PropiedadImagenModel, Long> {
}
