package com.backend.comsiontest.repository;


import com.backend.comsiontest.entities.Persona;
import com.backend.comsiontest.entities.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {

}
