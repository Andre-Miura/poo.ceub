package com.poo.controlador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.poo.controlador.models.ControladorModel;

@Repository
public interface ControladorRepository extends JpaRepository<ControladorModel, Integer>{

}
