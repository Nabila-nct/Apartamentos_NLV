package com.blue.apartamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blue.apartamentos.models.PropiedadesModel;

@Repository
public interface IPropiedadesRepository extends JpaRepository<PropiedadesModel, Long> {
}
