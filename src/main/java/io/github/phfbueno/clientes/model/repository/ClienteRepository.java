package io.github.phfbueno.clientes.model.repository;

import io.github.phfbueno.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {

}
