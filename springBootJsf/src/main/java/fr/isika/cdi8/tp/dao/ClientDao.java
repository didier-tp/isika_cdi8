package fr.isika.cdi8.tp.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.isika.cdi8.tp.entity.Client;

public interface ClientDao {
   Optional<Client> findById(Long id); 
   Client save(Client c);
   void deleteById(Long id);
}
