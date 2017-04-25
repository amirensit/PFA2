package org.sid.metier;

import org.sid.entities.Score;
import org.sid.entities.Universite;
import org.springframework.data.repository.query.Param;

public interface IOrient {
	
	public void ajouterUniversite(String nom,String region,double scoreMath,double scoreScience,double scoreInfo,double scoreLettre,double scoreEco);
	public Score scoreCorrespond(String nomModif);
	public Long identiteUniver(String nomModif);
	public void modifierScore(double scoreMathu,  double scoreScienceu,  double scoreInfou,  double scoreEcou, double scoreLettreu,Long identifiantUniveru);
	public void supprimerScore(Long identifiantUniveru);
	public void supprimerUniversite(String nomSupp);
}
