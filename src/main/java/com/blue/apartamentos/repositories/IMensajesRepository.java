package com.blue.apartamentos.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blue.apartamentos.models.MensajesModel;

@Repository
public interface IMensajesRepository extends JpaRepository<MensajesModel, Long> {
}
