package fr.isika.cdi8.tp.dao;

import org.springframework.data.repository.CrudRepository;

import fr.isika.cdi8.tp.entity.Client;

public interface ClientDao extends CrudRepository<Client,Long>{
   //principales méthodes héritées : findById() , save() , deleteById() , ...

}
