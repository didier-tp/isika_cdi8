package fr.isika.cdi8.tp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.isika.cdi8.tp.entity.Compte;

public interface CompteDao{
	Optional<Compte> findById(Long id); 
	Compte save(Compte c);
	void deleteById(Long id);
	List<Compte> findByClientNumero(long numClient);
	List<Compte> findAll();
}
