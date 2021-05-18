package fr.isika.cdi8.tp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.isika.cdi8.tp.entity.Compte;

public interface CompteDao extends CrudRepository<Compte,Long>{
   //principales méthodes héritées : findById() , save() , deleteById() , ...
	List<Compte> findByClientNumero(long numClient);
}
