package com.robson.back_end.repository;

import com.robson.back_end.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    List<Client> findAllByNameIgnoreCase(String name);

    Optional<Client> findByLogin(String username);
}
