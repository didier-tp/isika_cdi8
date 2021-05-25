package fr.isika.cdi8.tp.web;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.inject.Inject;


import fr.isika.cdi8.tp.entity.Compte;
import fr.isika.cdi8.tp.service.CompteService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean
@SessionScoped
@Getter @Setter @NoArgsConstructor
public class CompteMBean {
	
	
	private Long numClient;
	
	@Inject //ou @Autowired
	private CompteService compteService ;
	
	private List<Compte> comptes;//à afficher dans h:dataTable

	@PostConstruct
	public void init() {
		//this.comptes = this.compteService.rechercherTousLesComptes();
	}
	
	public String doRecupComptesDuClient() {
		System.out.println("doRecupComptesDuClient() appelé");
		this.comptes = this.compteService.comptesDuClient(this.numClient);
		return "comptes.xhtml";
	}
}
